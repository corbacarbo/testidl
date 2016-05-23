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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matt
 */
public class Porte extends CorbaClient{
  
  
  public static void main(String[] args){
	Porte porte = new Porte();
	autorisateur a = porte.resolveAutorisateur();
	
	Matricule matricule = new Matricule("tjean");
	
	try {
	  a.autoriser(matricule.toIdl());
	} catch (autorisationRefuseeException ex) {
	  System.out.println(ex.message);
	}
  }
}
