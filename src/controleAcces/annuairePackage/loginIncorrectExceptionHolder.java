package controleAcces.annuairePackage;

/**
 * Holder class for : loginIncorrectException
 * 
 * @author OpenORB Compiler
 */
final public class loginIncorrectExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal loginIncorrectException value
     */
    public controleAcces.annuairePackage.loginIncorrectException value;

    /**
     * Default constructor
     */
    public loginIncorrectExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public loginIncorrectExceptionHolder(controleAcces.annuairePackage.loginIncorrectException initial)
    {
        value = initial;
    }

    /**
     * Read loginIncorrectException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = loginIncorrectExceptionHelper.read(istream);
    }

    /**
     * Write loginIncorrectException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        loginIncorrectExceptionHelper.write(ostream,value);
    }

    /**
     * Return the loginIncorrectException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return loginIncorrectExceptionHelper.type();
    }

}
