package controleAcces;

/**
 * Interface definition : authentificateur
 * 
 * @author OpenORB Compiler
 */
public abstract class authentificateurPOA extends org.omg.PortableServer.Servant
        implements authentificateurOperations, org.omg.CORBA.portable.InvokeHandler
{
    public authentificateur _this()
    {
        return authentificateurHelper.narrow(_this_object());
    }

    public authentificateur _this(org.omg.CORBA.ORB orb)
    {
        return authentificateurHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:controleAcces/authentificateur:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("startSession")) {
                return _invoke_startSession(_is, handler);
        } else if (opName.equals("valideSession")) {
                return _invoke_valideSession(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_startSession(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        long _arg_result = startSession();

        _output = handler.createReply();
        controleAcces.CleHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_valideSession(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        long arg0_in = controleAcces.CleHelper.read(_is);

        try
        {
            valideSession(arg0_in);

            _output = handler.createReply();

        }
        catch (controleAcces.authentificateurPackage.sessionInvalidException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.authentificateurPackage.sessionInvalidExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

}