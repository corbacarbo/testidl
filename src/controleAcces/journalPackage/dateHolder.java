package controleAcces.journalPackage;

/**
 * Holder class for : date
 * 
 * @author OpenORB Compiler
 */
final public class dateHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal date value
     */
    public controleAcces.journalPackage.date value;

    /**
     * Default constructor
     */
    public dateHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public dateHolder(controleAcces.journalPackage.date initial)
    {
        value = initial;
    }

    /**
     * Read date from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = dateHelper.read(istream);
    }

    /**
     * Write date into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        dateHelper.write(ostream,value);
    }

    /**
     * Return the date TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return dateHelper.type();
    }

}
