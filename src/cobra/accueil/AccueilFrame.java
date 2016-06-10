package cobra.accueil;


import cobra.Empreinte;
import cobra.Matricule;
import controleAcces.annuairePackage.loginIncorrectException;
import controleAcces.annuairePackage.personneInexistanteException;
import controleAcces.coffreFortPackage.matriculeErroneException;
import controleAcces.coffreFortPackage.matriculeInconnuException;
import controleAcces.sessionExpireeException;
import controleAcces.sessionInvalidException;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccueilFrame extends javax.swing.JFrame {
  
  private Accueil accueil;

  private enum ETAT {
	NONCONNECTE, AJOUTTEMPORAIRE, AJOUTEMPREINTE, RECAPAJOUT, MENU, SUPPREMPREINTE
  };
  private ETAT etat;

  private enum ETATM {

	ERROR, INFOR
  };
  private ETATM etatMessage;

  private String message;

  private boolean aMessage;

  public AccueilFrame(Accueil accueil) throws HeadlessException {
	this.accueil = accueil;
	initComponents();
	this.setSize(700, 400);
        this.setTitle("Accueil");
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
	loginPanelAccueil2.initState();
	loginPanelAccueil2.setVisible(true);
	addPersonneTPanel2.setVisible(false);
        recapPersonneTPanel1.setVisible(false);
        empreinteAccueilPanel1.setVisible(false);
        menuPanel.setVisible(false);
        supprEmpreinteAccueilPanel1.setVisible(false);
        
  }

   private void activateAjoutTemporaire() {
	titreLabel.setText("Ajout d'un employé temporaire");
	okButton.setText("Enregistrer");
	okButton.setEnabled(true);
	cancelButton.setText("Annuler");
	cancelButton.setEnabled(true);
	updateMessage();

	addPersonneTPanel2.initState();
        loginPanelAccueil2.setVisible(false);
	addPersonneTPanel2.setVisible(true);        
        recapPersonneTPanel1.setVisible(false);  
        empreinteAccueilPanel1.setVisible(false);        
        menuPanel.setVisible(false);
        supprEmpreinteAccueilPanel1.setVisible(false);
  }
    private void activateAjoutEmpreinte() {
        titreLabel.setText("Ajout de l'empreinte");
	okButton.setText("Ajouter l'empreinte");
	okButton.setEnabled(true);
	cancelButton.setText("Annuler");
	cancelButton.setEnabled(true);
	updateMessage();
        empreinteAccueilPanel1.initState();
        loginPanelAccueil2.setVisible(false);
	addPersonneTPanel2.setVisible(false);        
        recapPersonneTPanel1.setVisible(false);
        empreinteAccueilPanel1.setVisible(true);
        menuPanel.setVisible(false);
        supprEmpreinteAccueilPanel1.setVisible(false);
    }
   
   private void activateRecapAjout() {
        recapPersonneTPanel1.setRecap(accueil.getPersonneAjout());
        titreLabel.setText("Informations de l'employé ajouté");
	okButton.setText("Retour au menu");
	okButton.setEnabled(true);
	cancelButton.setText("Annuler");
	cancelButton.setEnabled(false);
	updateMessage();
        loginPanelAccueil2.setVisible(false);
	addPersonneTPanel2.setVisible(false);        
        recapPersonneTPanel1.setVisible(true);
        empreinteAccueilPanel1.setVisible(false);
        menuPanel.setVisible(false);
        supprEmpreinteAccueilPanel1.setVisible(false);
    }
      private void activateMenu() {
        titreLabel.setText("Menu");
        okButton.setText("Ok");
	okButton.setEnabled(false);
        cancelButton.setText("Quitter");
	cancelButton.setEnabled(true);
	updateMessage();
        loginPanelAccueil2.setVisible(false);
	addPersonneTPanel2.setVisible(false);        
        recapPersonneTPanel1.setVisible(false);
        empreinteAccueilPanel1.setVisible(false);
        menuPanel.setVisible(true);
        supprEmpreinteAccueilPanel1.setVisible(false);
    }
      private void activateSuppressionEmpreinte() {
        titreLabel.setText("Suppression d'une Empreinte");
	okButton.setText("Supprimer l'empreinte");
	okButton.setEnabled(true);
	cancelButton.setText("Annuler");
	cancelButton.setEnabled(true);
	updateMessage();
//        supprEmpreinteAccueilPanel1.initState();
        loginPanelAccueil2.setVisible(false);
	addPersonneTPanel2.setVisible(false);        
        recapPersonneTPanel1.setVisible(false);
        empreinteAccueilPanel1.setVisible(false);
        menuPanel.setVisible(false);
        supprEmpreinteAccueilPanel1.setVisible(true);
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
  public AccueilFrame() {
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
        addPersonneTPanel2 = new cobra.accueil.AddPersonneTPanel();
        loginPanelAccueil2 = new cobra.accueil.LoginPanelAccueil();
        empreinteAccueilPanel1 = new cobra.accueil.EmpreinteAccueilPanel();
        recapPersonneTPanel1 = new cobra.accueil.RecapPersonneTPanel();
        menuPanel = new javax.swing.JPanel();
        addPersTButton = new javax.swing.JButton();
        addEmprButton = new javax.swing.JButton();
        SupprEmprButton = new javax.swing.JButton();
        supprEmpreinteAccueilPanel1 = new cobra.accueil.SupprEmpreinteAccueilPanel();

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

        addPersTButton.setText("Ajouter un Employé Temporaire");
        addPersTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersTButtonActionPerformed(evt);
            }
        });

        addEmprButton.setText("Ajouter une empreinte");
        addEmprButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmprButtonActionPerformed(evt);
            }
        });

        SupprEmprButton.setText("Supprimer une Empreinte");
        SupprEmprButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprEmprButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(addPersTButton))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(addEmprButton))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(SupprEmprButton)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(addPersTButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addEmprButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SupprEmprButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addPersonneTPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cancelButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(okButton))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(loginPanelAccueil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(empreinteAccueilPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(recapPersonneTPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(supprEmpreinteAccueilPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(loginPanelAccueil2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPersonneTPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(empreinteAccueilPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recapPersonneTPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supprEmpreinteAccueilPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                accueil.authentifier(loginPanelAccueil2.getMatricule(), loginPanelAccueil2.getMdp());
                etat = ETAT.MENU;
                activateMenu();
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

	  case AJOUTTEMPORAIRE:
            String nom = addPersonneTPanel2.getNom();
            String prenom = addPersonneTPanel2.getPrenom();
            String photo = addPersonneTPanel2.getPhoto();
            if(null != nom && null != prenom && null != photo) {
		if (! nom.equals("") && ! prenom.equals("") && !photo.equals("")) {
                    try {
                        accueil.ajouterTemporaire(nom, prenom, photo);
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
		  etat = ETAT.AJOUTTEMPORAIRE;
                  activateAjoutTemporaire();                          
		}
            }
            else {
                setMessage(ETATM.ERROR, "Attention, tous les champs doivent être remplis");
		  etat = ETAT.AJOUTTEMPORAIRE;
                  activateAjoutTemporaire();
            }
            break;
            
            case RECAPAJOUT:
		etat = ETAT.MENU;
                activateMenu();
		break;
           
          case AJOUTEMPREINTE:
            String empr = empreinteAccueilPanel1.getEmpreinte();
            String matriculeA = empreinteAccueilPanel1.getMatricule();
            if(null != empr && null !=matriculeA) {
		if (! empr.equals("") && ! matriculeA.equals("")) {
                    try {
                        accueil.ajouterEmpreinte(new Empreinte(empr), new Matricule(matriculeA));
                        setMessage(ETATM.INFOR, "L'empreinte a été ajoutée.");
			etat = ETAT.MENU;
 			activateMenu();
                    } catch (sessionInvalidException ex) {
                        sessionInvalide();
                    } catch (sessionExpireeException ex) {
                        sessionExpiree();
                    } catch (personneInexistanteException ex) {
                        setMessage(ETATM.ERROR, "Attention, ce matricule n'existe pas.");
                        etat = ETAT.AJOUTEMPREINTE;
                        activateAjoutEmpreinte();
                    } catch (matriculeErroneException ex) {
                        setMessage(ETATM.ERROR, "Attention, ce matricule n'est pas celui d'un employé temporaire.");
                        etat = ETAT.AJOUTEMPREINTE;
                        activateAjoutEmpreinte();
                    }
                } else {
		  setMessage(ETATM.ERROR, "Attention, tous les champs doivent être remplis");
		  etat = ETAT.AJOUTEMPREINTE;
                  activateAjoutEmpreinte();
		}
            }
            else {
                setMessage(ETATM.ERROR, "Attention, tous les champs doivent être remplis");
		  etat = ETAT.AJOUTEMPREINTE;
                  activateAjoutEmpreinte();
            }
            break;
           
          case SUPPREMPREINTE:
            String matriculeS = supprEmpreinteAccueilPanel1.getMatricule();
            if( null !=matriculeS) {
		if ( ! matriculeS.equals("")) {
                    try {
                        accueil.supprimerEmpreinte(new Matricule(matriculeS));
                        setMessage(ETATM.INFOR, "L'empreinte a été supprimée.");
			etat = ETAT.MENU;
 			activateMenu();
                    } catch (sessionInvalidException ex) {
                        sessionInvalide();
                    } catch (sessionExpireeException ex) {
                        sessionExpiree();
                    } catch (matriculeInconnuException ex) {
                        setMessage(ETATM.ERROR, "Attention, aucune empreinte n'est répertoriée pour ce matricule.");
                        etat = ETAT.SUPPREMPREINTE;
                        activateSuppressionEmpreinte();
                    } catch (matriculeErroneException ex) {
                        setMessage(ETATM.ERROR, "Attention, ce matricule n'est pas celui d'un employé temporaire.");
                        etat = ETAT.SUPPREMPREINTE;
                        activateSuppressionEmpreinte();
                    }
                } else {
		  setMessage(ETATM.ERROR, "Attention, tous les champs doivent être remplis");
		  etat = ETAT.SUPPREMPREINTE;
		  activateSuppressionEmpreinte();
		}
            }
            else {
                setMessage(ETATM.ERROR, "Attention, tous les champs doivent être remplis");
		  etat = ETAT.SUPPREMPREINTE;
		  activateSuppressionEmpreinte();
            }
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
	  case AJOUTTEMPORAIRE:
		setMessage(ETATM.INFOR, "Opération annulée");
                etat = ETAT.MENU;
                activateMenu();
		break;
          case AJOUTEMPREINTE:
		etat = ETAT.MENU;
		activateMenu();
		break;
          case SUPPREMPREINTE:
		etat = ETAT.MENU;
		activateMenu();
		break;
          case MENU:
              etat=ETAT.NONCONNECTE;
              accueil.reinitPersonnes();
              activateNonConnecte();
              break;
	  default:
		throw new RuntimeException("Transition d'état impossible");
	}
  }//GEN-LAST:event_cancelButtonActionPerformed

    private void addPersTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersTButtonActionPerformed
        etat=ETAT.AJOUTTEMPORAIRE;                                            
        activateAjoutTemporaire();
    }//GEN-LAST:event_addPersTButtonActionPerformed

    private void addEmprButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmprButtonActionPerformed
        etat=ETAT.AJOUTEMPREINTE;
        activateAjoutEmpreinte();
    }//GEN-LAST:event_addEmprButtonActionPerformed

    private void SupprEmprButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprEmprButtonActionPerformed
        etat=ETAT.SUPPREMPREINTE;
        activateSuppressionEmpreinte();
    }//GEN-LAST:event_SupprEmprButtonActionPerformed

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
	  java.util.logging.Logger.getLogger(AccueilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	  java.util.logging.Logger.getLogger(AccueilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	  java.util.logging.Logger.getLogger(AccueilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	  java.util.logging.Logger.getLogger(AccueilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	  public void run() {
		new AccueilFrame().setVisible(true);
	  }
	});
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SupprEmprButton;
    private javax.swing.JButton addEmprButton;
    private javax.swing.JButton addPersTButton;
    private cobra.accueil.AddPersonneTPanel addPersonneTPanel2;
    private javax.swing.JButton cancelButton;
    private cobra.accueil.EmpreinteAccueilPanel empreinteAccueilPanel1;
    private javax.swing.JLabel infoLabel;
    private cobra.accueil.LoginPanelAccueil loginPanelAccueil2;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton okButton;
    private cobra.accueil.RecapPersonneTPanel recapPersonneTPanel1;
    private cobra.accueil.SupprEmpreinteAccueilPanel supprEmpreinteAccueilPanel1;
    private javax.swing.JLabel titreLabel;
    // End of variables declaration//GEN-END:variables
}
