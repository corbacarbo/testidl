package controleAcces;

/**
 * Holder class for : trousseau
 * 
 * @author OpenORB Compiler
 */
final public class trousseauHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal trousseau value
     */
    public controleAcces.trousseau value;

    /**
     * Default constructor
     */
    public trousseauHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public trousseauHolder(controleAcces.trousseau initial)
    {
        value = initial;
    }

    /**
     * Read trousseau from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = trousseauHelper.read(istream);
    }

    /**
     * Write trousseau into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        trousseauHelper.write(ostream,value);
    }

    /**
     * Return the trousseau TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return trousseauHelper.type();
    }

}
