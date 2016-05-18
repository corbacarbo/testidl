package testidl;

public class Empreinte implements Comparable<Empreinte>{

  private long empreinte;

  public Empreinte(String s) {
    empreinte = s.hashCode();
  }
  
  public Empreinte(long l){
    empreinte = l;
  }

  public long toIdl() {
    return empreinte;
  }

  @Override
  public int compareTo(Empreinte t) {
    if(this.empreinte < t.empreinte)
      return -1;
    else if(this.empreinte > t.empreinte)
      return 1;
    else
      return 0;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    return hash;
  }

  /**
   *
   * @param obj
   * @return
   */
  @Override
  public boolean equals(Object obj) {
    Empreinte e = (Empreinte) obj;
    return this.empreinte == e.empreinte;
  }
  
  

}
