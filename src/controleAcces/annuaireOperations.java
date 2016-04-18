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
    public controleAcces.cle authentification(String matricule, String mdp)
        throws controleAcces.annuairePackage.loginIncorrectException;

    /**
     * La clé provient d'un appel à authentification().
     */
    public boolean modificationMdp(controleAcces.cle cle, String matricule, String nouveauMdp)
        throws controleAcces.annuairePackage.mdpIdentiqueException;

    /**
     * Peut retourner plusieurs personnes.
     */
    public controleAcces.personne[] rechercherPersonne(String matricule, String nom, String prenom)
        throws controleAcces.annuairePackage.personneInexistanteException;

    /**
     * 
     */
    public controleAcces.personne validerIdentite(String matricule)
        throws controleAcces.annuairePackage.personneInexistanteException;

    /**
     * -> dans une structure Personne incomplète.
     * Calcul automatique et renvoi du matricule (incrémental) et du mot de passe
     * -> dans une structure Personne complète.
     */
    public controleAcces.personne ajouterPermanent(controleAcces.personne p);

    /**
     * -> dans une structure Personne incomplète.
     * Calcul automatique et renvoi du matricule (incrémental)
     * -> dans une structure Personne presque complète (pas de mot de passe)
     */
    public controleAcces.personne ajouterTemporaire(controleAcces.personne p);

}
