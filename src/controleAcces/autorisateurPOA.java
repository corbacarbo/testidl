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
        } else if (opName.equals("validerAutorisation")) {
                return _invoke_validerAutorisation(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_ajouterAutorisationP(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        controleAcces.cle arg0_in = controleAcces.cleStructHelper.read(_is);
        controleAcces.autorisateurPackage.autorisationP arg1_in = controleAcces.autorisateurPackage.autorisationPStructHelper.read(_is);

        try
        {
            boolean _arg_result = ajouterAutorisationP(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (controleAcces.autorisateurPackage.conflitAutorisationException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.autorisateurPackage.conflitAutorisationExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterAutorisationT(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        controleAcces.cle arg0_in = controleAcces.cleStructHelper.read(_is);
        controleAcces.autorisateurPackage.autorisationT arg1_in = controleAcces.autorisateurPackage.autorisationTStructHelper.read(_is);

        try
        {
            boolean _arg_result = ajouterAutorisationT(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (controleAcces.autorisateurPackage.conflitAutorisationException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.autorisateurPackage.conflitAutorisationExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_validerAutorisation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = controleAcces.MatriculeHelper.read(_is);

        try
        {
            boolean _arg_result = validerAutorisation(arg0_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (controleAcces.autorisateurPackage.autorisationRefuseeException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.autorisateurPackage.autorisationRefuseeExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

}