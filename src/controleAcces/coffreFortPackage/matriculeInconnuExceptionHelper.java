package controleAcces.coffreFortPackage;

/** 
 * Helper class for : matriculeInconnuException
 *  
 * @author OpenORB Compiler
 */ 
public class matriculeInconnuExceptionHelper
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
     * Insert matriculeInconnuException into an any
     * @param a an any
     * @param t matriculeInconnuException value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.coffreFortPackage.matriculeInconnuException t)
    {
        a.insert_Streamable(new controleAcces.coffreFortPackage.matriculeInconnuExceptionHolder(t));
    }

    /**
     * Extract matriculeInconnuException from an any
     * @param a an any
     * @return the extracted matriculeInconnuException value
     */
    public static controleAcces.coffreFortPackage.matriculeInconnuException extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof controleAcces.coffreFortPackage.matriculeInconnuExceptionHolder)
                    return ((controleAcces.coffreFortPackage.matriculeInconnuExceptionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            controleAcces.coffreFortPackage.matriculeInconnuExceptionHolder h = new controleAcces.coffreFortPackage.matriculeInconnuExceptionHolder(read(a.create_input_stream()));
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
     * Return the matriculeInconnuException TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[1];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "message";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_exception_tc(id(),"matriculeInconnuException",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the matriculeInconnuException IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/coffreFort/matriculeInconnuException:1.0";

    /**
     * Read matriculeInconnuException from a marshalled stream
     * @param istream the input stream
     * @return the readed matriculeInconnuException value
     */
    public static controleAcces.coffreFortPackage.matriculeInconnuException read(org.omg.CORBA.portable.InputStream istream)
    {
        controleAcces.coffreFortPackage.matriculeInconnuException new_one = new controleAcces.coffreFortPackage.matriculeInconnuException();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.message = istream.read_string();

        return new_one;
    }

    /**
     * Write matriculeInconnuException into a marshalled stream
     * @param ostream the output stream
     * @param value matriculeInconnuException value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.coffreFortPackage.matriculeInconnuException value)
    {
        ostream.write_string(id());
        ostream.write_string(value.message);
    }

}
