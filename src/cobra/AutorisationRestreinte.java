package cobra;

import controleAcces.autorisateurPackage.autorisationRestreinteIdl;
import java.util.GregorianCalendar;

public class AutorisationRestreinte extends Autorisation {

  protected Date dateD;
  protected Date dateF;
  private String zone;

  public AutorisationRestreinte(Date dateD, Date dateF, String zone, Matricule matricule, Horaire heureD, Horaire heureF) {
	super(matricule, heureD, heureF);
	this.dateD = dateD;
	this.dateF = dateF;
	this.zone = zone;
  }

  public AutorisationRestreinte(autorisationRestreinteIdl autorisationRestreinteIdl) {
	this(new Date(autorisationRestreinteIdl.anneeD, autorisationRestreinteIdl.moisD, autorisationRestreinteIdl.jourD),
			new Date(autorisationRestreinteIdl.anneeF, autorisationRestreinteIdl.moisF, autorisationRestreinteIdl.jourF),
			autorisationRestreinteIdl.zone,
			new Matricule(autorisationRestreinteIdl.matricule),
			new Horaire(autorisationRestreinteIdl.heureD, autorisationRestreinteIdl.minuteD),
			new Horaire(autorisationRestreinteIdl.heureF, autorisationRestreinteIdl.minuteF));
  }

  public autorisationRestreinteIdl toIdlR() {
	return new autorisationRestreinteIdl(matricule.toIdl(),
			horaireD.heureToIdl(), horaireD.minuteToIdl(),
			horaireF.heureToIdl(), horaireF.minuteToIdl(),
			dateD.jourToIdl(), dateD.moisToIdl(), dateD.anneeToIdl(),
			dateF.jourToIdl(), dateF.moisToIdl(), dateF.anneeToIdl(),
			zone);
  }

  @Override
  public String toString() {
	return "AutorisationTemporaire{" + matricule + " " + horaireD + " " + horaireF + " " + dateD + " " + dateF + " " + zone + '}';
  }

  /**
   *
   * @param a
   * @return
   */
  public boolean recouvrement(AutorisationRestreinte a) {
	// |--------|   this
	//    |---      a
	if (this.dateD.before(a.dateD) && this.dateF.after(a.dateD) || this.dateF.equals(a.dateD)) {
	  return true;
	} //    |----
	// |--------|
	else if (this.dateD.after(a.dateD) && this.dateD.before(a.dateF) || this.dateD.equals(a.dateF)) {
	  return true;
	}
	return false;
  }

  @Override
  public boolean autoriserTemps(GregorianCalendar demande) {
	Date dateDemande = new Date(demande);
	if (dateD.before(dateDemande) && dateF.after(dateDemande)) {
	  return super.autoriserTemps(demande);
	}
	return false;
  }

  public boolean autoriserZone(String z){
	return zone.equals(z);
  }
  
}
