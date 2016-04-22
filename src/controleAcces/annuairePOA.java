package controleAcces;

/**
 * Interface definition : annuaire
 * 
 * @author OpenORB Compiler
 */
public abstract class annuairePOA extends org.omg.PortableServer.Servant
        implements annuaireOperations, org.omg.CORBA.portable.InvokeHandler
{
    public annuaire _this()
    {
        return annuaireHelper.narrow(_this_object());
    }

    public annuaire _this(org.omg.CORBA.ORB orb)
    {
        return annuaireHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:controleAcces/annuaire:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("ajouterPermanent")) {
                return _invoke_ajouterPermanent(_is, handler);
        } else if (opName.equals("ajouterTemporaire")) {
                return _invoke_ajouterTemporaire(_is, handler);
        } else if (opName.equals("authentification")) {
                return _invoke_authentification(_is, handler);
        } else if (opName.equals("modificationMdp")) {
                return _invoke_modificationMdp(_is, handler);
        } else if (opName.equals("rechercherPersonne")) {
                return _invoke_rechercherPersonne(_is, handler);
        } else if (opName.equals("validerIdentite")) {
                return _invoke_validerIdentite(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_authentification(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = controleAcces.MatriculeHelper.read(_is);
        String arg1_in = _is.read_string();

        try
        {
            long _arg_result = authentification(arg0_in, arg1_in);

            _output = handler.createReply();
            controleAcces.CleHelper.write(_output,_arg_result);

        }
        catch (controleAcces.annuairePackage.loginIncorrectException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.annuairePackage.loginIncorrectExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modificationMdp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        long arg0_in = controleAcces.CleHelper.read(_is);
        String arg1_in = controleAcces.MatriculeHelper.read(_is);
        String arg2_in = _is.read_string();

        try
        {
            boolean _arg_result = modificationMdp(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (controleAcces.annuairePackage.mdpIdentiqueException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.annuairePackage.mdpIdentiqueExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_rechercherPersonne(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = controleAcces.MatriculeHelper.read(_is);
        String arg1_in = _is.read_string();
        String arg2_in = _is.read_string();

        try
        {
            controleAcces.personneIdl[] _arg_result = rechercherPersonne(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            controleAcces.annuairePackage.listePersonneHelper.write(_output,_arg_result);

        }
        catch (controleAcces.annuairePackage.personneInexistanteException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.annuairePackage.personneInexistanteExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_validerIdentite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = controleAcces.MatriculeHelper.read(_is);

        try
        {
            controleAcces.personneIdl _arg_result = validerIdentite(arg0_in);

            _output = handler.createReply();
            controleAcces.personneStructHelper.write(_output,_arg_result);

        }
        catch (controleAcces.annuairePackage.personneInexistanteException _exception)
        {
            _output = handler.createExceptionReply();
            controleAcces.annuairePackage.personneInexistanteExceptionHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterPermanent(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        controleAcces.personneIdl arg0_in = controleAcces.personneStructHelper.read(_is);

        controleAcces.personneIdl _arg_result = ajouterPermanent(arg0_in);

        _output = handler.createReply();
        controleAcces.personneStructHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterTemporaire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        controleAcces.personneIdl arg0_in = controleAcces.personneStructHelper.read(_is);

        controleAcces.personneIdl _arg_result = ajouterTemporaire(arg0_in);

        _output = handler.createReply();
        controleAcces.personneStructHelper.write(_output,_arg_result);

        return _output;
    }

}
