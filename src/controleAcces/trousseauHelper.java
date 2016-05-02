package controleAcces;

/** 
 * Helper class for : trousseau
 *  
 * @author OpenORB Compiler
 */ 
public class trousseauHelper
{
    /**
     * Insert trousseau into an any
     * @param a an any
     * @param t trousseau value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.trousseau t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract trousseau from an any
     * @param a an any
     * @return the extracted trousseau value
     */
    public static controleAcces.trousseau extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return controleAcces.trousseauHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the trousseau TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"trousseau");
        }
        return _tc;
    }

    /**
     * Return the trousseau IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/trousseau:1.0";

    /**
     * Read trousseau from a marshalled stream
     * @param istream the input stream
     * @return the readed trousseau value
     */
    public static controleAcces.trousseau read(org.omg.CORBA.portable.InputStream istream)
    {
        return(controleAcces.trousseau)istream.read_Object(controleAcces._trousseauStub.class);
    }

    /**
     * Write trousseau into a marshalled stream
     * @param ostream the output stream
     * @param value trousseau value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.trousseau value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to trousseau
     * @param obj the CORBA Object
     * @return trousseau Object
     */
    public static trousseau narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof trousseau)
            return (trousseau)obj;

        if (obj._is_a(id()))
        {
            _trousseauStub stub = new _trousseauStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to trousseau
     * @param obj the CORBA Object
     * @return trousseau Object
     */
    public static trousseau unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof trousseau)
            return (trousseau)obj;

        _trousseauStub stub = new _trousseauStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
