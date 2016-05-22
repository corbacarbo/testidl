package cobra;

import controleAcces.autorisateurPackage.autorisationTIdl;

public class AutorisationTemporaire extends Autorisation{

  protected Date dateD;
  protected Date dateF;

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
  
}
