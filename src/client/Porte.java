package client;

import controleAcces.annuairePackage.loginIncorrectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import testidl.Client;

public class Porte extends Client {

  private controleAcces.annuaire annuaire;

  public Porte() {
	try {
	  //Récupération de l'annuaire
	  org.omg.CORBA.Object objetCorba = resolve("annuaire.EntiteAnnuaire");
	  annuaire = controleAcces.annuaireHelper.narrow(objetCorba);

	} catch (NotFound | CannotProceed | InvalidName ex) {
	  Logger.getLogger(Porte.class.getName()).log(Level.SEVERE, null, ex);
	}
  }

  public void authentifier() {
	String matricule = "pjohn";
	String mdp = "john";

	try {
	  annuaire.authentification(matricule, mdp);
	  System.out.println("Authentification réussie");

	} catch (loginIncorrectException ex) {
	  System.out.println(ex.message);
	}

  }

  public static void main(String[] args) {

	Porte p = new Porte();
	p.authentifier();

  }

}
