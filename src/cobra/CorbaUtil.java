package cobra;

import cobra.namingservice.Resolution;
import cobra.namingservice.ResolutionContexte;
import cobra.namingservice.ResolutionGlobale;

/**
 * Regroupement des méthodes de gestion corba générales utilisés par les entités
 * et les clients.
 *
 * @author
 */
public class CorbaUtil {

  protected org.omg.CORBA.ORB orb;

  protected String resolutionType;
  protected Resolution ns;

  /**
   * Constructeur par défaut.
   *
   * @param resolutionType
   */
  public CorbaUtil(String resolutionType) {
	this.resolutionType = resolutionType;
  }

  /**
   * Initialisation de l'orb.
   */
  public void initOrb() {
	orb = org.omg.CORBA.ORB.init(new String[0], null);
  }

  public void fetchNamingservice() {
	ns = (Resolution) new ResolutionGlobale(orb);
  }

  public void fetchNamingservice(String zone) {
	ns = (Resolution) new ResolutionContexte(orb, zone);
  }

}
