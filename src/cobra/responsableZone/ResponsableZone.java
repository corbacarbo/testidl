/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.responsableZone;

import cobra.Autorisation;
import cobra.AutorisationRestreinte;
import cobra.Cle;
import cobra.CorbaClient;
import cobra.Date;
import cobra.Horaire;
import cobra.Matricule;
import cobra.Personne;
import cobra.PersonnePermanent;
import controleAcces.annuaire;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.autorisateur;
import controleAcces.autorisateurPackage.conflitAutorisationException;
import controleAcces.personneIdl;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Mélanie
 */
public class ResponsableZone extends CorbaClient implements Runnable{
    private String zone;
    private ResponsableZoneFrame respZoneFrame;

    private Cle cle;

    private PersonnePermanent respZone;

    private HashMap<String,Personne>personnesTrouvees ;
    
    private Autorisation autorisationCourante;

    private AutorisationRestreinte autorisationCouranteR;

    public ArrayList<String> getPersonnesTrouvees() {
        ArrayList<String> listePersonnes = new ArrayList<String>();
        for (String p : personnesTrouvees.keySet()){
            listePersonnes.add(p);
        }
        return listePersonnes;
    }
    public Autorisation getAutorisationCourante() {
            return autorisationCourante;
    }
    public AutorisationRestreinte getAutorisationCouranteR() {
            return autorisationCouranteR;
    }
 
  public ResponsableZone (String zone) {
	super("contexte", zone);
      cle = null;
      this.zone = zone;
  }
  
  public String getZone() {
	return zone;
  }
  
  public static void main(String[] args) {
	String zones = "ABC";

	for (int i = 0; i < zones.length(); i++) {
	  Thread tRespZone = new Thread(new ResponsableZone(zones.substring(i, i+1)));
	  tRespZone.start();
	}
  }
  public void authentifier(String mat, String mdp) throws loginIncorrectException, personneInexistanteException {
    annuaire annuaire = ns.resolveAnnuaire();
    cle = new Cle(annuaire.authentification(mat, mdp));
    System.out.println("Authentification réussie " + cle + "  " + mat);

    public static void main(String[] args) {
          String zones = "B";

          for (int i = 0; i < zones.length(); i++) {
            Thread tRespZone = new Thread(new ResponsableZone(zones.substring(i, i+1)));
            tRespZone.start();
          }
    }
    public void authentifier(String mat, String mdp) throws loginIncorrectException, personneInexistanteException {
      annuaire annuaire = resolveAnnuaire();
      cle = new Cle(annuaire.authentification(mat, mdp));
      System.out.println("Authentification réussie " + cle + "  " + mat);

      personneIdl personneIdl = annuaire.validerIdentite(mat);
      respZone = new PersonnePermanent(personneIdl);
      if(!respZone.isReponsible(zone)){
	  respZone = null;
	  throw new loginIncorrectException("Vous n'êtes pas responsable de la zone "+zone);
	}
    }

    public void rechercherPersonne(String mat,String nom,String prenom) throws personneInexistanteException, sessionInvalidException, sessionExpireeException{
        annuaire annuaire = resolveAnnuaire();
        Matricule m = new Matricule(mat);
        personneIdl[] listePersTrouvees = annuaire.rechercherPersonne( cle.toIdl(), m.toIdl(), nom, prenom);
        personnesTrouvees = Personne.tableToHashMap(listePersTrouvees);
    }

    public void ajouterAutorisationP(String pers, String heureD , String minuteD,String heureF , String minuteF) throws conflitAutorisationException, sessionInvalidException, sessionExpireeException{
        Personne personneAAutoriser = personnesTrouvees.get(pers);
        Horaire horaireD = new Horaire(heureD+":"+minuteD);
        Horaire horaireF = new Horaire(heureF+":"+minuteF);
        autorisateur autorisateur = resolveAutorisateur(zone);
        Autorisation auth = new Autorisation(personneAAutoriser.getMatricule(), horaireD, horaireF);
        autorisationCourante = auth;
        autorisateur.ajouterAutorisation(cle.toIdl(), auth.toIdl());
    }

      public void ajouterAutorisationT(String pers, String heureD , String minuteD,String heureF , String minuteF, String jourD, String jourF) throws conflitAutorisationException, sessionInvalidException, sessionExpireeException{
        Personne personneAAutoriser = personnesTrouvees.get(pers);
        Horaire horaireD = new Horaire(heureD+":"+minuteD);
        Horaire horaireF = new Horaire(heureF+":"+minuteF);
        Date dateD = new Date(jourD);
        Date dateF = new Date(jourF);
        autorisateur autorisateur = resolveAutorisateurTemporaire();
        AutorisationRestreinte auth = new AutorisationRestreinte(dateD, dateF,zone, personneAAutoriser.getMatricule(), horaireD, horaireF);
        autorisationCouranteR = auth;
        autorisateur.ajouterAutorisationRestreinte(cle.toIdl(), auth.toIdlR());
    }
    
  
    @Override
    public void run() {
        respZoneFrame = new ResponsableZoneFrame(this);
        respZoneFrame.setVisible(true);
    }

    public void reinitPersonnes() {
        this.respZone=null;
    }
    public void reinitAjoutAutorisation(){
        if(null != this.personnesTrouvees){
            this.personnesTrouvees.clear();
        }
        this.autorisationCourante=null;
        this.autorisationCouranteR=null;
}
    
}
