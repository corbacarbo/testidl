package testidl;

public class PersonnePermanent extends Personne {

  protected String mdp;

  public PersonnePermanent(String mdp, String matricule, String nom, String prenom) {
	super(matricule, nom, prenom);
	this.mdp = mdp;
  }

  public String getMdp() {
	return mdp;
  }

  @Override
  public String toString() {
	return "Personne{" + "mdp=" + mdp + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + '}';
  }

}
