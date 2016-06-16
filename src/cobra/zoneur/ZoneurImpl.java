package cobra.zoneur;

import cobra.CorbaEntite;
import cobra.Matricule;
import cobra.namingservice.Resolution;
import controleAcces.annuaire;
import controleAcces.autorisateur;
import controleAcces.coffreFort;
import controleAcces.journal;
import controleAcces.trousseau;
import controleAcces.zoneur;
import controleAcces.zoneurOperations;
import java.util.ArrayList;

public class ZoneurImpl implements zoneurOperations {

  private ArrayList<Matricule> personnes;

  private String zone;

  private CorbaEntite serveur;

  private Resolution ns;

  public ZoneurImpl(Resolution ns, String zone) {
	this.zone = zone;
	this.ns = ns;
	personnes = new ArrayList<>();
  }

  @Override
  public annuaire resolveAnnuaire() {
	return ns.resolveAnnuaire();
  }

  @Override
  public coffreFort resolveCoffreFort() {
	return ns.resolveCoffreFort();
  }

  @Override
  public journal resolveJournal() {
	return ns.resolveJournal();
  }

  @Override
  public autorisateur resolveAutorisateur() {
	return ns.resolveAutorisateur(zone);
  }

  @Override
  public autorisateur resolveAutorisateurTemporaire() {
	return ns.resolveAutorisateurTemporaire();
  }

  @Override
  public trousseau resolveTrousseau() {
	return ns.resolveTrousseau();
  }

  @Override
  public boolean isNotInsideZone(String matriculeIdl) {
	Matricule matricule = new Matricule(matriculeIdl);
	return !personnes.contains(matricule);
  }

  @Override
  public boolean isNotInsideAllZone(String matriculeIdl) {
	char[] zoneChar = new char[1];
	zoneChar[0] = 'A';
	boolean continueParcours = true;

	while (continueParcours) {
	  String zoneString = new String(zoneChar);
	  zoneur zoneur = ns.resolveZoneur(zoneString);
	  if (zoneur != null) {
		if (!zoneur.isNotInsideZone(matriculeIdl)) {
		  return false;
		}
	  } else {
		continueParcours = false;
	  }
	  zoneChar[0]++;
	}
	return true;
  }

  public static void main(String[] args) {

  }

  @Override
  public void entre(String matriculeIdl) {
	Matricule matricule = new Matricule(matriculeIdl);
	personnes.add(matricule);
  }

  @Override
  public void sort(String matriculeIdl) {
	Matricule matricule = new Matricule(matriculeIdl);
	personnes.remove(matricule);
  }

}
