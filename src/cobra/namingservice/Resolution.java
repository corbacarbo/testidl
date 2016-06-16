package cobra.namingservice;

import controleAcces.annuaire;
import controleAcces.autorisateur;
import controleAcces.coffreFort;
import controleAcces.journal;
import controleAcces.trousseau;
import controleAcces.zoneur;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public interface Resolution {
  
  
  public void fetchNamingservice(org.omg.CORBA.ORB orb);
  public org.omg.CORBA.Object resolve(String stringToFind) 
		  throws NotFound, CannotProceed,
		  org.omg.CosNaming.NamingContextPackage.InvalidName;
		
  public org.omg.CosNaming.NamingContext getNamingService();
  
  public annuaire resolveAnnuaire();
  public coffreFort resolveCoffreFort();
  public journal resolveJournal();
  public autorisateur resolveAutorisateur(String zone);
  public autorisateur resolveAutorisateurTemporaire();
  public trousseau resolveTrousseau();
  public zoneur resolveZoneur(String zone);
}
