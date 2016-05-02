package controleAcces.trousseauPackage;

/**
 * Holder class for : sessionInvalidException
 * 
 * @author OpenORB Compiler
 */
final public class sessionInvalidExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal sessionInvalidException value
     */
    public controleAcces.trousseauPackage.sessionInvalidException value;

    /**
     * Default constructor
     */
    public sessionInvalidExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public sessionInvalidExceptionHolder(controleAcces.trousseauPackage.sessionInvalidException initial)
    {
        value = initial;
    }

    /**
     * Read sessionInvalidException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = sessionInvalidExceptionHelper.read(istream);
    }

    /**
     * Write sessionInvalidException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        sessionInvalidExceptionHelper.write(ostream,value);
    }

    /**
     * Return the sessionInvalidException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return sessionInvalidExceptionHelper.type();
    }

}
