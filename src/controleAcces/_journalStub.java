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
    public void loguer(String matricule, controleAcces.journalPackage.date dateHeure, int idZone, int idPorte, String statut, int type)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("loguer",false);
                    controleAcces.MatriculeHelper.write(_output,matricule);
                    controleAcces.journalPackage.dateStructHelper.write(_output,dateHeure);
                    _output.write_long(idZone);
                    _output.write_long(idPorte);
                    _output.write_string(statut);
                    _output.write_long(type);
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
                    _self.loguer( matricule,  dateHeure,  idZone,  idPorte,  statut,  type);
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
    public void loguerInconnu(int empreinte, controleAcces.journalPackage.date dateHeure, int idZone, int idPorte, String statut, int type)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("loguerInconnu",false);
                    controleAcces.EmpreinteHelper.write(_output,empreinte);
                    controleAcces.journalPackage.dateStructHelper.write(_output,dateHeure);
                    _output.write_long(idZone);
                    _output.write_long(idPorte);
                    _output.write_string(statut);
                    _output.write_long(type);
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
                    _self.loguerInconnu( empreinte,  dateHeure,  idZone,  idPorte,  statut,  type);
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
