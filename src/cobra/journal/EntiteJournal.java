/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.journal;

import cobra.CorbaEntite;
import controleAcces.journalPOATie;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 * Processus serveur hébergeant une implémentation du journal.
 * @author 
 */
public class EntiteJournal extends CorbaEntite {

  public EntiteJournal() {
    super("globale");
  }

  @Override
  public void createServant() {
    try {
      JournalImpl journal = new JournalImpl(this);

      journalPOATie journalTie = new journalPOATie(journal);

      byte[] journalId = rootPOA.activate_object(journalTie);

      rebind("journal", rootPOA.servant_to_reference(journalTie));

    } catch (ServantAlreadyActive | WrongPolicy | NotFound | CannotProceed | InvalidName | ServantNotActive ex) {
      Logger.getLogger(EntiteJournal.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public static void main(String[] args) {
    EntiteJournal e = new EntiteJournal();
    e.startEntite();
    e.startOrb();
  }
}

