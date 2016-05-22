package controleAcces.journalPackage;

/**
 * Struct definition : demandeIdl
 * 
 * @author OpenORB Compiler
*/
public final class demandeIdl implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member matricule
     */
    public String matricule;

    /**
     * Struct member empreinteIdl
     */
    public long empreinteIdl;

    /**
     * Struct member dateHeure
     */
    public long dateHeure;

    /**
     * Struct member idZone
     */
    public String idZone;

    /**
     * Struct member idPorte
     */
    public int idPorte;

    /**
     * Struct member statut
     */
    public String statut;

    /**
     * Struct member type
     */
    public int type;

    /**
     * Default constructor
     */
    public demandeIdl()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param empreinteIdl empreinteIdl struct member
     * @param dateHeure dateHeure struct member
     * @param idZone idZone struct member
     * @param idPorte idPorte struct member
     * @param statut statut struct member
     * @param type type struct member
     */
    public demandeIdl(String matricule, long empreinteIdl, long dateHeure, String idZone, int idPorte, String statut, int type)
    {
        this.matricule = matricule;
        this.empreinteIdl = empreinteIdl;
        this.dateHeure = dateHeure;
        this.idZone = idZone;
        this.idPorte = idPorte;
        this.statut = statut;
        this.type = type;
    }

}
