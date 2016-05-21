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
    public String heureD;

    /**
     * Struct member minuteD
     */
    public String minuteD;

    /**
     * Struct member heureF
     */
    public String heureF;

    /**
     * Struct member minuteF
     */
    public String minuteF;

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
    public autorisationPIdl(String matricule, String heureD, String minuteD, String heureF, String minuteF)
    {
        this.matricule = matricule;
        this.heureD = heureD;
        this.minuteD = minuteD;
        this.heureF = heureF;
        this.minuteF = minuteF;
    }

}
