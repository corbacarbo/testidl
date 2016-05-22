package cobra;

import controleAcces.personneIdl;

public class PersonnePermanent extends Personne {

  protected String mdp;

  protected boolean mdpChange;

  public PersonnePermanent(String mdp, boolean mdpChange, Matricule matricule, String nom, String prenom, String photo) {
    super(matricule, nom, prenom, photo);
    this.mdp = mdp;
    this.mdpChange = mdpChange;
  }

  public PersonnePermanent(personneIdl p) {
    super(p);
    mdpChange = p.mdpChange;
    if (p.mdp != null && !p.mdp.isEmpty()) {
      this.mdp = mdp;
    } else {
      this.mdp = null;
    }
  }

  public String getMdp() {
    return mdp;
  }
  
  public boolean isMdp(String mdp2){
    return mdp.equals(mdp2);
  }

  @Override
  public personneIdl toIdl() {
    return new personneIdl(matricule.toIdl(), nom, prenom, photo, mdp, mdpChange);
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
    s += ", nom=" + nom + ", prenom=" + prenom + ", photo=" + photo + '}';

    return s;
  }

    public String getNom() {
        return this.nom;
    }

    public String getPhoto() {
        return this.photo;
    }

}
