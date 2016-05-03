package testidl.trousseau;

import controleAcces.trousseauOperations;
import controleAcces.trousseauPackage.sessionExpireeException;
import controleAcces.trousseauPackage.sessionInvalidException;
import java.util.Date;

import java.util.HashMap;
import testidl.Cle;
import testidl.CorbaEntite;

public class TrousseauImpl implements trousseauOperations {

  private HashMap<Cle, Date> sessions;

  /**
   * Temps de validité d'une session, en secondes.
   */
  private long tempsSession = 10000;

  private CorbaEntite serveur;

  public TrousseauImpl(CorbaEntite serveur) {
	this.serveur = serveur;
	sessions = new HashMap<>();
  }

  public long tempsSessionMilliSecondes() {
	return tempsSession * 1000;
  }

  public void setTempsSession(long tempsSession) {
	this.tempsSession = tempsSession;
  }

  /**
   * Démarre une session. Génère une nouvelle clé de session et règle
   * l'expiration à partir de l'attribut tempsSession.
   *
   * @return une clé de session.
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
   * Vérifie la validité d'une clé de session. Vérifie si la clé existe, sinon
   * génère une sessionInvalidException. Puis vérifie la date d'expiration de la
   * clé : si la date d'expiration est inférieure (ie est passée) à maintenant,
   * la session n'est pas valide et une sessionExpireeException est générée.
   *
   * @param cleIdl La clé à tester.
   * @throws sessionInvalidException Si la clé de session n'existe pas.
   * @throws sessionExpireeException Si la clé existe mais n'est plus valide.
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
