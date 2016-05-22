package cobra;

import controleAcces.autorisateurPackage.autorisationPIdl;

public class AutorisationPermanent extends Autorisation{

  public AutorisationPermanent(autorisationPIdl autorisationPIdl) {
	this(new Matricule(autorisationPIdl.matricule),
			new Horaire(autorisationPIdl.heureD, autorisationPIdl.minuteD), 
			new Horaire(autorisationPIdl.heureF, autorisationPIdl.minuteF));
  }

  public AutorisationPermanent(Matricule matricule, Horaire heureD, Horaire heureF) {
	super(matricule, heureD, heureF);
  }

  @Override
 public autorisationPIdl toIdl(){
   return new autorisationPIdl(matricule.toIdl(), 
		   horaireD.heureToIdl(), horaireD.minuteToIdl(), 
		   horaireF.heureToIdl(), horaireF.minuteToIdl());
 }
  
}
