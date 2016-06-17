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

  private Resolution ns;
  
  private int idPorte = 1;

  public ZoneurImpl(Resolution ns, String zone) {
	this.zone = zone;
	this.ns = ns;
	personnes = new ArrayList<>();
  }

  @Override
  public annuaire resolveAnnuaire() {
	System.out.println("==" + zone + " résolution annuaire.");
	return ns.resolveAnnuaire();
  }

  @Override
  public coffreFort resolveCoffreFort() {
	System.out.println("==" + zone + " résolution coffreFort.");
	return ns.resolveCoffreFort();
  }

  @Override
  public journal resolveJournal() {
	System.out.println("==" + zone + " résolution journal.");
	return ns.resolveJournal();
  }

  @Override
  public autorisateur resolveAutorisateur() {
	System.out.println("==" + zone + " résolution autorisateur.");
	return ns.resolveAutorisateur(zone);
  }

  @Override
  public autorisateur resolveAutorisateurTemporaire() {
	System.out.println("==" + zone + " résolution autorisateur temporaire.");
	return ns.resolveAutorisateurTemporaire();
  }

  @Override
  public trousseau resolveTrousseau() {
	System.out.println("==" + zone + " résolution trousseau.");
	return ns.resolveTrousseau();
  }

  @Override
  public boolean isNotInsideZone(String matriculeIdl) {
	Matricule matricule = new Matricule(matriculeIdl);
	return !personnes.contains(matricule);
  }

  @Override
  public boolean isNotInsideAllZoneEntree(String matriculeIdl) {
	char[] zoneChar = new char[1];
	zoneChar[0] = 'A';
	boolean continueParcours = true;

	if (isInsideZone(matriculeIdl)) {
	  return false;
	}

	while (continueParcours) {
	  String zoneString = new String(zoneChar);
	  zoneur zoneur = ns.resolveZoneur(zoneString);
	  if (!zoneString.equals(zone)) {
		if (zoneur != null) {
		  if (!zoneur.isNotInsideZone(matriculeIdl)) {
			return false;
		  }
		} else {
		  continueParcours = false;
		}
	  }
	  zoneChar[0]++;
	}
	return true;
  }

  @Override
  public boolean isNotInsideAllZoneSortie(String matriculeIdl) {
	char[] zoneChar = new char[1];
	zoneChar[0] = 'A';
	boolean continueParcours = true;

	while (continueParcours) {
	  String zoneString = new String(zoneChar);
	  zoneur zoneur = ns.resolveZoneur(zoneString);
	  if (!zoneString.equals(zone)) {
		if (zoneur != null) {
		  if (!zoneur.isNotInsideZone(matriculeIdl)) {
			return false;
		  }
		} else {
		  continueParcours = false;
		}
	  }
	  zoneChar[0]++;
	}
	return true;
  }

  @Override
  public boolean isInsideZone(String matriculeIdl) {
	Matricule matricule = new Matricule(matriculeIdl);
	return personnes.contains(matricule);
  }

  @Override
  public void entre(String matriculeIdl) {
	Matricule matricule = new Matricule(matriculeIdl);
	personnes.add(matricule);
	System.out.println("++" + zone + " entrée: " + matricule);
  }

  @Override
  public void sort(String matriculeIdl) {
	Matricule matricule = new Matricule(matriculeIdl);
	personnes.remove(matricule);
	System.out.println("--" + zone + " sortie: " + matricule);
  }

  @Override
  public int getIdPorte() {
	return idPorte++;
  }

  public static void main(String[] args) {

  }

}
