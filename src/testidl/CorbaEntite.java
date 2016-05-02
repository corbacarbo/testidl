package testidl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

public abstract class CorbaEntite extends CorbaUtil {

  protected org.omg.PortableServer.POA rootPOA;

  public CorbaEntite() {
    super();

    try {
      rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      
      rootPOA.the_POAManager().activate();
	  
	  createServant();
      
    } catch (InvalidName ex) {
      Logger.getLogger(CorbaEntite.class.getName()).log(Level.SEVERE, null, ex);
    } catch (AdapterInactive ex) {
      Logger.getLogger(CorbaEntite.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public abstract void createServant();

  protected NameComponent[] nameToRegister() {
    NameComponent[] res = new NameComponent[1];
    res[0] = new NameComponent(this.getClass().getName(), "");
    return res;
  }

  protected void rebind(String nom, org.omg.CORBA.Object o) 
		  throws NotFound, CannotProceed, 
		  org.omg.CosNaming.NamingContextPackage.InvalidName{
	
	NameComponent[] nomTab = new NameComponent[1];
	nomTab[0] = new NameComponent(nom, "");
	namingService.rebind(nomTab, o);
	System.out.println("Servant enregistré : " + nom);
  }
  
  public void startEntite() {
    orb.run();
  }

}
