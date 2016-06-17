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
import cobra.namingservice.Resolution;
import controleAcces.annuaire;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.autorisateur;
import controleAcces.autorisateurPackage.autorisationRefuseeException;
import controleAcces.coffreFort;
import controleAcces.coffreFortPackage.empreinteInconnueException;
import controleAcces.personneIdl;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import controleAcces.zoneur;

/**
 *
 * @author matt
 */
public class Porte extends CorbaClient implements Runnable {

  private String zone;
  
  private int id;

  private PorteFrame porteFrame;

  private Cle cle;

  public Porte(String zone) {
	super("contexte", zone);
	cle = null;
	this.zone = zone;
	renewCle();
	id = ns.resolveZoneur(zone).getIdPorte();
  }

  public void renewCle() {
	if (cle == null) {
	  cle = new Cle(ns.resolveTrousseau().startSession("ABCDE"));
	} else {
	  cle = new Cle(ns.resolveTrousseau().startSession("ABCDE"));
	}
  }

  public void checkCle() {
	try {
	  ns.resolveTrousseau().valideSession(cle.toIdl());
	} catch (sessionInvalidException | sessionExpireeException ex) {
	  renewCle();
	}
  }

  public String getZone() {
	return zone;
  }

  public Resolution getNs() {
	return ns;
  }

  public int getId() {
	return id;
  }
  
  public Personne entrer(Empreinte e, String photo)
		  throws empreinteInconnueException,
		  sessionInvalidException,
		  sessionExpireeException,
		  personneInexistanteException,
		  autorisationRefuseeException,
		  PhotoErroneeException,
		  DejaDansZoneException {
	Personne personne;
	Matricule matricule;
	checkCle();

	// 1-Récupération du matricule à partir de l'empreinte
	coffreFort cf = ns.resolveCoffreFort();
	String mat = cf.validerEmpreinte(cle.toIdl(), e.toIdl());
	matricule = new Matricule(mat);

	// 2-Récupération de la personne à partir du matricule
	annuaire an = ns.resolveAnnuaire();
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

	zoneur zo = ns.resolveZoneur(zone);
	if (!zo.isNotInsideAllZoneEntree(matricule.toIdl())) {
	  throw new DejaDansZoneException("Déjà dans une zone " + "  " + matricule, matricule);
	}
	
	// 4-Vérification de l'autorisation
	if (matricule.isPermanent()) {
	  autorisateur au = ns.resolveAutorisateur(zone);
	  au.autoriser(matricule.toIdl(), zone);
	} else {
	  autorisateur at = ns.resolveAutorisateurTemporaire();
	  at.autoriser(matricule.toIdl(), zone);
	}


	zo.entre(matricule.toIdl());
	
	return personne;
  }

  public Personne sortir(Empreinte e, String photo)
		  throws empreinteInconnueException,
		  sessionInvalidException,
		  sessionExpireeException,
		  personneInexistanteException,
		  autorisationRefuseeException,
		  PhotoErroneeException,
		  DejaDansAutreZoneException,
		  PasDansZoneException {
	Personne personne;
	Matricule matricule;
	checkCle();

	// 1-Récupération du matricule à partir de l'empreinte
	coffreFort cf = ns.resolveCoffreFort();
	String mat = cf.validerEmpreinte(cle.toIdl(), e.toIdl());
	matricule = new Matricule(mat);

	// 2-Récupération de la personne à partir du matricule
	annuaire an = ns.resolveAnnuaire();
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
	
	zoneur zo = ns.resolveZoneur(zone);
	if (!zo.isNotInsideAllZoneSortie(matricule.toIdl())) {
	  throw new DejaDansAutreZoneException("Déjà dans une zone " + "  " + matricule, matricule);
	}
	if (!zo.isInsideZone(mat)) {
	  throw new PasDansZoneException("Pas dans zone " + zone + "  " + matricule, matricule);
	}

	// 4-Vérification de l'autorisation
	if (matricule.isPermanent()) {
	  autorisateur au = ns.resolveAutorisateur(zone);
	  au.autoriser(matricule.toIdl(), zone);
	} else {
	  autorisateur at = ns.resolveAutorisateurTemporaire();
	  at.autoriser(matricule.toIdl(), zone);
	}

	
	
	zo.sort(matricule.toIdl());

	return personne;
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
