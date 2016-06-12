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
import controleAcces.personneIdl;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matt
 */
public class Porte extends CorbaClient {

  private String zone;

  private Cle cle;

  private long lastRenew;

  public Porte() {
	cle = null;
	renewCle();
  }

  public void renewCle() {
	if (cle == null) {
	  cle = new Cle(resolveTrousseau().startSession("ABCDEF"));
	  lastRenew = System.currentTimeMillis();
	} else {
	  try {
		resolveTrousseau().valideSession(cle.toIdl());
	  } catch (sessionInvalidException ex) {
		Logger.getLogger(Porte.class.getName()).log(Level.SEVERE, null, ex);
	  } catch (sessionExpireeException ex) {
		cle = new Cle(resolveTrousseau().startSession("ABCDEF"));
		lastRenew = System.currentTimeMillis();
	  }
	}
  }

  public void checkCle() {
	if (System.currentTimeMillis() - lastRenew > 480000) {
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
	coffreFort cf = resolveCoffreFort();
	String mat = cf.validerEmpreinte(cle.toIdl(), e.toIdl());
	matricule = new Matricule(mat);

	// 2-Récupération de la personne à partir du matricule
	annuaire an = resolveAnnuaire();
	personneIdl pers = an.validerIdentite(matricule.toIdl());

	if (matricule.isPermanent()) {
	  personne = new PersonnePermanent(pers);
	} else {
	  personne = new PersonneTemporaire(pers);
	}
	
	// 3-Comparaison des photos
	if(!photo.equals(personne.getPhoto())){
	  throw new PhotoErroneeException("Photos différentes: " + photo + "<>"+ personne.getPhoto());
	}

	// 4-Vérification de l'autorisation
	if (matricule.isPermanent()) {
	  autorisateur au = resolveAutorisateur(zone);
	  au.autoriser(matricule.toIdl(), zone);
	} else {
	  autorisateur at = resolveAutorisateurTemporaire();
	  at.autoriser(matricule.toIdl(), zone);
	}
	return personne;
  }

  public static void main(String[] args) {
	Porte porte = new Porte();
	autorisateur a = porte.resolveAutorisateur("A");
	autorisateur t = porte.resolveAutorisateurTemporaire();

	Matricule matricule = new Matricule("tjean");

	try {
	  t.autoriser(matricule.toIdl(), "C");
	  System.out.println("Ok");
	} catch (autorisationRefuseeException ex) {
	  System.out.println(ex.message);
	}
  }
}
