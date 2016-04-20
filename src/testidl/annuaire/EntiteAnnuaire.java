package testidl.annuaire;

import controleAcces.annuairePOATie;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import testidl.Entite;

public class EntiteAnnuaire extends Entite {

  public EntiteAnnuaire() {
	super();
	createServant();
  }

  @Override
  public void createServant() {
	try {
	  AnnuaireImpl annuaire = new AnnuaireImpl();

	  annuairePOATie annuaireTie = new annuairePOATie(annuaire);

	  byte[] annuaireId = rootPOA.activate_object(annuaireTie);

	  rootPOA.the_POAManager().activate();

	  namingService.rebind(nameToRegister(), rootPOA.servant_to_reference(annuaireTie));
	  System.out.println("Service enregistré: " + nameToRegister()[0]);

	} catch (ServantAlreadyActive | WrongPolicy | AdapterInactive ex) {
	  Logger.getLogger(EntiteAnnuaire.class.getName()).log(Level.SEVERE, null, ex);
	} catch (NotFound ex) {
	  Logger.getLogger(EntiteAnnuaire.class.getName()).log(Level.SEVERE, null, ex);
	} catch (CannotProceed ex) {
	  Logger.getLogger(EntiteAnnuaire.class.getName()).log(Level.SEVERE, null, ex);
	} catch (InvalidName ex) {
	  Logger.getLogger(EntiteAnnuaire.class.getName()).log(Level.SEVERE, null, ex);
	} catch (ServantNotActive ex) {
	  Logger.getLogger(EntiteAnnuaire.class.getName()).log(Level.SEVERE, null, ex);
	}

  }

  public static void main(String[] args) {
	EntiteAnnuaire ea = new EntiteAnnuaire();
	ea.startEntite();
  }

}