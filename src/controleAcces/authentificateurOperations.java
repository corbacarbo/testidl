package controleAcces;

/**
 * Interface definition : authentificateur
 * 
 * @author OpenORB Compiler
 */
public interface authentificateurOperations
{
    /**
     * Operation startSession
     */
    public long startSession();

    /**
     * Operation valideSession
     */
    public void valideSession(long cleIdl)
        throws controleAcces.authentificateurPackage.sessionInvalidException;

}
