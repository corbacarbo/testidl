package cobra;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Horaire extends GregorianCalendar{
  
  public Horaire(String h, String m){
	super(0, 0, 0, Integer.parseInt(h), Integer.parseInt(m), 0);
  }
  
  public String heureToIdl(){
	return this.getDisplayName(HOUR, LONG_FORMAT, Locale.FRENCH);
  }
  
  public String minuteToIdl(){
	return this.getDisplayName(MINUTE, LONG_FORMAT, Locale.FRENCH);
  }

  @Override
  public String toString() {
	return "Horaire{" + this.get(HOUR) + ":" + this.get(MINUTE) + '}';
  }
  
  

  public static void main(String[] args) throws InterruptedException{
	Horaire h = new Horaire("08", "22");
	Thread.sleep(2);
	Horaire hh = new Horaire("08", "33");
	System.out.println(h);
	System.out.println(hh);
	
	if(h.compareTo(hh) < 0){
	System.out.println(" dans if");
	}
  }
}

