package controleAcces.coffreFortPackage;

/**
 * Holder class for : empreinteInconnueException
 * 
 * @author OpenORB Compiler
 */
final public class empreinteInconnueExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal empreinteInconnueException value
     */
    public controleAcces.coffreFortPackage.empreinteInconnueException value;

    /**
     * Default constructor
     */
    public empreinteInconnueExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public empreinteInconnueExceptionHolder(controleAcces.coffreFortPackage.empreinteInconnueException initial)
    {
        value = initial;
    }

    /**
     * Read empreinteInconnueException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = empreinteInconnueExceptionHelper.read(istream);
    }

    /**
     * Write empreinteInconnueException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        empreinteInconnueExceptionHelper.write(ostream,value);
    }

    /**
     * Return the empreinteInconnueException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return empreinteInconnueExceptionHelper.type();
    }

}
