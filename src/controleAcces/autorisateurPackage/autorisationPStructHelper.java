package controleAcces.autorisateurPackage;

/** 
 * Helper class for : autorisationPStruct
 *  
 * @author OpenORB Compiler
 */ 
public class autorisationPStructHelper
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
     * Insert autorisationPStruct into an any
     * @param a an any
     * @param t autorisationPStruct value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.autorisateurPackage.autorisationP t)
    {
        a.insert_Streamable(new controleAcces.autorisateurPackage.autorisationPHolder(t));
    }

    /**
     * Extract autorisationPStruct from an any
     * @param a an any
     * @return the extracted autorisationPStruct value
     */
    public static controleAcces.autorisateurPackage.autorisationP extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof controleAcces.autorisateurPackage.autorisationPHolder)
                    return ((controleAcces.autorisateurPackage.autorisationPHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            controleAcces.autorisateurPackage.autorisationPHolder h = new controleAcces.autorisateurPackage.autorisationPHolder(read(a.create_input_stream()));
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
     * Return the autorisationPStruct TypeCode
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
            _tc = orb.create_alias_tc(id(),"autorisationPStruct",controleAcces.autorisateurPackage.autorisationPHelper.type());
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the autorisationPStruct IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/autorisateur/autorisationPStruct:1.0";

    /**
     * Read autorisationPStruct from a marshalled stream
     * @param istream the input stream
     * @return the readed autorisationPStruct value
     */
    public static controleAcces.autorisateurPackage.autorisationP read(org.omg.CORBA.portable.InputStream istream)
    {
        return controleAcces.autorisateurPackage.autorisationPHelper.read(istream);
    }

    /**
     * Write autorisationPStruct into a marshalled stream
     * @param ostream the output stream
     * @param value autorisationPStruct value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.autorisateurPackage.autorisationP value)
    {
        controleAcces.autorisateurPackage.autorisationPHelper.write(ostream, value);
    }

}
