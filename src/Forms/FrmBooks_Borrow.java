/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Classes.Books;
import Classes.History;
import Connection.Connections;
import Connection.TableNewColors;
import Connection.Tools;
import javax.swing.JTable;

/**
 *
 * @author mohammadzreik
 */
public class FrmBooks_Borrow extends javax.swing.JFrame {

    /**
     * Creates new form FrmBorrow
     */
    public FrmBooks_Borrow() {
        initComponents();
        Borrowtable.setDefaultRenderer(Object.class, new TableNewColors());

    }

    public FrmBooks_Borrow(String CardNumber, String username) {
        initComponents();
        txtCard.setText(CardNumber);
        txtUser.setText(username);
        Borrowtable.setDefaultRenderer(Object.class, new TableNewColors());

    }

    Books book = new Books();
    History history = new History();

    private void SelectInfo() {
        int Row = Borrowtable.getSelectedRow();
        try {
            txtISBN.setText(Borrowtable.getValueAt(Row, 0).toString());
            txtTitle.setText(Borrowtable.getValueAt(Row, 1).toString());
        } catch (Exception ex) {
            Tools.MsgBox(ex.getMessage());
        }
    }

    public void GetTableInfo(String TableNameInDB, JTable table) {
        Connections.FillTable(TableNameInDB, table);
    }

    private boolean EmptyText() {
        if (txtISBN.getText().equals("") || txtTitle.getText().equals("") || txtCard.getText().equals("")
                || txtUser.getText().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Group = new javax.swing.ButtonGroup();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCard = new Controls.JTextBox();
        txtISBN = new Controls.JTextBox();
        txtTitle = new Controls.JTextBox();
        txtUser = new Controls.JTextBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Borrowtable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new Controls.JTextBox();
        searchbtn = new javax.swing.JLabel();
        RadTitle = new javax.swing.JRadioButton();
        RadNumberOfBorrowing = new javax.swing.JRadioButton();
        RadAuthor = new javax.swing.JRadioButton();
        RadISBN = new javax.swing.JRadioButton();
        RadShelf = new javax.swing.JRadioButton();
        RadPublisher = new javax.swing.JRadioButton();
        RadGenre = new javax.swing.JRadioButton();
        RadStatus = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        borrowbtn = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(886, 570));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(886, 559));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel11.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ISBN");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 140, 40, 20);

        jLabel12.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Title");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 210, 40, 20);

        jLabel17.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Username");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(10, 350, 70, 20);

        jLabel19.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Card Number");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 280, 110, 20);

        txtCard.setEditable(false);
        getContentPane().add(txtCard);
        txtCard.setBounds(10, 310, 160, 24);

        txtISBN.setEditable(false);
        getContentPane().add(txtISBN);
        txtISBN.setBounds(10, 170, 160, 24);

