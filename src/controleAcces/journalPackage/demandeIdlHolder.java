package controleAcces.journalPackage;

/**
 * Holder class for : demandeIdl
 * 
 * @author OpenORB Compiler
 */
final public class demandeIdlHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal demandeIdl value
     */
    public controleAcces.journalPackage.demandeIdl value;

    /**
     * Default constructor
     */
    public demandeIdlHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public demandeIdlHolder(controleAcces.journalPackage.demandeIdl initial)
    {
        value = initial;
    }

    /**
     * Read demandeIdl from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = demandeIdlHelper.read(istream);
    }

    /**
     * Write demandeIdl into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        demandeIdlHelper.write(ostream,value);
    }

    /**
     * Return the demandeIdl TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return demandeIdlHelper.type();
    }

}
