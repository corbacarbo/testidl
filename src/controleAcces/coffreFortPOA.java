package controleAcces;

/**
 * Interface definition : coffreFort
 * 
 * @author OpenORB Compiler
 */
public abstract class coffreFortPOA extends org.omg.PortableServer.Servant
        implements coffreFortOperations, org.omg.CORBA.portable.InvokeHandler
{
    public coffreFort _this()
    {
        return coffreFortHelper.narrow(_this_object());
    }

    public coffreFort _this(org.omg.CORBA.ORB orb)
    {
        return coffreFortHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:controleAcces/coffreFort:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("ajouterEmpreinteTemp")) {
                return _invoke_ajouterEmpreinteTemp(_is, handler);
        } else if (opName.equals("modificationEmpreinte")) {
                return _invoke_modificationEmpreinte(_is, handler);
        } else if (opName.equals("supprimerEmpreinteTemp")) {
                return _invoke_supprimerEmpreinteTemp(_is, handler);
        } else if (opName.equals("validerEmpreinte")) {
                return _invoke_validerEmpreinte(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_validerEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        long arg0_in = controleAcces.CleHelper.read(_is);
        long arg1_in = controleAcces.EmpreinteHelper.read(_is);

        try
        {
            String _arg_result = validerEmpreinte(arg0_in, arg1_in);

            _output = handler.createReply();
            controleAcces.MatriculeHelper.write(_output,_arg_result);

        }
        catch (controleAcces.coffreFortPackage.empreinteInconnueException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.coffreFortPackage.empreinteInconnueExceptionHelper.write(_output,_exception);
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

    private org.omg.CORBA.portable.OutputStream _invoke_modificationEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        long arg0_in = controleAcces.CleHelper.read(_is);
        long arg1_in = controleAcces.EmpreinteHelper.read(_is);
        String arg2_in = controleAcces.MatriculeHelper.read(_is);

        try
        {
            modificationEmpreinte(arg0_in, arg1_in, arg2_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterEmpreinteTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        long arg0_in = controleAcces.CleHelper.read(_is);
        long arg1_in = controleAcces.EmpreinteHelper.read(_is);
        String arg2_in = controleAcces.MatriculeHelper.read(_is);

        try
        {
            ajouterEmpreinteTemp(arg0_in, arg1_in, arg2_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerEmpreinteTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        long arg0_in = controleAcces.CleHelper.read(_is);
        String arg1_in = controleAcces.MatriculeHelper.read(_is);

        try
        {
            supprimerEmpreinteTemp(arg0_in, arg1_in);

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
