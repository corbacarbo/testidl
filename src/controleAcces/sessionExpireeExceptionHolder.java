package controleAcces;

/**
 * Holder class for : sessionExpireeException
 * 
 * @author OpenORB Compiler
 */
final public class sessionExpireeExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal sessionExpireeException value
     */
    public controleAcces.sessionExpireeException value;

    /**
     * Default constructor
     */
    public sessionExpireeExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public sessionExpireeExceptionHolder(controleAcces.sessionExpireeException initial)
    {
        value = initial;
    }

    /**
     * Read sessionExpireeException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = sessionExpireeExceptionHelper.read(istream);
    }

    /**
     * Write sessionExpireeException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        sessionExpireeExceptionHelper.write(ostream,value);
    }

    /**
     * Return the sessionExpireeException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return sessionExpireeExceptionHelper.type();
    }

}
