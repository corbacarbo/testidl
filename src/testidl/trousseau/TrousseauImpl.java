package testidl.trousseau;

import controleAcces.trousseauOperations;
import controleAcces.trousseauPackage.sessionExpireeException;
import controleAcces.trousseauPackage.sessionInvalidException;
import java.sql.Date;
import java.util.HashMap;
import testidl.Cle;
import testidl.CorbaEntite;

public class TrousseauImpl implements trousseauOperations {

  private HashMap<Cle, Date> sessions;

  private long tempsSession = 10;

  private CorbaEntite serveur;

  public TrousseauImpl(CorbaEntite serveur) {
	this.serveur = serveur;
	sessions = new HashMap<>();
  }

  public long tempsSessionMilliSecondes() {
	return tempsSession * 60000;
  }

  @Override
  public long startSession() {
	Cle cle = new Cle();
	Date date = new Date(System.currentTimeMillis() + tempsSessionMilliSecondes());
	sessions.put(cle, date);
	System.out.println("Clé générée " + cle + "   Fin " + date);
	return cle.toIdl();
  }

  @Override
  public void valideSession(long cleIdl) throws sessionInvalidException, sessionExpireeException {
	Cle cle = new Cle(cleIdl);
	Date courante = new Date(System.currentTimeMillis());

	Date date = sessions.get(cle);
	if (date == null) {
	  throw new sessionInvalidException("Clé introuvable " + cle);
	}
	if (date.before(courante)) {
	  throw new sessionExpireeException("Session expirée " + cle);
	}
  }

}
