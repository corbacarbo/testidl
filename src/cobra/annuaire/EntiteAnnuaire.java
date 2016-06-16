package cobra.annuaire;

import controleAcces.annuairePOATie;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import cobra.CorbaEntite;

/**
 * Processus serveur hébergeant une implémentation de l'annuaire.
 * @author 
 */
public class EntiteAnnuaire extends CorbaEntite {

  public EntiteAnnuaire() {
    super("globale");
  }

  @Override
  public void createServant() {
    try {
      AnnuaireImpl annuaire = new AnnuaireImpl(this.ns);

      annuairePOATie annuaireTie = new annuairePOATie(annuaire);

      byte[] annuaireId = rootPOA.activate_object(annuaireTie);

      rebind("annuaire", rootPOA.servant_to_reference(annuaireTie));

    } catch (ServantAlreadyActive | WrongPolicy | NotFound | CannotProceed | InvalidName | ServantNotActive ex) {
      Logger.getLogger(EntiteAnnuaire.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public static void main(String[] args) {
    EntiteAnnuaire e = new EntiteAnnuaire();
    e.startEntite();
    e.startOrb();
  }

}
