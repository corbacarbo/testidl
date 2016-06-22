package cobra.journal;

import cobra.CorbaEntite;
import cobra.DemandeAcces;
import controleAcces.journalOperations;
import controleAcces.journalPackage.demandeIdl;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mélanie
 */
public class JournalImpl implements journalOperations {

  /**
   * Liste des logs de connexions et tentatives de connexions
   */
  private TreeSet<DemandeAcces> journalLog;

  private CorbaEntite serveur;

  public JournalImpl(CorbaEntite s) {
	super();
	serveur = s;
	journalLog = new TreeSet<>();
  }

  @Override
  public void loguer(demandeIdl demandeIdl) {
	DemandeAcces demAcc = new DemandeAcces(demandeIdl);
	journalLog.add(demAcc);
	if (demAcc.isImportance()) {
	  System.err.println(demAcc);
	} else {
	  System.out.println(demAcc);
	}
  }

  @Override
  public void loguerInconnu(demandeIdl demandeIdl) {
	DemandeAcces demAcc = new DemandeAcces(demandeIdl);
	journalLog.add(demAcc);
	if (demAcc.isImportance()) {
	  System.err.println(demAcc);
	} else {
	  System.out.println(demAcc);
	}
  }

  
}
