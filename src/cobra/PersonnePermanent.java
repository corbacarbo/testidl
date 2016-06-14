package cobra;

import controleAcces.personneIdl;

public class PersonnePermanent extends Personne {

  protected String mdp;

  protected boolean mdpChange;

  protected String responsabilite;

  public PersonnePermanent(String mdp, boolean mdpChange, String responsabilite, Matricule matricule, String nom, String prenom, String photo) {
	super(matricule, nom, prenom, photo);
	this.mdp = mdp;
	this.mdpChange = mdpChange;
	this.responsabilite = responsabilite;
  }

  public PersonnePermanent(personneIdl p) {
	super(p);
	this.mdpChange = p.mdpChange;
	if (p.mdp != null && !p.mdp.isEmpty()) {
	  this.mdp = p.mdp;
	} else {
	  this.mdp = null;
	}
	this.responsabilite = p.responsabilite;
  }

  public String getMdp() {
	return mdp;
  }

  public boolean isMdp(String mdp2) {
	return mdp.equals(mdp2);
  }

  @Override
  public personneIdl toIdl() {
	return new personneIdl(matricule.toIdl(), nom, prenom, photo, mdp, mdpChange, responsabilite);
  }

  public boolean isMdpChange() {
	return mdpChange;
  }

  public void setMdp(String mdp) {
	this.mdp = mdp;
	mdpChange = false;
  }

  @Override
  public void genereMatricule() {
	this.matricule = new Matricule(Matricule.TYPE.PERMANENT);
  }

  public void genereMdp() {
	this.mdp = prenom;
  }

  @Override
  public String toString() {
	String s = "Personne{" + matricule + ", mdp=" + mdp;
	if (mdpChange) {
	  s += " (à changer)";
	}
	s += ", nom=" + nom + ", prenom=" + prenom + ", photo=" + photo + ", responsabilite=" + responsabilite + '}';

	return s;
  }

  public String getNom() {
	return this.nom;
  }

  public String getPhoto() {
	return this.photo;
  }

  public boolean isReponsible(String s){
	return responsabilite.contains(s);
  }
}
