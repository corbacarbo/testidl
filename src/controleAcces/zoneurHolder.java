package controleAcces;

/**
 * Holder class for : zoneur
 * 
 * @author OpenORB Compiler
 */
final public class zoneurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal zoneur value
     */
    public controleAcces.zoneur value;

    /**
     * Default constructor
     */
    public zoneurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public zoneurHolder(controleAcces.zoneur initial)
    {
        value = initial;
    }

    /**
     * Read zoneur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = zoneurHelper.read(istream);
    }

    /**
     * Write zoneur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        zoneurHelper.write(ostream,value);
    }

    /**
     * Return the zoneur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return zoneurHelper.type();
    }

}
