package controleAcces;

/**
 * Interface definition : trousseau
 * 
 * @author OpenORB Compiler
 */
public class trousseauPOATie extends trousseauPOA
{

    //
    // Private reference to implementation object
    //
    private trousseauOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public trousseauPOATie(trousseauOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public trousseauPOATie(trousseauOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public trousseauOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(trousseauOperations delegate_)
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
     * Operation startSession
     */
    public long startSession()
    {
        return _tie.startSession();
    }

    /**
     * Operation valideSession
     */
    public void valideSession(long cleIdl)
        throws controleAcces.trousseauPackage.sessionInvalidException, controleAcces.trousseauPackage.sessionExpireeException
    {
        _tie.valideSession( cleIdl);
    }

}
