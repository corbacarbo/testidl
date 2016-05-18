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
import controleAcces.trousseauPackage.sessionExpireeException;
import controleAcces.trousseauPackage.sessionInvalidException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import testidl.CorbaEntite;
import testidl.Matricule;
import testidl.PersonneTemporaire;

public class AnnuaireImpl implements annuaireOperations {

  /**
   * Référence vers la classe qui encapsule pour avoir accès aux méthodes de
   * CorbaEntite : résolution d'entité...
   */
  private CorbaEntite serveur;

  /**
   * Ensemble des employés de l'entreprise, permanents et temporaires.
   *
   */
  private HashMap<Matricule, Personne> annuaire;

  /**
   * Informations complémentaires d'authentification permettant aux non-employés
   * de se connecter (utilisé par l'accueil par exemple). Premier String : login
   * Deuxième String : mot de passe
   */
  private HashMap<String, String> loginInfo;

  /**
   * Constructeur
   *
   * @param s référence vers la classe instanciatrice (ou processus serveur).
   */
  public AnnuaireImpl(CorbaEntite s) {
    super();
    serveur = s;
    remplirAnnuaire();
  }

  /**
   * Remplit l'annuaire avec des données d'exemple.
   */
  private void remplirAnnuaire() {
    annuaire = DataExample.extractPersonnesFromFile("src/testidl/annuaire/listePersonne.txt");
    afficher();
    loginInfo = new HashMap<>();
    loginInfo.put("accueil", "accueil");
  }

  /**
   * Cherche un employé permanent dans l'annuaire.
   *
   * @param matricule de la personne recherchée
   * @return la personne recherchée
   * @throws personneInexistanteException
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

  /**
   * Cherche le mot de passe associé à un login complémentaire.
   *
   * @param login
   * @return le mot de passe, si le login existe,
   * @throws personneInexistanteException sinon.
   */
  private String getMdpLoginInfo(String login)
          throws personneInexistanteException {
    String res = loginInfo.get(login);
    if (res == null) {
      throw new personneInexistanteException("");
    }
    return res;
  }

  /**
   * Compare 2 chaînes (des mots de passe) et lève une exception si elles ne
   * sont pas identiques.
   *
   * @param mdp1 un mot de passe,
   * @param mdp2 un mot de passe,
   * @throws MdpErroneException si non identiques.
   */
  private void mdpEgaux(String mdp1, String mdp2) throws MdpErroneException {
    if (!mdp1.equals(mdp2)) {
      throw new MdpErroneException("Mot de passe erroné");
    }
  }

  private void genereMatricule(Personne p) {
    p.genereMatricule();
  }

  private void genereMdp(PersonnePermanent p) {
    p.genereMdp();
  }

  /**
   * Affiche les Personnes présentes dans l'annuaire.
   */
  private void afficher() {
    for (Personne p : annuaire.values()) {
      System.out.println(p);
    }
  }

  /**
   * Vérification des données d'identification des employés permanents et de
   * l'accueil, puis demande d'une nouvelle clé de session.
   *
   * @param matriculeIdl
   * @param mdp
   * @return une nouvelle clé permettant d'accéder à d'autres services.
   * @throws loginIncorrectException
   */
  @Override
  public long authentification(String matriculeIdl, String mdp) throws loginIncorrectException {
    Cle cle;
    PersonnePermanent p;
    Matricule matricule = new Matricule(matriculeIdl);
    String motDePasse;

    /**
     * * Début de l'authentification **
     */
    try {
      // Personne permanente
      if (matricule.isPermanent()) {
        p = getPersonnePermanent(matricule);
        motDePasse = p.getMdp();
      } // Login complémentaire
      else {
        motDePasse = getMdpLoginInfo(matriculeIdl);
      }

      // Vérification du mot de passe
      mdpEgaux(mdp, motDePasse);

    } catch (personneInexistanteException ex) {
      System.out.println("--Echec d'authentification: personne inexistante - "
              + matricule + "::" + mdp);
      throw new loginIncorrectException("Login incorrect.");
    } catch (MdpErroneException ex) {
      System.out.println("--Echec d'authentification: mdp erroné - " + matricule
              + "::" + mdp);
      throw new loginIncorrectException("Login incorrect.");
    }
    /**
     * * Fin : la personne est authentifiée **
     */

    /**
     * * Création d'une nouvelle session pour la personne authentifiée **
     */
    // Cherche gestionnaire de clé de session
    trousseau t = serveur.resolveTrousseau();
    // Récupération d'une nouvelle clé
    cle = new Cle(t.startSession());

    System.out.println("++Authentification réussie - " + matricule
            + "::" + mdp + " - " + cle);

    return cle.toIdl();
  }

  /**
   * Modifie le mot de passe d'un employé permanent.
   *
   * @param cle
   * @param matriculeIdl
   * @param nouveauMdp
   * @return
   * @throws mdpIdentiqueException si le nouveau mdp est identique au précédent.
   * @throws controleAcces.sessionInvalidException
   * @throws controleAcces.sessionExpireeException
   * @throws personneInexistanteException si le matricule n'est pas valide.
   */
  @Override
  public void modificationMdp(long cle, String matriculeIdl, String nouveauMdp)
          throws mdpIdentiqueException,
          controleAcces.sessionInvalidException,
          controleAcces.sessionExpireeException,
          personneInexistanteException {

    trousseau trousseau = serveur.resolveTrousseau();
    trousseau.valideSession(cle);

    PersonnePermanent p;
    Matricule matricule = new Matricule(matriculeIdl);

    p = getPersonnePermanent(matricule);
    if (!p.isMdp(nouveauMdp)) {
      p.setMdp(nouveauMdp);
    } else {
      throw new mdpIdentiqueException("Mot de passe identique, essayez à nouveau.");
    }
  }

  @Override
  public personneIdl[] rechercherPersonne(String matriculeIdl, String nom, String prenom) throws personneInexistanteException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public personneIdl validerIdentite(String matriculeIdl) throws personneInexistanteException {
    Matricule matricule = new Matricule(matriculeIdl);
    if (annuaire.containsKey(matricule)) {
      Personne personne = annuaire.get(matricule);
      return personne.toIdl();
    } else {
      throw new personneInexistanteException("Matricule non trouvé.");
    }
  }

  /**
   * Ajouter un nouvel employé permanent dans l'annuaire. L'appelant doit
   * fournir les nom, prénom, et photo dans un objet personneIdl (donc
   * incomplète). Calcul automatique et renvoi du matricule (incrémental) et du
   * mot de passe dans un objet personneIdl complète.
   *
   * @param p personne à ajouter dans l'annuaire.
   * @return la personne ajoutée avec un nouveau matricule et un nouveau mot de
   * passe.
   */
  @Override
  public personneIdl ajouterPermanent(personneIdl p) {
    PersonnePermanent personne = new PersonnePermanent(p);

    genereMdp(personne);
    genereMatricule(personne);

    annuaire.put(personne.getMatricule(), personne);

    return personne.toIdl();
  }

  /**
   * Ajouter un nouvel employé temporaire dans l'annuaire. L'appelant doit
   * fournir les nom, prénom, et photo dans un objet personneIdl (donc
   * incomplète). Calcul automatique et renvoi du matricule (incrémental) dans
   * un objet personneIdl complète.
   *
   * @param p
   * @return
   */
  @Override
  public personneIdl ajouterTemporaire(personneIdl p) {
    PersonneTemporaire personne = new PersonneTemporaire(p);

    genereMatricule(personne);

    annuaire.put(personne.getMatricule(), personne);

    return personne.toIdl();
  }

}
