package cobra.namingservice;

import cobra.CorbaUtil;
import controleAcces.annuaire;
import controleAcces.autorisateur;
import controleAcces.coffreFort;
import controleAcces.journal;
import controleAcces.trousseau;
import controleAcces.zoneur;
import controleAcces.zoneurHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class ResolutionContexte implements Resolution {

  public org.omg.CosNaming.NamingContext namingService;
  protected String zone;

  protected annuaire annuaire;
  protected coffreFort coffreFort;
  protected journal journal;
  protected trousseau trousseau;
  protected autorisateur autorisateurTemporaire;
  protected autorisateur autorisateur;
  protected zoneur zoneur;

  public ResolutionContexte(ORB orb, String zone) {
	fetchNamingservice(orb);
	this.zone = zone;
	annuaire = null;
	coffreFort = null;
	journal = null;
	trousseau = null;
	autorisateurTemporaire = null;
	autorisateur = null;
	zoneur = null;
  }

  /**
   * Récupération du service de nommage.
   *
   * @param orb
   */
  @Override
  public void fetchNamingservice(org.omg.CORBA.ORB orb) {
	try {
	  namingService = org.omg.CosNaming.NamingContextHelper.narrow(
			  orb.resolve_initial_references("NameService"));
	} catch (InvalidName ex) {
	  Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	}

//	namingService = org.omg.CosNaming.NamingContextHelper.narrow(
//			orb.string_to_object("corbaloc:iiop:1.2@192.168.43.158:2001/NameService"));
  }

  /**
   * Résout un nom dans le service de nommage et retourne l'objet corba.
   *
   * @param stringToFind le nom à résoudre
   * @return l'objet corba associé au nom
   * @throws NotFound
   * @throws CannotProceed
   * @throws org.omg.CosNaming.NamingContextPackage.InvalidName
   */
  @Override
  public org.omg.CORBA.Object resolve(String stringToFind)
		  throws NotFound, CannotProceed,
		  org.omg.CosNaming.NamingContextPackage.InvalidName {
	NameComponent[] nameToFind = new NameComponent[1];
	nameToFind[0] = new NameComponent(stringToFind, "");
	return namingService.resolve(nameToFind);
  }

  @Override
  public annuaire resolveAnnuaire() {
	if (annuaire != null) {
	  return annuaire;
	} else {
	  annuaire = this.resolveZoneur(zone).resolveAnnuaire();
	  return annuaire;
	}
  }

  @Override
  public trousseau resolveTrousseau() {
	if (trousseau != null) {
	  return trousseau;
	} else {
	  trousseau = resolveZoneur(zone).resolveTrousseau();
	  return trousseau;
	}
  }

  @Override
  public coffreFort resolveCoffreFort() {
	if (coffreFort != null) {
	  return coffreFort;
	} else {
	  coffreFort = resolveZoneur(zone).resolveCoffreFort();
	  return coffreFort;
	}
  }

  @Override
  public autorisateur resolveAutorisateur(String z) {
	if (autorisateur != null) {
	  return autorisateur;
	} else {
	  autorisateur = resolveZoneur(zone).resolveAutorisateur();
	  return autorisateur;
	}
  }

  @Override
  public autorisateur resolveAutorisateurTemporaire() {
	if (autorisateurTemporaire != null) {
	  return autorisateurTemporaire;
	} else {
	  autorisateurTemporaire = resolveZoneur(zone).resolveAutorisateurTemporaire();
	  return autorisateurTemporaire;
	}
  }

  @Override
  public journal resolveJournal() {
	if (journal != null) {
	  return journal;
	} else {
	  journal = resolveZoneur(zone).resolveJournal();
	  return journal;
	}
  }

  @Override
  public zoneur resolveZoneur(String z) {
	if (zoneur != null) {
	  return zoneur;
	} else {
	  try {
		NameComponent[] nameToFind = new NameComponent[2];
		nameToFind[0] = new NameComponent(zone, "");
		nameToFind[1] = new NameComponent("zoneur", "");
		org.omg.CORBA.Object o = namingService.resolve(nameToFind);
		zoneur = zoneurHelper.narrow(o);
		return zoneur;
	  } catch (NotFound ex) {
		System.out.println("Entité 'zoneur' non joignable.");
	  } catch (CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
		Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	  }
	}
	return null;
  }

  @Override
  public NamingContext getNamingService() {
	return namingService;
  }

}
