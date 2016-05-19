package cobra.trousseau;

import controleAcces.trousseauPOATie;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import cobra.CorbaEntite;

public class EntiteTrousseau extends CorbaEntite {

  public EntiteTrousseau() {
	super();
  }

  @Override
  public void createServant() {
	try {
	  TrousseauImpl trousseau = new TrousseauImpl(this);

	  trousseauPOATie trousseauTie = new trousseauPOATie(trousseau);

	  byte[] trousseauId = rootPOA.activate_object(trousseauTie);

	  rebind("trousseau", rootPOA.servant_to_reference(trousseauTie));

	} catch (ServantAlreadyActive | WrongPolicy | NotFound | CannotProceed | InvalidName | ServantNotActive ex) {
	  Logger.getLogger(EntiteTrousseau.class.getName()).log(Level.SEVERE, null, ex);
	}
  }

  public static void main(String[] args) {
	EntiteTrousseau e = new EntiteTrousseau();
	e.startEntite();
	e.startOrb();
  }

}
