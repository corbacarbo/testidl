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
    public boolean ajouterAutorisationP(controleAcces.cle cle, controleAcces.autorisateurPackage.autorisationP autorisation)
        throws controleAcces.autorisateurPackage.conflitAutorisationException;

    /**
     * Operation ajouterAutorisationT
     */
    public boolean ajouterAutorisationT(controleAcces.cle cle, controleAcces.autorisateurPackage.autorisationT autorisation)
        throws controleAcces.autorisateurPackage.conflitAutorisationException;

    /**
     * Operation validerAutorisation
     */
    public boolean validerAutorisation(String matricule)
        throws controleAcces.autorisateurPackage.autorisationRefuseeException;

}
