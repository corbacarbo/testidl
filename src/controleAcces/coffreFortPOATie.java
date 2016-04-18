package controleAcces;

/**
 * Interface definition : coffreFort
 * 
 * @author OpenORB Compiler
 */
public class coffreFortPOATie extends coffreFortPOA
{

    //
    // Private reference to implementation object
    //
    private coffreFortOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public coffreFortPOATie(coffreFortOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public coffreFortPOATie(coffreFortOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public coffreFortOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(coffreFortOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation validerEmpreinte
     */
    public String validerEmpreinte(controleAcces.cle cle, int empreinte)
        throws controleAcces.coffreFortPackage.empreinteInconnueException
    {
        return _tie.validerEmpreinte( cle,  empreinte);
    }

    /**
     * Operation modificationEmpreinte
     */
    public boolean modificationEmpreinte(controleAcces.cle cle, int empreinte, String matricule)
    {
        return _tie.modificationEmpreinte( cle,  empreinte,  matricule);
    }

    /**
     * Operation ajouterEmpreinteTemp
     */
    public boolean ajouterEmpreinteTemp(controleAcces.cle cle, int empreinte, String matricule)
    {
        return _tie.ajouterEmpreinteTemp( cle,  empreinte,  matricule);
    }

    /**
     * Operation supprimerEmpreinteTemp
     */
    public boolean supprimerEmpreinteTemp(controleAcces.cle cle, String matricule)
    {
        return _tie.supprimerEmpreinteTemp( cle,  matricule);
    }

}
