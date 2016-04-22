package controleAcces.autorisateurPackage;

/**
 * Holder class for : autorisationRefuseeException
 * 
 * @author OpenORB Compiler
 */
final public class autorisationRefuseeExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal autorisationRefuseeException value
     */
    public controleAcces.autorisateurPackage.autorisationRefuseeException value;

    /**
     * Default constructor
     */
    public autorisationRefuseeExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public autorisationRefuseeExceptionHolder(controleAcces.autorisateurPackage.autorisationRefuseeException initial)
    {
        value = initial;
    }

    /**
     * Read autorisationRefuseeException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = autorisationRefuseeExceptionHelper.read(istream);
    }

    /**
     * Write autorisationRefuseeException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        autorisationRefuseeExceptionHelper.write(ostream,value);
    }

    /**
     * Return the autorisationRefuseeException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return autorisationRefuseeExceptionHelper.type();
    }

}
