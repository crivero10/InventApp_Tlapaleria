package InventApp.ViewControllers;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jerry
 */
public class LoginFormViewController extends javax.swing.JFrame {

    /**
     * Creates new form Login_Form
     */
    public LoginFormViewController() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        // UNDERLINE the form title
        Font font = jLabel_Form_Title.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel_Form_Title.setFont(font.deriveFont(attributes));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Form_Title = new javax.swing.JLabel();
        jTextField_Username = new javax.swing.JTextField();
        jPasswordField_UserPass = new javax.swing.JPasswordField();
        jButton_LOGIN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(108, 122, 137));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");

        jLabel_Form_Title.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel_Form_Title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Form_Title.setText("Acceso a usuarios");
        jLabel_Form_Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextField_Username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Username.setText("admin");

        jPasswordField_UserPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPasswordField_UserPass.setText("adminpass");

        jButton_LOGIN.setBackground(new java.awt.Color(249, 105, 14));
        jButton_LOGIN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        jButton_LOGIN.setText("Login");
        jButton_LOGIN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton_LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LOGINActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_Form_Title)
                    .addComponent(jButton_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPasswordField_UserPass, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Form_Title)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField_UserPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButton_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // button login form
    private void jButton_LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LOGINActionPerformed
        
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = InventApp.DB_INFO.getConnection().prepareStatement("SELECT `username`, `password` , `fullname`, `user_type` FROM `users` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, jTextField_Username.getText());
            ps.setString(2, String.valueOf(jPasswordField_UserPass.getPassword()));
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                Date fechaActual = new Date();
                InventApp.Cajero cajeroEnSesion = new InventApp.Cajero(rs.getString("username"), rs.getString("fullname"));
                InventApp.Sesion nuevaSesion = new InventApp.Sesion(fechaActual, null, 0.0, cajeroEnSesion);
                InventApp.Configuracion.config.setSesionActual(nuevaSesion);
                System.out.println(InventApp.Configuracion.config.getSesionActual().getCashInSession());
                HomeFormViewController homeForm = new HomeFormViewController();
                homeForm.pack();
                homeForm.setExtendedState(homeForm.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                Dimension r = homeForm.getBounds().getSize();
                
                homeForm.setVisible(true);
                
                homeForm.setLocationRelativeTo(null);
                homeForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                this.dispose();

            }else{
                JOptionPane.showMessageDialog(null, "invalid username or password","Login Error",2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginFormViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_jButton_LOGINActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFormViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFormViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFormViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFormViewController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFormViewController().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_LOGIN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Form_Title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField_UserPass;
    private javax.swing.JTextField jTextField_Username;
    // End of variables declaration//GEN-END:variables
}