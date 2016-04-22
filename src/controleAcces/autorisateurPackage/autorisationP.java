package controleAcces.autorisateurPackage;

/**
 * Struct definition : autorisationP
 * 
 * @author OpenORB Compiler
*/
public final class autorisationP implements org.omg.CORBA.portable.IDLEntity
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
     * Struct member heureF
     */
    public String heureF;

    /**
     * Default constructor
     */
    public autorisationP()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param heureD heureD struct member
     * @param heureF heureF struct member
     */
    public autorisationP(String matricule, String heureD, String heureF)
    {
        this.matricule = matricule;
        this.heureD = heureD;
        this.heureF = heureF;
    }

}
