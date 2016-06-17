package controleAcces;

/**
 * Interface definition : annuaire
 * 
 * @author OpenORB Compiler
 */
public class _annuaireStub extends org.omg.CORBA.portable.ObjectImpl
        implements annuaire
{
    static final String[] _ids_list =
    {
        "IDL:controleAcces/annuaire:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = controleAcces.annuaireOperations.class;

    /**
     * Operation authentification
     */
    public long authentification(String matriculeIdl, String mdp)
        throws controleAcces.annuairePackage.loginIncorrectException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("authentification",true);
                    controleAcces.MatriculeHelper.write(_output,matriculeIdl);
                    _output.write_string(mdp);
                    _input = this._invoke(_output);
                    long _arg_ret = controleAcces.CleHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(controleAcces.annuairePackage.loginIncorrectExceptionHelper.id()))
                    {
                        throw controleAcces.annuairePackage.loginIncorrectExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("authentification",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.annuaireOperations _self = (controleAcces.annuaireOperations) _so.servant;
                try
                {
                    return _self.authentification( matriculeIdl,  mdp);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modificationMdp
     */
    public void modificationMdp(long cleIdl, String matriculeIdl, String nouveauMdp)
        throws controleAcces.annuairePackage.mdpIdentiqueException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException, controleAcces.annuairePackage.personneInexistanteException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modificationMdp",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.MatriculeHelper.write(_output,matriculeIdl);
                    _output.write_string(nouveauMdp);
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
                    if (_exception_id.equals(controleAcces.annuairePackage.mdpIdentiqueExceptionHelper.id()))
                    {
                        throw controleAcces.annuairePackage.mdpIdentiqueExceptionHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(controleAcces.sessionInvalidExceptionHelper.id()))
                    {
                        throw controleAcces.sessionInvalidExceptionHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(controleAcces.sessionExpireeExceptionHelper.id()))
                    {
                        throw controleAcces.sessionExpireeExceptionHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(controleAcces.annuairePackage.personneInexistanteExceptionHelper.id()))
                    {
                        throw controleAcces.annuairePackage.personneInexistanteExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modificationMdp",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.annuaireOperations _self = (controleAcces.annuaireOperations) _so.servant;
                try
                {
                    _self.modificationMdp( cleIdl,  matriculeIdl,  nouveauMdp);
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
     * Operation rechercherPersonne
     */
    public controleAcces.personneIdl[] rechercherPersonne(long cleIdl, String matriculeIdl, String nom, String prenom)
        throws controleAcces.annuairePackage.personneInexistanteException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rechercherPersonne",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.MatriculeHelper.write(_output,matriculeIdl);
                    _output.write_string(nom);
                    _output.write_string(prenom);
                    _input = this._invoke(_output);
                    controleAcces.personneIdl[] _arg_ret = controleAcces.annuairePackage.listePersonneHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(controleAcces.annuairePackage.personneInexistanteExceptionHelper.id()))
                    {
                        throw controleAcces.annuairePackage.personneInexistanteExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rechercherPersonne",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.annuaireOperations _self = (controleAcces.annuaireOperations) _so.servant;
                try
                {
                    return _self.rechercherPersonne( cleIdl,  matriculeIdl,  nom,  prenom);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation validerIdentite
     */
    public controleAcces.personneIdl validerIdentite(String matriculeIdl)
        throws controleAcces.annuairePackage.personneInexistanteException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("validerIdentite",true);
                    controleAcces.MatriculeHelper.write(_output,matriculeIdl);
                    _input = this._invoke(_output);
                    controleAcces.personneIdl _arg_ret = controleAcces.personneStructHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(controleAcces.annuairePackage.personneInexistanteExceptionHelper.id()))
                    {
                        throw controleAcces.annuairePackage.personneInexistanteExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("validerIdentite",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.annuaireOperations _self = (controleAcces.annuaireOperations) _so.servant;
                try
                {
                    return _self.validerIdentite( matriculeIdl);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation ajouterPermanent
     */
    public controleAcces.personneIdl ajouterPermanent(long cleIdl, controleAcces.personneIdl p)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterPermanent",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.personneStructHelper.write(_output,p);
                    _input = this._invoke(_output);
                    controleAcces.personneIdl _arg_ret = controleAcces.personneStructHelper.read(_input);
                    return _arg_ret;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterPermanent",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.annuaireOperations _self = (controleAcces.annuaireOperations) _so.servant;
                try
                {
                    return _self.ajouterPermanent( cleIdl,  p);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation ajouterTemporaire
     */
    public controleAcces.personneIdl ajouterTemporaire(long cleIdl, controleAcces.personneIdl p)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterTemporaire",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
                    controleAcces.personneStructHelper.write(_output,p);
                    _input = this._invoke(_output);
                    controleAcces.personneIdl _arg_ret = controleAcces.personneStructHelper.read(_input);
                    return _arg_ret;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterTemporaire",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.annuaireOperations _self = (controleAcces.annuaireOperations) _so.servant;
                try
                {
                    return _self.ajouterTemporaire( cleIdl,  p);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
