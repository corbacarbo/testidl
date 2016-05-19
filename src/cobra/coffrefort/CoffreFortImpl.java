package cobra.coffrefort;

import cobra.Cle;
import cobra.CorbaEntite;
import cobra.DataExample;
import cobra.Empreinte;
import cobra.Matricule;
import controleAcces.coffreFortOperations;
import controleAcces.coffreFortPackage.empreinteInconnueException;
import controleAcces.coffreFortPackage.matriculeInconnuException;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.util.HashMap;

public class CoffreFortImpl implements coffreFortOperations {

  private CorbaEntite serveur;

  private HashMap<Empreinte, Matricule> empreintes;

  public CoffreFortImpl(CorbaEntite serveur) {
	this.serveur = serveur;
	remplirCoffreFort();
  }

  private void remplirCoffreFort() {
	String chemin = "src\\cobra\\coffrefort\\listePersonne.txt";
    empreintes = DataExample.extractEmpreintesFromFile();
    afficher();
  }
  
  private void afficher(){
	System.out.println("------------------------");
	empreintes.keySet().stream().forEach((e) -> {
	  System.out.println(empreintes.get(e) + "  " + e);
	});
	System.out.println("------------------------");
  }
  
  private Empreinte getEmpreinte(Matricule matricule) throws matriculeInconnuException {
	for (Empreinte empreinte : empreintes.keySet()) {
	  Matricule m = empreintes.get(empreinte);
	  if (m.equals(matricule)) {
		return empreinte;
	  }
	}
	throw new matriculeInconnuException("Empreinte inconnue. " + matricule);
  }

  @Override
  public void aEmpreinte(long cleIdl, String matriculeIdl) throws matriculeInconnuException, sessionInvalidException, sessionExpireeException {
	serveur.resolveTrousseau().valideSession(cleIdl);
	
	Matricule matricule = new Matricule(matriculeIdl);
	Empreinte empreinte = getEmpreinte(matricule);
	
	System.out.println("## Empreinte vérifiée " + empreinte + "  " + matricule + "     " + new Cle(cleIdl));
  }

  
  @Override
  public String validerEmpreinte(long cleIdl, long empreinteIdl) throws empreinteInconnueException, sessionInvalidException, sessionExpireeException {
	serveur.resolveTrousseau().valideSession(cleIdl);

	Matricule matricule;
	Empreinte empreinte = new Empreinte(empreinteIdl);
	if (empreintes.containsKey(empreinte)) {
	  matricule = empreintes.get(empreinte);
	  System.out.println("## Empreinte validée " + empreinte + "    " + new Cle(cleIdl));
	  return matricule.toIdl();
	} else {
	  throw new empreinteInconnueException("Empreinte " + empreinte + " introuvable");
	}
  }

  @Override
  public void modificationEmpreinte(long cleIdl, long empreinteIdl, String matriculeIdl) throws matriculeInconnuException, sessionInvalidException, sessionExpireeException {
	serveur.resolveTrousseau().valideSession(cleIdl);

	Matricule matricule = new Matricule(matriculeIdl);
	Empreinte newEmpreinte = new Empreinte(empreinteIdl);
	
	// Empreinte à supprimer
	Empreinte oldEmpreinte = getEmpreinte(matricule);
	empreintes.remove(oldEmpreinte);
	
	// Ajout nouvelle empreinte
	empreintes.put(newEmpreinte, matricule);
	
	System.out.println("-+ Empreinte modifiée " + newEmpreinte + "  " + matricule + "     " + new Cle(cleIdl));
  }

  @Override
  public void ajouterEmpreinteTemp(long cleIdl, long empreinteIdl, String matriculeIdl) throws sessionInvalidException, sessionExpireeException {
	serveur.resolveTrousseau().valideSession(cleIdl);
	
	Matricule matricule = new Matricule(matriculeIdl);
	Empreinte empreinte = new Empreinte(empreinteIdl);
	
	empreintes.put(empreinte, matricule);
	
	System.out.println("++ Empreinte ajoutée " + empreinte + "  " + matricule + "     " + new Cle(cleIdl));
  }

  @Override
  public void supprimerEmpreinteTemp(long cleIdl, String matriculeIdl) throws matriculeInconnuException, sessionInvalidException, sessionExpireeException {
	serveur.resolveTrousseau().valideSession(cleIdl);
	
	Matricule matricule = new Matricule(matriculeIdl);
	Empreinte empreinte = getEmpreinte(matricule);
	
	empreintes.remove(empreinte);
	
	System.out.println("-- Empreinte supprimée " + empreinte + "  " + matricule + "     " + new Cle(cleIdl));
  }

  


}
