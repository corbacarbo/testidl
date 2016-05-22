package cobra;

import controleAcces.autorisateurPackage.autorisationPIdl;
import controleAcces.autorisateurPackage.autorisationTIdl;

public abstract class Autorisation {
  
  protected Matricule matricule;
  protected Horaire horaireD;
  protected Horaire horaireF;

  public Autorisation(Matricule matricule, Horaire horaireD, Horaire horaireF) {
	this.matricule = matricule;
	this.horaireD = horaireD;
	this.horaireF = horaireF;
  }

//  public Autorisation(autorisationPIdl autorisationPIdl) {
//	this(new Matricule(autorisationPIdl.matricule), 
//			new Horaire(autorisationPIdl.heureD, autorisationPIdl.minuteD), 
//			new Horaire(autorisationPIdl.heureF, autorisationPIdl.minuteF));
//  }
//
//   public Autorisation(autorisationTIdl autorisationTIdl) {
//	this(new Matricule(autorisationTIdl.matricule), 
//			new Horaire(autorisationTIdl.heureD, autorisationTIdl.minuteD), 
//			new Horaire(autorisationTIdl.heureF, autorisationTIdl.minuteF));
//  }


  public boolean isPermanent(){
	return matricule.isPermanent();
  }
  
  public boolean isTemporaire(){
	return matricule.isTemporaire();
  }
  
  public abstract Object toIdl();
  
  
}
