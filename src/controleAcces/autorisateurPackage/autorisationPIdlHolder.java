package controleAcces.autorisateurPackage;

/**
 * Holder class for : autorisationPIdl
 * 
 * @author OpenORB Compiler
 */
final public class autorisationPIdlHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal autorisationPIdl value
     */
    public controleAcces.autorisateurPackage.autorisationPIdl value;

    /**
     * Default constructor
     */
    public autorisationPIdlHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public autorisationPIdlHolder(controleAcces.autorisateurPackage.autorisationPIdl initial)
    {
        value = initial;
    }

    /**
     * Read autorisationPIdl from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = autorisationPIdlHelper.read(istream);
    }

    /**
     * Write autorisationPIdl into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        autorisationPIdlHelper.write(ostream,value);
    }

    /**
     * Return the autorisationPIdl TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return autorisationPIdlHelper.type();
    }

}
