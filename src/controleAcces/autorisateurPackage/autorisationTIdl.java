package controleAcces.autorisateurPackage;

/**
 * Struct definition : autorisationTIdl
 * 
 * @author OpenORB Compiler
*/
public final class autorisationTIdl implements org.omg.CORBA.portable.IDLEntity
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
     * Struct member jourD
     */
    public int jourD;

    /**
     * Struct member moisD
     */
    public int moisD;

    /**
     * Struct member anneeD
     */
    public int anneeD;

    /**
     * Struct member jourF
     */
    public int jourF;

    /**
     * Struct member moisF
     */
    public int moisF;

    /**
     * Struct member anneeF
     */
    public int anneeF;

    /**
     * Default constructor
     */
    public autorisationTIdl()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param heureD heureD struct member
     * @param minuteD minuteD struct member
     * @param heureF heureF struct member
     * @param minuteF minuteF struct member
     * @param jourD jourD struct member
     * @param moisD moisD struct member
     * @param anneeD anneeD struct member
     * @param jourF jourF struct member
     * @param moisF moisF struct member
     * @param anneeF anneeF struct member
     */
    public autorisationTIdl(String matricule, int heureD, int minuteD, int heureF, int minuteF, int jourD, int moisD, int anneeD, int jourF, int moisF, int anneeF)
    {
        this.matricule = matricule;
        this.heureD = heureD;
        this.minuteD = minuteD;
        this.heureF = heureF;
        this.minuteF = minuteF;
        this.jourD = jourD;
        this.moisD = moisD;
        this.anneeD = anneeD;
        this.jourF = jourF;
        this.moisF = moisF;
        this.anneeF = anneeF;
    }

}
