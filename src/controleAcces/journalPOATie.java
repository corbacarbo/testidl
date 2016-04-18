package controleAcces;

/**
 * Interface definition : journal
 * 
 * @author OpenORB Compiler
 */
public class journalPOATie extends journalPOA
{

    //
    // Private reference to implementation object
    //
    private journalOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public journalPOATie(journalOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public journalPOATie(journalOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public journalOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(journalOperations delegate_)
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
     * Operation loguer
     */
    public void loguer(String matricule, controleAcces.journalPackage.date dateHeure, int idZone, int idPorte, String statut, int type)
    {
        _tie.loguer( matricule,  dateHeure,  idZone,  idPorte,  statut,  type);
    }

    /**
     * Operation loguerInconnu
     */
    public void loguerInconnu(int empreinte, controleAcces.journalPackage.date dateHeure, int idZone, int idPorte, String statut, int type)
    {
        _tie.loguerInconnu( empreinte,  dateHeure,  idZone,  idPorte,  statut,  type);
    }

}
