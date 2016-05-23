package controleAcces.autorisateurPackage;

/**
 * Holder class for : autorisationIdl
 * 
 * @author OpenORB Compiler
 */
final public class autorisationIdlHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal autorisationIdl value
     */
    public controleAcces.autorisateurPackage.autorisationIdl value;

    /**
     * Default constructor
     */
    public autorisationIdlHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public autorisationIdlHolder(controleAcces.autorisateurPackage.autorisationIdl initial)
    {
        value = initial;
    }

    /**
     * Read autorisationIdl from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = autorisationIdlHelper.read(istream);
    }

    /**
     * Write autorisationIdl into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        autorisationIdlHelper.write(ostream,value);
    }

    /**
     * Return the autorisationIdl TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return autorisationIdlHelper.type();
    }

}
