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

  @Override
  public String toString() {
	return "AutorisationPermanent{" + matricule + " " + horaireD + " " + horaireF + '}';
  }
  
  public boolean recouvrement(AutorisationPermanent a){
	// |--------|   this
	//    |---      a
	if(this.horaireD.before(a.horaireD) && this.horaireF.after(a.horaireD) || this.horaireF.equals(a.horaireD))
	  return true;
	//    |----
	// |--------|
	else if(this.horaireD.after(a.horaireD) && this.horaireD.before(a.horaireF) || this.horaireD.equals(a.horaireF))
	  return true;
	else if(this.horaireD.equals(a.horaireD))
	  return true;
	return false;
  }
 
  public static void main(String[] args){
	AutorisationPermanent a = new AutorisationPermanent(new Matricule("a"), new Horaire("8:00"), new Horaire("15:00"));
	AutorisationPermanent b = new AutorisationPermanent(new Matricule("a"), new Horaire("5:00"), new Horaire("8:00"));
	
	System.out.println(a.recouvrement(b));
  }
 
}
