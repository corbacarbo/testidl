package cobra;

/**
 * Regroupement des méthodes de gestion corba spécifiques aux clients.
 *
 * @author
 */
public abstract class CorbaClient extends CorbaUtil {

  public CorbaClient(String resolutionType, String zone) {
	super(resolutionType);
	initOrb();
	if (resolutionType.equals("globale")) {
	  fetchNamingservice();
	} else {
	  fetchNamingservice(zone);
	}
  }

}
