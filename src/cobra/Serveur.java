package cobra;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.omg.PortableServer.Servant;

public class Serveur extends CorbaEntite{

  public Serveur(String resolutionType) {
	super(resolutionType);
  }

  @Override
  public void createServant() {
    
  }
  
  /**
   * 
   * @param fullName nom de la classe avec majuscule(s)
   * @param param
   */
  public void createServant2(String fullName, String param){
    
    try {
      
      // Nom de la classe avec un premier caractère en minuscule
      String halfName = fullName.substring(0, 0).toLowerCase() + fullName.substring(1);
      // Nom de l'impl avec premier caractère en majuscule
      String implFullName = fullName + "Impl";
      // Nom de l'impl avec premier caractère en minuscule
      String implHalfName = halfName + "Impl";
      // Nom de la classe POATie correspondante
      String poaTieName = implHalfName + "POATie";
      
      // Instanciation de la classe Impl (implantation de l'objet corba)
      Class implObj = Class.forName(implFullName);
      Constructor implConst = implObj.getConstructor(this.getClass());
      Servant impl = (Servant) implConst.newInstance(this);
      
      // Instanciation de la classe POATie
      Class poaTieObj = Class.forName(poaTieName);
      Constructor poaTieConst = poaTieObj.getConstructor(implObj);
      Servant servant = (Servant) poaTieConst.newInstance(impl);
      
      rootPOA.activate_object(servant);
      
      rebind(halfName + param, rootPOA.servant_to_reference(servant));
      
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchMethodException ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvocationTargetException ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ServantAlreadyActive ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (WrongPolicy ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NotFound ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (CannotProceed ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvalidName ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ServantNotActive ex) {
      Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  }
  
}
