/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.rh;

/**
 *
 * @author matt
 */
public class AddPersonnePanel extends javax.swing.JPanel {

  /**
   * Creates new form MdpPanel
   */
  public AddPersonnePanel() {
    initComponents();
    initState();
  }

  public void initState() {
    nomField.setText("");
    nomField.setFocusable(true);
    nomField.requestFocus();
    prenomField.setText("");
    photoField.setText("");
  }
  
  public String getNom(){
    return nomField.getText();
  }
  
  public String getPrenom(){
    return prenomField.getText();
  }
  public String getPhoto(){
    return photoField.getText();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomField = new javax.swing.JTextField();
        prenomField = new javax.swing.JTextField();
        NomEmpLabel = new javax.swing.JLabel();
        prenomEmpLabel = new javax.swing.JLabel();
        photoEmpLabel = new javax.swing.JLabel();
        photoField = new javax.swing.JTextField();

        nomField.setText("jTextField1");

        prenomField.setText("jTextField2");

        NomEmpLabel.setText("Nom de l'employé");

        prenomEmpLabel.setText("Prénom de l'employé :");

        photoEmpLabel.setText("Photo de l'employé : ");

        photoField.setText("jTextField3");
        photoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenomEmpLabel)
                            .addComponent(NomEmpLabel))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomField, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(prenomField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(photoEmpLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(photoField)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomEmpLabel)
                    .addComponent(nomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomEmpLabel)
                    .addComponent(prenomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(photoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(photoEmpLabel))
                .addGap(0, 25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void photoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_photoFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NomEmpLabel;
    private javax.swing.JTextField nomField;
    private javax.swing.JLabel photoEmpLabel;
    private javax.swing.JTextField photoField;
    private javax.swing.JLabel prenomEmpLabel;
    private javax.swing.JTextField prenomField;
    // End of variables declaration//GEN-END:variables
}
