package controleAcces;

/**
 * Interface definition : annuaire
 * 
 * @author OpenORB Compiler
 */
public interface annuaireOperations
{
    /**
     * Retourne une clé permettant d’accéder aux services nécessitant une authentification.
     */
    public long authentification(String matriculeIdl, String mdp)
        throws controleAcces.annuairePackage.loginIncorrectException;

    /**
     * La clé provient d'un appel à authentification().
     */
    public void modificationMdp(long cleIdl, String matriculeIdl, String nouveauMdp)
        throws controleAcces.annuairePackage.mdpIdentiqueException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException, controleAcces.annuairePackage.personneInexistanteException;

    /**
     * Peut retourner plusieurs personnes.
     */
    public controleAcces.personneIdl[] rechercherPersonne(long cleIdl, String matriculeIdl, String nom, String prenom)
        throws controleAcces.annuairePackage.personneInexistanteException, controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * 
     */
    public controleAcces.personneIdl validerIdentite(String matriculeIdl)
        throws controleAcces.annuairePackage.personneInexistanteException;

    /**
     * -> dans une structure Personne incomplète.
     * Calcul automatique et renvoi du matricule (incrémental) et du mot de passe
     * -> dans une structure Personne complète.
     */
    public controleAcces.personneIdl ajouterPermanent(long cleIdl, controleAcces.personneIdl p)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

    /**
     * -> dans une structure Personne incomplète.
     * Calcul automatique et renvoi du matricule (incrémental)
     * -> dans une structure Personne presque complète (pas de mot de passe)
     */
    public controleAcces.personneIdl ajouterTemporaire(long cleIdl, controleAcces.personneIdl p)
        throws controleAcces.sessionInvalidException, controleAcces.sessionExpireeException;

}
