package controleAcces.autorisateurPackage;

/** 
 * Helper class for : autorisationRestreinteStruct
 *  
 * @author OpenORB Compiler
 */ 
public class autorisationRestreinteStructHelper
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
     * Insert autorisationRestreinteStruct into an any
     * @param a an any
     * @param t autorisationRestreinteStruct value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.autorisateurPackage.autorisationRestreinteIdl t)
    {
        a.insert_Streamable(new controleAcces.autorisateurPackage.autorisationRestreinteIdlHolder(t));
    }

    /**
     * Extract autorisationRestreinteStruct from an any
     * @param a an any
     * @return the extracted autorisationRestreinteStruct value
     */
    public static controleAcces.autorisateurPackage.autorisationRestreinteIdl extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof controleAcces.autorisateurPackage.autorisationRestreinteIdlHolder)
                    return ((controleAcces.autorisateurPackage.autorisationRestreinteIdlHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            controleAcces.autorisateurPackage.autorisationRestreinteIdlHolder h = new controleAcces.autorisateurPackage.autorisationRestreinteIdlHolder(read(a.create_input_stream()));
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
     * Return the autorisationRestreinteStruct TypeCode
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
            _tc = orb.create_alias_tc(id(),"autorisationRestreinteStruct",controleAcces.autorisateurPackage.autorisationRestreinteIdlHelper.type());
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the autorisationRestreinteStruct IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/autorisateur/autorisationRestreinteStruct:1.0";

    /**
     * Read autorisationRestreinteStruct from a marshalled stream
     * @param istream the input stream
     * @return the readed autorisationRestreinteStruct value
     */
    public static controleAcces.autorisateurPackage.autorisationRestreinteIdl read(org.omg.CORBA.portable.InputStream istream)
    {
        return controleAcces.autorisateurPackage.autorisationRestreinteIdlHelper.read(istream);
    }

    /**
     * Write autorisationRestreinteStruct into a marshalled stream
     * @param ostream the output stream
     * @param value autorisationRestreinteStruct value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.autorisateurPackage.autorisationRestreinteIdl value)
    {
        controleAcces.autorisateurPackage.autorisationRestreinteIdlHelper.write(ostream, value);
    }

}
