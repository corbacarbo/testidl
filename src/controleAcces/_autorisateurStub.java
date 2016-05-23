package controleAcces;

/**
 * Interface definition : autorisateur
 * 
 * @author OpenORB Compiler
 */
public class _autorisateurStub extends org.omg.CORBA.portable.ObjectImpl
        implements autorisateur
{
    static final String[] _ids_list =
    {
        "IDL:controleAcces/autorisateur:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = controleAcces.autorisateurOperations.class;

    /**
     * Operation ajouterAutorisation
     */
    public void ajouterAutorisation(long cleIdl, controleAcces.autorisateurPackage.autorisationIdl autorisationIdl)
        throws controleAcces.autorisateurPackage.conflitAutorisationException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterAutorisation",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.autorisateurPackage.autorisationStructHelper.write(_output,autorisationIdl);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(controleAcces.autorisateurPackage.conflitAutorisationExceptionHelper.id()))
                    {
                        throw controleAcces.autorisateurPackage.conflitAutorisationExceptionHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(controleAcces.sessionInvalidExceptionHelper.id()))
                    {
                        throw controleAcces.sessionInvalidExceptionHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(controleAcces.sessionExpireeExceptionHelper.id()))
                    {
                        throw controleAcces.sessionExpireeExceptionHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterAutorisation",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.autorisateurOperations _self = (controleAcces.autorisateurOperations) _so.servant;
                try
                {
                    _self.ajouterAutorisation( cleIdl,  autorisationIdl);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation ajouterAutorisationRestreinte
     */
    public void ajouterAutorisationRestreinte(long cleIdl, controleAcces.autorisateurPackage.autorisationRestreinteIdl autorisationIdl)
        throws controleAcces.autorisateurPackage.conflitAutorisationException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterAutorisationRestreinte",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.autorisateurPackage.autorisationRestreinteStructHelper.write(_output,autorisationIdl);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(controleAcces.autorisateurPackage.conflitAutorisationExceptionHelper.id()))
                    {
                        throw controleAcces.autorisateurPackage.conflitAutorisationExceptionHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(controleAcces.sessionInvalidExceptionHelper.id()))
                    {
                        throw controleAcces.sessionInvalidExceptionHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(controleAcces.sessionExpireeExceptionHelper.id()))
                    {
                        throw controleAcces.sessionExpireeExceptionHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterAutorisationRestreinte",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.autorisateurOperations _self = (controleAcces.autorisateurOperations) _so.servant;
                try
                {
                    _self.ajouterAutorisationRestreinte( cleIdl,  autorisationIdl);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation autoriser
     */
    public void autoriser(String matriculeIdl)
        throws controleAcces.autorisateurPackage.autorisationRefuseeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("autoriser",true);
                    controleAcces.MatriculeHelper.write(_output,matriculeIdl);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(controleAcces.autorisateurPackage.autorisationRefuseeExceptionHelper.id()))
                    {
                        throw controleAcces.autorisateurPackage.autorisationRefuseeExceptionHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("autoriser",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.autorisateurOperations _self = (controleAcces.autorisateurOperations) _so.servant;
                try
                {
                    _self.autoriser( matriculeIdl);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
