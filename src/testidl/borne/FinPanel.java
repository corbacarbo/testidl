/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testidl.borne;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author matt
 */
public class FinPanel extends javax.swing.JPanel {
  
  private Borne borne;
  
  private Timer timer;

  /**
   * Creates new form FinPanel
   */
  public FinPanel() {
	initComponents();
	initState();
  }

  public void initState(){
	titreLabel.setText("EMPREINTE");
	messageLabel.setText("Empreinte changée.");
  }

  public void startTimer(){
	timer = new Timer(5000, new ActionListener() {

	  @Override
	  public void actionPerformed(ActionEvent ae) {
		borne.reinit();
	  }
	});
	
	timer.start();
  }

  
  public void setBorne(Borne borne) {
	this.borne = borne;
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    messageLabel = new javax.swing.JLabel();
    titreLabel = new javax.swing.JLabel();

    messageLabel.setText("Empreinte changée.");

    titreLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    titreLabel.setText("EMPREINTE");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(130, 130, 130)
            .addComponent(messageLabel))
          .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(titreLabel)))
        .addContainerGap(146, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addComponent(titreLabel)
        .addGap(37, 37, 37)
        .addComponent(messageLabel)
        .addContainerGap(83, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel messageLabel;
  private javax.swing.JLabel titreLabel;
  // End of variables declaration//GEN-END:variables
}
