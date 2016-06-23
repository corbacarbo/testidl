package cobra;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.AlreadyBound;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

/**
 * Regroupement des méthodes de gestion corba spécifiques aux entités. Les
 * processus serveurs faisant tourner une implementation d'un objet corba
 * héritent de cette classe. Ils peuvent ainsi utiliser les méthodes
 * d'enregistrement dans le service de noms, de démarrage de l'entité...
 *
 * @author
 */
public abstract class CorbaEntite extends CorbaUtil {

  /**
   * Référence vers le POA racine (qui permet d'activer des objets).
   */
  protected org.omg.PortableServer.POA rootPOA;

  /**
   * Constructeur par défaut.
   */
  public CorbaEntite(String resolutionType) {
	super(resolutionType);
  }

  /**
   * Chaque processus serveur prend en charge une ou plusieurs implémentations
   * d'objets corba. Ils doivent redéfinir cette méthode pour : 1. instancier
   * tous les objets corba souhaités ; 2. les activer ; 3. les enregistrer dans
   * le service de nommage.
   */
  public abstract void createServant();

  /**
   * Enregistre un objet corba auprès du service de noms.
   *
   * @param nom le nom sous lequel l'objet sera enregistré
   * @param o l'objet corba
   * @throws NotFound
   * @throws CannotProceed
   * @throws org.omg.CosNaming.NamingContextPackage.InvalidName
   */
  protected void rebind(String nom, org.omg.CORBA.Object o)
		  throws NotFound, CannotProceed,
		  org.omg.CosNaming.NamingContextPackage.InvalidName {

	NameComponent[] nomTab = new NameComponent[1];
	nomTab[0] = new NameComponent(nom, "");
	ns.getNamingService().rebind(nomTab, o);
	System.out.println("Servant enregistré : " + nom);
  }

  protected void rebind(String contexte, String nom, org.omg.CORBA.Object o)
		  throws NotFound, CannotProceed,
		  org.omg.CosNaming.NamingContextPackage.InvalidName, AlreadyBound {

	NameComponent[] nomTab = new NameComponent[2];
	nomTab[0] = new NameComponent(contexte, "");
	nomTab[1] = new NameComponent(nom, "");

	ns.getNamingService().rebind(nomTab, o);
	System.out.println("Servant enregistré : " + contexte + " / " + nom);
  }

  /**
   * Résout le POA racine et l'active.
   */
  public void chercheActivePOA() {
	try {
	  rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	  rootPOA.the_POAManager().activate();

	} catch (InvalidName | AdapterInactive ex) {
	  Logger.getLogger(CorbaEntite.class.getName()).log(Level.SEVERE, null, ex);
	}
  }

  /**
   * Réalise les 6 étapes (sur 7) du processus serveur : - initialisation de
   * l'orb ; - récupération du service de noms ; - récupération du POA racine ;
   * - activation du POA racine ; - création du servant ; - activation du
   * servant.
   */
  public void startEntite() {
	initOrb();
	fetchNamingservice();
	chercheActivePOA();
	createServant();
  }

  /**
   * Réalise les 6 étapes (sur 7) du processus serveur : - initialisation de
   * l'orb ; - récupération du service de noms ; - récupération du POA racine ;
   * - activation du POA racine ; - création du servant ; - activation du
   * servant.
   *
   * @param zone
   */
  public void startEntite(String zone) {
	initOrb();
	fetchNamingservice(zone);
	chercheActivePOA();
	createServant();
  }

  /**
   * Réalise la 7ème étape du processus serveur : - lancement de l'orb.
   */
  public void startOrb() {
	orb.run();
  }

}
