package controleAcces.autorisateurPackage;

/**
 * Struct definition : autorisationPIdl
 * 
 * @author OpenORB Compiler
*/
public final class autorisationPIdl implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member matricule
     */
    public String matricule;

    /**
     * Struct member horaireD
     */
    public int horaireD;

    /**
     * Struct member horaireF
     */
    public int horaireF;

    /**
     * Default constructor
     */
    public autorisationPIdl()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param horaireD horaireD struct member
     * @param horaireF horaireF struct member
     */
    public autorisationPIdl(String matricule, int horaireD, int horaireF)
    {
        this.matricule = matricule;
        this.horaireD = horaireD;
        this.horaireF = horaireF;
    }

}
