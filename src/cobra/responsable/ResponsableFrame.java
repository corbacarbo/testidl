/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobra.responsable;

import cobra.Autorisation;
import cobra.AutorisationRestreinte;
import cobra.Personne;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.autorisateurPackage.conflitAutorisationException;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matt
 */
public class ResponsableFrame extends javax.swing.JFrame {

  private ArrayList<Personne> personnesTrouvees;
  private Personne personneAutorise;

  private Responsable responsable;

  private enum ETAT {

	NONCONNECTE, RECHERCHE, TROUVE, AUTORISE
  };
  private ETAT etat;

  private enum ETATM {

	ERROR, INFOR
  };
  private ETATM etatMessage;

  private String message;

  private boolean aMessage;

  /**
   * Creates new form ResponsableFrame
   *
   * @param responsable
   */
  public ResponsableFrame(Responsable responsable) {
	initComponents();
	this.responsable = responsable;
	setTitle("Responsable " + responsable.getZone());
	aMessage = false;

	setSize(300, 300);
	
	etat = ETAT.NONCONNECTE;
	activateNonConnecte();
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

  public void activateNonConnecte() {
	personnesTrouvees = null;
	personneAutorise = null;

	titreLabel.setText("LOGIN");
	okButton.setText("Login");
	cancelButton.setText("Quitter");

	loginPanel.setVisible(true);
	recherchePanel.setVisible(false);
	autorisationPanel.setVisible(false);

	loginPanel.initState();
  }

  public void activateRecherche() {
	personnesTrouvees = null;
	personneAutorise = null;

	titreLabel.setText("RECHERCHE");
	okButton.setText("Rechercher");
	cancelButton.setText("Annuler");

	loginPanel.setVisible(false);
	recherchePanel.setVisible(true);
	autorisationPanel.setVisible(false);

	recherchePanel.initState();
  }

  public void activateTrouve(ArrayList<Personne> personnes) {
	titreLabel.setText("RECHERCHE");
	okButton.setText("Autoriser");
	cancelButton.setText("Annuler");

	loginPanel.setVisible(false);
	recherchePanel.setVisible(true);
	autorisationPanel.setVisible(false);

	recherchePanel.initTrouve(personnes);
  }

  public void activateAutorise(Personne p) {
	titreLabel.setText("AUTORISATION");
	okButton.setText("Autoriser");
	cancelButton.setText("Annuler");

	loginPanel.setVisible(false);
	recherchePanel.setVisible(false);
	autorisationPanel.setVisible(true);

	autorisationPanel.initState(p);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    titreLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    infoPane = new javax.swing.JTextPane();
    okButton = new javax.swing.JButton();
    cancelButton = new javax.swing.JButton();
    loginPanel = new cobra.responsable.LoginPanel();
    recherchePanel = new cobra.responsable.RecherchePanel();
    autorisationPanel = new cobra.responsable.AutorisationPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    titreLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    titreLabel.setText("jLabel1");

    jScrollPane1.setViewportView(infoPane);

    okButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    okButton.setText("jButton1");
    okButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        okButtonActionPerformed(evt);
      }
    });

    cancelButton.setText("jButton2");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(cancelButton)
            .addGap(18, 18, 18)
            .addComponent(okButton))
          .addGroup(layout.createSequentialGroup()
            .addComponent(titreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(recherchePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(autorisationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(titreLabel)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(recherchePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(autorisationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(okButton)
          .addComponent(cancelButton))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
	switch (etat) {
	  case NONCONNECTE: {
		try {
		  responsable.authentifier(loginPanel.getMatricule(), loginPanel.getMdp());
		  etat = ETAT.RECHERCHE;
		  activateRecherche();
		} catch (loginIncorrectException ex) {
		  etat = ETAT.NONCONNECTE;
		  setMessage(ETATM.ERROR, "Login incorrect.");
		  activateNonConnecte();
		} catch (personneInexistanteException ex) {
		  etat = ETAT.NONCONNECTE;
		  setMessage(ETATM.ERROR, "Erreur, personne inexistante.");
		  activateNonConnecte();
		}
	  }
	  break;

	  case RECHERCHE:
		try {
		  personnesTrouvees = responsable.rechercher(recherchePanel.getMatricule(),
				  recherchePanel.getNom(), recherchePanel.getPrenom());
		  etat = ETAT.TROUVE;
		  activateTrouve(personnesTrouvees);
		} catch (personneInexistanteException ex) {
		  etat = ETAT.RECHERCHE;
		  setMessage(ETATM.ERROR, "Aucune personne trouvée.");
		  activateRecherche();
		} catch (sessionInvalidException ex) {
		  etat = ETAT.NONCONNECTE;
		  setMessage(ETATM.ERROR, "Session invalide.");
		  activateNonConnecte();
		} catch (sessionExpireeException ex) {
		  etat = ETAT.NONCONNECTE;
		  setMessage(ETATM.ERROR, "Session expirée.");
		  activateNonConnecte();
		}
		break;

	  case TROUVE:
		try {
		  personneAutorise = recherchePanel.getSelectedPersonne();
		  etat = ETAT.AUTORISE;
		  activateAutorise(personneAutorise);
		} catch (AucuneSelectionException ex) {
		  etat = ETAT.TROUVE;
		  setMessage(ETATM.ERROR, ex.message);
		  activateTrouve(personnesTrouvees);
		}
		break;

	  case AUTORISE:

		try {
		  if (personneAutorise.isPermanent()) {
			Autorisation auto;
			auto = new Autorisation(personneAutorise.getMatricule(),
					autorisationPanel.getHoraireD(),
					autorisationPanel.getHoraireF());
			responsable.ajouterAutorisation(auto);
		  } else if (personneAutorise.isTemporaire()) {
			AutorisationRestreinte auto;
			auto = new AutorisationRestreinte(autorisationPanel.getDateD(),
					autorisationPanel.getDateF(),
					responsable.getZone(),
					personneAutorise.getMatricule(),
					autorisationPanel.getHoraireD(),
					autorisationPanel.getHoraireF());
			responsable.ajouterAutorisationRestreinte(auto);
		  }
		} catch (ChampManquantException ex) {
		  etat = ETAT.AUTORISE;
		  setMessage(ETATM.ERROR, ex.message);
		  activateAutorise(personneAutorise);
		} catch (conflitAutorisationException ex) {
		  etat = ETAT.AUTORISE;
		  setMessage(ETATM.ERROR, "Conflit avec une autorisation existante.");
		  activateAutorise(personneAutorise);
		} catch (sessionInvalidException ex) {
		  etat = ETAT.NONCONNECTE;
		  setMessage(ETATM.ERROR, "Session invalide.");
		  activateNonConnecte();
		} catch (sessionExpireeException ex) {
		  etat = ETAT.NONCONNECTE;
		  setMessage(ETATM.ERROR, "Session expirée.");
		  activateNonConnecte();
		}
		break;

	  default:
		throw new RuntimeException();
	}
  }//GEN-LAST:event_okButtonActionPerformed

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
	switch (etat) {
	  case NONCONNECTE:
		this.dispose();
		break;
	  case RECHERCHE:
		etat = ETAT.NONCONNECTE;
		setMessage(ETATM.INFOR, "Opération annulée.");
		activateNonConnecte();
		break;
	  case TROUVE:
		etat = ETAT.RECHERCHE;
		activateRecherche();
		break;
	  case AUTORISE:
		etat = ETAT.RECHERCHE;
		setMessage(ETATM.INFOR, "Opération annulée.");
		activateRecherche();
		break;
	  default:
		throw new RuntimeException();
	}
  }//GEN-LAST:event_cancelButtonActionPerformed

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
	  java.util.logging.Logger.getLogger(ResponsableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	  java.util.logging.Logger.getLogger(ResponsableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	  java.util.logging.Logger.getLogger(ResponsableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	  java.util.logging.Logger.getLogger(ResponsableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	  public void run() {
		new ResponsableFrame(null).setVisible(true);
	  }
	});
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private cobra.responsable.AutorisationPanel autorisationPanel;
  private javax.swing.JButton cancelButton;
  private javax.swing.JTextPane infoPane;
  private javax.swing.JScrollPane jScrollPane1;
  private cobra.responsable.LoginPanel loginPanel;
  private javax.swing.JButton okButton;
  private cobra.responsable.RecherchePanel recherchePanel;
  private javax.swing.JLabel titreLabel;
  // End of variables declaration//GEN-END:variables
}
