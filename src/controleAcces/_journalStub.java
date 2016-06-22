package controleAcces;

/**
 * Interface definition : journal
 * 
 * @author OpenORB Compiler
 */
public class _journalStub extends org.omg.CORBA.portable.ObjectImpl
        implements journal
{
    static final String[] _ids_list =
    {
        "IDL:controleAcces/journal:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = controleAcces.journalOperations.class;

    /**
     * Operation loguer
     */
    public void loguer(controleAcces.journalPackage.demandeIdl demandeIdl)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("loguer",false);
                    controleAcces.journalPackage.demandeStructHelper.write(_output,demandeIdl);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("loguer",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.journalOperations _self = (controleAcces.journalOperations) _so.servant;
                try
                {
                    _self.loguer( demandeIdl);
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
     * Operation loguerInconnu
     */
    public void loguerInconnu(controleAcces.journalPackage.demandeIdl demandeIdl)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("loguerInconnu",false);
                    controleAcces.journalPackage.demandeStructHelper.write(_output,demandeIdl);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("loguerInconnu",_opsClass);
                if (_so == null)
                   continue;
                controleAcces.journalOperations _self = (controleAcces.journalOperations) _so.servant;
                try
                {
                    _self.loguerInconnu( demandeIdl);
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
