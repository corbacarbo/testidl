package controleAcces.journalPackage;

/** 
 * Helper class for : dateStruct
 *  
 * @author OpenORB Compiler
 */ 
public class dateStructHelper
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
     * Insert dateStruct into an any
     * @param a an any
     * @param t dateStruct value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.journalPackage.date t)
    {
        a.insert_Streamable(new controleAcces.journalPackage.dateHolder(t));
    }

    /**
     * Extract dateStruct from an any
     * @param a an any
     * @return the extracted dateStruct value
     */
    public static controleAcces.journalPackage.date extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof controleAcces.journalPackage.dateHolder)
                    return ((controleAcces.journalPackage.dateHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            controleAcces.journalPackage.dateHolder h = new controleAcces.journalPackage.dateHolder(read(a.create_input_stream()));
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
     * Return the dateStruct TypeCode
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
            _tc = orb.create_alias_tc(id(),"dateStruct",controleAcces.journalPackage.dateHelper.type());
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the dateStruct IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/journal/dateStruct:1.0";

    /**
     * Read dateStruct from a marshalled stream
     * @param istream the input stream
     * @return the readed dateStruct value
     */
    public static controleAcces.journalPackage.date read(org.omg.CORBA.portable.InputStream istream)
    {
        return controleAcces.journalPackage.dateHelper.read(istream);
    }

    /**
     * Write dateStruct into a marshalled stream
     * @param ostream the output stream
     * @param value dateStruct value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.journalPackage.date value)
    {
        controleAcces.journalPackage.dateHelper.write(ostream, value);
    }

}
