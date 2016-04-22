package controleAcces.journalPackage;

/** 
 * Helper class for : demandeStruct
 *  
 * @author OpenORB Compiler
 */ 
public class demandeStructHelper
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
     * Insert demandeStruct into an any
     * @param a an any
     * @param t demandeStruct value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.journalPackage.demandeIdl t)
    {
        a.insert_Streamable(new controleAcces.journalPackage.demandeIdlHolder(t));
    }

    /**
     * Extract demandeStruct from an any
     * @param a an any
     * @return the extracted demandeStruct value
     */
    public static controleAcces.journalPackage.demandeIdl extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof controleAcces.journalPackage.demandeIdlHolder)
                    return ((controleAcces.journalPackage.demandeIdlHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            controleAcces.journalPackage.demandeIdlHolder h = new controleAcces.journalPackage.demandeIdlHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the demandeStruct TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"demandeStruct",controleAcces.journalPackage.demandeIdlHelper.type());
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the demandeStruct IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/journal/demandeStruct:1.0";

    /**
     * Read demandeStruct from a marshalled stream
     * @param istream the input stream
     * @return the readed demandeStruct value
     */
    public static controleAcces.journalPackage.demandeIdl read(org.omg.CORBA.portable.InputStream istream)
    {
        return controleAcces.journalPackage.demandeIdlHelper.read(istream);
    }

    /**
     * Write demandeStruct into a marshalled stream
     * @param ostream the output stream
     * @param value demandeStruct value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.journalPackage.demandeIdl value)
    {
        controleAcces.journalPackage.demandeIdlHelper.write(ostream, value);
    }

}
