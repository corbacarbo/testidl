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

  /**
   * L'orb.
   */
  protected org.omg.CORBA.ORB orb;

  /**
   * Méthode de résolution de nom.
   */
  protected String resolutionType;
  
  /**
   * Interface pour résoudre les noms.
   * Voir package cobra.namingservice.
   */
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

  /**
   * Récupération du naming service par la méthode "globale".
   */
  public void fetchNamingservice() {
	ns = (Resolution) new ResolutionGlobale(orb);
  }

  /**
   * Récupération du naming service par la méthode "contextuelle".
   * @param zone 
   */
  public void fetchNamingservice(String zone) {
	ns = (Resolution) new ResolutionContexte(orb, zone);
  }

}
