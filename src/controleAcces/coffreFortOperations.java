package controleAcces;

/**
 * Interface definition : coffreFort
 * 
 * @author OpenORB Compiler
 */
public interface coffreFortOperations
{
    /**
     * Operation validerEmpreinte
     */
    public String validerEmpreinte(long cleIdl, long empreinteIdl)
        throws controleAcces.coffreFortPackage.empreinteInconnueException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * Operation modificationEmpreinte
     */
    public void modificationEmpreinte(long cleIdl, long empreinteIdl, String matriculeIdl)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * Operation ajouterEmpreinteTemp
     */
    public void ajouterEmpreinteTemp(long cleIdl, long empreinteIdl, String matriculeIdl)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * Operation supprimerEmpreinteTemp
     */
    public void supprimerEmpreinteTemp(long cleIdl, String matriculeIdl)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

}
