package controleAcces;

/**
 * Interface definition : autorisateur
 * 
 * @author OpenORB Compiler
 */
public interface autorisateurOperations
{
    /**
     * Operation ajouterAutorisation
     */
    public void ajouterAutorisation(long cleIdl, controleAcces.autorisateurPackage.autorisationIdl autorisationIdl)
        throws controleAcces.autorisateurPackage.conflitAutorisationException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * Operation ajouterAutorisationRestreinte
     */
    public void ajouterAutorisationRestreinte(long cleIdl, controleAcces.autorisateurPackage.autorisationRestreinteIdl autorisationIdl)
        throws controleAcces.autorisateurPackage.conflitAutorisationException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * Operation autoriser
     */
    public void autoriser(String matriculeIdl)
        throws controleAcces.autorisateurPackage.autorisationRefuseeException;

}
