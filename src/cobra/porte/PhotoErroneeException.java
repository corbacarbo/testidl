package cobra.porte;

public class PhotoErroneeException extends Exception{
  
  String message;

  public PhotoErroneeException(String message) {
	super();
	this.message = message;
  }
}
