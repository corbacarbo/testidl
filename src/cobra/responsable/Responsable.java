package cobra.responsable;

import cobra.CorbaClient;

public class Responsable extends CorbaClient implements Runnable{

  private String zone;
  
  private ResponsableFrame responsableFrame;
  
  public Responsable(String resolutionType, String zone) {
	super(resolutionType, zone);
	this.zone = zone;
  }

  public String getZone() {
	return zone;
  }

  @Override
  public void run() {
	responsableFrame = new ResponsableFrame(this);
	responsableFrame.setVisible(true);
  }
  
  public static void main(String[] args) {
    
  }
  
}
