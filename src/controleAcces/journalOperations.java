package controleAcces;

/**
 * Interface definition : journal
 * 
 * @author OpenORB Compiler
 */
public interface journalOperations
{
    /**
     * Operation loguer
     */
    public void loguer(String matriculeIdl, long dateHeure, int idZone, int idPorte, String statut, int type);

    /**
     * Operation loguerInconnu
     */
    public void loguerInconnu(long empreinteIdl, long dateHeure, int idZone, int idPorte, String statut, int type);

    /**
     * Operation consulter
     */
    public controleAcces.journalPackage.demandeIdl[] consulter(String matriculeIdl);

}
