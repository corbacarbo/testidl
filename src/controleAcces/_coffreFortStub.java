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
     * Operation validerEmpreinte
     */
    public String validerEmpreinte(controleAcces.cle cle, int empreinte)
        throws controleAcces.coffreFortPackage.empreinteInconnueException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("validerEmpreinte",true);
                    controleAcces.cleStructHelper.write(_output,cle);
                    controleAcces.EmpreinteHelper.write(_output,empreinte);
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
                    return _self.validerEmpreinte( cle,  empreinte);
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
    public boolean modificationEmpreinte(controleAcces.cle cle, int empreinte, String matricule)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modificationEmpreinte",true);
                    controleAcces.cleStructHelper.write(_output,cle);
                    controleAcces.EmpreinteHelper.write(_output,empreinte);
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
                    return _self.modificationEmpreinte( cle,  empreinte,  matricule);
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
    public boolean ajouterEmpreinteTemp(controleAcces.cle cle, int empreinte, String matricule)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterEmpreinteTemp",true);
                    controleAcces.cleStructHelper.write(_output,cle);
                    controleAcces.EmpreinteHelper.write(_output,empreinte);
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
                    return _self.ajouterEmpreinteTemp( cle,  empreinte,  matricule);
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
    public boolean supprimerEmpreinteTemp(controleAcces.cle cle, String matricule)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerEmpreinteTemp",true);
                    controleAcces.cleStructHelper.write(_output,cle);
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
                    return _self.supprimerEmpreinteTemp( cle,  matricule);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
