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
    public controleAcces.cle authentification(String matricule, String mdp)
        throws controleAcces.annuairePackage.loginIncorrectException
    {
        return _tie.authentification( matricule,  mdp);
    }

    /**
     * Operation modificationMdp
     */
    public boolean modificationMdp(controleAcces.cle cle, String matricule, String nouveauMdp)
        throws controleAcces.annuairePackage.mdpIdentiqueException
    {
        return _tie.modificationMdp( cle,  matricule,  nouveauMdp);
    }

    /**
     * Operation rechercherPersonne
     */
    public controleAcces.personne[] rechercherPersonne(String matricule, String nom, String prenom)
        throws controleAcces.annuairePackage.personneInexistanteException
    {
        return _tie.rechercherPersonne( matricule,  nom,  prenom);
    }

    /**
     * Operation validerIdentite
     */
    public controleAcces.personne validerIdentite(String matricule)
        throws controleAcces.annuairePackage.personneInexistanteException
    {
        return _tie.validerIdentite( matricule);
    }

    /**
     * Operation ajouterPermanent
     */
    public controleAcces.personne ajouterPermanent(controleAcces.personne p)
    {
        return _tie.ajouterPermanent( p);
    }

    /**
     * Operation ajouterTemporaire
     */
    public controleAcces.personne ajouterTemporaire(controleAcces.personne p)
    {
        return _tie.ajouterTemporaire( p);
    }

}
