/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.porte;

import cobra.CorbaClient;
import cobra.Matricule;
import controleAcces.autorisateur;
import controleAcces.autorisateurPackage.autorisationRefuseeException;

/**
 * 
 * @author matt
 */
public class Porte extends CorbaClient{
  
  private String zone;
  
  public static void main(String[] args){
	Porte porte = new Porte();
	autorisateur a = porte.resolveAutorisateur("A");
	autorisateur t = porte.resolveAutorisateurTemporaire();
	
	Matricule matricule = new Matricule("tjean");
	
	try {
	  t.autoriser(matricule.toIdl(), "C");
	  System.out.println("Ok");
	} catch (autorisationRefuseeException ex) {
	  System.out.println(ex.message);
	}
  }
}
