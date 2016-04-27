package testidl;

import controleAcces.personneIdl;

public class PersonnePermanent extends Personne {

  protected String mdp;

  public PersonnePermanent(String mdp, Matricule matricule, String nom, String prenom) {
    super(matricule, nom, prenom);
    this.mdp = mdp;
  }

  public String getMdp() {
    return mdp;
  }

  public personneIdl toIdl() {
    return new personneIdl(matricule.toString(), nom, prenom, "", mdp);
  }

  @Override
  public String toString() {
    return "Personne{" + matricule + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom + '}';
  }

}
