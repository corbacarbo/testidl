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
    public long startSession(String c);

    /**
     * Operation valideSession
     */
    public void valideSession(long cleIdl)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

}
