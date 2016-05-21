package cobra.autorisateur;

import cobra.Autorisation;
import cobra.CorbaEntite;
import cobra.Matricule;
import controleAcces.autorisateurOperations;
import controleAcces.autorisateurPackage.autorisationPIdl;
import controleAcces.autorisateurPackage.autorisationRefuseeException;
import controleAcces.autorisateurPackage.autorisationTIdl;
import controleAcces.autorisateurPackage.conflitAutorisationException;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.util.HashMap;

public class AutorisateurImpl implements autorisateurOperations{

  private CorbaEntite serveur;
  
  private HashMap<Matricule, Autorisation> autorisations;

  public AutorisateurImpl(CorbaEntite serveur) {
	this.serveur = serveur;
  }
  
  private void remplirAutorisation(){
	
  }

  @Override
  public void ajouterAutorisationP(long cleIdl, autorisationPIdl autorisationIdl) throws conflitAutorisationException, sessionInvalidException, sessionExpireeException {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void ajouterAutorisationT(long cleIdl, autorisationTIdl autorisationIdl) throws conflitAutorisationException, sessionInvalidException, sessionExpireeException {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void autoriser(String matriculeIdl) throws autorisationRefuseeException {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }



  
}
