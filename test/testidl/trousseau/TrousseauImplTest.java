/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testidl.trousseau;

import controleAcces.trousseauPackage.sessionExpireeException;
import controleAcces.trousseauPackage.sessionInvalidException;
import static java.lang.Thread.sleep;
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
  
  private EntiteTrousseau entite;
  
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
	entite = new EntiteTrousseau();
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
  }

  /**
   * Test of startSession method, of class TrousseauImpl.
   */
  @Test
  public void testStartSession() {
	System.out.println("startSession");
	TrousseauImpl instance = new TrousseauImpl(entite);
	long result = instance.startSession();
  }

  /**
   * Test of valideSession method, of class TrousseauImpl.
   */
  @Test
  public void testValideSession() throws Exception {
	System.out.println("valideSession");
	long cle;
	TrousseauImpl instance = new TrousseauImpl(entite);
	
	//Temps de session à 5 secondes.
	instance.setTempsSession(5);
	//Démarrage d'une session pour tester son suivi.
	cle = instance.startSession();
	
	//Test OK
	instance.valideSession(cle);
	
	//Test session expirée
	try{
	  sleep(10000); //Attente de l'expiration de la session
	  instance.valideSession(cle);
	  fail("La session devrait être expirée");
	}
	catch(sessionExpireeException ex){
	}
	
	//Test clé invalide
	try{
	  sleep(10); //Attente de l'expiration de la session
	  instance.valideSession(cle + 1);
	  fail("La clé devrait être invalide.");
	}
	catch(sessionInvalidException ex){
	}
  }
  
}
