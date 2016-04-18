package controleAcces.autorisateurPackage;

/** 
 * Helper class for : autorisationP
 *  
 * @author OpenORB Compiler
 */ 
public class autorisationPHelper
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
     * Insert autorisationP into an any
     * @param a an any
     * @param t autorisationP value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.autorisateurPackage.autorisationP t)
    {
        a.insert_Streamable(new controleAcces.autorisateurPackage.autorisationPHolder(t));
    }

    /**
     * Extract autorisationP from an any
     * @param a an any
     * @return the extracted autorisationP value
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
     * Return the autorisationP TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[3];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "matricule";
                _members[0].type = controleAcces.MatriculeHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "heureD";
                _members[1].type = controleAcces.HeureHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "heureF";
                _members[2].type = controleAcces.HeureHelper.type();
                _tc = orb.create_struct_tc(id(),"autorisationP",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the autorisationP IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/autorisateur/autorisationP:1.0";

    /**
     * Read autorisationP from a marshalled stream
     * @param istream the input stream
     * @return the readed autorisationP value
     */
    public static controleAcces.autorisateurPackage.autorisationP read(org.omg.CORBA.portable.InputStream istream)
    {
        controleAcces.autorisateurPackage.autorisationP new_one = new controleAcces.autorisateurPackage.autorisationP();

        new_one.matricule = controleAcces.MatriculeHelper.read(istream);
        new_one.heureD = controleAcces.HeureHelper.read(istream);
        new_one.heureF = controleAcces.HeureHelper.read(istream);

        return new_one;
    }

    /**
     * Write autorisationP into a marshalled stream
     * @param ostream the output stream
     * @param value autorisationP value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.autorisateurPackage.autorisationP value)
    {
        controleAcces.MatriculeHelper.write(ostream,value.matricule);
        controleAcces.HeureHelper.write(ostream,value.heureD);
        controleAcces.HeureHelper.write(ostream,value.heureF);
    }

}
