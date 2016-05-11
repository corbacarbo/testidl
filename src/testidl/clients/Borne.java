package testidl.clients;

import controleAcces.annuaire;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.trousseau;
import controleAcces.trousseauPackage.sessionExpireeException;
import controleAcces.trousseauPackage.sessionInvalidException;
import testidl.Cle;
import testidl.CorbaClient;

public class Borne extends CorbaClient {

  public Borne() {
  }

  public void authentifier() {
    String matricule = "pjohn";
    String mdp = "mdp";

    Cle cle;

    try {
      annuaire annuaire = resolveAnnuaire();
      cle = new Cle(annuaire.authentification(matricule, mdp));
      System.out.println("Authentification réussie " + cle);

      trousseau trousseau = resolveTrousseau();
      trousseau.valideSession(234234);

    } catch (loginIncorrectException ex) {
      System.out.println(ex.message);
    } catch (sessionInvalidException ex) {
      System.out.println(ex.message);
    } catch (sessionExpireeException ex) {
      System.out.println(ex.message);
    }

  }

  public static void main(String[] args) {

    Borne p = new Borne();
    p.authentifier();

  }

}
