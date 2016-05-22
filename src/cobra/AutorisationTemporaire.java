package cobra;

import controleAcces.autorisateurPackage.autorisationTIdl;

public class AutorisationTemporaire extends Autorisation{

  protected Date dateD;
  protected Date dateF;
  private String zone;

  public AutorisationTemporaire(Date dateD, Date dateF, Matricule matricule, Horaire heureD, Horaire heureF) {
	super(matricule, heureD, heureF);
	this.dateD = dateD;
	this.dateF = dateF;
  }

  public AutorisationTemporaire(autorisationTIdl autorisationTIdl) {
	this(new Date(autorisationTIdl.anneeD, autorisationTIdl.moisD, autorisationTIdl.jourD), 
			new Date(autorisationTIdl.anneeF, autorisationTIdl.moisF, autorisationTIdl.jourF),
			new Matricule(autorisationTIdl.matricule),
			new Horaire(autorisationTIdl.heureD, autorisationTIdl.minuteD), 
			new Horaire(autorisationTIdl.heureF, autorisationTIdl.minuteF));
  }

  @Override
  public autorisationTIdl toIdl(){
	return new autorisationTIdl(matricule.toIdl(), 
			horaireD.heureToIdl(), horaireD.minuteToIdl(), 
			horaireF.heureToIdl(), horaireF.minuteToIdl(), 
			dateD.jourToIdl(), dateD.moisToIdl(), dateD.anneeToIdl(), 
			dateF.jourToIdl(), dateF.moisToIdl(), dateF.anneeToIdl());
  }

  @Override
  public String toString() {
	return "AutorisationTemporaire{" + matricule + " " + horaireD + " " + horaireF + " " + dateD + " " + dateF + " " + zone + '}';
  }

  public boolean recouvrement(AutorisationTemporaire a){
	// |--------|   this
	//    |---      a
	if(this.dateD.before(a.dateD) && this.dateF.after(a.dateD) || this.dateF.equals(a.dateD))
	  return true;
	//    |----
	// |--------|
	else if(this.dateD.after(a.dateD) && this.dateD.before(a.dateF) || this.dateD.equals(a.dateF))
	  return true;
	return false;
  }
  
  
}
