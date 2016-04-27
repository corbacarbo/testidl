package testidl;

import controleAcces.personneIdl;

public class PersonneTemporaire extends Personne {

  public PersonneTemporaire(Matricule matricule, String nom, String prenom) {
    super(matricule, nom, prenom);
  }

  public personneIdl toIdl() {
    return new personneIdl(matricule.toString(), nom, prenom, "", "");
  }

}
