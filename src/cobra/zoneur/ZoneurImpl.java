package cobra.zoneur;

import cobra.CorbaEntite;
import cobra.Matricule;
import controleAcces.annuaire;
import controleAcces.autorisateur;
import controleAcces.coffreFort;
import controleAcces.journal;
import controleAcces.zoneur;
import controleAcces.zoneurOperations;
import java.util.ArrayList;

public class ZoneurImpl implements zoneurOperations {

  private ArrayList<Matricule> personnes;

  private String zone;

  private CorbaEntite serveur;

  public ZoneurImpl(CorbaEntite serveur, String zone) {
	this.zone = zone;
	this.serveur = serveur;
	personnes = new ArrayList<>();
  }

  @Override
  public annuaire resolveAnnuaire() {
	return serveur.resolveAnnuaire();
  }

  @Override
  public coffreFort resolveCoffreFort() {
	return serveur.resolveCoffreFort();
  }

  @Override
  public journal resolveJournal() {
	return serveur.resolveJournal();
  }

  @Override
  public autorisateur resolveAutorisateur() {
	return serveur.resolveAutorisateur(zone);
  }

  @Override
  public autorisateur resolveAutorisateurTemporaire() {
	return serveur.resolveAutorisateurTemporaire();
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
	  zoneur zoneur = serveur.resolveZoneur(zoneString);
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
