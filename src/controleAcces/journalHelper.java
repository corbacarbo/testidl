package controleAcces;

/** 
 * Helper class for : journal
 *  
 * @author OpenORB Compiler
 */ 
public class journalHelper
{
    /**
     * Insert journal into an any
     * @param a an any
     * @param t journal value
     */
    public static void insert(org.omg.CORBA.Any a, controleAcces.journal t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract journal from an any
     * @param a an any
     * @return the extracted journal value
     */
    public static controleAcces.journal extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return controleAcces.journalHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the journal TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"journal");
        }
        return _tc;
    }

    /**
     * Return the journal IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/journal:1.0";

    /**
     * Read journal from a marshalled stream
     * @param istream the input stream
     * @return the readed journal value
     */
    public static controleAcces.journal read(org.omg.CORBA.portable.InputStream istream)
    {
        return(controleAcces.journal)istream.read_Object(controleAcces._journalStub.class);
    }

    /**
     * Write journal into a marshalled stream
     * @param ostream the output stream
     * @param value journal value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, controleAcces.journal value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to journal
     * @param obj the CORBA Object
     * @return journal Object
     */
    public static journal narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof journal)
            return (journal)obj;

        if (obj._is_a(id()))
        {
            _journalStub stub = new _journalStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to journal
     * @param obj the CORBA Object
     * @return journal Object
     */
    public static journal unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof journal)
            return (journal)obj;

        _journalStub stub = new _journalStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
