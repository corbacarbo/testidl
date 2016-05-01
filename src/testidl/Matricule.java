package testidl;

import java.util.Objects;

/**
 * Classe métier. Un matricule d'employé permanent commence par 'p', un employé
 * temporaire par 't'. Contient deux fonctions de transformation pour conversion
 * vers une nouvelle instance transmissible par Corba.
 */
public class Matricule implements Comparable<Matricule>{

  private String matricule;

  /**
   * Type d'employé
   */
  public static enum TYPE {
    PERMANENT, TEMPORAIRE
  };

  /**
   * Pour le calcul automatique des matricules. Un compteur pour chaque type
   * d'employé, l'un ou l'autre est incrémenté à chaque création de matricule.
   */
  private static int nextNumberP = 10;
  private static int nextNumberT = 10;

  /**
   * Constructeur de matricule en fonction du type d'employé.
   */
  public Matricule(TYPE type) {
    if (type == TYPE.PERMANENT) {
      matricule = "p" + ++nextNumberP;
    } else if (type == TYPE.TEMPORAIRE) {
      matricule = "t" + ++nextNumberT;
    }
  }

  /**
   * Pour construire un matricule à partir d'un String. Méthode de
   * transformation : utile pour convertir un matricule reçu par Corba en un
   * objet métier.
   *
   * @param matricule
   */
  public Matricule(String matricule) {
    this.matricule = matricule;
  }

  /**
   * Méthode de transformation : pour obtenir un objet matricule transmissible
   * par Corba.
   */
  public String toIdl() {
    return matricule;
  }

  public boolean isPermanent() {
    return matricule.startsWith("p");
  }

  public boolean isTemporaire() {
    return matricule.startsWith("t");
  }

  @Override
  public int compareTo(Matricule t) {
    return this.matricule.compareTo(t.matricule);
  }

  @Override
  public boolean equals(Object obj) {
    Matricule m = (Matricule) obj;
    return this.matricule.equals(m.matricule);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 71 * hash + Objects.hashCode(this.matricule);
    System.out.println(hash);
    return hash;
  }
  
  
  
  @Override
  public String toString() {
    return "Matricule{" + matricule + "}";
  }

}