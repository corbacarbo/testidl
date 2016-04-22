package controleAcces;

/** 
 * Helper class for : autorisateur
 *  
 * @author OpenORB Compiler
 */ 
public class autorisateurHelper
{
    /**
     * Insert autorisateur into an any
     * @param a an any
     * @param t autorisateur value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.autorisateur t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract autorisateur from an any
     * @param a an any
     * @return the extracted autorisateur value
     */
    public static controleAcces.autorisateur extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return controleAcces.autorisateurHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the autorisateur TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"autorisateur");
        }
        return _tc;
    }

    /**
     * Return the autorisateur IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/autorisateur:1.0";

    /**
     * Read autorisateur from a marshalled stream
     * @param istream the input stream
     * @return the readed autorisateur value
     */
    public static controleAcces.autorisateur read(org.omg.CORBA.portable.InputStream istream)
    {
        return(controleAcces.autorisateur)istream.read_Object(controleAcces._autorisateurStub.class);
    }

    /**
     * Write autorisateur into a marshalled stream
     * @param ostream the output stream
     * @param value autorisateur value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.autorisateur value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to autorisateur
     * @param obj the CORBA Object
     * @return autorisateur Object
     */
    public static autorisateur narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof autorisateur)
            return (autorisateur)obj;

        if (obj._is_a(id()))
        {
            _autorisateurStub stub = new _autorisateurStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to autorisateur
     * @param obj the CORBA Object
     * @return autorisateur Object
     */
    public static autorisateur unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof autorisateur)
            return (autorisateur)obj;

        _autorisateurStub stub = new _autorisateurStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
