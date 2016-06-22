package cobra.responsable;

import cobra.Autorisation;
import cobra.AutorisationRestreinte;
import cobra.Cle;
import cobra.CorbaClient;
import cobra.Matricule;
import cobra.Personne;
import cobra.PersonnePermanent;
import cobra.PersonneTemporaire;
import controleAcces.annuaire;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.autorisateur;
import controleAcces.autorisateurPackage.conflitAutorisationException;
import controleAcces.personneIdl;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.util.ArrayList;

public class Responsable extends CorbaClient implements Runnable {

  private String zone;

  private Cle cle;

  private ResponsableFrame responsableFrame;

  private PersonnePermanent personneConnecte;

  private Personne personneAutorise;

  public Responsable(String zone) {
	super("contexte", zone);
	this.zone = zone;
  }

  public void authentifier(String mat, String mdp)
		  throws loginIncorrectException, personneInexistanteException {
	annuaire annuaire = ns.resolveAnnuaire();
	cle = new Cle(annuaire.authentification(mat, mdp));
	System.out.println("Authentification réussie " + cle + "  " + mat);

	personneIdl personneIdl = annuaire.validerIdentite(mat);
	personneConnecte = new PersonnePermanent(personneIdl);
	
	if(!personneConnecte.isReponsible(zone)){
	  throw new loginIncorrectException("Vous n'êtes pas responsable de cette zone.");
	}
  }

  public ArrayList<Personne> rechercher(String mat, String nom, String prenom)
		  throws personneInexistanteException, sessionInvalidException,
		  sessionExpireeException {
	ArrayList<Personne> res = new ArrayList<>();
	personneIdl[] personnes;

	annuaire annuaire = ns.resolveAnnuaire();
	personnes = annuaire.rechercherPersonne(cle.toIdl(), mat, nom, prenom);

	for (personneIdl personne : personnes) {
	  Personne p;
	  Matricule matricule = new Matricule(personne.matricule);
	  if (matricule.isPermanent()) {
		p = new PersonnePermanent(personne);
	  } else {
		p = new PersonneTemporaire(personne);
	  }
	  res.add(p);
	}
	return res;
  }

  public void ajouterAutorisation(Autorisation auto)
		  throws conflitAutorisationException,
		  sessionInvalidException, sessionExpireeException {
	autorisateur autorisateur = ns.resolveAutorisateur(zone);
	autorisateur.ajouterAutorisation(cle.toIdl(), auto.toIdl());
  }

  public void ajouterAutorisationRestreinte(AutorisationRestreinte auto)
		  throws conflitAutorisationException,
		  sessionInvalidException, sessionExpireeException {
	autorisateur autorisateur = ns.resolveAutorisateurTemporaire();
	autorisateur.ajouterAutorisationRestreinte(cle.toIdl(), auto.toIdlR());
  }

  public String getZone() {
	return zone;
  }

  @Override
  public void run() {
	responsableFrame = new ResponsableFrame(this);
	responsableFrame.setVisible(true);
  }

  public static void main(String[] args) {
	String zones = "A";

	for (int i = 0; i < zones.length(); i++) {
	  Thread tResponsable = new Thread(new Responsable(zones.substring(i, i + 1)));
	  tResponsable.start();
	}
  }

}
