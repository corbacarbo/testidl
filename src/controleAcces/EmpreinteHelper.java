package controleAcces;

/** 
 * Helper class for : Empreinte
 *  
 * @author OpenORB Compiler
 */ 
public class EmpreinteHelper
{
    /**
     * Insert Empreinte into an any
     * @param a an any
     * @param t Empreinte value
     */
    public static void insert(org.omg.CORBA.Any a, long t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract Empreinte from an any
     * @param a an any
     * @return the extracted Empreinte value
     */
    public static long extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Empreinte TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"Empreinte",orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_longlong));
        }
        return _tc;
    }

    /**
     * Return the Empreinte IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:controleAcces/Empreinte:1.0";

    /**
     * Read Empreinte from a marshalled stream
     * @param istream the input stream
     * @return the readed Empreinte value
     */
    public static long read(org.omg.CORBA.portable.InputStream istream)
    {
        long new_one;
        new_one = istream.read_longlong();

        return new_one;
    }

    /**
     * Write Empreinte into a marshalled stream
     * @param ostream the output stream
     * @param value Empreinte value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, long value)
    {
        ostream.write_longlong(value);
    }

}
