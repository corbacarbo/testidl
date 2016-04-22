package controleAcces.autorisateurPackage;

/**
 * Holder class for : autorisationT
 * 
 * @author OpenORB Compiler
 */
final public class autorisationTHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal autorisationT value
     */
    public controleAcces.autorisateurPackage.autorisationT value;

    /**
     * Default constructor
     */
    public autorisationTHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public autorisationTHolder(controleAcces.autorisateurPackage.autorisationT initial)
    {
        value = initial;
    }

    /**
     * Read autorisationT from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = autorisationTHelper.read(istream);
    }

    /**
     * Write autorisationT into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        autorisationTHelper.write(ostream,value);
    }

    /**
     * Return the autorisationT TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return autorisationTHelper.type();
    }

}
