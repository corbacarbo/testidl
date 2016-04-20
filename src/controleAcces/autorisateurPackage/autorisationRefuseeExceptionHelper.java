package controleAcces.autorisateurPackage;

/** 
 * Helper class for : autorisationRefuseeException
 *  
 * @author OpenORB Compiler
 */ 
public class autorisationRefuseeExceptionHelper
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
     * Insert autorisationRefuseeException into an any
     * @param a an any
     * @param t autorisationRefuseeException value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.autorisateurPackage.autorisationRefuseeException t)
    {
        a.insert_Streamable(new controleAcces.autorisateurPackage.autorisationRefuseeExceptionHolder(t));
    }

    /**
     * Extract autorisationRefuseeException from an any
     * @param a an any
     * @return the extracted autorisationRefuseeException value
     */
    public static controleAcces.autorisateurPackage.autorisationRefuseeException extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof controleAcces.autorisateurPackage.autorisationRefuseeExceptionHolder)
                    return ((controleAcces.autorisateurPackage.autorisationRefuseeExceptionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            controleAcces.autorisateurPackage.autorisationRefuseeExceptionHolder h = new controleAcces.autorisateurPackage.autorisationRefuseeExceptionHolder(read(a.create_input_stream()));
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
     * Return the autorisationRefuseeException TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "message";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "heure";
                _members[1].type = controleAcces.HeureHelper.type();
                _tc = orb.create_exception_tc(id(),"autorisationRefuseeException",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the autorisationRefuseeException IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/autorisateur/autorisationRefuseeException:1.0";

    /**
     * Read autorisationRefuseeException from a marshalled stream
     * @param istream the input stream
     * @return the readed autorisationRefuseeException value
     */
    public static controleAcces.autorisateurPackage.autorisationRefuseeException read(org.omg.CORBA.portable.InputStream istream)
    {
        controleAcces.autorisateurPackage.autorisationRefuseeException new_one = new controleAcces.autorisateurPackage.autorisationRefuseeException();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.message = istream.read_string();
        new_one.heure = controleAcces.HeureHelper.read(istream);

        return new_one;
    }

    /**
     * Write autorisationRefuseeException into a marshalled stream
     * @param ostream the output stream
     * @param value autorisationRefuseeException value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.autorisateurPackage.autorisationRefuseeException value)
    {
        ostream.write_string(id());
        ostream.write_string(value.message);
        controleAcces.HeureHelper.write(ostream,value.heure);
    }

}