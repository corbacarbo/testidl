package cobra.namingservice;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;

public class NamingService extends org.openorb.util.MapNamingContext{

  public static void main(String[] args){
	org.openorb.util.MapNamingContext.main(args);
  }

  public NamingService(ORB orb, POA poa) {
	super(orb, poa);
	addZoneContext();
  }

  public NamingService(ORB orb, POA poa, String string) throws AdapterAlreadyExists {
	super(orb, poa, string);
	addZoneContext();
  }

  private void addZoneContext(){
	addContext("A");
	addContext("B");
	addContext("C");
	addContext("D");
	addContext("E");
  }

}
