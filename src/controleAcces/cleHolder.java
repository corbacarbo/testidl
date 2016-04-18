package controleAcces;

/**
 * Holder class for : cle
 * 
 * @author OpenORB Compiler
 */
final public class cleHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal cle value
     */
    public controleAcces.cle value;

    /**
     * Default constructor
     */
    public cleHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public cleHolder(controleAcces.cle initial)
    {
        value = initial;
    }

    /**
     * Read cle from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = cleHelper.read(istream);
    }

    /**
     * Write cle into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        cleHelper.write(ostream,value);
    }

    /**
     * Return the cle TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return cleHelper.type();
    }

}
