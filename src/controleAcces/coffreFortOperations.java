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
    public String validerEmpreinte(long cleIdl, int empreinteIdl)
        throws controleAcces.coffreFortPackage.empreinteInconnueException;

    /**
     * Operation modificationEmpreinte
     */
    public boolean modificationEmpreinte(long cleIdl, int empreinteIdl, String matriculeIdl);

    /**
     * Operation ajouterEmpreinteTemp
     */
    public boolean ajouterEmpreinteTemp(long cleIdl, int empreinteIdl, String matriculeIdl);

    /**
     * Operation supprimerEmpreinteTemp
     */
    public boolean supprimerEmpreinteTemp(long cleIdl, String matriculeIdl);

}
