/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra;

import java.util.GregorianCalendar;

public class Date extends GregorianCalendar {

  public Date(int a, int m, int j) {
	super(a, m - 1, j, 0, 0, 0);
  }
  
  public Date(String s){
	this(Integer.parseInt(s.split("/")[2]), Integer.parseInt(s.split("/")[1]), Integer.parseInt(s.split("/")[0]));
  }

  public Date(GregorianCalendar cal){
	this(cal.get(YEAR), cal.get(MONTH) + 1, cal.get(DAY_OF_MONTH));
  }
  
  public int jourToIdl() {
	return get(DAY_OF_MONTH);
  }
  
  public int moisToIdl(){
	return get(MONTH);
  }
  
  public int anneeToIdl(){
	return get(YEAR);
  }

  @Override
  public String toString() {
	return "Date{" + get(DAY_OF_MONTH) + "/" + (get(MONTH)+1) + "/" + get(YEAR) + '}';
  }

  public static void main(String[] args){
	Date d = new Date("02/05/2016");
	Date dd = new Date("02/05/2016");
	
	System.out.println(d);
	
	if (d.compareTo(dd) < 0) {
	  System.out.println("inf");
	}
	if (d.compareTo(dd) == 0) {
	  System.out.println("egal");
	}
	if (d.compareTo(dd) > 0) {
	  System.out.println("sup");
	}
  }

}
