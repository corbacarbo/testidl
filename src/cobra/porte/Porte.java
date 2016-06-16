/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.porte;

import cobra.Cle;
import cobra.CorbaClient;
import cobra.Empreinte;
import cobra.Matricule;
import cobra.Personne;
import cobra.PersonnePermanent;
import cobra.PersonneTemporaire;
import controleAcces.annuaire;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.autorisateur;
import controleAcces.autorisateurPackage.autorisationRefuseeException;
import controleAcces.coffreFort;
import controleAcces.coffreFortPackage.empreinteInconnueException;
import controleAcces.journal;
import controleAcces.personneIdl;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import controleAcces.trousseau;

/**
 *
 * @author matt
 */
public class Porte extends CorbaClient implements Runnable {

  private String zone;

  private PorteFrame porteFrame;

  private Cle cle;

  private long lastRenew;

  public Porte(String zone) {
	cle = null;
	this.zone = zone;
	renewCle();
  }

  public void renewCle() {
	if (cle == null) {
	  cle = new Cle(resolveTrousseau().startSession("ABCDE"));
	  lastRenew = System.currentTimeMillis();
	} else {

	  cle = new Cle(resolveTrousseau().startSession("ABCDE"));

	}
  }

  public void checkCle() {
	try {
	  resolveTrousseau().valideSession(cle.toIdl());

	} catch (sessionInvalidException | sessionExpireeException ex) {
	  renewCle();
	}
  }

  public String getZone() {
	return zone;
  }

  public Personne entrer(Empreinte e, String photo)
		  throws empreinteInconnueException,
		  sessionInvalidException,
		  sessionExpireeException,
		  personneInexistanteException,
		  autorisationRefuseeException,
		  PhotoErroneeException {
	Personne personne;
	Matricule matricule;
	checkCle();

	// 1-Récupération du matricule à partir de l'empreinte
	coffreFort cf = resolveZoneur(zone).resolveCoffreFort();
	String mat = cf.validerEmpreinte(cle.toIdl(), e.toIdl());
	matricule = new Matricule(mat);

	// 2-Récupération de la personne à partir du matricule
	annuaire an = resolveZoneur(zone).resolveAnnuaire();
	personneIdl pers = an.validerIdentite(matricule.toIdl());

	if (matricule.isPermanent()) {
	  personne = new PersonnePermanent(pers);
	} else {
	  personne = new PersonneTemporaire(pers);
	}

	// 3-Comparaison des photos
	if (!photo.equals(personne.getPhoto())) {
	  throw new PhotoErroneeException("Photos différentes: " + photo + "<>" + personne.getPhoto());
	}

	// 4-Vérification de l'autorisation
	if (matricule.isPermanent()) {
	  autorisateur au = resolveZoneur(zone).resolveAutorisateur();
	  au.autoriser(matricule.toIdl(), zone);
	} else {
	  autorisateur at = resolveZoneur(zone).resolveAutorisateurTemporaire();
	  at.autoriser(matricule.toIdl(), zone);
	}
	return personne;
  }

  public Personne sortir(Empreinte e, String photo)
		  throws empreinteInconnueException,
		  sessionInvalidException,
		  sessionExpireeException,
		  personneInexistanteException,
		  autorisationRefuseeException,
		  PhotoErroneeException {
	Personne personne;
	Matricule matricule;
	checkCle();

	// 1-Récupération du matricule à partir de l'empreinte
	coffreFort cf = resolveZoneur(zone).resolveCoffreFort();
	String mat = cf.validerEmpreinte(cle.toIdl(), e.toIdl());
	matricule = new Matricule(mat);

	// 2-Récupération de la personne à partir du matricule
	annuaire an = resolveZoneur(zone).resolveAnnuaire();
	personneIdl pers = an.validerIdentite(matricule.toIdl());

	if (matricule.isPermanent()) {
	  personne = new PersonnePermanent(pers);
	} else {
	  personne = new PersonneTemporaire(pers);
	}

	// 3-Comparaison des photos
	if (!photo.equals(personne.getPhoto())) {
	  throw new PhotoErroneeException("Photos différentes: " + photo + "<>" + personne.getPhoto());
	}

	// 4-Vérification de l'autorisation
	if (matricule.isPermanent()) {
	  autorisateur au = resolveZoneur(zone).resolveAutorisateur();
	  au.autoriser(matricule.toIdl(), zone);
	} else {
	  autorisateur at = resolveZoneur(zone).resolveAutorisateurTemporaire();
	  at.autoriser(matricule.toIdl(), zone);
	}
	return personne;
  }

  @Override
  public annuaire resolveAnnuaire(){
	throw new RuntimeException("Appel non optimisé.");
  }
  @Override
  public coffreFort resolveCoffreFort(){
	throw new RuntimeException("Appel non optimisé.");
  }
  @Override
  public journal resolveJournal(){
	throw new RuntimeException("Appel non optimisé.");
  }
  @Override
  public autorisateur resolveAutorisateur(String zone){
	throw new RuntimeException("Appel non optimisé.");
  }
  @Override
  public autorisateur resolveAutorisateurTemporaire(){
	throw new RuntimeException("Appel non optimisé.");
  }
  @Override
  public trousseau resolveTrousseau(){
	throw new RuntimeException("Appel non optimisé.");
  }
  
  @Override
  public void run() {
	porteFrame = new PorteFrame(this);
	porteFrame.setVisible(true);
  }

  public static void main(String[] args) {
	String zones = "ABC";

	for (int i = 0; i < zones.length(); i++) {
	  Thread tPorte = new Thread(new Porte(zones.substring(i, i + 1)));
	  tPorte.start();
	}
  }

}
