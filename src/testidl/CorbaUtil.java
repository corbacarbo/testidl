package testidl;

import controleAcces.annuaire;
import controleAcces.annuaireHelper;
import controleAcces.trousseau;
import controleAcces.trousseauHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class CorbaUtil {

  protected org.omg.CORBA.ORB orb;
  protected org.omg.CosNaming.NamingContext namingService;

  public CorbaUtil() {

	orb = org.omg.CORBA.ORB.init(new String[0], null);

	try {
	  namingService = org.omg.CosNaming.NamingContextHelper.narrow(
			  orb.resolve_initial_references("NameService"));
	} catch (InvalidName ex) {
	  Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	}
//
//	namingService = org.omg.CosNaming.NamingContextHelper.narrow(
//			orb.string_to_object("corbaloc:iiop:1.2@SP3win:2001/NameService"));
  }

  public org.omg.CORBA.Object resolve(String stringToFind)
		  throws NotFound, CannotProceed,
		  org.omg.CosNaming.NamingContextPackage.InvalidName {
	NameComponent[] nameToFind = new NameComponent[1];
	nameToFind[0] = new NameComponent(stringToFind, "");
	return namingService.resolve(nameToFind);
  }

  public annuaire resolveAnnuaire() {
	try {
	  org.omg.CORBA.Object o = resolve("annuaire");
	  return annuaireHelper.narrow(o);
	} catch (NotFound ex) {
	  System.out.println("Entité 'annuaire' non joignable.");
	} catch (CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
	  Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
  }

  public trousseau resolveTrousseau() {
	try {
	  org.omg.CORBA.Object o = resolve("trousseau");
	  return trousseauHelper.narrow(o);
	} catch (NotFound ex) {
	  System.out.println("Entité 'trousseau' non joignable.");
	} catch (CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
	  Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
  }
}
