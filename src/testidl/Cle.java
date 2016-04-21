package testidl;

import java.util.Random;

public class Cle {

  private long cle;

  private static final Random GENERATEUR = new Random(System.currentTimeMillis());

  public Cle() {
	initCle();
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
  public String toString() {
	return "Cle{ " + cle + " }";
  }

  public static void main(String[] args) {
	Cle c = new Cle();

	System.out.println(c);

  }

}
