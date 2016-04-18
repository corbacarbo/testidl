package controleAcces.autorisateurPackage;

/** 
 * Helper class for : conflitAutorisationException
 *  
 * @author OpenORB Compiler
 */ 
public class conflitAutorisationExceptionHelper
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
     * Insert conflitAutorisationException into an any
     * @param a an any
     * @param t conflitAutorisationException value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.autorisateurPackage.conflitAutorisationException t)
    {
        a.insert_Streamable(new controleAcces.autorisateurPackage.conflitAutorisationExceptionHolder(t));
    }

    /**
     * Extract conflitAutorisationException from an any
     * @param a an any
     * @return the extracted conflitAutorisationException value
     */
    public static controleAcces.autorisateurPackage.conflitAutorisationException extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof controleAcces.autorisateurPackage.conflitAutorisationExceptionHolder)
                    return ((controleAcces.autorisateurPackage.conflitAutorisationExceptionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            controleAcces.autorisateurPackage.conflitAutorisationExceptionHolder h = new controleAcces.autorisateurPackage.conflitAutorisationExceptionHolder(read(a.create_input_stream()));
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
     * Return the conflitAutorisationException TypeCode
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
                _tc = orb.create_exception_tc(id(),"conflitAutorisationException",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the conflitAutorisationException IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/autorisateur/conflitAutorisationException:1.0";

    /**
     * Read conflitAutorisationException from a marshalled stream
     * @param istream the input stream
     * @return the readed conflitAutorisationException value
     */
    public static controleAcces.autorisateurPackage.conflitAutorisationException read(org.omg.CORBA.portable.InputStream istream)
    {
        controleAcces.autorisateurPackage.conflitAutorisationException new_one = new controleAcces.autorisateurPackage.conflitAutorisationException();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.message = istream.read_string();

        return new_one;
    }

    /**
     * Write conflitAutorisationException into a marshalled stream
     * @param ostream the output stream
     * @param value conflitAutorisationException value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.autorisateurPackage.conflitAutorisationException value)
    {
        ostream.write_string(id());
        ostream.write_string(value.message);
    }

}
