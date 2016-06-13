package cobra.namingservice;

import com.sun.corba.se.impl.naming.cosnaming.NamingContextImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.AlreadyBound;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;

/**
 * Non utilisée, A SUPPRIMER.
 * 
 * @author matt
 */
public class NamingService{

  public static void main(String[] args) throws InvalidName{
	try {
	  org.openorb.util.MapNamingContext.main(args);
	  
	  org.omg.CORBA.ORB orb;
	  org.omg.CosNaming.NamingContext namingService;
	  
	  orb = org.omg.CORBA.ORB.init();
	  namingService = org.omg.CosNaming.NamingContextHelper.narrow(
			  orb.resolve_initial_references("NameService"));
	  
	  
	  
	  NameComponent[] nc = new NameComponent[1];
	  nc[0] = new NameComponent("A", "");
	  namingService.bind_new_context(nc);
	  
	  
	} catch (NotFound ex) {
	  Logger.getLogger(NamingService.class.getName()).log(Level.SEVERE, null, ex);
	} catch (AlreadyBound ex) {
	  Logger.getLogger(NamingService.class.getName()).log(Level.SEVERE, null, ex);
	} catch (CannotProceed ex) {
	  Logger.getLogger(NamingService.class.getName()).log(Level.SEVERE, null, ex);
	} catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
	  Logger.getLogger(NamingService.class.getName()).log(Level.SEVERE, null, ex);
	}
  }

 

}
