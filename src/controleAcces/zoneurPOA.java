package controleAcces;

/**
 * Interface definition : zoneur
 * 
 * @author OpenORB Compiler
 */
public abstract class zoneurPOA extends org.omg.PortableServer.Servant
        implements zoneurOperations, org.omg.CORBA.portable.InvokeHandler
{
    public zoneur _this()
    {
        return zoneurHelper.narrow(_this_object());
    }

    public zoneur _this(org.omg.CORBA.ORB orb)
    {
        return zoneurHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:controleAcces/zoneur:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("entre",
                    new Operation_entre());
            operationMap.put("getIdPorte",
                    new Operation_getIdPorte());
            operationMap.put("isInsideZone",
                    new Operation_isInsideZone());
            operationMap.put("isNotInsideAllZoneEntree",
                    new Operation_isNotInsideAllZoneEntree());
            operationMap.put("isNotInsideAllZoneSortie",
                    new Operation_isNotInsideAllZoneSortie());
            operationMap.put("isNotInsideZone",
                    new Operation_isNotInsideZone());
            operationMap.put("resolveAnnuaire",
                    new Operation_resolveAnnuaire());
            operationMap.put("resolveAutorisateur",
                    new Operation_resolveAutorisateur());
            operationMap.put("resolveAutorisateurTemporaire",
                    new Operation_resolveAutorisateurTemporaire());
            operationMap.put("resolveCoffreFort",
                    new Operation_resolveCoffreFort());
            operationMap.put("resolveJournal",
                    new Operation_resolveJournal());
            operationMap.put("resolveTrousseau",
                    new Operation_resolveTrousseau());
            operationMap.put("sort",
                    new Operation_sort());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_resolveAnnuaire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        controleAcces.annuaire _arg_result = resolveAnnuaire();

        _output = handler.createReply();
        controleAcces.annuaireHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_resolveCoffreFort(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        controleAcces.coffreFort _arg_result = resolveCoffreFort();

        _output = handler.createReply();
        controleAcces.coffreFortHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_resolveJournal(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        controleAcces.journal _arg_result = resolveJournal();

        _output = handler.createReply();
        controleAcces.journalHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_resolveAutorisateur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        controleAcces.autorisateur _arg_result = resolveAutorisateur();

        _output = handler.createReply();
        controleAcces.autorisateurHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_resolveAutorisateurTemporaire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        controleAcces.autorisateur _arg_result = resolveAutorisateurTemporaire();

        _output = handler.createReply();
        controleAcces.autorisateurHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_resolveTrousseau(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        controleAcces.trousseau _arg_result = resolveTrousseau();

        _output = handler.createReply();
        controleAcces.trousseauHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_isNotInsideZone(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = isNotInsideZone(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_isNotInsideAllZoneEntree(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = isNotInsideAllZoneEntree(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_isNotInsideAllZoneSortie(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = isNotInsideAllZoneSortie(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_isInsideZone(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        boolean _arg_result = isInsideZone(arg0_in);

        _output = handler.createReply();
        _output.write_boolean(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_entre(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        entre(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_sort(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        sort(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getIdPorte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        int _arg_result = getIdPorte();

        _output = handler.createReply();
        _output.write_long(_arg_result);

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                zoneurPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation_resolveAnnuaire extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_resolveAnnuaire(_is, handler);
        }
    }

    private static final class Operation_resolveCoffreFort extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_resolveCoffreFort(_is, handler);
        }
    }

    private static final class Operation_resolveJournal extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_resolveJournal(_is, handler);
        }
    }

    private static final class Operation_resolveAutorisateur extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_resolveAutorisateur(_is, handler);
        }
    }

    private static final class Operation_resolveAutorisateurTemporaire extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_resolveAutorisateurTemporaire(_is, handler);
        }
    }

    private static final class Operation_resolveTrousseau extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_resolveTrousseau(_is, handler);
        }
    }

    private static final class Operation_isNotInsideZone extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_isNotInsideZone(_is, handler);
        }
    }

    private static final class Operation_isNotInsideAllZoneEntree extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_isNotInsideAllZoneEntree(_is, handler);
        }
    }

    private static final class Operation_isNotInsideAllZoneSortie extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_isNotInsideAllZoneSortie(_is, handler);
        }
    }

    private static final class Operation_isInsideZone extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_isInsideZone(_is, handler);
        }
    }

    private static final class Operation_entre extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_entre(_is, handler);
        }
    }

    private static final class Operation_sort extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_sort(_is, handler);
        }
    }

    private static final class Operation_getIdPorte extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final zoneurPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getIdPorte(_is, handler);
        }
    }

}
