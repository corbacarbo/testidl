package controleAcces;

/** 
 * Helper class for : coffreFort
 *  
 * @author OpenORB Compiler
 */ 
public class coffreFortHelper
{
    /**
     * Insert coffreFort into an any
     * @param a an any
     * @param t coffreFort value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.coffreFort t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract coffreFort from an any
     * @param a an any
     * @return the extracted coffreFort value
     */
    public static controleAcces.coffreFort extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return controleAcces.coffreFortHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the coffreFort TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"coffreFort");
        }
        return _tc;
    }

    /**
     * Return the coffreFort IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/coffreFort:1.0";

    /**
     * Read coffreFort from a marshalled stream
     * @param istream the input stream
     * @return the readed coffreFort value
     */
    public static controleAcces.coffreFort read(org.omg.CORBA.portable.InputStream istream)
    {
        return(controleAcces.coffreFort)istream.read_Object(controleAcces._coffreFortStub.class);
    }

    /**
     * Write coffreFort into a marshalled stream
     * @param ostream the output stream
     * @param value coffreFort value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.coffreFort value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to coffreFort
     * @param obj the CORBA Object
     * @return coffreFort Object
     */
    public static coffreFort narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof coffreFort)
            return (coffreFort)obj;

        if (obj._is_a(id()))
        {
            _coffreFortStub stub = new _coffreFortStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to coffreFort
     * @param obj the CORBA Object
     * @return coffreFort Object
     */
    public static coffreFort unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof coffreFort)
            return (coffreFort)obj;

        _coffreFortStub stub = new _coffreFortStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
