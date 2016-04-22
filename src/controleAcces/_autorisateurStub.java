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
     * Operation ajouterAutorisationP
     */
    public void ajouterAutorisationP(long cleIdl, controleAcces.autorisateurPackage.autorisationP autorisation)
        throws controleAcces.autorisateurPackage.conflitAutorisationException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterAutorisationP",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.autorisateurPackage.autorisationPStructHelper.write(_output,autorisation);
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

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterAutorisationP",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.autorisateurOperations _self = (controleAcces.autorisateurOperations) _so.servant;
                try
                {
                    _self.ajouterAutorisationP( cleIdl,  autorisation);
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
     * Operation ajouterAutorisationT
     */
    public void ajouterAutorisationT(long cleIdl, controleAcces.autorisateurPackage.autorisationT autorisation)
        throws controleAcces.autorisateurPackage.conflitAutorisationException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterAutorisationT",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.autorisateurPackage.autorisationTStructHelper.write(_output,autorisation);
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

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterAutorisationT",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.autorisateurOperations _self = (controleAcces.autorisateurOperations) _so.servant;
                try
                {
                    _self.ajouterAutorisationT( cleIdl,  autorisation);
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
