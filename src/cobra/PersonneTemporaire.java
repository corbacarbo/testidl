package cobra;

import controleAcces.personneIdl;

public class PersonneTemporaire extends Personne {

  public PersonneTemporaire(Matricule matricule, String nom, String prenom, String photo) {
    super(matricule, nom, prenom, photo);
  }

  public PersonneTemporaire(personneIdl p) {
    super(p);
  }
  
  @Override
  public void genereMatricule() {
    this.matricule = new Matricule(Matricule.TYPE.TEMPORAIRE);
  }

  public personneIdl toIdl() {
    return new personneIdl(matricule.toIdl(), nom, prenom, photo, "", false, "");
  }

    public String getNom() {
        return this.nom;
    }

    public String getPhoto() {
        return this.photo;
    }

}
