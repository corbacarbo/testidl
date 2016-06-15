package cobra;

import controleAcces.personneIdl;
import java.util.HashMap;

public class Personne {

  protected Matricule matricule;
  protected String nom;
  protected String prenom;
  protected String photo;

  public Personne(Matricule matricule, String nom, String prenom, String photo) {
    this.matricule = matricule;
    this.nom = nom;
    this.prenom = prenom;
    this.photo = photo;
  }

  public Personne(personneIdl p) {
    if (p.matricule != null && !p.matricule.isEmpty()) {
      this.matricule = new Matricule(p.matricule);
    }
    this.nom = p.nom;
    this.prenom = p.prenom;
    this.photo = p.photo;
  }

  public Matricule getMatricule() {
    return matricule;
  }

  public String getPrenom() {
    return prenom;
  }

  public String getPhoto() {
	return photo;
  }

  public void genereMatricule(){
	this.matricule = new Matricule(prenom);
  }

  public boolean isPermanent() {
    return matricule.isPermanent();
  }

  public boolean isTemporaire() {
    return matricule.isTemporaire();
  }

  public personneIdl toIdl(){
	return new personneIdl(matricule.toIdl(), nom, prenom, photo, "", false, "");
  }
  /**
   * 
   * @param personnes
   * @return le hashmap des personnes en entrée, avec en clé
   * la concaténation du matricule, du nom et du prénom, et en valeur, la personne associée
   */
  public static HashMap<String,Personne> tableToHashMap (personneIdl[] personnes){
     HashMap<String,Personne> personnesTrouvees = new HashMap<String,Personne>();
    for (personneIdl p : personnes){
          Personne pers = new Personne(p);
          personnesTrouvees.put(p.matricule+" - "+p.nom+" - "+p.prenom, pers);
      }
    return personnesTrouvees;
  }
  
  @Override
  public String toString() {
    return "Personne{" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", photo=" + photo + '}';
  }

  public String getPrenomNom() {
	return prenom + " " + nom.toUpperCase();
  }

}
