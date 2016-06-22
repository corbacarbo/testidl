package cobra.coffrefort;

import cobra.Cle;
import cobra.Empreinte;
import cobra.Matricule;
import cobra.bdd.Bdd;
import cobra.namingservice.Resolution;
import controleAcces.coffreFortOperations;
import controleAcces.coffreFortPackage.empreinteInconnueException;
import controleAcces.coffreFortPackage.matriculeErroneException;
import controleAcces.coffreFortPackage.matriculeInconnuException;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.util.HashMap;

public class CoffreFortImpl implements coffreFortOperations {

  private Resolution ns;
  
  private Bdd bdd;

  private HashMap<Empreinte, Matricule> empreintes;

  public CoffreFortImpl(Resolution ns) {
	this.ns = ns;
	bdd = new Bdd("empreinte", null);
	remplirCoffreFort();
  }

  private void remplirCoffreFort() {
	empreintes = bdd.loadEmpreintes();
	afficher();
  }

  private void afficher() {
	System.out.println("------------------------");
	empreintes.keySet().stream().forEach((e) -> {
	  System.out.println(empreintes.get(e) + "  " + e);
	});
	System.out.println("------------------------");
  }

  private Empreinte getEmpreinte(Matricule matricule) 
		  throws matriculeInconnuException {
	for (Empreinte empreinte : empreintes.keySet()) {
	  Matricule m = empreintes.get(empreinte);
	  if (m.equals(matricule)) {
		return empreinte;
	  }
	}
	throw new matriculeInconnuException("Empreinte inconnue. " + matricule);
  }

  @Override
  public void aEmpreinte(long cleIdl, String matriculeIdl) 
		  throws matriculeInconnuException, sessionInvalidException, 
		  sessionExpireeException {
	ns.resolveTrousseau().valideSession(cleIdl);

	Matricule matricule = new Matricule(matriculeIdl);
	Empreinte empreinte = getEmpreinte(matricule);

	System.out.println("## Empreinte vérifiée " + empreinte + "  " + matricule + "     " + new Cle(cleIdl));
  }

  @Override
  public String validerEmpreinte(long cleIdl, long empreinteIdl) 
		  throws empreinteInconnueException, sessionInvalidException, 
		  sessionExpireeException {
	ns.resolveTrousseau().valideSession(cleIdl);

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
  public void modificationEmpreinte(long cleIdl, long empreinteIdl, 
		  String matriculeIdl) 
		  throws matriculeInconnuException, sessionInvalidException, 
		  sessionExpireeException {
	ns.resolveTrousseau().valideSession(cleIdl);

	Matricule matricule = new Matricule(matriculeIdl);
	Empreinte newEmpreinte = new Empreinte(empreinteIdl);

	// Empreinte à supprimer
	try {
	  Empreinte oldEmpreinte = getEmpreinte(matricule);
	  empreintes.remove(oldEmpreinte);
	} catch (Exception e) {
	}

	// Ajout nouvelle empreinte
	empreintes.put(newEmpreinte, matricule);
	bdd.modifierEmpreinte(matricule, newEmpreinte);

	System.out.println("-+ Empreinte modifiée " + newEmpreinte + "  " + matricule + "     " + new Cle(cleIdl));
  }

  @Override
  public void ajouterEmpreinteTemp(long cleIdl, long empreinteIdl, 
		  String matriculeIdl) 
		  throws sessionInvalidException, sessionExpireeException, 
		  matriculeErroneException {
	ns.resolveTrousseau().valideSession(cleIdl);

	Matricule matricule = new Matricule(matriculeIdl);
	Empreinte empreinte = new Empreinte(empreinteIdl);
	if (matricule.getMat().startsWith("t")) {
	  empreintes.put(empreinte, matricule);
	  bdd.addEmpreinte(matricule, empreinte);
	} else {
	  throw new matriculeErroneException("Ajout d'empreinte pour permanent impossible");
	}
	System.out.println("++ Empreinte ajoutée " + empreinte + "  " + matricule + "     " + new Cle(cleIdl));
  }

  @Override
  public void supprimerEmpreinteTemp(long cleIdl, String matriculeIdl) 
		  throws matriculeErroneException, sessionInvalidException, 
		  sessionExpireeException, matriculeInconnuException {
	ns.resolveTrousseau().valideSession(cleIdl);

	Matricule matricule = new Matricule(matriculeIdl);
	Empreinte empreinte = getEmpreinte(matricule);
	if (matricule.getMat().startsWith("t")) {
	  empreintes.remove(empreinte);
	  bdd.removeEmpreinte(matricule);
	} else {
	  throw new matriculeErroneException("Suppression d'empreinte pour permanent impossible");
	}

	System.out.println("-- Empreinte supprimée " + empreinte + "  " + matricule + "     " + new Cle(cleIdl));

  }

}
