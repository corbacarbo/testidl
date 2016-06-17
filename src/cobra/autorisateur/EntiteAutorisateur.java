package cobra.autorisateur;

import cobra.CorbaEntite;
import controleAcces.autorisateurPOATie;
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

public class EntiteAutorisateur extends CorbaEntite implements Runnable {

  private String zone;

  public EntiteAutorisateur(String resolutionType, String zone) {
	super(resolutionType);
	this.zone = zone;
  }

  @Override
  public void createServant() {
	try {
	  AutorisateurImpl autorisateur = new AutorisateurImpl(this.ns, zone);

	  autorisateurPOATie autorisateurTie = new autorisateurPOATie(autorisateur);

	  byte[] autorisateurId = rootPOA.activate_object(autorisateurTie);

	  if (zone != null) {
		try {
		  // Création d'un nouveau contexte
		  NameComponent[] contTab = new NameComponent[1];
		  contTab[0] = new NameComponent(zone, "");
		  ns.getNamingService().bind_new_context(contTab);
		} catch (AlreadyBound ex) {
		  System.out.println("Contexte " + zone + " déjà créé.");
		}

		rebind(zone, "autorisateur", rootPOA.servant_to_reference(autorisateurTie));
	  } else {
		rebind("autorisateurTemporaire", rootPOA.servant_to_reference(autorisateurTie));
	  }

	} catch (ServantAlreadyActive | WrongPolicy | NotFound | CannotProceed | InvalidName | ServantNotActive | AlreadyBound ex) {
	  Logger.getLogger(EntiteAutorisateur.class.getName()).log(Level.SEVERE, null, ex);
	}

  }

  @Override
  public void run() {
	startEntite(zone);
	startOrb();
  }

  public static void main(String[] args) throws InterruptedException {
	String zones = "ABCT";

	for (int i = 0; i < zones.length(); i++) {
	  String zo = zones.substring(i, i + 1);

	  if (zo.equals("T")) {
		EntiteAutorisateur e = new EntiteAutorisateur("globale", null);
		Thread t = new Thread(e);
		t.start();
		Thread.sleep(1000);
	  } else {
		EntiteAutorisateur e = new EntiteAutorisateur("contexte", zo);
		Thread t = new Thread(e);
		t.start();
		Thread.sleep(1000);
	  }
	}
  }

}
