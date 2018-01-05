/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Connection.Tools;
import java.awt.Cursor;

/**
 *
 * @author mnaze
 */
public class FrmCustomer_Menu extends javax.swing.JFrame {

    /**
     * Creates new form FrmCustomer_Menu
     */
    static int Card;
    static String Name;
    static String Email;
    public FrmCustomer_Menu() {
        initComponents();
    }
     public FrmCustomer_Menu(String Email) {
        initComponents();
         Card = Connection.Connections.GetCustomerCardNumber(Email);
         Name = Connection.Connections.GetCustomerName(Email);
         lblTitleName.setText("Welcome "+ Name +" :) ");
         lblTitleCard.setText("Your Library Card Number is: {"+ Card +"}");
         this.Email = Email;
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
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        lblTitleName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        historybtn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        historybtn1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        historybtn2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        lblTitleCard = new javax.swing.JLabel();
        historybtn3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        exitbtn4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(901, 448));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(901, 448));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/menu.png"))); // NOI18N

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));

        lblTitleName.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        lblTitleName.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleName.setText("Customer Menu (Name)");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/testb.png"))); // NOI18N
        jLabel2.setToolTipText("Borrow a book");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setAutoscrolls(true);

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("HISTORY");

        historybtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/histor.png"))); // NOI18N
        historybtn.setToolTipText("Your history");
        historybtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historybtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historybtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historybtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historybtnMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Borrow");

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator6.setAutoscrolls(true);

        historybtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/refresh-lock (1).png"))); // NOI18N
        historybtn1.setToolTipText("Change your password");
        historybtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historybtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historybtn1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historybtn1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historybtn1MouseEntered(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Return");

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setAutoscrolls(true);

        historybtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/library.png"))); // NOI18N
        historybtn2.setToolTipText("Return a book");
        historybtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historybtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historybtn2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historybtn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historybtn2MouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Change Password");

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator8.setAutoscrolls(true);

        lblTitleCard.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        lblTitleCard.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleCard.setText("Customer Menu (CardNumber)");

        historybtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/user (2).png"))); // NOI18N
        historybtn3.setToolTipText("Change your password");
        historybtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historybtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historybtn3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historybtn3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historybtn3MouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Edit your profile");

        jSeparator13.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator13.setAutoscrolls(true);

        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));

        exitbtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/logout.png"))); // NOI18N
        exitbtn4.setToolTipText("Log out");
        exitbtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitbtn4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitbtn4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitbtn4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(exitbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(historybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(historybtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(141, 141, 141)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(93, 93, 93)
                                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(historybtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(historybtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitleCard, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                            .addComponent(lblTitleName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblTitleName, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lblTitleCard, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(historybtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(historybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(historybtn1)
                            .addComponent(historybtn3))
                        .addGap(1, 1, 1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(exitbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 900, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void historybtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtnMouseClicked

        this.dispose();
        Tools.OpenForm(new FrmCustomer_History(Card,Name,Email));
    }//GEN-LAST:event_historybtnMouseClicked

    private void historybtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtnMouseEntered
      
    }//GEN-LAST:event_historybtnMouseEntered

    private void historybtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtnMouseExited
        
    }//GEN-LAST:event_historybtnMouseExited

    private void historybtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtn1MouseClicked
       this.dispose();
       Tools.OpenForm(new FrmCustomer_ChangePass(Email));
    }//GEN-LAST:event_historybtn1MouseClicked

    private void historybtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_historybtn1MouseEntered

    private void historybtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtn1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_historybtn1MouseExited

    private void historybtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtn2MouseClicked
        this.dispose();
        Tools.OpenForm(new FrmBooks_Return(String.valueOf(Card), Name, Email, 1));
    }//GEN-LAST:event_historybtn2MouseClicked

    private void historybtn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtn2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_historybtn2MouseEntered

    private void historybtn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtn2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_historybtn2MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
        Tools.OpenForm(new FrmBooks_Borrow(Card,Name,Email, 1));
    }//GEN-LAST:event_jLabel2MouseClicked

    private void historybtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtn3MouseClicked
        this.dispose();
        Tools.OpenForm(new FrmCustomer_Change_InFo(Email, Card));
    }//GEN-LAST:event_historybtn3MouseClicked

    private void historybtn3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtn3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_historybtn3MouseExited

    private void historybtn3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historybtn3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_historybtn3MouseEntered

    private void exitbtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbtn4MouseClicked
        boolean check = Tools.YesNoChooserBox("Do you want to quit?", "Exit!");
        if(check){
        this.dispose();
        Tools.OpenForm(new FrmCustomer_Login());
        }
        
    }//GEN-LAST:event_exitbtn4MouseClicked

    private void exitbtn4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbtn4MouseExited
        
    }//GEN-LAST:event_exitbtn4MouseExited

    private void exitbtn4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbtn4MouseEntered
        
    }//GEN-LAST:event_exitbtn4MouseEntered

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
            java.util.logging.Logger.getLogger(FrmCustomer_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCustomer_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCustomer_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCustomer_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCustomer_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitbtn;
    private javax.swing.JLabel exitbtn1;
    private javax.swing.JLabel exitbtn2;
    private javax.swing.JLabel exitbtn3;
    private javax.swing.JLabel exitbtn4;
    private javax.swing.JLabel historybtn;
    private javax.swing.JLabel historybtn1;
    private javax.swing.JLabel historybtn2;
    private javax.swing.JLabel historybtn3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblTitleCard;
    private javax.swing.JLabel lblTitleName;
    // End of variables declaration//GEN-END:variables
}
