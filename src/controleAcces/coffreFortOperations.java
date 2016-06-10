package controleAcces;

/**
 * Interface definition : coffreFort
 * 
 * @author OpenORB Compiler
 */
public interface coffreFortOperations
{
    /**
     * Operation aEmpreinte
     */
    public void aEmpreinte(long cleIdl, String matriculeIdl)
        throws controleAcces.coffreFortPackage.matriculeInconnuException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * Operation validerEmpreinte
     */
    public String validerEmpreinte(long cleIdl, long empreinteIdl)
        throws controleAcces.coffreFortPackage.empreinteInconnueException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * Operation modificationEmpreinte
     */
    public void modificationEmpreinte(long cleIdl, long empreinteIdl, String matriculeIdl)
        throws controleAcces.coffreFortPackage.matriculeInconnuException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * Operation ajouterEmpreinteTemp
     */
    public void ajouterEmpreinteTemp(long cleIdl, long empreinteIdl, String matriculeIdl)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException, controleAcces.coffreFortPackage.matriculeErroneException;

    /**
     * Operation supprimerEmpreinteTemp
     */
    public void supprimerEmpreinteTemp(long cleIdl, String matriculeIdl)
        throws controleAcces.coffreFortPackage.matriculeErroneException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException, controleAcces.coffreFortPackage.matriculeInconnuException;

}
