package controleAcces.annuairePackage;

/** 
 * Helper class for : listePersonne
 *  
 * @author OpenORB Compiler
 */ 
public class listePersonneHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert listePersonne into an any
     * @param a an any
     * @param t listePersonne value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.personneIdl[] t)
    {
        a.insert_Streamable(new controleAcces.annuairePackage.listePersonneHolder(t));
    }

    /**
     * Extract listePersonne from an any
     * @param a an any
     * @return the extracted listePersonne value
     */
    public static controleAcces.personneIdl[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof controleAcces.annuairePackage.listePersonneHolder)
                    return ((controleAcces.annuairePackage.listePersonneHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            controleAcces.annuairePackage.listePersonneHolder h = new controleAcces.annuairePackage.listePersonneHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the listePersonne TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listePersonne",orb.create_sequence_tc(0,controleAcces.personneStructHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listePersonne IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/annuaire/listePersonne:1.0";

    /**
     * Read listePersonne from a marshalled stream
     * @param istream the input stream
     * @return the readed listePersonne value
     */
    public static controleAcces.personneIdl[] read(org.omg.CORBA.portable.InputStream istream)
    {
        controleAcces.personneIdl[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new controleAcces.personneIdl[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = controleAcces.personneStructHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listePersonne into a marshalled stream
     * @param ostream the output stream
     * @param value listePersonne value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.personneIdl[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            controleAcces.personneStructHelper.write(ostream,value[i7]);

        }
    }

}
