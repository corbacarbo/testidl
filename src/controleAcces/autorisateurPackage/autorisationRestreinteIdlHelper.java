package controleAcces.autorisateurPackage;

/** 
 * Helper class for : autorisationRestreinteIdl
 *  
 * @author OpenORB Compiler
 */ 
public class autorisationRestreinteIdlHelper
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
     * Insert autorisationRestreinteIdl into an any
     * @param a an any
     * @param t autorisationRestreinteIdl value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.autorisateurPackage.autorisationRestreinteIdl t)
    {
        a.insert_Streamable(new controleAcces.autorisateurPackage.autorisationRestreinteIdlHolder(t));
    }

    /**
     * Extract autorisationRestreinteIdl from an any
     * @param a an any
     * @return the extracted autorisationRestreinteIdl value
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
     * Return the autorisationRestreinteIdl TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[12];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "matricule";
                _members[0].type = controleAcces.MatriculeHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "heureD";
                _members[1].type = controleAcces.HeureHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "minuteD";
                _members[2].type = controleAcces.MinuteHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "heureF";
                _members[3].type = controleAcces.HeureHelper.type();
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "minuteF";
                _members[4].type = controleAcces.MinuteHelper.type();
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "jourD";
                _members[5].type = controleAcces.JourHelper.type();
                _members[6] = new org.omg.CORBA.StructMember();
                _members[6].name = "moisD";
                _members[6].type = controleAcces.MoisHelper.type();
                _members[7] = new org.omg.CORBA.StructMember();
                _members[7].name = "anneeD";
                _members[7].type = controleAcces.AnneeHelper.type();
                _members[8] = new org.omg.CORBA.StructMember();
                _members[8].name = "jourF";
                _members[8].type = controleAcces.JourHelper.type();
                _members[9] = new org.omg.CORBA.StructMember();
                _members[9].name = "moisF";
                _members[9].type = controleAcces.MoisHelper.type();
                _members[10] = new org.omg.CORBA.StructMember();
                _members[10].name = "anneeF";
                _members[10].type = controleAcces.AnneeHelper.type();
                _members[11] = new org.omg.CORBA.StructMember();
                _members[11].name = "zone";
                _members[11].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"autorisationRestreinteIdl",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the autorisationRestreinteIdl IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/autorisateur/autorisationRestreinteIdl:1.0";

    /**
     * Read autorisationRestreinteIdl from a marshalled stream
     * @param istream the input stream
     * @return the readed autorisationRestreinteIdl value
     */
    public static controleAcces.autorisateurPackage.autorisationRestreinteIdl read(org.omg.CORBA.portable.InputStream istream)
    {
        controleAcces.autorisateurPackage.autorisationRestreinteIdl new_one = new controleAcces.autorisateurPackage.autorisationRestreinteIdl();

        new_one.matricule = controleAcces.MatriculeHelper.read(istream);
        new_one.heureD = controleAcces.HeureHelper.read(istream);
        new_one.minuteD = controleAcces.MinuteHelper.read(istream);
        new_one.heureF = controleAcces.HeureHelper.read(istream);
        new_one.minuteF = controleAcces.MinuteHelper.read(istream);
        new_one.jourD = controleAcces.JourHelper.read(istream);
        new_one.moisD = controleAcces.MoisHelper.read(istream);
        new_one.anneeD = controleAcces.AnneeHelper.read(istream);
        new_one.jourF = controleAcces.JourHelper.read(istream);
        new_one.moisF = controleAcces.MoisHelper.read(istream);
        new_one.anneeF = controleAcces.AnneeHelper.read(istream);
        new_one.zone = istream.read_string();

        return new_one;
    }

    /**
     * Write autorisationRestreinteIdl into a marshalled stream
     * @param ostream the output stream
     * @param value autorisationRestreinteIdl value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.autorisateurPackage.autorisationRestreinteIdl value)
    {
        controleAcces.MatriculeHelper.write(ostream,value.matricule);
        controleAcces.HeureHelper.write(ostream,value.heureD);
        controleAcces.MinuteHelper.write(ostream,value.minuteD);
        controleAcces.HeureHelper.write(ostream,value.heureF);
        controleAcces.MinuteHelper.write(ostream,value.minuteF);
        controleAcces.JourHelper.write(ostream,value.jourD);
        controleAcces.MoisHelper.write(ostream,value.moisD);
        controleAcces.AnneeHelper.write(ostream,value.anneeD);
        controleAcces.JourHelper.write(ostream,value.jourF);
        controleAcces.MoisHelper.write(ostream,value.moisF);
        controleAcces.AnneeHelper.write(ostream,value.anneeF);
        ostream.write_string(value.zone);
    }

}
