package controleAcces.annuairePackage;

/**
 * Holder class for : listePersonne
 * 
 * @author OpenORB Compiler
 */
final public class listePersonneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listePersonne value
     */
    public controleAcces.personne[] value;

    /**
     * Default constructor
     */
    public listePersonneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listePersonneHolder(controleAcces.personne[] initial)
    {
        value = initial;
    }

    /**
     * Read listePersonne from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listePersonneHelper.read(istream);
    }

    /**
     * Write listePersonne into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listePersonneHelper.write(ostream,value);
    }

    /**
     * Return the listePersonne TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listePersonneHelper.type();
    }

}
