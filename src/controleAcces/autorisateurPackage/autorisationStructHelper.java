package controleAcces.autorisateurPackage;

/** 
 * Helper class for : autorisationStruct
 *  
 * @author OpenORB Compiler
 */ 
public class autorisationStructHelper
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
     * Insert autorisationStruct into an any
     * @param a an any
     * @param t autorisationStruct value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.autorisateurPackage.autorisationIdl t)
    {
        a.insert_Streamable(new controleAcces.autorisateurPackage.autorisationIdlHolder(t));
    }

    /**
     * Extract autorisationStruct from an any
     * @param a an any
     * @return the extracted autorisationStruct value
     */
    public static controleAcces.autorisateurPackage.autorisationIdl extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof controleAcces.autorisateurPackage.autorisationIdlHolder)
                    return ((controleAcces.autorisateurPackage.autorisationIdlHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            controleAcces.autorisateurPackage.autorisationIdlHolder h = new controleAcces.autorisateurPackage.autorisationIdlHolder(read(a.create_input_stream()));
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
     * Return the autorisationStruct TypeCode
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
            _tc = orb.create_alias_tc(id(),"autorisationStruct",controleAcces.autorisateurPackage.autorisationIdlHelper.type());
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the autorisationStruct IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/autorisateur/autorisationStruct:1.0";

    /**
     * Read autorisationStruct from a marshalled stream
     * @param istream the input stream
     * @return the readed autorisationStruct value
     */
    public static controleAcces.autorisateurPackage.autorisationIdl read(org.omg.CORBA.portable.InputStream istream)
    {
        return controleAcces.autorisateurPackage.autorisationIdlHelper.read(istream);
    }

    /**
     * Write autorisationStruct into a marshalled stream
     * @param ostream the output stream
     * @param value autorisationStruct value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.autorisateurPackage.autorisationIdl value)
    {
        controleAcces.autorisateurPackage.autorisationIdlHelper.write(ostream, value);
    }

}
