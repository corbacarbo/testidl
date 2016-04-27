package testidl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class CorbaUtil {

  protected org.omg.CORBA.ORB orb;
  protected org.omg.CosNaming.NamingContext namingService;

  public CorbaUtil() {
	try {
	  orb = org.omg.CORBA.ORB.init(new String[0], null);
	  namingService = org.omg.CosNaming.NamingContextHelper.narrow(
			  orb.resolve_initial_references("NameService"));

	} catch (InvalidName ex) {
	  Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	}
  }

  protected org.omg.CORBA.Object resolve(String stringToFind)
		  throws NotFound, CannotProceed,
		  org.omg.CosNaming.NamingContextPackage.InvalidName {
	NameComponent[] nameToFind = new NameComponent[1];
	nameToFind[0] = new NameComponent(stringToFind, "");
	return namingService.resolve(nameToFind);
  }

}
