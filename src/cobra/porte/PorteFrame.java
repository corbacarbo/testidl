/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.porte;

import cobra.DemandeAcces;
import cobra.Empreinte;
import cobra.Matricule;
import cobra.Personne;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.autorisateurPackage.autorisationRefuseeException;
import controleAcces.coffreFortPackage.empreinteInconnueException;
import controleAcces.journal;
import controleAcces.journalPackage.demandeIdl;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.awt.Color;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matt
 */
public class PorteFrame extends javax.swing.JFrame {

  private Porte porte;

  private demandeIdl lastDemande;

  /**
   * Gestion des messages informatifs et d'alertes pour les utilisateurs.
   */
  private enum ETATM {

	ERROR, INFOR
  };
  private ETATM etatMessage;

  private String message;

  private boolean aMessage;

  /**
   * Creates new form PorteFrame
   *
   * @param porte
   */
  public PorteFrame(Porte porte) {
	initComponents();
	this.porte = porte;
	init();
	this.setSize(300, 350);
	this.setTitle("Porte " + porte.getZone());
  }

  private void init() {
	titreLabel.setText("Porte " + porte.getZone());

	empreinteEntrerField.setText("");
	empreinteEntrerField.setSize(70, 78);
	empreinteEntrerField.setFocusable(true);
	empreinteEntrerField.requestFocus();

	photoEntrerField.setText("");
	photoEntrerField.setSize(70, 78);
	photoEntrerField.setFocusable(true);

	empreinteSortirField.setText("");
	empreinteSortirField.setSize(70, 78);
	empreinteSortirField.setFocusable(true);

	photoSortirField.setText("");
	photoSortirField.setSize(70, 78);
	photoSortirField.setFocusable(true);

	entrerButton.setText("Entrer");
	entrerButton.setEnabled(true);
	sortirButton.setText("Sortir");
	sortirButton.setEnabled(true);

	infoPane.setText("");
	updateMessage();
  }

  private void activateEchec() {
	titreLabel.setText("Porte " + porte.getZone());

	empreinteEntrerField.requestFocus();

	entrerButton.setText("Entrer");
	entrerButton.setEnabled(true);
	sortirButton.setText("Sortir");
	sortirButton.setEnabled(true);

	updateMessage();
  }

  private void activateReussi() {
	titreLabel.setText("Porte " + porte.getZone());

	empreinteEntrerField.setText("");
	empreinteEntrerField.requestFocus();
	photoEntrerField.setText("");
	empreinteSortirField.setText("");
	photoSortirField.setText("");

	entrerButton.setText("Entrer");
	entrerButton.setEnabled(true);
	sortirButton.setText("Sortir");
	sortirButton.setEnabled(true);

	updateMessage();
  }

  public PorteFrame() {
	initComponents();
  }

  private void setMessage(ETATM em, String m) {
	etatMessage = em;
	message = m;
	aMessage = true;
  }

  private void updateMessage() {
	if (aMessage) {
	  infoPane.setText(message);
	  if (etatMessage == ETATM.ERROR) {
		infoPane.setForeground(Color.red);
	  }
	  if (etatMessage == ETATM.INFOR) {
		infoPane.setForeground(Color.blue);
	  }
	} else {
	  infoPane.setText("");
	}
	aMessage = false;
  }

  private boolean checkParamEntrer() {
	return !(empreinteEntrerField.getText().isEmpty() || photoEntrerField.getText().isEmpty());
  }

  private boolean checkParamSortir() {
	return !(empreinteSortirField.getText().isEmpty() || photoSortirField.getText().isEmpty());
  }

