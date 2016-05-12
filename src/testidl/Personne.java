package testidl;

import controleAcces.personneIdl;

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
	return new personneIdl(matricule.toString(), nom, prenom, photo, "", false);
  }
  
  @Override
  public String toString() {
    return "Personne{" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", photo=" + photo + '}';
  }

}
