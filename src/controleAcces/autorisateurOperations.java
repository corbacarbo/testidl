package controleAcces;

/**
 * Interface definition : autorisateur
 * 
 * @author OpenORB Compiler
 */
public interface autorisateurOperations
{
    /**
     * Operation ajouterAutorisationP
     */
    public void ajouterAutorisationP(long cleIdl, controleAcces.autorisateurPackage.autorisationP autorisation)
        throws controleAcces.autorisateurPackage.conflitAutorisationException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * Operation ajouterAutorisationT
     */
    public void ajouterAutorisationT(long cleIdl, controleAcces.autorisateurPackage.autorisationT autorisation)
        throws controleAcces.autorisateurPackage.conflitAutorisationException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * Operation autoriser
     */
    public void autoriser(String matriculeIdl)
        throws controleAcces.autorisateurPackage.autorisationRefuseeException;

}
