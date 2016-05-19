package controleAcces;

/**
 * Interface definition : coffreFort
 * 
 * @author OpenORB Compiler
 */
public class _coffreFortStub extends org.omg.CORBA.portable.ObjectImpl
        implements coffreFort
{
    static final String[] _ids_list =
    {
        "IDL:controleAcces/coffreFort:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = controleAcces.coffreFortOperations.class;

    /**
     * Operation aEmpreinte
     */
    public void aEmpreinte(long cleIdl, String matriculeIdl)
        throws controleAcces.coffreFortPackage.matriculeInconnuException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("aEmpreinte",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
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
                    if (_exception_id.equals(controleAcces.coffreFortPackage.matriculeInconnuExceptionHelper.id()))
                    {
                        throw controleAcces.coffreFortPackage.matriculeInconnuExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("aEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.coffreFortOperations _self = (controleAcces.coffreFortOperations) _so.servant;
                try
                {
                    _self.aEmpreinte( cleIdl,  matriculeIdl);
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
     * Operation validerEmpreinte
     */
    public String validerEmpreinte(long cleIdl, long empreinteIdl)
        throws controleAcces.coffreFortPackage.empreinteInconnueException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("validerEmpreinte",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.EmpreinteHelper.write(_output,empreinteIdl);
                    _input = this._invoke(_output);
                    String _arg_ret = controleAcces.MatriculeHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(controleAcces.coffreFortPackage.empreinteInconnueExceptionHelper.id()))
                    {
                        throw controleAcces.coffreFortPackage.empreinteInconnueExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("validerEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.coffreFortOperations _self = (controleAcces.coffreFortOperations) _so.servant;
                try
                {
                    return _self.validerEmpreinte( cleIdl,  empreinteIdl);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modificationEmpreinte
     */
    public void modificationEmpreinte(long cleIdl, long empreinteIdl, String matriculeIdl)
        throws controleAcces.coffreFortPackage.matriculeInconnuException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modificationEmpreinte",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.EmpreinteHelper.write(_output,empreinteIdl);
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
                    if (_exception_id.equals(controleAcces.coffreFortPackage.matriculeInconnuExceptionHelper.id()))
                    {
                        throw controleAcces.coffreFortPackage.matriculeInconnuExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modificationEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.coffreFortOperations _self = (controleAcces.coffreFortOperations) _so.servant;
                try
                {
                    _self.modificationEmpreinte( cleIdl,  empreinteIdl,  matriculeIdl);
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
     * Operation ajouterEmpreinteTemp
     */
    public void ajouterEmpreinteTemp(long cleIdl, long empreinteIdl, String matriculeIdl)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterEmpreinteTemp",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.EmpreinteHelper.write(_output,empreinteIdl);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterEmpreinteTemp",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.coffreFortOperations _self = (controleAcces.coffreFortOperations) _so.servant;
                try
                {
                    _self.ajouterEmpreinteTemp( cleIdl,  empreinteIdl,  matriculeIdl);
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
     * Operation supprimerEmpreinteTemp
     */
    public void supprimerEmpreinteTemp(long cleIdl, String matriculeIdl)
        throws controleAcces.coffreFortPackage.matriculeInconnuException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerEmpreinteTemp",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
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
                    if (_exception_id.equals(controleAcces.coffreFortPackage.matriculeInconnuExceptionHelper.id()))
                    {
                        throw controleAcces.coffreFortPackage.matriculeInconnuExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerEmpreinteTemp",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.coffreFortOperations _self = (controleAcces.coffreFortOperations) _so.servant;
                try
                {
                    _self.supprimerEmpreinteTemp( cleIdl,  matriculeIdl);
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
