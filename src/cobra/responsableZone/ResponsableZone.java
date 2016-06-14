/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.responsableZone;

import cobra.Cle;
import cobra.CorbaClient;
import cobra.Matricule;
import cobra.Personne;
import cobra.PersonnePermanent;
import controleAcces.annuaire;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.personneIdl;
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
  
  private HashMap<String,Personne> personnesTrouvees;
 
  public ResponsableZone (String zone) {
      cle = null;
      this.zone = zone;
      personnesTrouvees = new HashMap<String,Personne>();
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
    annuaire annuaire = resolveAnnuaire();
    cle = new Cle(annuaire.authentification(mat, mdp));
    System.out.println("Authentification réussie " + cle + "  " + mat);

    personneIdl personneIdl = annuaire.validerIdentite(mat);
    respZone = new PersonnePermanent(personneIdl);
  }
  
  public void rechercherPersonne(String mat,String nom,String prenom) throws personneInexistanteException{
      annuaire annuaire = resolveAnnuaire();
      Matricule m = new Matricule(mat);
      personneIdl[] listePersTrouvees = annuaire.rechercherPersonne(m.toIdl(), nom, prenom);
      for (personneIdl p : listePersTrouvees){
          Personne pers = new Personne(p);
          personnesTrouvees.put(p.matricule+" - "+p.nom+" - "+p.prenom, pers);
      }
  }
  
    
  
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
