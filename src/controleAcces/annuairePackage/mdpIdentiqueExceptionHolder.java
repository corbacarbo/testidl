package controleAcces.annuairePackage;

/**
 * Holder class for : mdpIdentiqueException
 * 
 * @author OpenORB Compiler
 */
final public class mdpIdentiqueExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal mdpIdentiqueException value
     */
    public controleAcces.annuairePackage.mdpIdentiqueException value;

    /**
     * Default constructor
     */
    public mdpIdentiqueExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public mdpIdentiqueExceptionHolder(controleAcces.annuairePackage.mdpIdentiqueException initial)
    {
        value = initial;
    }

    /**
     * Read mdpIdentiqueException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = mdpIdentiqueExceptionHelper.read(istream);
    }

    /**
     * Write mdpIdentiqueException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        mdpIdentiqueExceptionHelper.write(ostream,value);
    }

    /**
     * Return the mdpIdentiqueException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return mdpIdentiqueExceptionHelper.type();
    }

}
