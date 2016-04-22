package testidl;

public class Matricule {
  
  private String matricule;
  
  public static enum TYPE {PERMANENT, TEMPORAIRE};
  
  private static int nextNumberP = 10;
  private static int nextNumberT = 10;

  public Matricule(TYPE type) {
    if(type == TYPE.PERMANENT){
      matricule = "p" + ++nextNumberP;
    }
    else if(type == TYPE.TEMPORAIRE){
      matricule = "t" + ++nextNumberT;
    }
  }

  public Matricule(String matricule) {
    this.matricule = matricule;
  }
  
  public String toIdl(){
    return matricule;
  }
  
  public boolean isPermanent(){
    return matricule.startsWith("p");
  }
  
  public boolean isTemporaire(){
    return matricule.startsWith("t");
  }

  @Override
  public String toString() {
    return "Matricule{ " + matricule + " }";
  }
  
  
}
