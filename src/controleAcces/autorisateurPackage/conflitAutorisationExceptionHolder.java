package controleAcces.autorisateurPackage;

/**
 * Holder class for : conflitAutorisationException
 * 
 * @author OpenORB Compiler
 */
final public class conflitAutorisationExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal conflitAutorisationException value
     */
    public controleAcces.autorisateurPackage.conflitAutorisationException value;

    /**
     * Default constructor
     */
    public conflitAutorisationExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public conflitAutorisationExceptionHolder(controleAcces.autorisateurPackage.conflitAutorisationException initial)
    {
        value = initial;
    }

    /**
     * Read conflitAutorisationException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = conflitAutorisationExceptionHelper.read(istream);
    }

    /**
     * Write conflitAutorisationException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        conflitAutorisationExceptionHelper.write(ostream,value);
    }

    /**
     * Return the conflitAutorisationException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return conflitAutorisationExceptionHelper.type();
    }

}
