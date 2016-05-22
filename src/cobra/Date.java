/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra;

import java.util.GregorianCalendar;

public class Date extends GregorianCalendar {

  public Date(int a, int m, int j) {
	super(a, m, j, 0, 0, 0);
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
	return "Date{" + get(DAY_OF_MONTH) + "/" + get(MONTH) + "/" + get(YEAR) + '}';
  }



}
