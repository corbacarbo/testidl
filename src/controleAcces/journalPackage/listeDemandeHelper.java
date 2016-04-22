package controleAcces.journalPackage;

/** 
 * Helper class for : listeDemande
 *  
 * @author OpenORB Compiler
 */ 
public class listeDemandeHelper
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
     * Insert listeDemande into an any
     * @param a an any
     * @param t listeDemande value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.journalPackage.demandeIdl[] t)
    {
        a.insert_Streamable(new controleAcces.journalPackage.listeDemandeHolder(t));
    }

    /**
     * Extract listeDemande from an any
     * @param a an any
     * @return the extracted listeDemande value
     */
    public static controleAcces.journalPackage.demandeIdl[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof controleAcces.journalPackage.listeDemandeHolder)
                    return ((controleAcces.journalPackage.listeDemandeHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            controleAcces.journalPackage.listeDemandeHolder h = new controleAcces.journalPackage.listeDemandeHolder(read(a.create_input_stream()));
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
     * Return the listeDemande TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listeDemande",orb.create_sequence_tc(0,controleAcces.journalPackage.demandeStructHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listeDemande IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/journal/listeDemande:1.0";

    /**
     * Read listeDemande from a marshalled stream
     * @param istream the input stream
     * @return the readed listeDemande value
     */
    public static controleAcces.journalPackage.demandeIdl[] read(org.omg.CORBA.portable.InputStream istream)
    {
        controleAcces.journalPackage.demandeIdl[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new controleAcces.journalPackage.demandeIdl[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = controleAcces.journalPackage.demandeStructHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listeDemande into a marshalled stream
     * @param ostream the output stream
     * @param value listeDemande value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.journalPackage.demandeIdl[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            controleAcces.journalPackage.demandeStructHelper.write(ostream,value[i7]);

        }
    }

}
