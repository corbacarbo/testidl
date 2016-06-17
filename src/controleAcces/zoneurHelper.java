package controleAcces;

/** 
 * Helper class for : zoneur
 *  
 * @author OpenORB Compiler
 */ 
public class zoneurHelper
{
    /**
     * Insert zoneur into an any
     * @param a an any
     * @param t zoneur value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.zoneur t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract zoneur from an any
     * @param a an any
     * @return the extracted zoneur value
     */
    public static controleAcces.zoneur extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return controleAcces.zoneurHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the zoneur TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"zoneur");
        }
        return _tc;
    }

    /**
     * Return the zoneur IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/zoneur:1.0";

    /**
     * Read zoneur from a marshalled stream
     * @param istream the input stream
     * @return the readed zoneur value
     */
    public static controleAcces.zoneur read(org.omg.CORBA.portable.InputStream istream)
    {
        return(controleAcces.zoneur)istream.read_Object(controleAcces._zoneurStub.class);
    }

    /**
     * Write zoneur into a marshalled stream
     * @param ostream the output stream
     * @param value zoneur value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.zoneur value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to zoneur
     * @param obj the CORBA Object
     * @return zoneur Object
     */
    public static zoneur narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof zoneur)
            return (zoneur)obj;

        if (obj._is_a(id()))
        {
            _zoneurStub stub = new _zoneurStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to zoneur
     * @param obj the CORBA Object
     * @return zoneur Object
     */
    public static zoneur unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof zoneur)
            return (zoneur)obj;

        _zoneurStub stub = new _zoneurStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
