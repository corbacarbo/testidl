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
    public boolean ajouterAutorisationP(controleAcces.cle cle, controleAcces.autorisateurPackage.autorisationP autorisation)
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
                    controleAcces.cleStructHelper.write(_output,cle);
                    controleAcces.autorisateurPackage.autorisationPStructHelper.write(_output,autorisation);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
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
                    return _self.ajouterAutorisationP( cle,  autorisation);
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
    public boolean ajouterAutorisationT(controleAcces.cle cle, controleAcces.autorisateurPackage.autorisationT autorisation)
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
                    controleAcces.cleStructHelper.write(_output,cle);
                    controleAcces.autorisateurPackage.autorisationTStructHelper.write(_output,autorisation);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
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
                    return _self.ajouterAutorisationT( cle,  autorisation);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation validerAutorisation
     */
    public boolean validerAutorisation(String matricule)
        throws controleAcces.autorisateurPackage.autorisationRefuseeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("validerAutorisation",true);
                    controleAcces.MatriculeHelper.write(_output,matricule);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("validerAutorisation",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.autorisateurOperations _self = (controleAcces.autorisateurOperations) _so.servant;
                try
                {
                    return _self.validerAutorisation( matricule);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
