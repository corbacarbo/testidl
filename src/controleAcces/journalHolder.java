package controleAcces;

/**
 * Holder class for : journal
 * 
 * @author OpenORB Compiler
 */
final public class journalHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal journal value
     */
    public controleAcces.journal value;

    /**
     * Default constructor
     */
    public journalHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public journalHolder(controleAcces.journal initial)
    {
        value = initial;
    }

    /**
     * Read journal from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = journalHelper.read(istream);
    }

    /**
     * Write journal into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        journalHelper.write(ostream,value);
    }

    /**
     * Return the journal TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return journalHelper.type();
    }

}
