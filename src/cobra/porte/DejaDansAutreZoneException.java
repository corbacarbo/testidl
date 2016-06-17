package cobra.porte;

import cobra.Matricule;

public class DejaDansAutreZoneException extends Exception{
  String message;
  Matricule matricule;

  public DejaDansAutreZoneException(String message,Matricule m) {
	super();
	this.message = message;
	matricule = m;
  }
  
}
