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
     * Operation aEmpreinte
     */
    public void aEmpreinte(long cleIdl, String matriculeIdl)
        throws controleAcces.coffreFortPackage.matriculeInconnuException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        _tie.aEmpreinte( cleIdl,  matriculeIdl);
    }

    /**
     * Operation validerEmpreinte
     */
    public String validerEmpreinte(long cleIdl, long empreinteIdl)
        throws controleAcces.coffreFortPackage.empreinteInconnueException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        return _tie.validerEmpreinte( cleIdl,  empreinteIdl);
    }

    /**
     * Operation modificationEmpreinte
     */
    public void modificationEmpreinte(long cleIdl, long empreinteIdl, String matriculeIdl)
        throws controleAcces.coffreFortPackage.matriculeInconnuException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        _tie.modificationEmpreinte( cleIdl,  empreinteIdl,  matriculeIdl);
    }

    /**
     * Operation ajouterEmpreinteTemp
     */
    public void ajouterEmpreinteTemp(long cleIdl, long empreinteIdl, String matriculeIdl)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException, controleAcces.coffreFortPackage.matriculeErroneException
    {
        _tie.ajouterEmpreinteTemp( cleIdl,  empreinteIdl,  matriculeIdl);
    }

    /**
     * Operation supprimerEmpreinteTemp
     */
    public void supprimerEmpreinteTemp(long cleIdl, String matriculeIdl)
        throws controleAcces.coffreFortPackage.matriculeErroneException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        _tie.supprimerEmpreinteTemp( cleIdl,  matriculeIdl);
    }

}
