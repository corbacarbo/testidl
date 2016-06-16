package controleAcces;

/**
 * Interface definition : zoneur
 * 
 * @author OpenORB Compiler
 */
public interface zoneurOperations
{
    /**
     * Operation resolveAnnuaire
     */
    public controleAcces.annuaire resolveAnnuaire();

    /**
     * Operation resolveCoffreFort
     */
    public controleAcces.coffreFort resolveCoffreFort();

    /**
     * Operation resolveJournal
     */
    public controleAcces.journal resolveJournal();

    /**
     * Operation resolveAutorisateur
     */
    public controleAcces.autorisateur resolveAutorisateur();

    /**
     * Operation resolveAutorisateurTemporaire
     */
    public controleAcces.autorisateur resolveAutorisateurTemporaire();

    /**
     * Operation resolveTrousseau
     */
    public controleAcces.trousseau resolveTrousseau();

    /**
     * Operation isNotInsideZone
     */
    public boolean isNotInsideZone(String matriculeIdl);

    /**
     * Operation isNotInsideAllZone
     */
    public boolean isNotInsideAllZone(String matriculeIdl);

    /**
     * Operation entre
     */
    public void entre(String matriculeIdl);

    /**
     * Operation sort
     */
    public void sort(String matriculeIdl);

}
