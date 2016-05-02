package testidl.annuaire;

import testidl.Cle;
import testidl.Personne;
import testidl.PersonnePermanent;
import controleAcces.annuaireOperations;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.mdpIdentiqueException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.personneIdl;
import controleAcces.trousseau;
import java.util.HashMap;
import testidl.CorbaEntite;
import testidl.Matricule;

public class AnnuaireImpl implements annuaireOperations {

  private CorbaEntite serveur;
  
  /* Le paramètre String est le matricule de Personne */
  private HashMap<Matricule, Personne> annuaire;
  private HashMap<String, String> loginInfo;

  public AnnuaireImpl(CorbaEntite s) {
    super();
	serveur = s;
    remplirAnnuaire();
  }

  private void remplirAnnuaire() {
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
  private PersonnePermanent getPersonnePermanent(Matricule matricule)
          throws personneInexistanteException {
    Personne p = annuaire.get(matricule);
    if (p != null) {
      return (PersonnePermanent) p;
    } else {
      throw new personneInexistanteException("Matricule " + matricule
              + " introuvable pour un employé permanent");
    }
  }

  private String getMdpLoginInfo(String login)
          throws personneInexistanteException {
    String res = loginInfo.get(login);
    if (res == null) {
      throw new personneInexistanteException("");
    }
    return res;
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
   * @param matriculeIdl
   * @param mdp
   * @return
   * @throws loginIncorrectException
   */
  @Override
  public long authentification(String matriculeIdl, String mdp) throws loginIncorrectException {
    Cle cle;
    PersonnePermanent p;
    Matricule matricule = new Matricule(matriculeIdl);
    String motDePasse;

    try {
      if (matricule.isPermanent()) {
        p = getPersonnePermanent(matricule);
        motDePasse = p.getMdp();
      } else {
        motDePasse = loginInfo.get(matriculeIdl);
      }

      mdpEgaux(mdp, motDePasse);

    } catch (personneInexistanteException ex) {
      System.out.println("--Echec d'authentification: personne inexistante - " + matricule
              + "::" + mdp);
      throw new loginIncorrectException("Matricule introuvable ou ne correspondant pas à un employé permanent.");
    } catch (MdpErroneException ex) {
      System.out.println("--Echec d'authentification: mdp erroné - " + matricule
              + "::" + mdp);
      throw new loginIncorrectException("Matricule introuvable ou ne correspondant pas à un employé permanent.");
    }
	
	trousseau t = serveur.resolveTrousseau();
    cle = new Cle(t.startSession());
    System.out.println("++Authentification réussie - " + matricule
            + "::" + mdp + " - " + cle);
    return cle.toIdl();
  }

  @Override
  public boolean modificationMdp(long cle, String matricule, String nouveauMdp) throws mdpIdentiqueException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public personneIdl[] rechercherPersonne(String matricule, String nom, String prenom) throws personneInexistanteException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public personneIdl validerIdentite(String matricule) throws personneInexistanteException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public personneIdl ajouterPermanent(personneIdl p) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public personneIdl ajouterTemporaire(personneIdl p) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
