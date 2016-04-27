package testidl;

import controleAcces.personneIdl;

public class Personne {

  protected Matricule matricule;
  protected String nom;
  protected String prenom;

  public Personne(Matricule matricule, String nom, String prenom) {
    this.matricule = matricule;
    this.nom = nom;
    this.prenom = prenom;
  }

  public Matricule getMatricule() {
    return matricule;
  }

  public boolean isPermanent() {
    return matricule.isPermanent();
  }

  public boolean isTemporaire() {
    return matricule.isTemporaire();
  }
  
  @Override
  public String toString() {
    return "Personne{" + matricule + ", nom=" + nom + ", prenom=" + prenom + '}';
  }

}
