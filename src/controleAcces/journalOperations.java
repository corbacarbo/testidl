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
    public void loguer(controleAcces.journalPackage.demandeIdl demandeIdl);

    /**
     * Operation loguerInconnu
     */
    public void loguerInconnu(controleAcces.journalPackage.demandeIdl demandeIdl);

}
