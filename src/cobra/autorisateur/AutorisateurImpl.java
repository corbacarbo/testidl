package cobra.autorisateur;

import cobra.Autorisation;
import cobra.AutorisationRestreinte;
import cobra.Date;
import cobra.Matricule;
import cobra.bdd.Bdd;
import cobra.namingservice.Resolution;
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
  private Resolution ns;

  private Bdd bdd;

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
   * @param ns
   * @param serveur référence vers la classe instanciatrice (ou processus
   * serveur).
   * @param zone
   */
  public AutorisateurImpl(Resolution ns, String zone) {
	bdd = new Bdd("autorisation", zone);
	this.ns = ns;
	this.zone = zone;
	if (zone == null) {
	  // Autorisateur pour temporaires
	  permanent = false;
	} else {
	  // Autorisateur pour permanents
	  permanent = true;
	}
	remplirAutorisation();
	afficher();
  }

  private void remplirAutorisation() {
	autorisations = bdd.loadAutorisations(zone);
  }

  public void afficher() {
	System.out.println(zone + "------------------------");
	for (Autorisation a : autorisations) {
	  System.out.println(a);
	}
  }

  @Override
  public void ajouterAutorisation(long cleIdl, autorisationIdl autorisationIdl)
		  throws conflitAutorisationException, sessionInvalidException,
		  sessionExpireeException {
	ns.resolveZoneur(zone).resolveTrousseau().valideSession(cleIdl);

	Autorisation autorisationDemandee = new Autorisation(autorisationIdl);

	for (Autorisation uneAuto : autorisations) {
	  if (uneAuto.getMatricule().equals(autorisationDemandee.getMatricule())
			  && autorisationDemandee.recouvrement(uneAuto)) {
		throw new conflitAutorisationException("Conflit : " + autorisationDemandee + " avec " + uneAuto);
	  }
	}
	System.out.println("++" + zone + "  autorisation permanente ajoutée " + autorisationDemandee);
	autorisations.add(autorisationDemandee);
	bdd.addAutorisation(autorisationDemandee, zone);
  }

  @Override
  public void ajouterAutorisationRestreinte(long cleIdl,
		  autorisationRestreinteIdl autorisationIdl)
		  throws conflitAutorisationException, sessionInvalidException,
		  sessionExpireeException {
	
	ns.resolveTrousseau().valideSession(cleIdl);

	AutorisationRestreinte autorisationDemandee = new AutorisationRestreinte(autorisationIdl);

	for (Autorisation uneAuto : autorisations) {
	  AutorisationRestreinte uneAutoRest = (AutorisationRestreinte) uneAuto;
	  if (uneAutoRest.getMatricule().equals(autorisationDemandee.getMatricule())
			  && uneAutoRest.getZone().equals(autorisationDemandee.getZone())
			  && autorisationDemandee.recouvrement(uneAutoRest)) {
		throw new conflitAutorisationException("Conflit : " + autorisationDemandee + " avec " + uneAuto);
	  }
	}
	System.out.println("++" + zone + "  autorisation temporaire ajoutée " + autorisationDemandee);
	autorisations.add(autorisationDemandee);
	bdd.addAutorisationRestreinte(autorisationDemandee);
  }

  @Override
  public void autoriser(String matriculeIdl, String zoneIdl)
		  throws autorisationRefuseeException {
	Matricule matricule = new Matricule(matriculeIdl);
	GregorianCalendar maintenant = new GregorianCalendar();
	
	Date d = new Date(maintenant);

	for (Autorisation uneAuto : autorisations) {
	  if (uneAuto.autoriserMatricule(matricule)) {
		if (uneAuto.autoriserTemps(maintenant)) {

		  //Vérifie Zone si autorisateur temporaire
		  if (!permanent) {
			AutorisationRestreinte ar = (AutorisationRestreinte) uneAuto;
			if (ar.autoriserZone(zoneIdl)) {
			  System.out.println("== TEMP: autorisation accordée " + d + " "+ uneAuto);
			  return;
			}
			// Si autorisateur permanent, pas besoin de vérifier zone.
		  } else {
			System.out.println("== " + zone + ": autorisation accordée " + uneAuto);
			return;
		  }
		}
	  }
	}
	if (permanent) {
	  System.out.println("!! " + zone + ": autorisation refusée " + matricule);
	  throw new autorisationRefuseeException("Autorisation refusée pour " + matricule + " à " + maintenant, maintenant.getTimeInMillis(), matricule.toIdl());
	} else {
	  System.out.println("!! TEMP: autorisation refusée " + matricule);
	  throw new autorisationRefuseeException("Autorisation refusée pour " + matricule + ", zone " + zoneIdl + ", à " + maintenant, maintenant.getTimeInMillis(), matricule.toIdl());
	}
  }

}
