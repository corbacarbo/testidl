package cobra;

import controleAcces.annuaire;
import controleAcces.annuaireHelper;
import controleAcces.coffreFort;
import controleAcces.coffreFortHelper;
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
 * @author 
 */
public class CorbaUtil {

  protected org.omg.CORBA.ORB orb;
  protected org.omg.CosNaming.NamingContext namingService;

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
   * @return l'objet corba annuaire
   */
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

  /**
   * Retourne l'objet corba enregistré sous le nom "trousseau".
   * @return l'objet corba trousseau
   */
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
  
  /**
   * Retourne l'objet corba enregistré sous le nom "coffreFort".
   * @return l'objet corba trousseau
   */
  public coffreFort resolveCoffreFort() {
    try {
      org.omg.CORBA.Object o = resolve("coffreFort");
      return coffreFortHelper.narrow(o);
    } catch (NotFound ex) {
      System.out.println("Entité 'coffreFort' non joignable.");
    } catch (CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
      Logger.getLogger(CorbaUtil.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
}
