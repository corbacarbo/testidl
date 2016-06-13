package controleAcces;

/**
 * Interface definition : trousseau
 * 
 * @author OpenORB Compiler
 */
public abstract class trousseauPOA extends org.omg.PortableServer.Servant
        implements trousseauOperations, org.omg.CORBA.portable.InvokeHandler
{
    public trousseau _this()
    {
        return trousseauHelper.narrow(_this_object());
    }

    public trousseau _this(org.omg.CORBA.ORB orb)
    {
        return trousseauHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:controleAcces/trousseau:1.0"
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
        String arg0_in = _is.read_string();

        long _arg_result = startSession(arg0_in);

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
        catch (controleAcces.sessionInvalidException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.sessionInvalidExceptionHelper.write(_output,_exception);
        }
        catch (controleAcces.sessionExpireeException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.sessionExpireeExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

}
