package controleAcces;

/**
 * Holder class for : coffreFort
 * 
 * @author OpenORB Compiler
 */
final public class coffreFortHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal coffreFort value
     */
    public controleAcces.coffreFort value;

    /**
     * Default constructor
     */
    public coffreFortHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public coffreFortHolder(controleAcces.coffreFort initial)
    {
        value = initial;
    }

    /**
     * Read coffreFort from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = coffreFortHelper.read(istream);
    }

    /**
     * Write coffreFort into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        coffreFortHelper.write(ostream,value);
    }

    /**
     * Return the coffreFort TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return coffreFortHelper.type();
    }

}
