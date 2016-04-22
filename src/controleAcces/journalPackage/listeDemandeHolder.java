package controleAcces.journalPackage;

/**
 * Holder class for : listeDemande
 * 
 * @author OpenORB Compiler
 */
final public class listeDemandeHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listeDemande value
     */
    public controleAcces.journalPackage.demandeIdl[] value;

    /**
     * Default constructor
     */
    public listeDemandeHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listeDemandeHolder(controleAcces.journalPackage.demandeIdl[] initial)
    {
        value = initial;
    }

    /**
     * Read listeDemande from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listeDemandeHelper.read(istream);
    }

    /**
     * Write listeDemande into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listeDemandeHelper.write(ostream,value);
    }

    /**
     * Return the listeDemande TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listeDemandeHelper.type();
    }

}
