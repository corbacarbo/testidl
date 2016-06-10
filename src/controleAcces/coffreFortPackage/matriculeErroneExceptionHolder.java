package controleAcces.coffreFortPackage;

/**
 * Holder class for : matriculeErroneException
 * 
 * @author OpenORB Compiler
 */
final public class matriculeErroneExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal matriculeErroneException value
     */
    public controleAcces.coffreFortPackage.matriculeErroneException value;

    /**
     * Default constructor
     */
    public matriculeErroneExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public matriculeErroneExceptionHolder(controleAcces.coffreFortPackage.matriculeErroneException initial)
    {
        value = initial;
    }

    /**
     * Read matriculeErroneException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = matriculeErroneExceptionHelper.read(istream);
    }

    /**
     * Write matriculeErroneException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        matriculeErroneExceptionHelper.write(ostream,value);
    }

    /**
     * Return the matriculeErroneException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return matriculeErroneExceptionHelper.type();
    }

}
