package testidl.annuaire;

import controleAcces.annuaireOperations;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.mdpIdentiqueException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.cle;
import controleAcces.personne;
import java.util.HashMap;

public class AnnuaireImpl implements annuaireOperations {

  /* Le paramètre String est le matricule de Personne */
  private HashMap<String, Personne> annuaire;
  private HashMap<String, String> loginInfo;

  public AnnuaireImpl() {
    super();
    remplirAnnuaire();
  }

  private void remplirAnnuaire(){
    annuaire = DataExample.extractPersonnesFromFile("src/testidl/annuaire/listePersonne.txt");
    afficher();
    loginInfo = new HashMap<>();
    loginInfo.put("accueil", "accueil");
  }
  
  /**
   * Cherche un employé permanent dans l'annuaire.
   *
   * @param matricule
   * @return
   */
  private PersonnePermanent getPersonnePermanent(String matricule)
          throws personneInexistanteException {
    Personne p = annuaire.get(matricule);
    if (p != null && p.isPermanent()) {
      return (PersonnePermanent) p;
    } else {
      throw new personneInexistanteException("Matricule " + matricule
              + " introuvable pour un employé permanent");
    }
  }

  /**
   * Compare 2 chaînes et lève une exception si elles ne sont pas identiques.
   *
   * @param mdp1
   * @param mdp2
   * @throws MdpErroneException
   */
  private void mdpEgaux(String mdp1, String mdp2) throws MdpErroneException {
    if (!mdp1.equals(mdp2)) {
      throw new MdpErroneException("Mot de passe erroné");
    }
  }

  private void afficher() {
    for (Personne p : annuaire.values()) {
      System.out.println(p);
    }
  }

  /**
   * Vérification des données d'identification des employés permanents et de
   * l'accueil (accueil : A FAIRE).
   *
   * @param matricule d'un employé permanent ou login partagé de l'accueil
   * @param mdp d'un employé permanent ou du login partagé de l'accueil
   * @return une cle pour autoriser l'appel de méthodes protégées
   * @throws loginIncorrectException
   */
  @Override
  public cle authentification(String matricule, String mdp) throws loginIncorrectException {
    Cle cle;
    PersonnePermanent p;

    try {
      // Recherche si le matricule correspond à un employé permanent
      p = getPersonnePermanent(matricule);

      mdpEgaux(mdp, p.getMdp());

    } catch (personneInexistanteException ex) {
      System.out.println("--Echec d'authentification: personne inexistante - " + matricule
              + "::" + mdp);
      throw new loginIncorrectException("Matricule introuvable ou ne correspondant pas à un employé permanent.");
    } catch (MdpErroneException ex) {
      System.out.println("--Echec d'authentification: mdp erroné - " + matricule
              + "::" + mdp);
      throw new loginIncorrectException("Matricule introuvable ou ne correspondant pas à un employé permanent.");
    }
    cle = new Cle();
    System.out.println("++Authentification réussie - " + matricule
            + "::" + mdp + " - " + cle);
    return cle.toCle();
  }

  @Override
  public boolean modificationMdp(cle cle, String matricule, String nouveauMdp) throws mdpIdentiqueException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public personne[] rechercherPersonne(String matricule, String nom, String prenom) throws personneInexistanteException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public personne validerIdentite(String matricule) throws personneInexistanteException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public personne ajouterPermanent(personne p) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public personne ajouterTemporaire(personne p) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
