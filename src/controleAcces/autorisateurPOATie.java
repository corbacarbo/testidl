package controleAcces;

/**
 * Interface definition : autorisateur
 * 
 * @author OpenORB Compiler
 */
public class autorisateurPOATie extends autorisateurPOA
{

    //
    // Private reference to implementation object
    //
    private autorisateurOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public autorisateurPOATie(autorisateurOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public autorisateurPOATie(autorisateurOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public autorisateurOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(autorisateurOperations delegate_)
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
     * Operation ajouterAutorisationP
     */
    public void ajouterAutorisationP(long cleIdl, controleAcces.autorisateurPackage.autorisationPIdl autorisationIdl)
        throws controleAcces.autorisateurPackage.conflitAutorisationException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        _tie.ajouterAutorisationP( cleIdl,  autorisationIdl);
    }

    /**
     * Operation ajouterAutorisationT
     */
    public void ajouterAutorisationT(long cleIdl, controleAcces.autorisateurPackage.autorisationTIdl autorisationIdl)
        throws controleAcces.autorisateurPackage.conflitAutorisationException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        _tie.ajouterAutorisationT( cleIdl,  autorisationIdl);
    }

    /**
     * Operation autoriser
     */
    public void autoriser(String matriculeIdl)
        throws controleAcces.autorisateurPackage.autorisationRefuseeException
    {
        _tie.autoriser( matriculeIdl);
    }

}
