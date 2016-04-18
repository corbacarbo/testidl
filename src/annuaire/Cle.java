package annuaire;

import controleAcces.cle;
import java.util.Random;

public class Cle {

  private long cle;

  private static final Random generateur = new Random(System.currentTimeMillis());

  public Cle() {
	initCle();
  }

  private void initCle() {
	cle = generateur.nextLong();
  }

  public long getCle() {
	return cle;
  }

  public cle toCle() {
	return new cle(cle);
  }

  @Override
  public String toString() {
	return "Cle:" + cle + ':';
  }

  public static void main(String[] args) {
	Cle c = new Cle();

	System.out.println(c);

  }

}
