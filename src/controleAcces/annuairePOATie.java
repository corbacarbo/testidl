package controleAcces;

/**
 * Interface definition : annuaire
 * 
 * @author OpenORB Compiler
 */
public class annuairePOATie extends annuairePOA
{

    //
    // Private reference to implementation object
    //
    private annuaireOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public annuairePOATie(annuaireOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public annuairePOATie(annuaireOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public annuaireOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(annuaireOperations delegate_)
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
     * Operation authentification
     */
    public long authentification(String matriculeIdl, String mdp)
        throws controleAcces.annuairePackage.loginIncorrectException
    {
        return _tie.authentification( matriculeIdl,  mdp);
    }

    /**
     * Operation modificationMdp
     */
    public void modificationMdp(long cleIdl, String matriculeIdl, String nouveauMdp)
        throws controleAcces.annuairePackage.mdpIdentiqueException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException, controleAcces.annuairePackage.personneInexistanteException
    {
        _tie.modificationMdp( cleIdl,  matriculeIdl,  nouveauMdp);
    }

    /**
     * Operation rechercherPersonne
     */
    public controleAcces.personneIdl[] rechercherPersonne(String matriculeIdl, String nom, String prenom)
        throws controleAcces.annuairePackage.personneInexistanteException
    {
        return _tie.rechercherPersonne( matriculeIdl,  nom,  prenom);
    }

    /**
     * Operation validerIdentite
     */
    public controleAcces.personneIdl validerIdentite(String matriculeIdl)
        throws controleAcces.annuairePackage.personneInexistanteException
    {
        return _tie.validerIdentite( matriculeIdl);
    }

    /**
     * Operation ajouterPermanent
     */
    public controleAcces.personneIdl ajouterPermanent(controleAcces.personneIdl p)
    {
        return _tie.ajouterPermanent( p);
    }

    /**
     * Operation ajouterTemporaire
     */
    public controleAcces.personneIdl ajouterTemporaire(controleAcces.personneIdl p)
    {
        return _tie.ajouterTemporaire( p);
    }

}
