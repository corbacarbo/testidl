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
    public controleAcces.cle authentification(String matricule, String mdp)
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
                    controleAcces.MatriculeHelper.write(_output,matricule);
                    _output.write_string(mdp);
                    _input = this._invoke(_output);
                    controleAcces.cle _arg_ret = controleAcces.cleStructHelper.read(_input);
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
                    return _self.authentification( matricule,  mdp);
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
    public boolean modificationMdp(controleAcces.cle cle, String matricule, String nouveauMdp)
        throws controleAcces.annuairePackage.mdpIdentiqueException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modificationMdp",true);
                    controleAcces.cleStructHelper.write(_output,cle);
                    controleAcces.MatriculeHelper.write(_output,matricule);
                    _output.write_string(nouveauMdp);
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
                    if (_exception_id.equals(controleAcces.annuairePackage.mdpIdentiqueExceptionHelper.id()))
                    {
                        throw controleAcces.annuairePackage.mdpIdentiqueExceptionHelper.read(_exception.getInputStream());
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
                    return _self.modificationMdp( cle,  matricule,  nouveauMdp);
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
    public controleAcces.personne[] rechercherPersonne(String matricule, String nom, String prenom)
        throws controleAcces.annuairePackage.personneInexistanteException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rechercherPersonne",true);
                    controleAcces.MatriculeHelper.write(_output,matricule);
                    _output.write_string(nom);
                    _output.write_string(prenom);
                    _input = this._invoke(_output);
                    controleAcces.personne[] _arg_ret = controleAcces.annuairePackage.listePersonneHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rechercherPersonne",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.annuaireOperations _self = (controleAcces.annuaireOperations) _so.servant;
                try
                {
                    return _self.rechercherPersonne( matricule,  nom,  prenom);
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
    public controleAcces.personne validerIdentite(String matricule)
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
                    controleAcces.MatriculeHelper.write(_output,matricule);
                    _input = this._invoke(_output);
                    controleAcces.personne _arg_ret = controleAcces.personneStructHelper.read(_input);
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
                    return _self.validerIdentite( matricule);
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
    public controleAcces.personne ajouterPermanent(controleAcces.personne p)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterPermanent",true);
                    controleAcces.personneStructHelper.write(_output,p);
                    _input = this._invoke(_output);
                    controleAcces.personne _arg_ret = controleAcces.personneStructHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
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
                    return _self.ajouterPermanent( p);
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
    public controleAcces.personne ajouterTemporaire(controleAcces.personne p)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterTemporaire",true);
                    controleAcces.personneStructHelper.write(_output,p);
                    _input = this._invoke(_output);
                    controleAcces.personne _arg_ret = controleAcces.personneStructHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
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
                    return _self.ajouterTemporaire( p);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
