package controleAcces;

/**
 * Enregistre les tentatives d'entrée et de sortie, en cas de succès ou d'échec.
 */
public interface journalOperations
{
    /**
     * Operation loguer
     */
    public void loguer(controleAcces.journalPackage.demandeIdl demandeIdl);

    /**
     * Operation loguerInconnu
     */
    public void loguerInconnu(controleAcces.journalPackage.demandeIdl demandeIdl);

}
