package cobra.responsable;

import cobra.Personne;

public class PersonneListModel {
  
  private Personne personne;

  public PersonneListModel(Personne personne) {
	this.personne = personne;
  }

  public Personne getPersonne() {
	return personne;
  }
  
  @Override
  public String toString() {
	return personne.getPrenom() + " " + personne.getNom() + " - " + personne.getMatricule().toIdl();
  }
  
  
  
}
