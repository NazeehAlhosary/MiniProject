/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Connection.Connections;
import Connection.Tools;

/**
 *
 * @author mohammadzreik
 */
public class FrmCustomer_ChangePass extends javax.swing.JFrame {

    static String email;

    /**
     * Creates new form FrmCustomer_ChangePass
     */
    public FrmCustomer_ChangePass() {
        initComponents();
    }

    public FrmCustomer_ChangePass(String Email) {
        initComponents();
        this.email = Email;
    }

    public void UpdatePass() {
        String hash = Tools.hashPassword(txtpass.getText());
  
        String update = "Update customerlogin set PassWord='" + hash + "' where " 
                + "Email= '"+ email + "' ;";
        boolean updateQ = Connections.RunNonQuery(update);
        if (updateQ) {
            Tools.MsgBoxInfo(" Password Has Been Successfully Reseted ", " Password Reseted ");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnback = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtrepass = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnres = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(551, 356));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(551, 356));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Big Caslon", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reset  Your  Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 30, 360, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/password.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 10, 90, 90);

        jLabel3.setFont(new java.awt.Font("Big Caslon", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("New Password :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 150, 140, 20);

        txtpass.setBackground(new java.awt.Color(102, 0, 102));
        txtpass.setForeground(new java.awt.Color(255, 255, 255));
        txtpass.setText("jPasswordField1");
        txtpass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpassMouseClicked(evt);
            }
        });
        getContentPane().add(txtpass);
        txtpass.setBounds(180, 150, 250, 27);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/locked.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(440, 230, 40, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/locked.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(440, 130, 40, 70);

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/back32.png"))); // NOI18N
        btnback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackMouseClicked(evt);
            }
        });
        getContentPane().add(btnback);
        btnback.setBounds(10, 310, 40, 40);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(180, 180, 250, 20);

        txtrepass.setBackground(new java.awt.Color(102, 0, 102));
        txtrepass.setForeground(new java.awt.Color(255, 255, 255));
        txtrepass.setText("jPasswordField1");
        txtrepass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtrepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtrepassMouseClicked(evt);
            }
        });
        getContentPane().add(txtrepass);
        txtrepass.setBounds(180, 240, 250, 27);

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(180, 270, 250, 20);

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));

        jLabel4.setFont(new java.awt.Font("Big Caslon", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Re-Password :");

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setToolTipText("");

        btnres.setFont(new java.awt.Font("Big Caslon", 3, 18)); // NOI18N
        btnres.setForeground(new java.awt.Color(255, 255, 255));
        btnres.setText(" Reset");
        btnres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(btnres, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(356, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 550, 360);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked

        this.dispose();
        Tools.OpenForm(new FrmCustomer_Menu());
    }//GEN-LAST:event_btnbackMouseClicked

    private void btnresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresMouseClicked
        if (txtpass.getText().equals(txtrepass.getText())) {
            UpdatePass();
            this.dispose();
            Tools.OpenForm(new FrmCustomer_Menu());
        } else {
            Tools.MsgBoxInfo("Please Enter The Same Password ! ", " Reset Password ");
            txtpass.setText("");
            txtrepass.setText("");
        }

    }//GEN-LAST:event_btnresMouseClicked

    private void txtpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpassMouseClicked
       txtpass.setText("");
    }//GEN-LAST:event_txtpassMouseClicked

    private void txtrepassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtrepassMouseClicked
        txtrepass.setText("");
    }//GEN-LAST:event_txtrepassMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCustomer_ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCustomer_ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCustomer_ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCustomer_ChangePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCustomer_ChangePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnback;
    private javax.swing.JLabel btnres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtrepass;
    // End of variables declaration//GEN-END:variables
}