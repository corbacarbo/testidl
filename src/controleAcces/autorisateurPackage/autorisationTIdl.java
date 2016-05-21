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
     * Struct member horaireD
     */
    public int horaireD;

    /**
     * Struct member horaireF
     */
    public int horaireF;

    /**
     * Struct member jourD
     */
    public String jourD;

    /**
     * Struct member moisD
     */
    public String moisD;

    /**
     * Struct member anneeD
     */
    public String anneeD;

    /**
     * Struct member jourF
     */
    public String jourF;

    /**
     * Struct member moisF
     */
    public String moisF;

    /**
     * Struct member anneeF
     */
    public String anneeF;

    /**
     * Default constructor
     */
    public autorisationTIdl()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param horaireD horaireD struct member
     * @param horaireF horaireF struct member
     * @param jourD jourD struct member
     * @param moisD moisD struct member
     * @param anneeD anneeD struct member
     * @param jourF jourF struct member
     * @param moisF moisF struct member
     * @param anneeF anneeF struct member
     */
    public autorisationTIdl(String matricule, int horaireD, int horaireF, String jourD, String moisD, String anneeD, String jourF, String moisF, String anneeF)
    {
        this.matricule = matricule;
        this.horaireD = horaireD;
        this.horaireF = horaireF;
        this.jourD = jourD;
        this.moisD = moisD;
        this.anneeD = anneeD;
        this.jourF = jourF;
        this.moisF = moisF;
        this.anneeF = anneeF;
    }

}
