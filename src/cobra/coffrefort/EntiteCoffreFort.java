package cobra.coffrefort;

import cobra.CorbaEntite;
import cobra.annuaire.EntiteAnnuaire;
import controleAcces.coffreFortPOATie;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class EntiteCoffreFort extends CorbaEntite{

  public EntiteCoffreFort() {
	super("globale");
  }
  
  @Override
  public void createServant() {
	try {
      CoffreFortImpl coffreFort = new CoffreFortImpl(this.ns);

      coffreFortPOATie coffreFortTie = new coffreFortPOATie(coffreFort);

      byte[] coffreFortId = rootPOA.activate_object(coffreFortTie);

      rebind("coffreFort", rootPOA.servant_to_reference(coffreFortTie));

    } catch (ServantAlreadyActive | WrongPolicy | NotFound | CannotProceed | InvalidName | ServantNotActive ex) {
      Logger.getLogger(EntiteAnnuaire.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
   public static void main(String[] args) {
    EntiteCoffreFort e = new EntiteCoffreFort();
    e.startEntite();
    e.startOrb();
  }
   
}
