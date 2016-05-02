package testidl;

import java.util.Random;

public class Cle implements Comparable<Cle>{

  private long cle;

  private static final Random GENERATEUR = new Random(System.currentTimeMillis());

  public Cle() {
	initCle();
  }

  public Cle(long cle) {
	this.cle = cle;
  }
  
  private void initCle() {
	cle = GENERATEUR.nextLong();
  }

  public long getCle() {
	return cle;
  }

  public long toIdl() {
	return cle;
  }
  
  @Override
  public int compareTo(Cle t) {
	if(this.cle < t.cle)
	  return -1;
	else if(this.cle > t.cle)
	  return 1;
	else
	  return 0;
  }

  @Override
  public int hashCode() {
	int hash = 5;
	hash = 31 * hash + (int) (this.cle ^ (this.cle >>> 32));
	return hash;
  }

  @Override
  public boolean equals(Object obj) {
	if (obj == null) {
	  return false;
	}
	if (getClass() != obj.getClass()) {
	  return false;
	}
	final Cle other = (Cle) obj;
	if (this.cle != other.cle) {
	  return false;
	}
	return true;
  }
  
  @Override
  public String toString() {
	return "Cle{ " + cle + " }";
  }

  public static void main(String[] args) {
	Cle c = new Cle();

	System.out.println(c);

  }

}
