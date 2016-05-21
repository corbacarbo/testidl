package controleAcces;

/**
 * Interface definition : autorisateur
 * 
 * @author OpenORB Compiler
 */
public abstract class autorisateurPOA extends org.omg.PortableServer.Servant
        implements autorisateurOperations, org.omg.CORBA.portable.InvokeHandler
{
    public autorisateur _this()
    {
        return autorisateurHelper.narrow(_this_object());
    }

    public autorisateur _this(org.omg.CORBA.ORB orb)
    {
        return autorisateurHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:controleAcces/autorisateur:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("ajouterAutorisationP")) {
                return _invoke_ajouterAutorisationP(_is, handler);
        } else if (opName.equals("ajouterAutorisationT")) {
                return _invoke_ajouterAutorisationT(_is, handler);
        } else if (opName.equals("autoriser")) {
                return _invoke_autoriser(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_ajouterAutorisationP(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        long arg0_in = controleAcces.CleHelper.read(_is);
        controleAcces.autorisateurPackage.autorisationPIdl arg1_in = controleAcces.autorisateurPackage.autorisationPStructHelper.read(_is);

        try
        {
            ajouterAutorisationP(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (controleAcces.autorisateurPackage.conflitAutorisationException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.autorisateurPackage.conflitAutorisationExceptionHelper.write(_output,_exception);
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

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterAutorisationT(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        long arg0_in = controleAcces.CleHelper.read(_is);
        controleAcces.autorisateurPackage.autorisationTIdl arg1_in = controleAcces.autorisateurPackage.autorisationTStructHelper.read(_is);

        try
        {
            ajouterAutorisationT(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (controleAcces.autorisateurPackage.conflitAutorisationException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.autorisateurPackage.conflitAutorisationExceptionHelper.write(_output,_exception);
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

    private org.omg.CORBA.portable.OutputStream _invoke_autoriser(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = controleAcces.MatriculeHelper.read(_is);

        try
        {
            autoriser(arg0_in);

            _output = handler.createReply();

        }
        catch (controleAcces.autorisateurPackage.autorisationRefuseeException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.autorisateurPackage.autorisationRefuseeExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

}
