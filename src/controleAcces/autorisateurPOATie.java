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
    public boolean ajouterAutorisationP(controleAcces.cle cle, controleAcces.autorisateurPackage.autorisationP autorisation)
        throws controleAcces.autorisateurPackage.conflitAutorisationException
    {
        return _tie.ajouterAutorisationP( cle,  autorisation);
    }

    /**
     * Operation ajouterAutorisationT
     */
    public boolean ajouterAutorisationT(controleAcces.cle cle, controleAcces.autorisateurPackage.autorisationT autorisation)
        throws controleAcces.autorisateurPackage.conflitAutorisationException
    {
        return _tie.ajouterAutorisationT( cle,  autorisation);
    }

    /**
     * Operation validerAutorisation
     */
    public boolean validerAutorisation(String matricule)
        throws controleAcces.autorisateurPackage.autorisationRefuseeException
    {
        return _tie.validerAutorisation( matricule);
    }

}
