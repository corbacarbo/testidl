package testidl;

import controleAcces.personneIdl;

public class PersonnePermanent extends Personne {

  protected String mdp;
  
  protected boolean mdpChange;

  public PersonnePermanent(String mdp, Matricule matricule, String nom, String prenom, String photo) {
    super(matricule, nom, prenom, photo);
    this.mdp = mdp;
  }

  public PersonnePermanent(personneIdl p) {
    super(p);
    if(p.mdp != null && !p.mdp.isEmpty()){
      this.mdp = mdp;
    }
    else{
      this.mdp = null;
    }
  }
  
  public String getMdp() {
    return mdp;
  }

  @Override
  public personneIdl toIdl() {
    return new personneIdl(matricule.toString(), nom, prenom, photo, mdp, mdpChange);
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
  
  public void genereMdp(){
    this.mdp = prenom;
  }
  
  @Override
  public String toString() {
    return "Personne{" + matricule + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom + '}';
  }

  

}
