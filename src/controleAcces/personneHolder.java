package controleAcces;

/**
 * Holder class for : personne
 * 
 * @author OpenORB Compiler
 */
final public class personneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal personne value
     */
    public controleAcces.personne value;

    /**
     * Default constructor
     */
    public personneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public personneHolder(controleAcces.personne initial)
    {
        value = initial;
    }

    /**
     * Read personne from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = personneHelper.read(istream);
    }

    /**
     * Write personne into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        personneHelper.write(ostream,value);
    }

    /**
     * Return the personne TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return personneHelper.type();
    }

}
