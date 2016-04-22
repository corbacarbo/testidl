package controleAcces;

/**
 * Holder class for : authentificateur
 * 
 * @author OpenORB Compiler
 */
final public class authentificateurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal authentificateur value
     */
    public controleAcces.authentificateur value;

    /**
     * Default constructor
     */
    public authentificateurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public authentificateurHolder(controleAcces.authentificateur initial)
    {
        value = initial;
    }

    /**
     * Read authentificateur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = authentificateurHelper.read(istream);
    }

    /**
     * Write authentificateur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        authentificateurHelper.write(ostream,value);
    }

    /**
     * Return the authentificateur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return authentificateurHelper.type();
    }

}
