package testidl;

/**
 * Regroupement des méthodes de gestion corba spécifiques aux clients.
 * @author 
 */
public abstract class CorbaClient extends CorbaUtil {

  public CorbaClient() {
    super();
    initOrb();
    fetchNamingservice();
  }

}
