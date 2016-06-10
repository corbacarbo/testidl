package cobra.rh;


import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RHFrame extends javax.swing.JFrame {
  
  private RH rh;

  private enum ETAT {
	NONCONNECTE, AJOUTPERMANENT, RECAPAJOUT
  };
  private ETAT etat;

  private enum ETATM {

	ERROR, INFOR
  };
  private ETATM etatMessage;

  private String message;

  private boolean aMessage;

  public RHFrame(RH rh) throws HeadlessException {
	this.rh = rh;
	initComponents();
	this.setSize(700, 400);
        this.setTitle("RH");
	etat = ETAT.NONCONNECTE;
	activateNonConnecte();
	aMessage = false;
  }

  private void setMessage(ETATM em, String m) {
	etatMessage = em;
	message = m;
	aMessage = true;
  }

  private void updateMessage() {
	if (aMessage) {
	  infoLabel.setText(message);
	  if (etatMessage == ETATM.ERROR) {
		infoLabel.setForeground(Color.red);
	  }
	  if (etatMessage == ETATM.INFOR) {
		infoLabel.setForeground(Color.blue);
	  }
	} else {
	  infoLabel.setText("");
	}
	aMessage = false;
  }

  private void activateNonConnecte() {
	titreLabel.setText("LOGIN");
	okButton.setText("Connexion");
	okButton.setEnabled(true);
	cancelButton.setText("Fermer");
	cancelButton.setEnabled(true);
	updateMessage();

	loginPanelRH1.initState();
	loginPanelRH1.setVisible(true);
	addPersonnePanel1.setVisible(false);
        recapPersonnePanel1.setVisible(false);
  }

   private void activateAjoutPermanent() {
	titreLabel.setText("Ajout d'un employé permanent");
	okButton.setText("Enregistrer");
	okButton.setEnabled(true);
	cancelButton.setText("Annuler");
	cancelButton.setEnabled(true);
	updateMessage();

	addPersonnePanel1.initState();
        loginPanelRH1.setVisible(false);
	addPersonnePanel1.setVisible(true);        
        recapPersonnePanel1.setVisible(false);
  }
   
   private void activateRecapAjout() {
        recapPersonnePanel1.setRecap(rh.getPersonneAjout());
        titreLabel.setText("Informations de l'employé ajouté");
	okButton.setText("Ajouter un autre employé");
	okButton.setEnabled(true);
	cancelButton.setText("Terminer");
	cancelButton.setEnabled(true);
	updateMessage();
        loginPanelRH1.setVisible(false);
	addPersonnePanel1.setVisible(false);        
        recapPersonnePanel1.setVisible(true);
    }

  private void sessionExpiree() {
	setMessage(ETATM.ERROR, "Session expirée");
	etat = ETAT.NONCONNECTE;
	activateNonConnecte();
  }

  private void sessionInvalide() {
	setMessage(ETATM.ERROR, "Session invalide");
	etat = ETAT.NONCONNECTE;
	activateNonConnecte();
  }

  /**
   * Creates new form BorneFrame
   */
  public RHFrame() {
	initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        titreLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        loginPanelRH1 = new cobra.rh.LoginPanelRH();
        addPersonnePanel1 = new cobra.rh.AddPersonnePanel();
        recapPersonnePanel1 = new cobra.rh.RecapPersonnePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        okButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        titreLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titreLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titreLabel.setText("jLabel1");
        titreLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        infoLabel.setText("jLabel1");
        infoLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(okButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addPersonnePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginPanelRH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(recapPersonnePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 204, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(loginPanelRH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPersonnePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recapPersonnePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
	switch (etat) {

            case NONCONNECTE:
            try {
                rh.authentifier(loginPanelRH1.getMatricule(), loginPanelRH1.getMdp());
                etat = ETAT.AJOUTPERMANENT;
                activateAjoutPermanent();
            } catch (loginIncorrectException ex) {
                setMessage(ETATM.ERROR, ex.message);
                etat = ETAT.NONCONNECTE;
                activateNonConnecte();
            } catch (personneInexistanteException ex) {
                setMessage(ETATM.ERROR, ex.message);
                etat = ETAT.NONCONNECTE;
                activateNonConnecte();
            }
            break;

	  case AJOUTPERMANENT:
            String nom = addPersonnePanel1.getNom();
            String prenom = addPersonnePanel1.getPrenom();
            String photo = addPersonnePanel1.getPhoto();
            if(null != nom && null != prenom && null != photo) {
		if (! nom.equals("") && ! prenom.equals("") && !photo.equals("")) {
                    try {
                        rh.ajouterPermanent(nom, prenom, photo);
                        setMessage(ETATM.INFOR, nom+" "+prenom+ " a été ajouté à l'annuaire.");
			etat = ETAT.RECAPAJOUT;
 			activateRecapAjout();
                    } catch (sessionInvalidException ex) {
                        sessionInvalide();
                    } catch (sessionExpireeException ex) {
                        sessionExpiree();
                    }
                } else {
		  setMessage(ETATM.ERROR, "Attention, tous les champs doivent être remplis");
		  etat = ETAT.AJOUTPERMANENT;
		  activateAjoutPermanent();
		}
            }
            else {
                setMessage(ETATM.ERROR, "Attention, tous les champs doivent être remplis");
		  etat = ETAT.AJOUTPERMANENT;
		  activateAjoutPermanent();
            }
            break;

	  case RECAPAJOUT:
		etat = ETAT.AJOUTPERMANENT;
                activateAjoutPermanent();
		break;
	  default:
		throw new RuntimeException("Transition d'état impossible");
	}
  }//GEN-LAST:event_okButtonActionPerformed

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
	switch (etat) {
	  case NONCONNECTE:
		this.dispose();
		break;
	  case AJOUTPERMANENT:
		setMessage(ETATM.INFOR, "Opération annulée");
                etat = ETAT.NONCONNECTE;
                rh.reinitPersonnes();
		activateNonConnecte();
		break;
          case RECAPAJOUT:
		etat = ETAT.NONCONNECTE;
                rh.reinitPersonnes();
		activateNonConnecte();
		break;
	  default:
		throw new RuntimeException("Transition d'état impossible");
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
	  java.util.logging.Logger.getLogger(RHFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	  java.util.logging.Logger.getLogger(RHFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	  java.util.logging.Logger.getLogger(RHFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	  java.util.logging.Logger.getLogger(RHFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	  public void run() {
		new RHFrame().setVisible(true);
	  }
	});
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cobra.rh.AddPersonnePanel addPersonnePanel1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel infoLabel;
    private cobra.rh.LoginPanelRH loginPanelRH1;
    private javax.swing.JButton okButton;
    private cobra.rh.RecapPersonnePanel recapPersonnePanel1;
    private javax.swing.JLabel titreLabel;
    // End of variables declaration//GEN-END:variables
}
