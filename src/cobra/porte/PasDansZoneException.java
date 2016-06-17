package cobra.porte;

import cobra.Matricule;

public class PasDansZoneException extends Exception{
  String message;
  Matricule matricule;

  public PasDansZoneException(String message, Matricule m) {
	super();
	this.message = message;
	matricule = m;
  }
  
  
}
