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
     * Struct member heureD
     */
    public int heureD;

    /**
     * Struct member minuteD
     */
    public int minuteD;

    /**
     * Struct member heureF
     */
    public int heureF;

    /**
     * Struct member minuteF
     */
    public int minuteF;

    /**
     * Default constructor
     */
    public autorisationPIdl()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param heureD heureD struct member
     * @param minuteD minuteD struct member
     * @param heureF heureF struct member
     * @param minuteF minuteF struct member
     */
    public autorisationPIdl(String matricule, int heureD, int minuteD, int heureF, int minuteF)
    {
        this.matricule = matricule;
        this.heureD = heureD;
        this.minuteD = minuteD;
        this.heureF = heureF;
        this.minuteF = minuteF;
    }

}
