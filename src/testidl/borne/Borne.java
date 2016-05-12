package testidl.borne;

import controleAcces.annuaire;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.trousseau;
import controleAcces.trousseauPackage.sessionExpireeException;
import controleAcces.trousseauPackage.sessionInvalidException;
import java.util.logging.Level;
import java.util.logging.Logger;
import testidl.Cle;
import testidl.CorbaClient;
import testidl.Matricule;

public class Borne extends CorbaClient implements Runnable {

  private Cle cle;

  private Matricule matricule;

  public Borne() {
    matricule = null;
  }

  public void authentifier(String mat, String mdp) throws loginIncorrectException {
    annuaire annuaire = resolveAnnuaire();
    cle = new Cle(annuaire.authentification(mat, mdp));
    System.out.println("Authentification réussie " + cle);
    matricule = new Matricule(mat);
  }

  @Override
  public void run() {
    LoginFrame loginFrame = new LoginFrame();
    loginFrame.setBorne(this);
    loginFrame.setVisible(true);
    if(matricule != null){
      System.out.println("dans if");
    }
  }

  public static void main(String[] args) {
    Borne borne = new Borne();
    Thread tBorne = new Thread(borne);
    tBorne.start();
  }

}
