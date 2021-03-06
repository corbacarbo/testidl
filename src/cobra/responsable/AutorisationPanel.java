/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.responsable;

import cobra.Date;
import cobra.Horaire;
import cobra.Personne;

/**
 *
 * @author matt
 */
public class AutorisationPanel extends javax.swing.JPanel {

  private Personne personne;

  /**
   * Creates new form AutorisationPanel
   */
  public AutorisationPanel() {
	initComponents();
  }

  public void initState(Personne personne) {
	if(personne.isPermanent()){
	  activatePermanent(personne);
	}
	else if(personne.isTemporaire()){
	  activateTemporaire(personne);
	}
  }

  public void activatePermanent(Personne p) {
	personne = p;
	personneLabel.setText(p.getPrenom() + " " + p.getNom() + " - " + p.getMatricule().toIdl());
	heureDField.setText("");
	heureDField.requestFocus();
	heureFField.setText("");
	minuteDField.setText("");
	minuteFField.setText("");
	dateDField.setVisible(false);
	dateDLabel.setVisible(false);
	dateFField.setVisible(false);
	dateFLabel.setVisible(false);
  }

  public void activateTemporaire(Personne p) {
	personne = p;
	personneLabel.setText(p.getPrenom() + " " + p.getNom() + " - " + p.getMatricule().toIdl());
	heureDField.setText("");
	heureDField.requestFocus();
	heureFField.setText("");
	minuteDField.setText("");
	minuteFField.setText("");
	dateDField.setVisible(true);
	dateDLabel.setVisible(true);
	dateFField.setVisible(true);
	dateFLabel.setVisible(true);
	dateDField.setText("");
	dateFField.setText("");
  }

  public Horaire getHoraireD() throws ChampManquantException{
	if(heureDField.getText().equals("") || minuteDField.getText().equals(""))
	  throw new ChampManquantException("Indiquez une heure de début.");
	Horaire h = new Horaire(heureDField.getText() + ":" + minuteDField.getText());
	return h;
  }
  
  public Horaire getHoraireF() throws ChampManquantException{
	if(heureFField.getText().equals("") || minuteFField.getText().equals(""))
	  throw new ChampManquantException("Indiquez une heure de fin.");
	Horaire h = new Horaire(heureFField.getText() + ":" + minuteFField.getText());
	return h;
  }
  
  public Date getDateD() throws ChampManquantException{
	if(dateDField.getText().equals(""))
	  throw new ChampManquantException("Indiquez une date de début.");
	return new Date(dateDField.getText());
  }
  
  public Date getDateF() throws ChampManquantException{
	if(dateFField.getText().equals(""))
	  throw new ChampManquantException("Indiquez une date de fin.");
	return new Date(dateFField.getText());
  }
  
  
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    personneLabel = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    heureFField = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    minuteFField = new javax.swing.JTextField();
    heureDField = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    minuteDField = new javax.swing.JTextField();
    dateDLabel = new javax.swing.JLabel();
    dateDField = new javax.swing.JTextField();
    dateFField = new javax.swing.JTextField();
    dateFLabel = new javax.swing.JLabel();

    personneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    personneLabel.setText("jLabel1");

    jLabel1.setText("Horaire d'entrée :");

    jLabel2.setText("Horaire de sortie :");

    heureFField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    heureFField.setText("jTextField1");

    jLabel3.setText(":");

    minuteFField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    minuteFField.setText("jTextField2");

    heureDField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    heureDField.setText("jTextField1");

    jLabel4.setText(":");

    minuteDField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    minuteDField.setText("jTextField2");

    dateDLabel.setText("Date d'entrée :");

    dateDField.setText("jTextField5");

    dateFField.setText("jTextField6");

    dateFLabel.setText("Date de sortie :");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(32, 32, 32)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel1)
          .addComponent(jLabel2)
          .addComponent(dateDLabel)
          .addComponent(dateFLabel))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addGroup(layout.createSequentialGroup()
                .addComponent(heureFField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
              .addGroup(layout.createSequentialGroup()
                .addComponent(heureDField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(minuteFField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(minuteDField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(dateDField)
          .addComponent(dateFField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(42, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(personneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(personneLabel)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(heureDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4)
          .addComponent(minuteDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(heureFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3)
          .addComponent(minuteFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(dateDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(dateDLabel))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(dateFField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(dateFLabel))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField dateDField;
  private javax.swing.JLabel dateDLabel;
  private javax.swing.JTextField dateFField;
  private javax.swing.JLabel dateFLabel;
  private javax.swing.JTextField heureDField;
  private javax.swing.JTextField heureFField;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JTextField minuteDField;
  private javax.swing.JTextField minuteFField;
  private javax.swing.JLabel personneLabel;
  // End of variables declaration//GEN-END:variables
}
