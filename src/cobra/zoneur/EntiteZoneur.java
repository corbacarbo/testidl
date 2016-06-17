package cobra.zoneur;

import cobra.CorbaEntite;
import cobra.autorisateur.EntiteAutorisateur;
import controleAcces.zoneurPOATie;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.AlreadyBound;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class EntiteZoneur extends CorbaEntite implements Runnable {

  private String zone;

  public EntiteZoneur(String zone) {
	super("globale");
	this.zone = zone;
  }

  @Override
  public void createServant() {
	try {
	  ZoneurImpl zoneur = new ZoneurImpl(this.ns, zone);

	  zoneurPOATie zoneurTie = new zoneurPOATie(zoneur);

	  byte[] zoneurId = rootPOA.activate_object(zoneurTie);

	  if (zone != null) {
		try {
		  // Création d'un nouveau contexte
		  NameComponent[] contTab = new NameComponent[1];
		  contTab[0] = new NameComponent(zone, "");
		  ns.getNamingService().bind_new_context(contTab);
		} catch (AlreadyBound ex) {
		  System.out.println("Contexte " + zone + " déjà créé.");
		}

		rebind(zone, "zoneur", rootPOA.servant_to_reference(zoneurTie));
	  }
	} catch (ServantAlreadyActive | WrongPolicy | NotFound | CannotProceed | InvalidName | ServantNotActive | AlreadyBound ex) {
	  Logger.getLogger(EntiteAutorisateur.class.getName()).log(Level.SEVERE, null, ex);
	}

  }

  @Override
  public void run() {
	startEntite();
	startOrb();
  }

  public static void main(String[] args) throws InterruptedException {
	String zones = "ABC";

	for (int i = 0; i < zones.length(); i++) {
	  String zo = zones.substring(i, i + 1);

	  EntiteZoneur e = new EntiteZoneur(zo);
	  Thread t = new Thread(e);
	  t.start();
	  Thread.sleep(1000);

	}
  }

}
