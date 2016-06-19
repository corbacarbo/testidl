package cobra.responsable;

public class AucuneSelectionException extends Exception{

  public String message;

  public AucuneSelectionException(String message) {
	this.message = message;
  }

}
