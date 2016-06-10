package cobra.autorisateur;

import cobra.CorbaEntite;
import controleAcces.autorisateurPOATie;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class EntiteAutorisateur extends CorbaEntite{
  
  private String zone = null;
  
  public EntiteAutorisateur() {
    super();
  }

  @Override
  public void createServant() {
    try {
      AutorisateurImpl autorisateur = new AutorisateurImpl(this, zone);

      autorisateurPOATie autorisateurTie = new autorisateurPOATie(autorisateur);

      byte[] autorisateurId = rootPOA.activate_object(autorisateurTie);

      rebind("autorisateur", rootPOA.servant_to_reference(autorisateurTie));

    } catch (ServantAlreadyActive | WrongPolicy | NotFound | CannotProceed | InvalidName | ServantNotActive ex) {
      Logger.getLogger(EntiteAutorisateur.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public static void main(String[] args) {
    EntiteAutorisateur e = new EntiteAutorisateur();
    e.startEntite();
    e.startOrb();
  }

}