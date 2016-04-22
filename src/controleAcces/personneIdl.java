package controleAcces;

/**
 * Struct definition : personneIdl
 * 
 * @author OpenORB Compiler
*/
public final class personneIdl implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member matricule
     */
    public String matricule;

    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member prenom
     */
    public String prenom;

    /**
     * Struct member photo
     */
    public String photo;

    /**
     * Struct member mdp
     */
    public String mdp;

    /**
     * Default constructor
     */
    public personneIdl()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param nom nom struct member
     * @param prenom prenom struct member
     * @param photo photo struct member
     * @param mdp mdp struct member
     */
    public personneIdl(String matricule, String nom, String prenom, String photo, String mdp)
    {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
        this.mdp = mdp;
    }

}
