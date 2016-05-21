package controleAcces.autorisateurPackage;

/**
 * Holder class for : autorisationTIdl
 * 
 * @author OpenORB Compiler
 */
final public class autorisationTIdlHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal autorisationTIdl value
     */
    public controleAcces.autorisateurPackage.autorisationTIdl value;

    /**
     * Default constructor
     */
    public autorisationTIdlHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public autorisationTIdlHolder(controleAcces.autorisateurPackage.autorisationTIdl initial)
    {
        value = initial;
    }

    /**
     * Read autorisationTIdl from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = autorisationTIdlHelper.read(istream);
    }

    /**
     * Write autorisationTIdl into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        autorisationTIdlHelper.write(ostream,value);
    }

    /**
     * Return the autorisationTIdl TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return autorisationTIdlHelper.type();
    }

}
