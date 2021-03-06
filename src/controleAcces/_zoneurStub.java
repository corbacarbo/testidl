package controleAcces;

/**
 * Un zoneur est responsable :
 * - maintenir une liste des personnes actuellement présentes dans sa zone
 * (afin d'éviter les usurpations)
 * - servir de relais pour décharger le naming service : les entités et 
 * clients spécifiques à une zone passent par lui pour obtenir des IOR.
 * - de gérer les id des portes présentes dans sa zone.
 */
public class _zoneurStub extends org.omg.CORBA.portable.ObjectImpl
        implements zoneur
{
    static final String[] _ids_list =
    {
        "IDL:controleAcces/zoneur:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = controleAcces.zoneurOperations.class;

    /**
     * Operation resolveAnnuaire
     */
    public controleAcces.annuaire resolveAnnuaire()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("resolveAnnuaire",true);
                    _input = this._invoke(_output);
                    controleAcces.annuaire _arg_ret = controleAcces.annuaireHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("resolveAnnuaire",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.resolveAnnuaire();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation resolveCoffreFort
     */
    public controleAcces.coffreFort resolveCoffreFort()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("resolveCoffreFort",true);
                    _input = this._invoke(_output);
                    controleAcces.coffreFort _arg_ret = controleAcces.coffreFortHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("resolveCoffreFort",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.resolveCoffreFort();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation resolveJournal
     */
    public controleAcces.journal resolveJournal()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("resolveJournal",true);
                    _input = this._invoke(_output);
                    controleAcces.journal _arg_ret = controleAcces.journalHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("resolveJournal",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.resolveJournal();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation resolveAutorisateur
     */
    public controleAcces.autorisateur resolveAutorisateur()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("resolveAutorisateur",true);
                    _input = this._invoke(_output);
                    controleAcces.autorisateur _arg_ret = controleAcces.autorisateurHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("resolveAutorisateur",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.resolveAutorisateur();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation resolveAutorisateurTemporaire
     */
    public controleAcces.autorisateur resolveAutorisateurTemporaire()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("resolveAutorisateurTemporaire",true);
                    _input = this._invoke(_output);
                    controleAcces.autorisateur _arg_ret = controleAcces.autorisateurHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("resolveAutorisateurTemporaire",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.resolveAutorisateurTemporaire();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation resolveTrousseau
     */
    public controleAcces.trousseau resolveTrousseau()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("resolveTrousseau",true);
                    _input = this._invoke(_output);
                    controleAcces.trousseau _arg_ret = controleAcces.trousseauHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("resolveTrousseau",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.resolveTrousseau();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation isNotInsideZone
     */
    public boolean isNotInsideZone(String matriculeIdl)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("isNotInsideZone",true);
                    _output.write_string(matriculeIdl);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("isNotInsideZone",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.isNotInsideZone( matriculeIdl);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation isNotInsideAllZoneEntree
     */
    public boolean isNotInsideAllZoneEntree(String matriculeIdl)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("isNotInsideAllZoneEntree",true);
                    _output.write_string(matriculeIdl);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("isNotInsideAllZoneEntree",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.isNotInsideAllZoneEntree( matriculeIdl);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation isNotInsideAllZoneSortie
     */
    public boolean isNotInsideAllZoneSortie(String matriculeIdl)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("isNotInsideAllZoneSortie",true);
                    _output.write_string(matriculeIdl);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("isNotInsideAllZoneSortie",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.isNotInsideAllZoneSortie( matriculeIdl);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation isInsideZone
     */
    public boolean isInsideZone(String matriculeIdl)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("isInsideZone",true);
                    _output.write_string(matriculeIdl);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("isInsideZone",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.isInsideZone( matriculeIdl);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation entre
     */
    public void entre(String matriculeIdl)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("entre",false);
                    _output.write_string(matriculeIdl);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("entre",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    _self.entre( matriculeIdl);
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
     * Operation sort
     */
    public void sort(String matriculeIdl)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("sort",false);
                    _output.write_string(matriculeIdl);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("sort",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    _self.sort( matriculeIdl);
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
     * Operation getIdPorte
     */
    public int getIdPorte()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getIdPorte",true);
                    _input = this._invoke(_output);
                    int _arg_ret = _input.read_long();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getIdPorte",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.zoneurOperations _self = (controleAcces.zoneurOperations) _so.servant;
                try
                {
                    return _self.getIdPorte();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
