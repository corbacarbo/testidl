package cobra;

import controleAcces.annuaire;
import controleAcces.annuaireHelper;
import controleAcces.autorisateur;
import controleAcces.autorisateurHelper;
import controleAcces.coffreFort;
import controleAcces.coffreFortHelper;
import controleAcces.journal;
import controleAcces.journalHelper;
import controleAcces.trousseau;
import controleAcces.trousseauHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * Regroupement des méthodes de gestion corba générales utilisés par les entités
 * et les clients.
 *
 * @author
 */
public class CorbaUtil {

  protected org.omg.CORBA.ORB orb;
  protected org.omg.CosNaming.NamingContext namingService;

  protected annuaire annuaire;
  protected coffreFort coffreFort;
  protected journal journal;
  protected trousseau trousseau;
  protected autorisateur autorisateurTemporaire;
  protected autorisateur autorisateur;

  /**
   * Constructeur par défaut.
   */
  public CorbaUtil() {
  }

  /**
   * Initialisation de l'orb.
   */
  public void initOrb() {
	orb = org.omg.CORBA.ORB.init(new String[0], null);
	annuaire = null;
	coffreFort = null;
	journal = null;
	trousseau = null;
	autorisateurTemporaire = null;
	autorisateur = null;
  }

  /**
   * Récupération du service de nommage.
   */
  public void fetchNamingservice() {
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

  /**
   * Résout un nom dans le service de nommage et retourne l'objet corba.
   *
   * @param stringToFind le nom à résoudre
   * @return l'objet corba associé au nom
   * @throws NotFound
   * @throws CannotProceed
   * @throws org.omg.CosNaming.NamingContextPackage.InvalidName
   */
  public org.omg.CORBA.Object resolve(String stringToFind)
		  throws NotFound, CannotProceed,
		  org.omg.CosNaming.NamingContextPackage.InvalidName {
	NameComponent[] nameToFind = new NameComponent[1];
	nameToFind[0] = new NameComponent(stringToFind, "");
	return namingService.resolve(nameToFind);
  }

  /**
   * Retourne l'objet corba enregistré sous le nom "annuaire".
   *
   * @return l'objet corba annuaire
   */
  public annuaire resolveAnnuaire() {
	if (annuaire != null) {
	  return annuaire;
	} else {
	  try {
		org.omg.CORBA.Object o = resolve("annuaire");
		annuaire = annuaireHelper.narrow(o);
		return annuaire;
	  } catch (NotFound ex) {
		System.out.println("Entité 'annuaire' non joignable.");
	  } catch (CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
		Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	  }
	}
	return null;
  }

  /**
   * Retourne l'objet corba enregistré sous le nom "trousseau".
   *
   * @return l'objet corba trousseau
   */
  public trousseau resolveTrousseau() {
	if (trousseau != null) {
	  return trousseau;
	} else {
	  try {
		org.omg.CORBA.Object o = resolve("trousseau");
		trousseau = trousseauHelper.narrow(o);
		return trousseau;
	  } catch (NotFound ex) {
		System.out.println("Entité 'trousseau' non joignable.");
	  } catch (CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
		Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	  }
	}
	return null;
  }

  /**
   * Retourne l'objet corba enregistré sous le nom "coffreFort".
   *
   * @return l'objet corba trousseau
   */
  public coffreFort resolveCoffreFort() {
	if (coffreFort != null) {
	  return coffreFort;
	} else {
	  try {
		org.omg.CORBA.Object o = resolve("coffreFort");
		coffreFort = coffreFortHelper.narrow(o);
		return coffreFort;
	  } catch (NotFound ex) {
		System.out.println("Entité 'coffreFort' non joignable.");
	  } catch (CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
		Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	  }
	}
	return null;
  }

  public autorisateur resolveAutorisateur(String zone) {
	if (autorisateur != null) {
	  return autorisateur;
	} else {
	  try {
		NameComponent[] nameToFind = new NameComponent[2];
		nameToFind[0] = new NameComponent(zone, "");
		nameToFind[1] = new NameComponent("autorisateur", "");
		org.omg.CORBA.Object o = namingService.resolve(nameToFind);
		autorisateur = autorisateurHelper.narrow(o);
		return autorisateur;
	  } catch (NotFound ex) {
		System.out.println("Entité 'autorisateur' non joignable.");
	  } catch (CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
		Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	  }
	}
	return null;
  }

  public autorisateur resolveAutorisateurTemporaire() {
	if (autorisateurTemporaire != null) {
	  return autorisateurTemporaire;
	} else {
	  try {
		org.omg.CORBA.Object o = resolve("autorisateurTemporaire");
		autorisateurTemporaire = autorisateurHelper.narrow(o);
		return autorisateurTemporaire;
	  } catch (NotFound ex) {
		System.out.println("Entité 'autorisateurTemporaire' non joignable.");
	  } catch (CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
		Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	  }
	}
	return null;
  }

  public journal resolveJournal() {
	if (journal != null) {
	  return journal;
	} else {
	  try {
		org.omg.CORBA.Object o = resolve("journal");
		journal = journalHelper.narrow(o);
		return journal;
	  } catch (NotFound ex) {
		System.out.println("Entité 'journal' non joignable.");
	  } catch (CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
		Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
	  }
	}
	return null;
  }

}
