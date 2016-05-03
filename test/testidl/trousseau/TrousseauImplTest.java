/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testidl.trousseau;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matt
 */
public class TrousseauImplTest {
  
  public TrousseauImplTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of tempsSessionMilliSecondes method, of class TrousseauImpl.
   */
  @Test
  public void testTempsSessionMilliSecondes() {
	System.out.println("tempsSessionMilliSecondes");
	TrousseauImpl instance = null;
	long expResult = 0L;
	long result = instance.tempsSessionMilliSecondes();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
  }

  /**
   * Test of startSession method, of class TrousseauImpl.
   */
  @Test
  public void testStartSession() {
	System.out.println("startSession");
	TrousseauImpl instance = null;
	long expResult = 0L;
	long result = instance.startSession();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
  }

  /**
   * Test of valideSession method, of class TrousseauImpl.
   */
  @Test
  public void testValideSession() throws Exception {
	System.out.println("valideSession");
	long cleIdl = 0L;
	TrousseauImpl instance = null;
	instance.valideSession(cleIdl);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
  }
  
}
