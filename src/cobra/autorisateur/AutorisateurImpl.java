package cobra.autorisateur;

import cobra.Autorisation;
import cobra.AutorisationRestreinte;
import cobra.CorbaEntite;
import cobra.DataExample;
import cobra.Matricule;
import controleAcces.autorisateurOperations;
import controleAcces.autorisateurPackage.autorisationRefuseeException;
import controleAcces.autorisateurPackage.autorisationIdl;
import controleAcces.autorisateurPackage.autorisationRestreinteIdl;
import controleAcces.autorisateurPackage.conflitAutorisationException;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Il existe deux types d'autorisateur: - pour les permanents : il en existe un
 * par zone, responsable de toutes les autorisations de cette zone ; - pour les
 * temporaires : il en existe un unique, responsable de toutes les autorisations
 * des temporaires. Cette classe implémente l'un et l'autre. Elle sait elle-même
 * de quel type elle est grâce au paramètre 'zone' du constructeur. S'il est
 * null, alors c'est un autorisateur temporaire.
 *
 * @author matt
 */
public class AutorisateurImpl implements autorisateurOperations {

  /**
   * Référence vers la classe qui encapsule pour avoir accès aux méthodes de
   * CorbaEntite : résolution d'entité...
   */
  private CorbaEntite serveur;

  /**
   * La zone de responsabilité de cet autorisateur (seulement si permanent).
   */
  private String zone;

  /**
   * Le type d'autorisateur: - true: autorisateur permanent ; une entité par
   * zone, contenant toutes les autorisations permanentes de la zone; - false:
   * autorisateur temporaire ; une seule entité ne gérant uniquement les
   * autorisations temporaires.
   */
  private boolean permanent;

  /**
   * Les autorisations.
   */
  private ArrayList<Autorisation> autorisations;

  /**
   * Constructeur. String contient la lettre de zone (A, B, C...), ou bien est
   * null. Dans ce deuxième cas, il s'agit alors de l'autorisateur pour les
   * personnes temporaires.
   *
   * @param serveur référence vers la classe instanciatrice (ou processus
   * serveur).
   * @param zone
   */
  public AutorisateurImpl(CorbaEntite serveur, String zone) {
	this.serveur = serveur;
	this.zone = zone;
	if (zone == null) {
	  // Autorisateur pour temporaires
	  permanent = false;
	} else {
	  // Autorisateur pour permanent
	  permanent = true;
	}
	remplirAutorisation();
	afficher();
  }

  private void remplirAutorisation() {
	autorisations = DataExample.extractAutorisationsFromFile(zone);
  }

  public void afficher() {
	System.out.println("------------------------");
	for (Autorisation a : autorisations) {
	  System.out.println(a);
	}
	System.out.println("------------------------");
  }

  @Override
  public void ajouterAutorisation(long cleIdl, autorisationIdl autorisationIdl) throws conflitAutorisationException, sessionInvalidException, sessionExpireeException {
	serveur.resolveTrousseau().valideSession(cleIdl);

	Autorisation autorisationDemandee = new Autorisation(autorisationIdl);

	for (Autorisation uneAuto : autorisations) {
	  if (autorisationDemandee.recouvrement(uneAuto)) {
		throw new conflitAutorisationException("Conflit : " + autorisationDemandee + " avec " + uneAuto);
	  }
	}
	autorisations.add(autorisationDemandee);
  }

  @Override
  public void ajouterAutorisationRestreinte(long cleIdl, autorisationRestreinteIdl autorisationIdl) throws conflitAutorisationException, sessionInvalidException, sessionExpireeException {
	serveur.resolveTrousseau().valideSession(cleIdl);

	AutorisationRestreinte autorisationDemandee = new AutorisationRestreinte(autorisationIdl);

	for (Autorisation uneAuto : autorisations) {
	  if (autorisationDemandee.recouvrement(uneAuto)) {
		throw new conflitAutorisationException("Conflit : " + autorisationDemandee + " avec " + uneAuto);
	  }
	}
	autorisations.add(autorisationDemandee);
  }

  @Override
  public void autoriser(String matriculeIdl) throws autorisationRefuseeException {
	Matricule matricule = new Matricule(matriculeIdl);
	GregorianCalendar maintenant = new GregorianCalendar();

	for (Autorisation uneAuto : autorisations) {
	  if (uneAuto.autoriserMatricule(matricule)) {
		if (uneAuto.autoriserTemps(maintenant)) {
		  
		  return;
		}
	  }
	}
	throw new autorisationRefuseeException("Autorisation refusée pour " + matricule + " à " + maintenant, maintenant.getTimeInMillis());
  }

}
