package controleAcces.autorisateurPackage;

/**
 * Struct definition : autorisationT
 * 
 * @author OpenORB Compiler
*/
public final class autorisationT implements org.omg.CORBA.portable.IDLEntity
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
     * Struct member jourD
     */
    public String jourD;

    /**
     * Struct member jourF
     */
    public String jourF;

    /**
     * Default constructor
     */
    public autorisationT()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param heureD heureD struct member
     * @param heureF heureF struct member
     * @param jourD jourD struct member
     * @param jourF jourF struct member
     */
    public autorisationT(String matricule, String heureD, String heureF, String jourD, String jourF)
    {
        this.matricule = matricule;
        this.heureD = heureD;
        this.heureF = heureF;
        this.jourD = jourD;
        this.jourF = jourF;
    }

}
