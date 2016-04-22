package controleAcces;

/**
 * Holder class for : autorisateur
 * 
 * @author OpenORB Compiler
 */
final public class autorisateurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal autorisateur value
     */
    public controleAcces.autorisateur value;

    /**
     * Default constructor
     */
    public autorisateurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public autorisateurHolder(controleAcces.autorisateur initial)
    {
        value = initial;
    }

    /**
     * Read autorisateur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = autorisateurHelper.read(istream);
    }

    /**
     * Write autorisateur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        autorisateurHelper.write(ostream,value);
    }

    /**
     * Return the autorisateur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return autorisateurHelper.type();
    }

}
