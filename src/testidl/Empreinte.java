package testidl;

public class Empreinte {
  
  private long empreinte;
  
  public Empreinte(String s){
	empreinte = s.hashCode();
  }
  
  public long toIdl(){
	return empreinte;
  }
  
}
