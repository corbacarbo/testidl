package controleAcces;

/**
 * Interface definition : trousseau
 * 
 * @author OpenORB Compiler
 */
public interface trousseauOperations
{
    /**
     * Operation startSession
     */
    public long startSession();

    /**
     * Operation valideSession
     */
    public void valideSession(long cleIdl)
        throws controleAcces.trousseauPackage.sessionInvalidException, controleAcces.trousseauPackage.sessionExpireeException;

}
