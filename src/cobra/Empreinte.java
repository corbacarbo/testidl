package cobra;

public class Empreinte implements Comparable<Empreinte>{

  /**
   * Hash d'une empreinte.
   */
  private long empreinte;

  /**
   * Constructeur du hash à partir d'un string représentant une empreinte.
   * @param s 
   */
  public Empreinte(String s) {
    empreinte = s.hashCode();
  }
  
  /**
   * Contructeur à partir d'un hash.
   * @param l 
   */
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

  @Override
  public String toString() {
	return "Empreinte{" + empreinte + '}';
  }
  
  

}
