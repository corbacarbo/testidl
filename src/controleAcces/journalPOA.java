package controleAcces;

/**
 * Interface definition : journal
 * 
 * @author OpenORB Compiler
 */
public abstract class journalPOA extends org.omg.PortableServer.Servant
        implements journalOperations, org.omg.CORBA.portable.InvokeHandler
{
    public journal _this()
    {
        return journalHelper.narrow(_this_object());
    }

    public journal _this(org.omg.CORBA.ORB orb)
    {
        return journalHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:controleAcces/journal:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("loguer")) {
                return _invoke_loguer(_is, handler);
        } else if (opName.equals("loguerInconnu")) {
                return _invoke_loguerInconnu(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_loguer(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        controleAcces.journalPackage.demandeIdl arg0_in = controleAcces.journalPackage.demandeStructHelper.read(_is);

        loguer(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_loguerInconnu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        controleAcces.journalPackage.demandeIdl arg0_in = controleAcces.journalPackage.demandeStructHelper.read(_is);

        loguerInconnu(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