  private boolean checkParam(String sens) {
	if (sens.equals("entrée")) {
	  return checkParamEntrer();
	} else {
	  return checkParamSortir();
	}
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    titreLabel = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    photoEntrerField = new javax.swing.JTextField();
    empreinteEntrerField = new javax.swing.JTextField();
    entrerButton = new javax.swing.JButton();
    sortirButton = new javax.swing.JButton();
    empreinteSortirField = new javax.swing.JTextField();
    photoSortirField = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    infoPane = new javax.swing.JTextPane();

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    titreLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    titreLabel.setText("jLabel1");

    jLabel1.setText("Empreinte");

    jLabel2.setText("Photo");

    photoEntrerField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    photoEntrerField.setText("jTextField1");

    empreinteEntrerField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    empreinteEntrerField.setText("jTextField1");

    entrerButton.setText("Entrer");
    entrerButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        entrerButtonActionPerformed(evt);
      }
    });

    sortirButton.setText("Sortir");
    sortirButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        sortirButtonActionPerformed(evt);
      }
    });

    empreinteSortirField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    empreinteSortirField.setText("jTextField1");

    photoSortirField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    photoSortirField.setText("jTextField1");

    jLabel3.setText("Empreinte");

    jLabel4.setText("Photo");

    jScrollPane2.setViewportView(infoPane);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addComponent(titreLabel)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane2))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(empreinteEntrerField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel1))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addGroup(layout.createSequentialGroup()
                .addComponent(photoEntrerField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(entrerButton))))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(empreinteSortirField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel3))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(photoSortirField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sortirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(titreLabel)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(empreinteEntrerField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(photoEntrerField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(entrerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jLabel4))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(empreinteSortirField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(photoSortirField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(sortirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void entrerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrerButtonActionPerformed
	passerPorte("entrée");
  }//GEN-LAST:event_entrerButtonActionPerformed

  private void sortirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortirButtonActionPerformed
	passerPorte("sortie");
  }//GEN-LAST:event_sortirButtonActionPerformed

  private void passerPorte(String sens) {
	if (checkParam(sens)) {
	  Empreinte empreinte;
	  String photo;

	  if (sens.equals("entrée")) {
		empreinte = new Empreinte(empreinteEntrerField.getText());
		photo = photoEntrerField.getText();
	  } else {
		empreinte = new Empreinte(empreinteSortirField.getText());
		photo = photoSortirField.getText();
	  }

	  Personne personne;
	  DemandeAcces demande = new DemandeAcces();

	  try {
		demande.setEmpreinteInconnu(empreinte);
		demande.setIdZone(porte.getZone());
		demande.setType(sens);
		demande.setIdPorte(porte.getId());
		demande.setDateHeure(new GregorianCalendar());
		demande.setImportant(false);

		if (sens.equals("entrée")) {
		  personne = porte.entrer(empreinte, photo);
		  setMessage(ETATM.INFOR, "Bienvenue " + personne.getPrenomNom() + ".");
		} else {
		  personne = porte.sortir(empreinte, photo);
		  setMessage(ETATM.INFOR, "Au revoir " + personne.getPrenomNom() + ".");
		}
		activateReussi();
		demande.setMatricule(personne.getMatricule());
		demande.setStatut(sens + " autorisée");
		demande.setImportant(false);

	  } catch (empreinteInconnueException ex) {
		setMessage(ETATM.ERROR, "Empreinte inconnue");
		demande.setStatut(ex.message);
		demande.setImportant(true);
		activateEchec();
	  } catch (sessionInvalidException ex) {
		setMessage(ETATM.ERROR, "Erreur interne (session invalide)");
		demande.setStatut(ex.message);
		demande.setImportant(false);
		activateEchec();
	  } catch (sessionExpireeException ex) {
		setMessage(ETATM.ERROR, "Erreur interne (session expirée)");
		demande.setStatut(ex.message);
		demande.setImportant(false);
		activateEchec();
	  } catch (personneInexistanteException ex) {
		setMessage(ETATM.ERROR, "Erreur interne (matricule ?)");
		demande.setStatut(ex.message);
		demande.setImportant(false);
		activateEchec();
	  } catch (autorisationRefuseeException ex) {
		if (sens.equals("entrée")) {
		  setMessage(ETATM.ERROR, "Autorisation refusée.");
		} else {
		  setMessage(ETATM.ERROR, "Autorisation refusée, appelez la sécurité.");
		}
		demande.setMatricule(new Matricule(ex.matricule));
		demande.setStatut(ex.message);
		demande.setImportant(true);
		activateReussi();
	  } catch (PhotoErroneeException ex) {
		setMessage(ETATM.ERROR, "Photo et empreinte ne correspondent pas.");
		demande.setStatut(ex.message);
		demande.setImportant(false);
		activateEchec();
	  } catch (DejaDansZoneException ex) {
		setMessage(ETATM.ERROR, "Entrée impossible.");
		demande.setMatricule(new Matricule(ex.matricule.toIdl()));
		demande.setStatut(ex.message);
		demande.setImportant(true);
		activateReussi();
	  } catch (DejaDansAutreZoneException ex) {
		setMessage(ETATM.ERROR, "Sortie impossible.");
		demande.setMatricule(new Matricule(ex.matricule.toIdl()));
		demande.setStatut(ex.message);
		demande.setImportant(true);
		activateReussi();
	  } catch (PasDansZoneException ex) {
		setMessage(ETATM.ERROR, "Vous n'êtes pas entré.");
		demande.setMatricule(new Matricule(ex.matricule.toIdl()));
		demande.setStatut(ex.message);
		demande.setImportant(true);
		activateReussi();
	  } finally {
		journal j = porte.getNs().resolveJournal();
		if (demande.getMatricule() == null) {
		  j.loguerInconnu(demande.toIdl());
		} else {
		  j.loguer(demande.toIdl());
		}
		System.out.println(demande);
	  }
	} else {
	  setMessage(ETATM.ERROR, "Posez votre doigt et ne bougez pas la tête.");
	  activateEchec();
	}

  }

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		  javax.swing.UIManager.setLookAndFeel(info.getClassName());
		  break;
		}
	  }
	} catch (ClassNotFoundException ex) {
	  java.util.logging.Logger.getLogger(PorteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	  java.util.logging.Logger.getLogger(PorteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	  java.util.logging.Logger.getLogger(PorteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	  java.util.logging.Logger.getLogger(PorteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	  @Override
	  public void run() {
		new PorteFrame(null).setVisible(true);
	  }
	});
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField empreinteEntrerField;
  private javax.swing.JTextField empreinteSortirField;
  private javax.swing.JButton entrerButton;
  private javax.swing.JTextPane infoPane;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JTextField photoEntrerField;
  private javax.swing.JTextField photoSortirField;
  private javax.swing.JButton sortirButton;
  private javax.swing.JLabel titreLabel;
  // End of variables declaration//GEN-END:variables
}
