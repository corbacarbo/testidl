package controleAcces;

/** 
 * Helper class for : authentificateur
 *  
 * @author OpenORB Compiler
 */ 
public class authentificateurHelper
{
    /**
     * Insert authentificateur into an any
     * @param a an any
     * @param t authentificateur value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.authentificateur t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract authentificateur from an any
     * @param a an any
     * @return the extracted authentificateur value
     */
    public static controleAcces.authentificateur extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return controleAcces.authentificateurHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the authentificateur TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"authentificateur");
        }
        return _tc;
    }

    /**
     * Return the authentificateur IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/authentificateur:1.0";

    /**
     * Read authentificateur from a marshalled stream
     * @param istream the input stream
     * @return the readed authentificateur value
     */
    public static controleAcces.authentificateur read(org.omg.CORBA.portable.InputStream istream)
    {
        return(controleAcces.authentificateur)istream.read_Object(controleAcces._authentificateurStub.class);
    }

    /**
     * Write authentificateur into a marshalled stream
     * @param ostream the output stream
     * @param value authentificateur value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.authentificateur value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to authentificateur
     * @param obj the CORBA Object
     * @return authentificateur Object
     */
    public static authentificateur narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof authentificateur)
            return (authentificateur)obj;

        if (obj._is_a(id()))
        {
            _authentificateurStub stub = new _authentificateurStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to authentificateur
     * @param obj the CORBA Object
     * @return authentificateur Object
     */
    public static authentificateur unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof authentificateur)
            return (authentificateur)obj;

        _authentificateurStub stub = new _authentificateurStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
