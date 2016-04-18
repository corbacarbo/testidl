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
    public void loguer(String matricule, controleAcces.journalPackage.date dateHeure, int idZone, int idPorte, String statut, int type);

    /**
     * Operation loguerInconnu
     */
    public void loguerInconnu(int empreinte, controleAcces.journalPackage.date dateHeure, int idZone, int idPorte, String statut, int type);

}
