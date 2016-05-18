package testidl.trousseau;

import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import controleAcces.trousseauOperations;
import java.util.Date;
import java.util.HashMap;
import testidl.Cle;
import testidl.CorbaEntite;

public class TrousseauImpl implements trousseauOperations {

  /**
   * Liste des clés avec leur date d'expiration.
   */
  private HashMap<Cle, Date> sessions;

  /**
   * Temps de validité d'une session, en secondes.
   */
  private long tempsSession = 600;

  /**
   * Référence vers la classe qui encapsule pour avoir accès aux méthodes de
   * CorbaEntite : résolution d'entité...
   */
  private CorbaEntite serveur;

  /**
   * Constructeur.
   * @param serveur référence vers la classe instanciatrice (ou processus serveur).
   */
  public TrousseauImpl(CorbaEntite serveur) {
    this.serveur = serveur;
    sessions = new HashMap<>();
  }

  /**
   * Convertit puis renvoie le temps de validité d'une session en millisecondes.
   * @return temps de validité d'une session en millisecondes
   */
  public long tempsSessionMilliSecondes() {
    return tempsSession * 1000;
  }

  /**
   * Réglage du temps de validité d'une session en secondes.
   * @param tempsSession le temps de validité d'une session en secondes
   */
  public void setTempsSession(long tempsSession) {
    this.tempsSession = tempsSession;
  }

  /**
   * Démarrage d'une nouvelle session.
   * Génère et souvegarde une nouvelle clé de session et réglage de l'expiration
   * de cette clé (à partir de l'attribut tempsSession).
   * @return une nouvelle clé de session.
   */
  @Override
  public long startSession() {
    Cle cle = new Cle();
    Date date = new Date(System.currentTimeMillis() + tempsSessionMilliSecondes());
    sessions.put(cle, date);
    System.out.println("Clé générée " + cle + "   Fin " + date);
    return cle.toIdl();
  }

  /**
   * Vérifie la validité d'une clé de session.
   * Vérifie si la clé existe, sinon génère une sessionInvalidException. 
   * Puis vérifie la date d'expiration de la clé : si la date d'expiration est 
   * inférieure (ie est passée) à maintenant, la session n'est pas valide et une
   * sessionExpireeException est générée.
   * @param cleIdl la clé à tester.
   * @throws sessionInvalidException la clé de session n'existe pas.
   * @throws sessionExpireeException la clé existe mais n'est plus valide.
   */
  @Override
  public void valideSession(long cleIdl) throws sessionInvalidException, sessionExpireeException {
    Cle cle = new Cle(cleIdl);
    Date courante;

    Date date = sessions.get(cle);
    if (date == null) {
      throw new sessionInvalidException("Clé introuvable " + cle);
    } else {
      courante = new Date(System.currentTimeMillis());
      if (date.before(courante)) {
        throw new sessionExpireeException("Session expirée " + cle);
      }
    }
  }

}
