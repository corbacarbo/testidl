package testidl.annuaire;

import testidl.Personne;
import testidl.PersonneTemporaire;
import testidl.PersonnePermanent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataExample {

  public static HashMap<String, Personne> extractPersonnesFromFile(String filename) {

    HashMap<String, Personne> res = new HashMap<>();

    try {
      InputStream file = new FileInputStream(filename);
      Scanner scan = new Scanner(file);
      
      while(scan.hasNext()){
        String line = scan.next();
        Personne p = extractLine(line);
        res.put(p.getMatricule(), p);
      }
      

    } catch (FileNotFoundException ex) {
      Logger.getLogger(DataExample.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
      Logger.getLogger(DataExample.class.getName()).log(Level.SEVERE, null, ex);
    }

    return res;
  }
  
  private static Personne extractLine(String line) throws Exception{
    Personne p;
    
    String[] mots = line.split(";");
    String matricule = mots[0];
    String prenom = mots[1];
    String nom = mots[2];
    
    if(matricule.startsWith("p")){
      String mdp = mots[3];
      p = new PersonnePermanent(mdp, matricule, nom, prenom);
    }
    else if(matricule.startsWith("t")){
      p = new PersonneTemporaire(matricule, nom, prenom);
    }
    else{
      throw new Exception("Erreur de lecture du fichier des personnes.");
    }
    return p;
  }

}