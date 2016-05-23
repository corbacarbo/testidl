package cobra;

import controleAcces.autorisateurPackage.autorisationIdl;
import java.util.GregorianCalendar;

public class Autorisation {

  protected Matricule matricule;
  protected Horaire horaireD;
  protected Horaire horaireF;

  public Autorisation(Matricule matricule, Horaire horaireD, Horaire horaireF) {
	this.matricule = matricule;
	this.horaireD = horaireD;
	this.horaireF = horaireF;
  }

  public Autorisation(autorisationIdl autorisationIdl) {
	this(new Matricule(autorisationIdl.matricule),
			new Horaire(autorisationIdl.heureD, autorisationIdl.minuteD),
			new Horaire(autorisationIdl.heureF, autorisationIdl.minuteF));
  }

  public autorisationIdl toIdl() {
	return new autorisationIdl(matricule.toIdl(),
			horaireD.heureToIdl(), horaireD.minuteToIdl(),
			horaireF.heureToIdl(), horaireF.minuteToIdl());
  }

  @Override
  public String toString() {
	return "AutorisationPermanent{" + matricule + " " + horaireD + " " + horaireF + '}';
  }

  public boolean recouvrement(Autorisation a) {
	// |--------|   this
	//    |---      a
	if (this.horaireD.before(a.horaireD) && this.horaireF.after(a.horaireD) || this.horaireF.equals(a.horaireD)) {
	  return true;
	} //    |----
	// |--------|
	else if (this.horaireD.after(a.horaireD) && this.horaireD.before(a.horaireF) || this.horaireD.equals(a.horaireF)) {
	  return true;
	} else if (this.horaireD.equals(a.horaireD)) {
	  return true;
	}
	return false;
  }

  public boolean autoriserTemps(GregorianCalendar demande) {
	Horaire horaireDemande = new Horaire(demande);
	return horaireD.before(horaireDemande) && horaireF.after(horaireDemande);
  }

  public boolean autoriserMatricule(Matricule matricule) {
	return this.matricule.equals(matricule);
  }

  public static void main(String[] args) {
	Autorisation a = new Autorisation(new Matricule("a"), new Horaire("8:00"), new Horaire("15:00"));
	Autorisation b = new Autorisation(new Matricule("a"), new Horaire("5:00"), new Horaire("8:00"));

	System.out.println(a.recouvrement(b));
  }

}
