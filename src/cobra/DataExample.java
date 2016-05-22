package cobra;

import cobra.Personne;
import cobra.PersonneTemporaire;
import cobra.PersonnePermanent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import cobra.Matricule;

public class DataExample {

  private static String filenamePersonne = "src/cobra/listePersonne.txt";
  
  private static String fileNameAutorisation = "src/cobra/listeAutorisation.txt";

  public static HashMap<Matricule, Personne> extractPersonnesFromFile() {

	HashMap<Matricule, Personne> res = new HashMap<>();

	try {
	  InputStream file = new FileInputStream(filenamePersonne);
	  Scanner scan = new Scanner(file);
	  scan.nextLine();

	  while (scan.hasNext()) {
		String line = scan.nextLine();
		Personne p = extractLinePersonne(line);
		res.put(p.getMatricule(), p);
	  }

	} catch (FileNotFoundException ex) {
	  Logger.getLogger(DataExample.class.getName()).log(Level.SEVERE, null, ex);
	} catch (Exception ex) {
	  Logger.getLogger(DataExample.class.getName()).log(Level.SEVERE, null, ex);
	}

	return res;
  }

  private static Personne extractLinePersonne(String line) throws Exception {
	Personne p;

	String[] mots = line.split(";");
	Matricule matricule = new Matricule(mots[0]);
	String prenom = mots[1];
	String nom = mots[2];
	String photo = mots[4];
	boolean mdpChange = Boolean.parseBoolean(mots[5]);

	if (matricule.isPermanent()) {
	  String mdp = mots[3];
	  p = new PersonnePermanent(mdp, mdpChange, matricule, nom, prenom, photo);
	} else if (matricule.isTemporaire()) {
	  p = new PersonneTemporaire(matricule, nom, prenom, photo);
	} else {
	  throw new Exception("Erreur de lecture du fichier des personnes.");
	}
	return p;
  }

  public static HashMap<Empreinte, Matricule> extractEmpreintesFromFile() {

	HashMap<Empreinte, Matricule> res = new HashMap<>();

	try {
	  InputStream file = new FileInputStream(filenamePersonne);
	  Scanner scan = new Scanner(file);
	  scan.nextLine();

	  while (scan.hasNext()) {
		String line = scan.nextLine();
		String[] mots = line.split(";");
		Matricule matricule = new Matricule(mots[0]);
		Empreinte empreinte = new Empreinte(mots[6]);
		res.put(empreinte, matricule);
	  }

	} catch (FileNotFoundException ex) {
	  Logger.getLogger(DataExample.class.getName()).log(Level.SEVERE, null, ex);
	} catch (Exception ex) {
	  Logger.getLogger(DataExample.class.getName()).log(Level.SEVERE, null, ex);
	}

	return res;
  }

  public static HashMap<Matricule, Autorisation> extractAutorisationsFromFile(){
	HashMap<Matricule, Autorisation> res = new HashMap<>();

	try {
	  InputStream file = new FileInputStream(filenamePersonne);
	  Scanner scan = new Scanner(file);
	  scan.nextLine();

	  while (scan.hasNext()) {
		String line = scan.nextLine();
		Personne p = extractLinePersonne(line);
		//res.put(p.getMatricule(), p);
	  }

	} catch (FileNotFoundException ex) {
	  Logger.getLogger(DataExample.class.getName()).log(Level.SEVERE, null, ex);
	} catch (Exception ex) {
	  Logger.getLogger(DataExample.class.getName()).log(Level.SEVERE, null, ex);
	}

	return res;
	
  }
  
    private static Personne extractLineAutorisation(String line) throws Exception {
	Personne p;

	String[] mots = line.split(";");
	Matricule matricule = new Matricule(mots[0]);
	String prenom = mots[1];
	String nom = mots[2];
	String photo = mots[4];
	boolean mdpChange = Boolean.parseBoolean(mots[5]);

	if (matricule.isPermanent()) {
	  String mdp = mots[3];
	  p = new PersonnePermanent(mdp, mdpChange, matricule, nom, prenom, photo);
	} else if (matricule.isTemporaire()) {
	  p = new PersonneTemporaire(matricule, nom, prenom, photo);
	} else {
	  throw new Exception("Erreur de lecture du fichier des personnes.");
	}
	return p;
  }
  
}
