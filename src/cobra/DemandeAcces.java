/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra;

import controleAcces.journalPackage.demandeIdl;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Mélanie
 */
public class DemandeAcces implements Comparable{
    /**
     * Matricule de la personne qui tente de passer une porte
     */
    private Matricule matricule;
    /**
     * Date et Heure de la tentative
     */
    private GregorianCalendar dateHeure;
    /**
     * zone dans laquelle la tentative a lieu
     */
    private int idZone;
    /**
     * porte pour laquelle la tentative a lieu
     */
    private int idPorte;
    /**
     * statut final de la tentative : succès, echec...
     */
    private String statut;
    /**
     * type de tentative : Entrée ou Sortie
    */
    private String type;
    
    private Empreinte empreinteInconnu;
   
    public DemandeAcces(demandeIdl d, String emp){
        if (null==d.matricule){
            this.matricule = new Matricule("");
            this.empreinteInconnu = new Empreinte(emp);
        }
        else{
            this.matricule = new Matricule(d.matricule);
        }
        this.dateHeure.setTimeInMillis(d.dateHeure);
        this.idPorte=d.idPorte;
        this.idZone=d.idZone;
        this.statut=d.statut;
        if (d.type==0){
            this.type="Entree";
        }
        else {
            if (d.type==1){
                this.type="Sortie";
            }
        }        
    }
    public String afficher(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY - HH:mm:ss");
        String versLeFutur = format.format(this.dateHeure.getTime())+" - ";
        if (this.matricule.toString().equals("")){
            versLeFutur+="Inconnu - ";
        }
        else {
            versLeFutur+=this.matricule.toString()+" - ";
        }
        versLeFutur+="Zone "+this.idZone+" - Porte "+ this.idPorte+" - ";
        versLeFutur+="Statut "+this.statut+" - Type "+ this.type;
        return versLeFutur;
    }
    
    public demandeIdl toIdl(){
        int typeES=0;
        if (this.type.equals("Sortie")){
            typeES=1;
        }
        return new demandeIdl(this.matricule.toIdl(), this.dateHeure.getTimeInMillis(), this.idZone, this.idPorte, this.statut, typeES);
    };
    /**
     * @param o une demande d'acces
     * @return  la comparaison sur la date.
     */
    @Override
    public int compareTo(Object o) {
        DemandeAcces d = (DemandeAcces) o;
        int versLeFutur = 1;
        if (d.dateHeure.before(this.dateHeure)){
            versLeFutur = 0;
        }
        return versLeFutur;      
    }
}
