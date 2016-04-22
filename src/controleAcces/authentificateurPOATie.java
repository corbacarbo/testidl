package controleAcces;

/**
 * Interface definition : authentificateur
 * 
 * @author OpenORB Compiler
 */
public class authentificateurPOATie extends authentificateurPOA
{

    //
    // Private reference to implementation object
    //
    private authentificateurOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public authentificateurPOATie(authentificateurOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public authentificateurPOATie(authentificateurOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public authentificateurOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(authentificateurOperations delegate_)
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
        throws controleAcces.authentificateurPackage.sessionInvalidException
    {
        _tie.valideSession( cleIdl);
    }

}
