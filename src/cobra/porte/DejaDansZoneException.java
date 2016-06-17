package cobra.porte;

import cobra.Matricule;

public class DejaDansZoneException extends Exception{
  String message;
  Matricule matricule;

  public DejaDansZoneException(String message, Matricule m) {
	super();
	this.message = message;
	matricule = m;
  }
  
  
}
