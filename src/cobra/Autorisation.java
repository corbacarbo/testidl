package cobra;

import controleAcces.autorisateurPackage.autorisationIdl;
import java.util.GregorianCalendar;

public class Autorisation {

  /**
   * Le matricule de l'employé concerné par cette autorisation.
   */
  protected Matricule matricule;
  
  /**
   * Horaire de début de l'autorisation.
   */
  protected Horaire horaireD;
  
  /**
   * Horaire de fin de l'autorisation.
   */
  protected Horaire horaireF;

  /**
   * Obtenir le matricule de l'employé concerné par l'autorisation.
   * @return le matricule.
   */
  public Matricule getMatricule() {
	return matricule;
  }

  public Horaire getHoraireD() {
	return horaireD;
  }

  public Horaire getHoraireF() {
	return horaireF;
  }

  public Autorisation(Matricule matricule, Horaire horaireD, Horaire horaireF) {
	this.matricule = matricule;
	this.horaireD = horaireD;
	this.horaireF = horaireF;
  }

  /**
   * Pour instancier une autorisation à partir d'une autorisationIdl reçu par
   * une entité corba.
   * @param autorisationIdl 
   */
  public Autorisation(autorisationIdl autorisationIdl) {
	this(new Matricule(autorisationIdl.matricule),
			new Horaire(autorisationIdl.heureD, autorisationIdl.minuteD),
			new Horaire(autorisationIdl.heureF, autorisationIdl.minuteF));
  }

  /**
   * Pour obtenir une instance de cette autorisation transmissible par corba.
   * @return 
   */
  public autorisationIdl toIdl() {
	return new autorisationIdl(matricule.toIdl(),
			horaireD.heureToIdl(), horaireD.minuteToIdl(),
			horaireF.heureToIdl(), horaireF.minuteToIdl());
  }

  @Override
  public String toString() {
	return "AutorisationPermanent{" + matricule + " " + horaireD + " " + horaireF + '}';
  }

  /**
   * Vérifie si une autorisation entre en conflit avec une autre autorisation.
   * @param a autorisation à vérifier.
   * @return vrai s'il y a un recouvrement, false sinon.
   */
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

  /**
   * Vérifie si une date donnée se trouve à l'intérieur de la période de
   * l'autorisation courante.
   * @param demande date
   * @return vrai si la date se trouve entre les bornes de l'autorisation.
   */
  public boolean autoriserTemps(GregorianCalendar demande) {
	Horaire horaireDemande = new Horaire(demande);
	return horaireD.before(horaireDemande) && horaireF.after(horaireDemande);
  }

  /**
   * Vérifie si un matricule donnée est le matricule de l'autorisation.
   * @param matricule
   * @return true si les matricules correspondent, false sinon.
   */
  public boolean autoriserMatricule(Matricule matricule) {
	return this.matricule.equals(matricule);
  }

  public static void main(String[] args) {
	Autorisation a = new Autorisation(new Matricule("a"), new Horaire("8:00"), new Horaire("15:00"));
	Autorisation b = new Autorisation(new Matricule("a"), new Horaire("5:00"), new Horaire("8:00"));

	System.out.println(a.recouvrement(b));
  }

}
