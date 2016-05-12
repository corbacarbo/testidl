package testidl.borne;

import controleAcces.annuaire;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.mdpIdentiqueException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.coffreFort;
import controleAcces.personneIdl;
import testidl.Cle;
import testidl.CorbaClient;
import testidl.Empreinte;
import testidl.Personne;
import testidl.PersonnePermanent;

public class Borne extends CorbaClient implements Runnable {

  private Cle cle;

  private PersonnePermanent personne;

  private BorneFrame borneFrame;

  public Borne() {
	personne = null;
  }

  public void authentifier(String mat, String mdp) throws loginIncorrectException, personneInexistanteException {
	annuaire annuaire = resolveAnnuaire();
	cle = new Cle(annuaire.authentification(mat, mdp));
	System.out.println("Authentification réussie " + cle);

	personneIdl personneIdl = annuaire.validerIdentite(mat);
	personne = new PersonnePermanent(personneIdl);

	if (personne.isMdpChange()) {
	  borneFrame.versMdp();
	} else {
	  borneFrame.versEmpreinte();
	}
  }

  public void changeMdp(String mdp) throws mdpIdentiqueException {
	annuaire annuaire = resolveAnnuaire();
	annuaire.modificationMdp(cle.toIdl(), personne.getMatricule().toIdl(), mdp);
	borneFrame.versEmpreinte();
  }

  public void empreinte(Empreinte empreinte) {
	coffreFort coffreFort = resolveCoffreFort();
	coffreFort.modificationEmpreinte(cle.toIdl(), empreinte.toIdl(), personne.getMatricule().toIdl());
	// TODO : retour de fonction non traité -> modifier l'idl et mettre exceptions
	borneFrame.versEmpreinteChangee();
  }

  public void reinit() {
	borneFrame.versConnexion();
	personne = null;
  }

  public void quitter() {
	borneFrame.dispose();
  }

  @Override
  public void run() {
	borneFrame = new BorneFrame();
	borneFrame.setBorne(this);
	borneFrame.setVisible(true);
  }

  public static void main(String[] args) {
	Borne borne = new Borne();
	Thread tBorne = new Thread(borne);
	tBorne.start();
  }

}
