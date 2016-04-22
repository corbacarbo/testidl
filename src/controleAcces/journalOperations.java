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
    public void loguer(String matriculeIdl, controleAcces.journalPackage.date dateHeure, int idZone, int idPorte, String statut, int type);

    /**
     * Operation loguerInconnu
     */
    public void loguerInconnu(int empreinteIdl, controleAcces.journalPackage.date dateHeure, int idZone, int idPorte, String statut, int type);

    /**
     * Operation consulter
     */
    public controleAcces.journalPackage.demandeIdl[] consulter(String matriculeIdl);

}
