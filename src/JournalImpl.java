
import cobra.DemandeAcces;
import controleAcces.journalOperations;
import controleAcces.journalPackage.demandeIdl;
import javafx.collections.transformation.SortedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mélanie
 */
public class JournalImpl implements journalOperations {
    /**
     * Liste des logs de connexions et tentatives de connexions
     */
    private SortedList<DemandeAcces> journalLog;

    @Override
    public void loguer(String matriculeIdl, long dateHeure, int idZone, int idPorte, String statut, int type) {
        
    }

    @Override
    public void loguerInconnu(long empreinteIdl, long dateHeure, int idZone, int idPorte, String statut, int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public demandeIdl[] consulter(String matriculeIdl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     

   
}
