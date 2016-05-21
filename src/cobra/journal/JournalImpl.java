package cobra.journal;


import cobra.CorbaEntite;
import cobra.DemandeAcces;
import cobra.Matricule;
import controleAcces.journalOperations;
import controleAcces.journalPackage.demandeIdl;
import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javafx.collections.ObservableList;
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
    
    private CorbaEntite serveur;
    
    public JournalImpl (CorbaEntite s) {
        super();
        serveur = s;
    }

    @Override
    public void loguer(demandeIdl demandeIdl) {
        DemandeAcces demAcc = new DemandeAcces(demandeIdl);
        journalLog.add(demAcc);
    }

    @Override
    public void loguerInconnu(demandeIdl demandeIdl) {
        DemandeAcces demAcc = new DemandeAcces(demandeIdl);
        journalLog.add(demAcc);
    }

    @Override
    public demandeIdl[] consulterByMatricule(String matriculeIdl) {
        demandeIdl[] versLeFutur = new demandeIdl[0];
        if (null != matriculeIdl){
            if (! matriculeIdl.equals("")){
                ArrayList<DemandeAcces> tmpDemandesARenvoyer = new ArrayList<DemandeAcces>();
                for (DemandeAcces demAcc : journalLog){
                    if (demAcc.getMatricule().equals(new Matricule(matriculeIdl)))
                        tmpDemandesARenvoyer.add(demAcc);
                }
                 versLeFutur = new demandeIdl[tmpDemandesARenvoyer.size()];
                
                for (int i =0;i<tmpDemandesARenvoyer.size()-1;i++){
                    versLeFutur[i] = (tmpDemandesARenvoyer.get(i)).toIdl();
                }
            }
        }
        return versLeFutur;
    }

    @Override
    public demandeIdl[] consulterByDate(long date) {
        ArrayList<DemandeAcces> tmpDemandesARenvoyer = new ArrayList<DemandeAcces>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        GregorianCalendar tmpDateHeureParam = new GregorianCalendar();
        tmpDateHeureParam.setTimeInMillis(date);
        String tmpDateParam = format.format(tmpDateHeureParam.getTime());
        for (DemandeAcces demAcc : journalLog){
            if (format.format((demAcc.getDateHeure().getTime())).equals(tmpDateParam))
                tmpDemandesARenvoyer.add(demAcc);
        }
        demandeIdl[] versLeFutur = new demandeIdl[tmpDemandesARenvoyer.size()];

        for (int i =0;i<tmpDemandesARenvoyer.size()-1;i++){
            versLeFutur[i] = (tmpDemandesARenvoyer.get(i)).toIdl();
        }        
        return versLeFutur;
    }
}
