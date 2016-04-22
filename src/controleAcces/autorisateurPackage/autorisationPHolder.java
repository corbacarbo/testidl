package controleAcces.autorisateurPackage;

/**
 * Holder class for : autorisationP
 * 
 * @author OpenORB Compiler
 */
final public class autorisationPHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal autorisationP value
     */
    public controleAcces.autorisateurPackage.autorisationP value;

    /**
     * Default constructor
     */
    public autorisationPHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public autorisationPHolder(controleAcces.autorisateurPackage.autorisationP initial)
    {
        value = initial;
    }

    /**
     * Read autorisationP from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = autorisationPHelper.read(istream);
    }

    /**
     * Write autorisationP into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        autorisationPHelper.write(ostream,value);
    }

    /**
     * Return the autorisationP TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return autorisationPHelper.type();
    }

}
