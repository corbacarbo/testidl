package annuaire;

public class Personne {
    
    protected String matricule;
    protected String nom;
    protected String prenom;

    
    
    public Personne(String matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }
    
    public boolean isPermanent(){
      return matricule.startsWith("p");
    }

  @Override
  public String toString() {
    return "Personne{" + "matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + '}';
  }
    
    
    
    
}
