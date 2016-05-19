package controleAcces.coffreFortPackage;

/**
 * Holder class for : matriculeInconnuException
 * 
 * @author OpenORB Compiler
 */
final public class matriculeInconnuExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal matriculeInconnuException value
     */
    public controleAcces.coffreFortPackage.matriculeInconnuException value;

    /**
     * Default constructor
     */
    public matriculeInconnuExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public matriculeInconnuExceptionHolder(controleAcces.coffreFortPackage.matriculeInconnuException initial)
    {
        value = initial;
    }

    /**
     * Read matriculeInconnuException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = matriculeInconnuExceptionHelper.read(istream);
    }

    /**
     * Write matriculeInconnuException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        matriculeInconnuExceptionHelper.write(ostream,value);
    }

    /**
     * Return the matriculeInconnuException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return matriculeInconnuExceptionHelper.type();
    }

}
