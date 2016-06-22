package controleAcces;

/**
 * Un zoneur est responsable :
 * - maintenir une liste des personnes actuellement présentes dans sa zone
 * (afin d'éviter les usurpations)
 * - servir de relais pour décharger le naming service : les entités et 
 * clients spécifiques à une zone passent par lui pour obtenir des IOR.
 * - de gérer les id des portes présentes dans sa zone.
 */
public interface zoneurOperations
{
    /**
     * Renvoie un lien pointant vers l'entité annuaire.
     */
    public controleAcces.annuaire resolveAnnuaire();

    /**
     * Renvoie un lien pointant vers l'entité coffreFort.
     */
    public controleAcces.coffreFort resolveCoffreFort();

    /**
     * Renvoie un lien pointant vers l'entité journal.
     */
    public controleAcces.journal resolveJournal();

    /**
     * Renvoie un lien pointant vers l'entité autorisateur de la zone du zoneur.
     */
    public controleAcces.autorisateur resolveAutorisateur();

    /**
     * Renvoie un lien pointant vers l'entité autorisateurTemporaire.
     */
    public controleAcces.autorisateur resolveAutorisateurTemporaire();

    /**
     * Renvoie un lien pointant vers l'entité trousseau.
     */
    public controleAcces.trousseau resolveTrousseau();

    /**
     * Vérifie si un employé n'est pas présent dans la zone.
     */
    public boolean isNotInsideZone(String matriculeIdl);

    /**
     * Vérifie si un employé est présent dans une des zones.
     * Contacte tous les zoneurs (sauf lui-même) pour vérifier la non-présence
     * d'un employé. Renvoie Vrai si l'employé est introuvable.
     */
    public boolean isNotInsideAllZoneEntree(String matriculeIdl);

    /**
     * Vérifie si un employé est présent dans une des zones.
     * Contacte tous les zoneurs pour vérifier la présence
     * d'un employé. Renvoie Vrai si l'employé est trouvable.
     */
    public boolean isNotInsideAllZoneSortie(String matriculeIdl);

    /**
     * Vérifie si un employé est présent dans la zone.
     */
    public boolean isInsideZone(String matriculeIdl);

    /**
     * Enrregistre un employé comme étant présent dans la zone.
     */
    public void entre(String matriculeIdl);

    /**
     * Enrregistre un employé comme n'étant plus présent dans la zone.
     */
    public void sort(String matriculeIdl);

    /**
     * Renvoie un id porte non utilisé pour une nouvelle porte.
     */
    public int getIdPorte();

}
