package controleAcces;

/**
 * Holder class for : personneIdl
 * 
 * @author OpenORB Compiler
 */
final public class personneIdlHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal personneIdl value
     */
    public controleAcces.personneIdl value;

    /**
     * Default constructor
     */
    public personneIdlHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public personneIdlHolder(controleAcces.personneIdl initial)
    {
        value = initial;
    }

    /**
     * Read personneIdl from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = personneIdlHelper.read(istream);
    }

    /**
     * Write personneIdl into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        personneIdlHelper.write(ostream,value);
    }

    /**
     * Return the personneIdl TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return personneIdlHelper.type();
    }

}
