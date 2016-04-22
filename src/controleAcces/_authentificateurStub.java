package controleAcces;

/**
 * Interface definition : authentificateur
 * 
 * @author OpenORB Compiler
 */
public class _authentificateurStub extends org.omg.CORBA.portable.ObjectImpl
        implements authentificateur
{
    static final String[] _ids_list =
    {
        "IDL:controleAcces/authentificateur:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = controleAcces.authentificateurOperations.class;

    /**
     * Operation startSession
     */
    public long startSession()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("startSession",true);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("startSession",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.authentificateurOperations _self = (controleAcces.authentificateurOperations) _so.servant;
                try
                {
                    return _self.startSession();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation valideSession
     */
    public void valideSession(long cleIdl)
        throws controleAcces.authentificateurPackage.sessionInvalidException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("valideSession",true);
                    controleAcces.CleHelper.write(_output,cleIdl);
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
                    if (_exception_id.equals(controleAcces.authentificateurPackage.sessionInvalidExceptionHelper.id()))
                    {
                        throw controleAcces.authentificateurPackage.sessionInvalidExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("valideSession",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.authentificateurOperations _self = (controleAcces.authentificateurOperations) _so.servant;
                try
                {
                    _self.valideSession( cleIdl);
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
