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
    public String validerEmpreinte(controleAcces.cle cle, int empreinte)
        throws controleAcces.coffreFortPackage.empreinteInconnueException;

    /**
     * Operation modificationEmpreinte
     */
    public boolean modificationEmpreinte(controleAcces.cle cle, int empreinte, String matricule);

    /**
     * Operation ajouterEmpreinteTemp
     */
    public boolean ajouterEmpreinteTemp(controleAcces.cle cle, int empreinte, String matricule);

    /**
     * Operation supprimerEmpreinteTemp
     */
    public boolean supprimerEmpreinteTemp(controleAcces.cle cle, String matricule);

}