        txtTitle.setEditable(false);
        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });
        getContentPane().add(txtTitle);
        txtTitle.setBounds(10, 240, 160, 24);

        txtUser.setEditable(false);
        getContentPane().add(txtUser);
        txtUser.setBounds(10, 380, 160, 24);

        Borrowtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Title", "Author", "Publisher", "Shelf", "Genre", "Status", "N. Borrowing"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Borrowtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BorrowtableMouseClicked(evt);
            }
        });
        Borrowtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BorrowtableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BorrowtableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Borrowtable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 150, 690, 406);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/testb.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 0, 90, 100);

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Library Books");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 0, 270, 70);
        getContentPane().add(txtSearch);
        txtSearch.setBounds(210, 110, 600, 24);

        searchbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/searchbtn.png"))); // NOI18N
        searchbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbtnMouseClicked(evt);
            }
        });
        getContentPane().add(searchbtn);
        searchbtn.setBounds(820, 100, 40, 40);

        RadTitle.setBackground(new java.awt.Color(102, 0, 102));
        RadTitle.setForeground(new java.awt.Color(255, 255, 255));
        RadTitle.setText("Title");
        RadTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(RadTitle);
        RadTitle.setBounds(280, 70, 70, 30);

        RadNumberOfBorrowing.setBackground(new java.awt.Color(102, 0, 102));
        RadNumberOfBorrowing.setForeground(new java.awt.Color(255, 255, 255));
        RadNumberOfBorrowing.setText("N.Borrowing");
        RadNumberOfBorrowing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(RadNumberOfBorrowing);
        RadNumberOfBorrowing.setBounds(770, 70, 110, 30);

        RadAuthor.setBackground(new java.awt.Color(102, 0, 102));
        RadAuthor.setForeground(new java.awt.Color(255, 255, 255));
        RadAuthor.setText("Author");
        RadAuthor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(RadAuthor);
        RadAuthor.setBounds(350, 70, 70, 30);

        RadISBN.setBackground(new java.awt.Color(102, 0, 102));
        RadISBN.setForeground(new java.awt.Color(255, 255, 255));
        RadISBN.setText("ISBN");
        RadISBN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(RadISBN);
        RadISBN.setBounds(210, 70, 70, 30);

        RadShelf.setBackground(new java.awt.Color(102, 0, 102));
        RadShelf.setForeground(new java.awt.Color(255, 255, 255));
        RadShelf.setText("Shelf");
        RadShelf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(RadShelf);
        RadShelf.setBounds(540, 70, 70, 30);

        RadPublisher.setBackground(new java.awt.Color(102, 0, 102));
        RadPublisher.setForeground(new java.awt.Color(255, 255, 255));
        RadPublisher.setText("Publisher");
        RadPublisher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(RadPublisher);
        RadPublisher.setBounds(440, 70, 90, 30);

        RadGenre.setBackground(new java.awt.Color(102, 0, 102));
        RadGenre.setForeground(new java.awt.Color(255, 255, 255));
        RadGenre.setText("Genre");
        RadGenre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(RadGenre);
        RadGenre.setBounds(610, 70, 70, 30);

        RadStatus.setBackground(new java.awt.Color(102, 0, 102));
        RadStatus.setForeground(new java.awt.Color(255, 255, 255));
        RadStatus.setText("Status");
        RadStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(RadStatus);
        RadStatus.setBounds(690, 70, 60, 30);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        borrowbtn.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        borrowbtn.setForeground(new java.awt.Color(255, 255, 255));
        borrowbtn.setText("  Borrow");
        borrowbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrowbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowbtnMouseClicked(evt);
            }
        });
        jPanel1.add(borrowbtn);
        borrowbtn.setBounds(0, 0, 120, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 450, 120, 40);

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setAutoscrolls(true);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(10, 340, 160, 10);

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setAutoscrolls(true);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(30, 100, 110, 10);

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator6.setAutoscrolls(true);
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(10, 270, 160, 10);

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setAutoscrolls(true);
        getContentPane().add(jSeparator7);
        jSeparator7.setBounds(10, 410, 160, 10);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/back32.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 520, 40, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/exit.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 520, 32, 40);

        jPanel4.setBackground(new java.awt.Color(102, 0, 102));
        getContentPane().add(jPanel4);
        jPanel4.setBounds(180, 0, 710, 570);

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator8.setAutoscrolls(true);
        getContentPane().add(jSeparator8);
        jSeparator8.setBounds(10, 200, 160, 10);

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator9.setAutoscrolls(true);
        getContentPane().add(jSeparator9);
        jSeparator9.setBounds(10, 90, 160, 10);

        jPanel3.setBackground(new java.awt.Color(64, 1, 64));
        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 180, 570);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String statement = "SELECT * FROM `books` WHERE `Status` = 'Available' ";
        book.GetSomeRows(statement, Borrowtable);

        Group.add(RadISBN);
        Group.add(RadTitle);
        Group.add(RadAuthor);
        Group.add(RadPublisher);
        Group.add(RadShelf);
        Group.add(RadGenre);
        Group.add(RadStatus);
        Group.add(RadNumberOfBorrowing);
    }//GEN-LAST:event_formWindowOpened

    private void BorrowtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BorrowtableMouseClicked
        SelectInfo();
    }//GEN-LAST:event_BorrowtableMouseClicked

    private void BorrowtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BorrowtableKeyReleased
        SelectInfo();
    }//GEN-LAST:event_BorrowtableKeyReleased

    private void searchbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbtnMouseClicked
        String statementStatus = "SELECT * FROM `books` WHERE `Status` = 'Available' ";
        String Statement = "Select * from Books where ";
        String Statement2 = " like '%" + txtSearch.getText() + "%' ";
        if (RadISBN.isSelected()) {
            Statement += " ISBN " + Statement2;
        } else if (RadTitle.isSelected()) {
            Statement += " Title " + Statement2;
        } else if (RadShelf.isSelected()) {
            Statement += " Shelf " + Statement2;
        } else if (RadGenre.isSelected()) {
            Statement += " Genre " + Statement2;
        } else if (RadPublisher.isSelected()) {
            Statement += " Publisher " + Statement2;
        } else if (RadAuthor.isSelected()) {
            Statement += " Author " + Statement2;
        } else if (RadStatus.isSelected()) {
            Statement += " Status " + Statement2;
        } else {
            Statement += " NumberOfBorrowing " + Statement2;
        }

        book.GetSomeRows(Statement, Borrowtable);
        int Row = Borrowtable.getRowCount();
        if (Row == 0) {
            Tools.MsgBoxErrorX("No result!", "Searsh not found");
            txtSearch.setText("");
            book.GetSomeRows(statementStatus, Borrowtable);
            txtSearch.requestFocus();
        }
    }//GEN-LAST:event_searchbtnMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
        Tools.OpenForm(new FrmManagement());
    }//GEN-LAST:event_jLabel5MouseClicked

    private void borrowbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowbtnMouseClicked
        if (EmptyText()) {
            Tools.MsgBoxError1(" Please Select a Book ", "Select Book");
        } else {

            int Row = Borrowtable.getSelectedRow();
            String statement = "SELECT * FROM `books` WHERE `Status` = 'Available' ";

            book.setNumberOfBorrowing(Integer.parseInt(Borrowtable.getValueAt(Row, 7).toString()));
            book.setISBN(Integer.parseInt(txtISBN.getText()));
            book.UpdateBorrowing();

            history.setISBN(Integer.parseInt(txtISBN.getText()));
            history.setCardNumber(Integer.parseInt(txtCard.getText()));
            history.setTitle(txtTitle.getText());
            history.setAuthor(Borrowtable.getValueAt(Row, 2).toString());
            history.setRentalDate(Tools.ToDay());
            history.setReturnedDate(Tools.DateAfterFourteenDays());

            history.Add();

            book.GetSomeRows(statement, Borrowtable);

            txtCard.setText("");
            txtISBN.setText("");
            txtTitle.setText("");
            txtUser.setText("");
            txtSearch.requestFocus();

        }
    }//GEN-LAST:event_borrowbtnMouseClicked

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void BorrowtableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BorrowtableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BorrowtableKeyPressed

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
            java.util.logging.Logger.getLogger(FrmBooks_Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBooks_Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBooks_Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBooks_Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBooks_Borrow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Borrowtable;
    private javax.swing.ButtonGroup Group;
    private javax.swing.JRadioButton RadAuthor;
    private javax.swing.JRadioButton RadGenre;
    private javax.swing.JRadioButton RadISBN;
    private javax.swing.JRadioButton RadNumberOfBorrowing;
    private javax.swing.JRadioButton RadPublisher;
    private javax.swing.JRadioButton RadShelf;
    private javax.swing.JRadioButton RadStatus;
    private javax.swing.JRadioButton RadTitle;
    private javax.swing.JLabel borrowbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel searchbtn;
    private Controls.JTextBox txtCard;
    private Controls.JTextBox txtISBN;
    private Controls.JTextBox txtSearch;
    private Controls.JTextBox txtTitle;
    private Controls.JTextBox txtUser;
    // End of variables declaration//GEN-END:variables

}