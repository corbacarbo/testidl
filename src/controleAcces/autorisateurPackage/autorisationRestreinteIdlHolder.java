package controleAcces.autorisateurPackage;

/**
 * Holder class for : autorisationRestreinteIdl
 * 
 * @author OpenORB Compiler
 */
final public class autorisationRestreinteIdlHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal autorisationRestreinteIdl value
     */
    public controleAcces.autorisateurPackage.autorisationRestreinteIdl value;

    /**
     * Default constructor
     */
    public autorisationRestreinteIdlHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public autorisationRestreinteIdlHolder(controleAcces.autorisateurPackage.autorisationRestreinteIdl initial)
    {
        value = initial;
    }

    /**
     * Read autorisationRestreinteIdl from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = autorisationRestreinteIdlHelper.read(istream);
    }

    /**
     * Write autorisationRestreinteIdl into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        autorisationRestreinteIdlHelper.write(ostream,value);
    }

    /**
     * Return the autorisationRestreinteIdl TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return autorisationRestreinteIdlHelper.type();
    }

}
