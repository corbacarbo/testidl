package testidl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

public abstract class Entite extends CorbaUtil {

  protected org.omg.PortableServer.POA rootPOA;

  public Entite() {
    super();

    try {
      rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      
      rootPOA.the_POAManager().activate();
      
    } catch (InvalidName ex) {
      Logger.getLogger(Entite.class.getName()).log(Level.SEVERE, null, ex);
    } catch (AdapterInactive ex) {
      Logger.getLogger(Entite.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public abstract void createServant();

  protected NameComponent[] nameToRegister() {
    NameComponent[] res = new NameComponent[1];
    res[0] = new NameComponent(this.getClass().getName(), "");
    return res;
  }

  public void startEntite() {
    orb.run();
  }

}
