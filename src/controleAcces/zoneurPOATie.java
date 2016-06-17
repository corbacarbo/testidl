package controleAcces;

/**
 * Interface definition : zoneur
 * 
 * @author OpenORB Compiler
 */
public class zoneurPOATie extends zoneurPOA
{

    //
    // Private reference to implementation object
    //
    private zoneurOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public zoneurPOATie(zoneurOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public zoneurPOATie(zoneurOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public zoneurOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(zoneurOperations delegate_)
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
     * Operation resolveAnnuaire
     */
    public controleAcces.annuaire resolveAnnuaire()
    {
        return _tie.resolveAnnuaire();
    }

    /**
     * Operation resolveCoffreFort
     */
    public controleAcces.coffreFort resolveCoffreFort()
    {
        return _tie.resolveCoffreFort();
    }

    /**
     * Operation resolveJournal
     */
    public controleAcces.journal resolveJournal()
    {
        return _tie.resolveJournal();
    }

    /**
     * Operation resolveAutorisateur
     */
    public controleAcces.autorisateur resolveAutorisateur()
    {
        return _tie.resolveAutorisateur();
    }

    /**
     * Operation resolveAutorisateurTemporaire
     */
    public controleAcces.autorisateur resolveAutorisateurTemporaire()
    {
        return _tie.resolveAutorisateurTemporaire();
    }

    /**
     * Operation resolveTrousseau
     */
    public controleAcces.trousseau resolveTrousseau()
    {
        return _tie.resolveTrousseau();
    }

    /**
     * Operation isNotInsideZone
     */
    public boolean isNotInsideZone(String matriculeIdl)
    {
        return _tie.isNotInsideZone( matriculeIdl);
    }

    /**
     * Operation isNotInsideAllZoneEntree
     */
    public boolean isNotInsideAllZoneEntree(String matriculeIdl)
    {
        return _tie.isNotInsideAllZoneEntree( matriculeIdl);
    }

    /**
     * Operation isNotInsideAllZoneSortie
     */
    public boolean isNotInsideAllZoneSortie(String matriculeIdl)
    {
        return _tie.isNotInsideAllZoneSortie( matriculeIdl);
    }

    /**
     * Operation isInsideZone
     */
    public boolean isInsideZone(String matriculeIdl)
    {
        return _tie.isInsideZone( matriculeIdl);
    }

    /**
     * Operation entre
     */
    public void entre(String matriculeIdl)
    {
        _tie.entre( matriculeIdl);
    }

    /**
     * Operation sort
     */
    public void sort(String matriculeIdl)
    {
        _tie.sort( matriculeIdl);
    }

    /**
     * Operation getIdPorte
     */
    public int getIdPorte()
    {
        return _tie.getIdPorte();
    }

}
