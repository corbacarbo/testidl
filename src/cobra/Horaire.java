package cobra;

import java.util.GregorianCalendar;

public class Horaire extends GregorianCalendar {

  public Horaire(int h, int m) {
	super(0, 0, 0, h, m, 0);
  }

  public Horaire(String horaire){
	this(Integer.parseInt(horaire.split(":")[0]), Integer.parseInt(horaire.split(":")[1]));
  }
  
  public Horaire(GregorianCalendar cal){
	this(cal.get(HOUR_OF_DAY), cal.get(MINUTE));
  }
  
  public int heureToIdl() {
	return get(HOUR_OF_DAY);
  }

  public int minuteToIdl() {
	return get(MINUTE);
  }

  @Override
  public String toString() {
	return "Horaire{" + get(HOUR_OF_DAY) + ":" + get(MINUTE) + '}';
  }

  public static void main(String[] args) throws InterruptedException {
	/* Tests */
	Horaire h = new Horaire(8, 22);
	Thread.sleep(1000);
	Horaire hh = new Horaire("08:01");
	System.out.println(h);
	System.out.println(hh);

	if (h.compareTo(hh) < 0) {
	  System.out.println("inf");
	}
	if (h.compareTo(hh) == 0) {
	  System.out.println("egal");
	}
	if (h.compareTo(hh) > 0) {
	  System.out.println("sup");
	}
	
	GregorianCalendar gre = new GregorianCalendar();
	h = new Horaire(gre);
	System.out.println(h);
	
	/* Fin tests */
  }
}
