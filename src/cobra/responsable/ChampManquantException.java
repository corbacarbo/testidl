package cobra.responsable;

public class ChampManquantException extends Exception{
  
  public String message;

  public ChampManquantException(String message) {
	this.message = message;
  }
  
  
}
