/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.accueil;

import cobra.Cle;
import cobra.CorbaClient;
import cobra.Empreinte;
import cobra.Matricule;
import cobra.PersonnePermanent;
import cobra.PersonneTemporaire;
import controleAcces.annuaire;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.coffreFort;
import controleAcces.coffreFortPackage.matriculeErroneException;
import controleAcces.coffreFortPackage.matriculeInconnuException;
import controleAcces.personneIdl;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;

/**
 *
 * @author Mélanie
 */
public class Accueil extends CorbaClient implements Runnable {

  private Cle cle;

  private PersonneTemporaire personneAjout;

  private PersonneTemporaire personneEmpreinte;

  private PersonnePermanent accueilConnecte;

  private AccueilFrame accueilFrame;

  public Accueil() {
	super("globale", "");
	personneAjout = null;
	accueilConnecte = null;
  }

  public void authentifier(String mat, String mdp) throws loginIncorrectException, personneInexistanteException {
	annuaire annuaire = ns.resolveAnnuaire();
	cle = new Cle(annuaire.authentification(mat, mdp));
	System.out.println("Authentification réussie " + cle + "  " + mat);

	try {
	  personneIdl personneIdl = annuaire.validerIdentite(mat);
	  throw new loginIncorrectException("Seul \"accueil\" peut s'identifier.");
	  
	} catch (personneInexistanteException ex) {
	  // Ok, seul "accueil" peut s'identifier.
	}

	//accueilConnecte = new PersonnePermanent(personneIdl);
  }

  public void ajouterTemporaire(String nom, String prenom, String photo) throws sessionInvalidException, sessionExpireeException {
	annuaire annuaire = ns.resolveAnnuaire();
	PersonnePermanent p = new PersonnePermanent("", true, "", new Matricule(""), nom, prenom, photo);
	personneIdl persCree = annuaire.ajouterTemporaire(cle.toIdl(), p.toIdl());
	personneAjout = new PersonneTemporaire(persCree);
	System.out.println("Accueil : Ajout de la personne " + personneAjout.getMatricule() + " " + personneAjout.getPrenom());
  }

  public void ajouterEmpreinte(Empreinte empreinte, Matricule matricule) throws sessionInvalidException, sessionExpireeException, personneInexistanteException, matriculeErroneException {
	annuaire annuaire = ns.resolveAnnuaire();
	annuaire.validerIdentite(matricule.toIdl());
	coffreFort coffreFort = ns.resolveCoffreFort();
	coffreFort.ajouterEmpreinteTemp(cle.toIdl(), empreinte.toIdl(), matricule.toIdl());
  }

  public void supprimerEmpreinte(Matricule matricule) throws sessionInvalidException, sessionExpireeException, matriculeInconnuException, matriculeErroneException {
	coffreFort coffreFort = ns.resolveCoffreFort();
	coffreFort.supprimerEmpreinteTemp(cle.toIdl(), matricule.toIdl());
  }

  @Override
  public void run() {
	accueilFrame = new AccueilFrame(this);
	accueilFrame.setVisible(true);
  }

  public static void main(String[] args) {
	Accueil accueil = new Accueil();
	Thread tAccueil = new Thread(accueil);
	tAccueil.start();
  }

  public PersonneTemporaire getPersonneAjout() {
	return this.personneAjout;
  }

  public void reinitPersonnes() {
	this.personneAjout = null;
	this.accueilConnecte = null;
  }
}
