package cobra.annuaire;

import cobra.DataExample;
import cobra.Cle;
import cobra.Personne;
import cobra.PersonnePermanent;
import controleAcces.annuaireOperations;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.mdpIdentiqueException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.personneIdl;
import controleAcces.trousseau;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.util.HashMap;
import cobra.CorbaEntite;
import cobra.Matricule;
import cobra.PersonneTemporaire;
import cobra.namingservice.Resolution;
import java.util.ArrayList;

public class AnnuaireImpl implements annuaireOperations {

  /**
   * Référence vers la classe qui encapsule pour avoir accès aux méthodes de
   * CorbaEntite : résolution d'entité...
   */
  private Resolution ns;

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
   * @param ns
   * @param s référence vers la classe instanciatrice (ou processus serveur).
   */
  public AnnuaireImpl(Resolution ns) {
    super();
    this.ns = ns;
    remplirAnnuaire();
  }

  /**
   * Remplit l'annuaire avec des données d'exemple.
   */
  private void remplirAnnuaire() {
    annuaire = DataExample.extractPersonnesFromFile();
    afficher();
    loginInfo = new HashMap<>();
    loginInfo.put("accueil", "accueil");
  }

  /**
   * Cherche un employé permanent dans l'annuaire.
   *
   * @param matricule le matricule de la personne recherchée
   * @return la personne trouvée, null sinon
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
   * Cherche le mot de passe associé à un login complémentaire (ie autre qu'un
   * employé permanent).
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
   * @throws MdpErroneException si les chaînes ne sont pas identiques.
   */
  private void mdpEgaux(String mdp1, String mdp2) 
		  throws MdpErroneException {
    if (!mdp1.equals(mdp2)) {
      throw new MdpErroneException("Mot de passe erroné");
    }
  }

  /**
   * Génère un nouveau matricule pour une personne donnée.
   * @param p la personne recevant un nouveau matricule.
   */
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
	System.out.println("------------------------");
    for (Personne p : annuaire.values()) {
      System.out.println(p);
    }
	System.out.println("------------------------");
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
  public long authentification(String matriculeIdl, String mdp) 
		  throws loginIncorrectException {
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
    trousseau t = ns.resolveTrousseau();
    // Récupération d'une nouvelle clé
    cle = new Cle(t.startSession("ABCDE"));

    System.out.println("++Authentification réussie - " + matricule
            + "::" + mdp + " - " + cle);

    return cle.toIdl();
  }

  /**
   * Modifie le mot de passe d'un employé permanent.
   *
   * @param cle la clé de session autorisant le traitement
   * @param matriculeIdl le matricule de l'employé
   * @param nouveauMdp le nouveau mot de passe souhaité
   * @return
   * @throws mdpIdentiqueException le nouveau mdp est identique au précédent.
   * @throws controleAcces.sessionInvalidException la clé de session n'existe pas
   * @throws controleAcces.sessionExpireeException la clé de session est expirée
   * @throws personneInexistanteException le matricule n'est pas valide.
   */
  @Override
  public void modificationMdp(long cle, String matriculeIdl, String nouveauMdp)
          throws mdpIdentiqueException,
		  sessionInvalidException,
          sessionExpireeException,
          personneInexistanteException {

    trousseau trousseau = ns.resolveTrousseau();
    trousseau.valideSession(cle);

    PersonnePermanent p;
    Matricule matricule = new Matricule(matriculeIdl);

    p = getPersonnePermanent(matricule);
    if (!p.isMdp(nouveauMdp)) {
      p.setMdp(nouveauMdp);
	  System.out.println("== Mot de passe changé " + p.getMatricule() + "  Nouveau mdp : " + nouveauMdp);
    } else {
      throw new mdpIdentiqueException("Mot de passe identique, essayez à nouveau.");
    }
  }

  @Override
  public personneIdl[] rechercherPersonne(String matriculeIdl, String nom, String prenom) throws personneInexistanteException {
	ArrayList<Personne> res = new ArrayList<>();
    Matricule matricule;
	// On met les paramètres à null s'ils ont des valeurs sans importance,
	// pour faciliter les tests.
	if(matriculeIdl == null || matriculeIdl.isEmpty()){
	  matricule = null;
	}
	else{
	  matricule = new Matricule(matriculeIdl);
	}
	if(nom.isEmpty()){
	  nom = null;
	}
	if(prenom.isEmpty()){
	  prenom = null;
	}
	
	for(Personne p : annuaire.values()){
	  if(matricule != null && p.getMatricule().equals(matricule)){
		res.add(p);
	  }
	  else if(prenom != null && p.getPrenom().equals(prenom)){
		res.add(p);
	  }
	  else if(nom != null && p.getNom().equals(nom)){
		res.add(p);
	  }
	}
	return Personne.listToTabidl(res);
  }

  /**
   * Cherche et retourne une personne à partir de son matricule.
   * @param matriculeIdl le matricule de la personne recherchée
   * @return
   * @throws personneInexistanteException le matricule fourni n'existe pas
   */
  @Override
  public personneIdl validerIdentite(String matriculeIdl) 
		  throws personneInexistanteException {
    Matricule matricule = new Matricule(matriculeIdl);
    if (annuaire.containsKey(matricule)) {
      Personne personne = annuaire.get(matricule);
	  System.out.println("ValiderIdentite: " + personne);
      return personne.toIdl();
    } else {
      throw new personneInexistanteException("Matricule non trouvé.");
    }
  }

  /**
   * Ajouter un nouvel employé permanent dans l'annuaire. L'appelant doit
   * fournir les nom, prénom, et photo dans un objet personneIdl (donc
   * incomplet). Calcul automatique et renvoi du nouveau matricule et du
   * nouveau mot de passe dans un objet personneIdl complet.
   *
   * @param cle la clé de session autorisant le traitement
   * @param p personne à ajouter dans l'annuaire.
   * @return la personne ajoutée avec un nouveau matricule et un nouveau mot de
   * passe.
   * @throws controleAcces.sessionInvalidException
   * @throws controleAcces.sessionExpireeException
   */
  @Override
  public personneIdl ajouterPermanent(long cle, personneIdl p)
		  throws sessionInvalidException, sessionExpireeException 
  {
	ns.resolveTrousseau().valideSession(cle);
	
    PersonnePermanent personne = new PersonnePermanent(p);

    genereMdp(personne);
    genereMatricule(personne);

    annuaire.put(personne.getMatricule(), personne);
    System.out.println(personne);
    return personne.toIdl();
  }

  /**
   * Ajouter un nouvel employé temporaire dans l'annuaire. L'appelant doit
   * fournir les nom, prénom, et photo dans un objet personneIdl (donc
   * incomplet). Calcul automatique et renvoi du nouveau matricule dans
   * un objet personneIdl complet.
   * @param cle la clé de session autorisant le traitement
   * @param p
   * @return
     * @throws controleAcces.sessionInvalidException
     * @throws controleAcces.sessionExpireeException
   */
  @Override
  public personneIdl ajouterTemporaire(long cle, personneIdl p) 
		  throws sessionInvalidException, sessionExpireeException {
	
	ns.resolveTrousseau().valideSession(cle);
	
    PersonneTemporaire personne = new PersonneTemporaire(p);

    genereMatricule(personne);

    annuaire.put(personne.getMatricule(), personne);

    return personne.toIdl();
  }

}
