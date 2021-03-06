/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.rh;

import cobra.Cle;
import cobra.CorbaClient;
import cobra.Matricule;
import cobra.PersonnePermanent;
import controleAcces.annuaire;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.personneIdl;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;

/**
 *
 * @author Mélanie
 */
public class RH extends CorbaClient implements Runnable {
    
    private Cle cle;
    
    private PersonnePermanent personneAjout;
    
    private PersonnePermanent rhConnecte;
    
    private RHFrame rhFrame;
    
    public RH(){
	  super("globale", null);
        personneAjout=null;
        rhConnecte=null;
    }
    
    public void authentifier(String mat, String mdp) throws loginIncorrectException, personneInexistanteException {
    annuaire annuaire = ns.resolveAnnuaire();
    cle = new Cle(annuaire.authentification(mat, mdp));
    System.out.println("Authentification réussie " + cle + "  " + mat);

    personneIdl personneIdl = annuaire.validerIdentite(mat);
    rhConnecte = new PersonnePermanent(personneIdl);
	if(!rhConnecte.isReponsible("R")){
	  rhConnecte = null;
	  throw new loginIncorrectException("Vous n'êtes pas RH ");
	}
  }
    
    public void ajouterPermanent(String nom,String prenom, String photo) throws sessionInvalidException, sessionExpireeException{
        annuaire annuaire = ns.resolveAnnuaire();
        PersonnePermanent p = new PersonnePermanent("", true, "", new Matricule(""), nom, prenom, photo);
        personneIdl persCree = annuaire.ajouterPermanent(cle.toIdl(),p.toIdl());
        personneAjout=new PersonnePermanent(persCree);
        System.out.println("RH : Ajout de la personne "+personneAjout.getMatricule() +" "+personneAjout.getPrenom());
    }
    
    @Override
    public void run() {
        rhFrame = new RHFrame (this);
        rhFrame.setVisible(true);
    }
	
    public static void main(String[] args) {
        RH rh = new RH();
        Thread tRH = new Thread(rh);
        tRH.start();
  }

    public PersonnePermanent getPersonneAjout() {
        System.out.println(personneAjout);
        return this.personneAjout;
    }
    
	public void reinitPersonnes (){
        this.personneAjout=null;
        this.rhConnecte=null;
    }
}