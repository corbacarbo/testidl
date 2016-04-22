package controleAcces.annuairePackage;

/**
 * Holder class for : personneInexistanteException
 * 
 * @author OpenORB Compiler
 */
final public class personneInexistanteExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal personneInexistanteException value
     */
    public controleAcces.annuairePackage.personneInexistanteException value;

    /**
     * Default constructor
     */
    public personneInexistanteExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public personneInexistanteExceptionHolder(controleAcces.annuairePackage.personneInexistanteException initial)
    {
        value = initial;
    }

    /**
     * Read personneInexistanteException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = personneInexistanteExceptionHelper.read(istream);
    }

    /**
     * Write personneInexistanteException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        personneInexistanteExceptionHelper.write(ostream,value);
    }

    /**
     * Return the personneInexistanteException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return personneInexistanteExceptionHelper.type();
    }

}
