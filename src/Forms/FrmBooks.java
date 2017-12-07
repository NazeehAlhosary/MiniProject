/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Classes.Books;
import Connection.TableNewColors;
import Connection.Tools;
import java.awt.Cursor;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Nazeeh
 */
public class FrmBooks extends javax.swing.JFrame {

    /**
     * Creates new form FrmBooks
     */
    public FrmBooks() {
        initComponents();
        BooksTable.setDefaultRenderer(Object.class, new TableNewColors());
        SetLabels();
        
    }
    Books book = new Books();
    private void PutInfo(){
        book.setISBN(Integer.parseInt( txtISBN.getText() ));
        book.setTitle(txtTitle.getText());  // Test for pushing 
        book.setAuthor(txtAuthor.getText());
        book.setPublisher(txtPublisher.getText());
        book.setShelf(txtShelf.getText());
        book.setGenre(ComGenre.getSelectedItem().toString());
        book.setStatus(ComStatus.getSelectedItem().toString());
        book.setNumberOfBorrowing(Integer.parseInt(txtNumberOfBorrowing.getText()));
    }
    
    private void Add(){
    if (!NoEmptyTextField()){
             PutInfo();
             book.Add();
             ClearInfo();    
        }     
        else {
            Tools.MsgBoxError1("Please fill all field and make sure that you have chosen status and Genre...", "Empty Field or Boxes");
        }    
    }
    
    private void Delete(){
     if (!txtISBN.getText().equals("")){
            book.setISBN(Integer.parseInt( txtISBN.getText() ));
            book.Delete();
            ClearInfo();
       }
       else {
       Tools.MsgBoxError1("Please put book's ISBN to Delete it..", "Empty Field");
       }
    }
    private void Update(){
    if (!NoEmptyTextField()){
        PutInfo();
        book.Update();
         ClearInfo();
       }
       else {
            Tools.MsgBoxError1("Please fill all field and make sure that you have chosen status and Genre...", "Empty Field or Boxes");
        }
    }
    
    private void SetLabels(){
    Tools.PutImageInLable("Refresh-white.png", lblRefresh, 30, 30);
    Tools.PutImageInLable("add-512-white.png", lblAdd, 30, 30);
    Tools.PutImageInLable("pen.png", lblUpdate, 30, 30);
    Tools.PutImageInLable("Delete_Icon_White.png", lblDelete, 30, 30);
    Tools.PutImageInLable("Search-icon-White.png", lblSearsh, 30, 30);
    Tools.PutImageInLable("Ascending_White.png", lblAscending, 30, 30);
    Tools.PutImageInLable("Descending_White.png", lblDescending, 30, 30);
    Tools.PutImageInLable("Exit_Red.png", lblExit, 35, 35);
    Tools.PutImageInLable("Back_White.png", lblBack, 30, 30);
    Tools.PutImageInLable("Google.png", lblGoogle, 30, 30);
    
    lblRefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
    lblAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
    lblUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
    lblDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
    lblSearsh.setCursor(new Cursor(Cursor.HAND_CURSOR));
    lblAscending.setCursor(new Cursor(Cursor.HAND_CURSOR));
    lblDescending.setCursor(new Cursor(Cursor.HAND_CURSOR));
    lblExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
    lblBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    }
    
    private void ClearInfo(){
    txtISBN.setText("");
    txtAuthor.setText("");
    txtTitle.setText("");
    txtShelf.setText("");
    ComGenre.setSelectedItem("***Select Genre***");
    ComStatus.setSelectedItem("***Select Status***");
    txtNumberOfBorrowing.setText("0");
    txtPublisher.setText("");
    txtSearch.setText("");
    txtISBN.requestFocus();
    book.GetTableInfo("Books", BooksTable);
    MenuBar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    }
    
    private void OrderItems(String OrderBy){
     String Statement = "Select * from Books order by ";
        if (RadISBN.isSelected()){
            Statement += " ISBN " + OrderBy;
        }
        else if (RadTitle.isSelected()){
            Statement += " Title " + OrderBy;
            
        }
        else if (RadAuthor.isSelected()){
             Statement += " Author " + OrderBy;
        }
         else if (RadGenre.isSelected()){
             Statement += " Genre " + OrderBy;
        }
        else if (RadPublisher.isSelected()){
             Statement += " Publisher " + OrderBy;
        }
         else if (RadShelf.isSelected()){
             Statement += " Shelf " + OrderBy;
        }
        else if (RadStatus.isSelected()){
             Statement += " Status " + OrderBy;
        }
        else {
             Statement += " NumberOfBorrowing " + OrderBy;
        }
        book.GetSomeRows(Statement, BooksTable);
    }
    
    private void SelectInfo(){
        int Row = BooksTable.getSelectedRow();
                try {
    txtISBN.setText(BooksTable.getValueAt(Row,0).toString() );
    txtTitle.setText(BooksTable.getValueAt(Row, 1).toString() );
    txtAuthor.setText(BooksTable.getValueAt(Row, 2).toString());
    txtPublisher.setText(BooksTable.getValueAt(Row, 3).toString());
    txtShelf.setText(BooksTable.getValueAt(Row, 4).toString());
    ComGenre.setSelectedItem(BooksTable.getValueAt(Row, 5).toString());
    ComStatus.setSelectedItem(BooksTable.getValueAt(Row, 6).toString());
    txtNumberOfBorrowing.setText(BooksTable.getValueAt(Row, 7).toString());
                 }catch(Exception ex){
                Tools.MsgBox(ex.getMessage());
                }
    }
    
    private boolean NoEmptyTextField(){
    if (txtISBN.getText().equals("") || txtTitle.getText().equals("") || txtAuthor.getText().equals("") 
            || txtPublisher.getText().equals("") || ComGenre.getSelectedItem().equals("***Select Genre***")
            ||txtShelf.getText().equals("") || ComStatus.getSelectedItem().equals("***Select Status***")){
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

        btnGroup = new javax.swing.ButtonGroup();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        lblDate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        RadISBN = new javax.swing.JRadioButton();
        RadTitle = new javax.swing.JRadioButton();
        RadAuthor = new javax.swing.JRadioButton();
        RadPublisher = new javax.swing.JRadioButton();
        RadShelf = new javax.swing.JRadioButton();
        RadGenre = new javax.swing.JRadioButton();
        RadNumberOF = new javax.swing.JRadioButton();
        RadStatus = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        lblAdd = new javax.swing.JLabel();
        lblUpdate = new javax.swing.JLabel();
        lblRefresh = new javax.swing.JLabel();
        lblDelete = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtISBN = new Controls.JTextBox();
        jLabel1 = new javax.swing.JLabel();
        txtTitle = new Controls.JTextBox();
        jLabel2 = new javax.swing.JLabel();
        txtAuthor = new Controls.JTextBox();
        jLabel3 = new javax.swing.JLabel();
        txtPublisher = new Controls.JTextBox();
        jLabel4 = new javax.swing.JLabel();
        txtShelf = new Controls.JTextBox();
        jLabel6 = new javax.swing.JLabel();
        ComGenre = new Controls.JCombo();
        jLabel7 = new javax.swing.JLabel();
        txtNumberOfBorrowing = new Controls.JTextBox();
        jLabel8 = new javax.swing.JLabel();
        ComStatus = new Controls.JCombo();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        lblSearsh = new javax.swing.JLabel();
        lblAscending = new javax.swing.JLabel();
        lblDescending = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BooksTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new Controls.JTextBox();
        jLabel11 = new javax.swing.JLabel();
        lblPrint = new javax.swing.JLabel();
        lblGoogle = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuFileAdd = new javax.swing.JMenuItem();
        MenuFileDelete = new javax.swing.JMenuItem();
        MenuFileUpdate = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MenuFilePrint = new javax.swing.JMenuItem();
        MenuFileBackUp = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MenuFileRefresh = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MenuFileHome = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuFileQuit = new javax.swing.JMenuItem();
        MenuMoveMenu = new javax.swing.JMenu();
        MenuMoveToHome = new javax.swing.JMenuItem();
        MenuMoveCustomers = new javax.swing.JMenuItem();
        MenuMoveHistory = new javax.swing.JMenuItem();
        MenuMoveManagement = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem5.setText("jMenuItem5");

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        lblDate.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblDate);
        lblDate.setBounds(45, 6, 97, 17);

        jLabel10.setFont(new java.awt.Font("Garamond", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(6, 6, 33, 17);

        RadISBN.setBackground(new java.awt.Color(44, 0, 44));
        RadISBN.setForeground(new java.awt.Color(255, 255, 255));
        RadISBN.setSelected(true);
        RadISBN.setText("ISBN");
        getContentPane().add(RadISBN);
        RadISBN.setBounds(391, 130, 59, 28);

        RadTitle.setBackground(new java.awt.Color(44, 0, 44));
        RadTitle.setForeground(new java.awt.Color(255, 255, 255));
        RadTitle.setText("Title");
        getContentPane().add(RadTitle);
        RadTitle.setBounds(467, 130, 56, 28);

        RadAuthor.setBackground(new java.awt.Color(44, 0, 44));
        RadAuthor.setForeground(new java.awt.Color(255, 255, 255));
        RadAuthor.setText("Author");
        getContentPane().add(RadAuthor);
        RadAuthor.setBounds(541, 130, 70, 28);

        RadPublisher.setBackground(new java.awt.Color(44, 0, 44));
        RadPublisher.setForeground(new java.awt.Color(255, 255, 255));
        RadPublisher.setText("Publisher");
        getContentPane().add(RadPublisher);
        RadPublisher.setBounds(617, 130, 86, 28);

        RadShelf.setBackground(new java.awt.Color(44, 0, 44));
        RadShelf.setForeground(new java.awt.Color(255, 255, 255));
        RadShelf.setText("Shelf");
        getContentPane().add(RadShelf);
        RadShelf.setBounds(721, 130, 61, 28);

        RadGenre.setBackground(new java.awt.Color(44, 0, 44));
        RadGenre.setForeground(new java.awt.Color(255, 255, 255));
        RadGenre.setText("Genre");
        getContentPane().add(RadGenre);
        RadGenre.setBounds(794, 130, 66, 28);

        RadNumberOF.setBackground(new java.awt.Color(44, 0, 44));
        RadNumberOF.setForeground(new java.awt.Color(255, 255, 255));
        RadNumberOF.setText("Number of Borrowing");
        getContentPane().add(RadNumberOF);
        RadNumberOF.setBounds(953, 130, 153, 28);

        RadStatus.setBackground(new java.awt.Color(44, 0, 44));
        RadStatus.setForeground(new java.awt.Color(255, 255, 255));
        RadStatus.setText("Status");
        getContentPane().add(RadStatus);
        RadStatus.setBounds(872, 130, 69, 28);

        jPanel1.setBackground(new java.awt.Color(64, 1, 64));

        lblAdd.setToolTipText("Add new Book");
        lblAdd.setMaximumSize(new java.awt.Dimension(50, 50));
        lblAdd.setMinimumSize(new java.awt.Dimension(50, 50));
        lblAdd.setPreferredSize(new java.awt.Dimension(50, 50));
        lblAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddMouseExited(evt);
            }
        });

        lblUpdate.setToolTipText("Edit a Book");
        lblUpdate.setMaximumSize(new java.awt.Dimension(50, 50));
        lblUpdate.setMinimumSize(new java.awt.Dimension(50, 50));
        lblUpdate.setPreferredSize(new java.awt.Dimension(50, 50));
        lblUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUpdateMouseExited(evt);
            }
        });

        lblRefresh.setToolTipText("Refresh");
        lblRefresh.setMaximumSize(new java.awt.Dimension(50, 50));
        lblRefresh.setMinimumSize(new java.awt.Dimension(50, 50));
        lblRefresh.setPreferredSize(new java.awt.Dimension(50, 50));
        lblRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRefreshMouseExited(evt);
            }
        });

        lblDelete.setToolTipText("Delete a Book");
        lblDelete.setMaximumSize(new java.awt.Dimension(50, 50));
        lblDelete.setMinimumSize(new java.awt.Dimension(50, 50));
        lblDelete.setPreferredSize(new java.awt.Dimension(50, 50));
        lblDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDeleteMouseExited(evt);
            }
        });

        lblExit.setToolTipText("Exit the program");
        lblExit.setMaximumSize(new java.awt.Dimension(50, 50));
        lblExit.setMinimumSize(new java.awt.Dimension(50, 50));
        lblExit.setPreferredSize(new java.awt.Dimension(50, 50));
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExitMouseExited(evt);
            }
        });

        lblBack.setToolTipText("Back To Menu");
        lblBack.setMaximumSize(new java.awt.Dimension(50, 50));
        lblBack.setMinimumSize(new java.awt.Dimension(50, 50));
        lblBack.setPreferredSize(new java.awt.Dimension(50, 50));
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackMouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("N.Borrowing");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ISBN");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Title");

        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Author");

        txtPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublisherActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Publisher");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Shelf");

        ComGenre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "***Select Genre***", "Action and Adventure", "Anthology", "Art", "Autobiographies", "Biographies", "Children's", "Comics", "Cookbooks", "Diaries", "Dictionaries", "Drama", "Encyclopedias", "Fantasy", "Guide", "Health", "History", "Horror", "Journals", "Math", "Mystery", "Poetry", "Prayer books", "Religion", "Romance", "Satire", "Science", "Science fiction", "Self help", "Series", "Spirituality & New Age", "Travel", "Trilogy" }));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Genre");

        txtNumberOfBorrowing.setEditable(false);
        txtNumberOfBorrowing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberOfBorrowingActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");

        ComStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "***Select Status***", "Available", "Unavailable" }));
        ComStatus.setToolTipText("Select Book status");

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ComStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(12, 12, 12)
                            .addComponent(ComGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumberOfBorrowing, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 0, 0)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(0, 0, 0)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 0, 0)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ComGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ComStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumberOfBorrowing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 370, 580);

        jPanel2.setBackground(new java.awt.Color(44, 0, 44));

        lblSearsh.setToolTipText("Search");
        lblSearsh.setMaximumSize(new java.awt.Dimension(50, 50));
        lblSearsh.setMinimumSize(new java.awt.Dimension(50, 50));
        lblSearsh.setPreferredSize(new java.awt.Dimension(50, 50));
        lblSearsh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSearshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSearshMouseExited(evt);
            }
        });

        lblAscending.setToolTipText("Order items Ascending ");
        lblAscending.setMaximumSize(new java.awt.Dimension(50, 50));
        lblAscending.setMinimumSize(new java.awt.Dimension(50, 50));
        lblAscending.setPreferredSize(new java.awt.Dimension(50, 50));
        lblAscending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAscendingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAscendingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAscendingMouseExited(evt);
            }
        });

        lblDescending.setToolTipText("Order items Descending");
        lblDescending.setMaximumSize(new java.awt.Dimension(50, 50));
        lblDescending.setMinimumSize(new java.awt.Dimension(50, 50));
        lblDescending.setPreferredSize(new java.awt.Dimension(50, 50));
        lblDescending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDescendingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDescendingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDescendingMouseExited(evt);
            }
        });

        BooksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        BooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BooksTableMouseClicked(evt);
            }
        });
        BooksTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BooksTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(BooksTable);
        if (BooksTable.getColumnModel().getColumnCount() > 0) {
            BooksTable.getColumnModel().getColumn(0).setMinWidth(20);
            BooksTable.getColumnModel().getColumn(0).setMaxWidth(55);
            BooksTable.getColumnModel().getColumn(1).setMinWidth(130);
            BooksTable.getColumnModel().getColumn(1).setMaxWidth(180);
            BooksTable.getColumnModel().getColumn(2).setMinWidth(120);
            BooksTable.getColumnModel().getColumn(2).setMaxWidth(170);
            BooksTable.getColumnModel().getColumn(3).setMinWidth(70);
            BooksTable.getColumnModel().getColumn(3).setMaxWidth(120);
            BooksTable.getColumnModel().getColumn(4).setMinWidth(30);
            BooksTable.getColumnModel().getColumn(4).setMaxWidth(50);
            BooksTable.getColumnModel().getColumn(5).setMinWidth(100);
            BooksTable.getColumnModel().getColumn(5).setMaxWidth(150);
            BooksTable.getColumnModel().getColumn(6).setMinWidth(60);
            BooksTable.getColumnModel().getColumn(6).setMaxWidth(80);
            BooksTable.getColumnModel().getColumn(7).setMinWidth(45);
            BooksTable.getColumnModel().getColumn(7).setMaxWidth(90);
        }

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Footlight MT Light", 3, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/books-stack-from-top-view (1).png"))); // NOI18N
        jLabel5.setText("BOOKS");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Search");

        lblPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/printer- (1).png"))); // NOI18N
        lblPrint.setToolTipText("Print Table");
        lblPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrintMouseClicked(evt);
            }
        });

        lblGoogle.setToolTipText("Searching by Google");
        lblGoogle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGoogle.setMaximumSize(new java.awt.Dimension(50, 50));
        lblGoogle.setMinimumSize(new java.awt.Dimension(50, 50));
        lblGoogle.setPreferredSize(new java.awt.Dimension(50, 50));
        lblGoogle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGoogleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGoogleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGoogleMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSearsh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAscending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDescending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblGoogle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(lblPrint))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSearsh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAscending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGoogle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrint)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(370, 0, 840, 580);

        MenuBar.setBackground(new java.awt.Color(44, 0, 44));
        MenuBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(44, 0, 44), new java.awt.Color(66, 0, 66), null, null));
        MenuBar.setForeground(new java.awt.Color(66, 0, 66));
        MenuBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuBarMouseReleased(evt);
            }
        });

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("File");

        MenuFileAdd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuFileAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/plus-black-symbol (2).png"))); // NOI18N
        MenuFileAdd.setText("Add");
        MenuFileAdd.setToolTipText("Add new Book");
        MenuFileAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFileAddActionPerformed(evt);
            }
        });
        jMenu1.add(MenuFileAdd);

        MenuFileDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuFileDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/Menu_Delete_Black.png"))); // NOI18N
        MenuFileDelete.setText("Delete");
        MenuFileDelete.setToolTipText("Delete selected Book");
        MenuFileDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFileDeleteActionPerformed(evt);
            }
        });
        jMenu1.add(MenuFileDelete);

        MenuFileUpdate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuFileUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/Menu_Update_Black.png"))); // NOI18N
        MenuFileUpdate.setText("Update");
        MenuFileUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFileUpdateActionPerformed(evt);
            }
        });
        jMenu1.add(MenuFileUpdate);
        jMenu1.add(jSeparator3);

        MenuFilePrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuFilePrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/Menu_Print_Black.png"))); // NOI18N
        MenuFilePrint.setText("Print");
        jMenu1.add(MenuFilePrint);

        MenuFileBackUp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuFileBackUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/BackUp.png"))); // NOI18N
        MenuFileBackUp.setText("Back Up");
        MenuFileBackUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFileBackUpActionPerformed(evt);
            }
        });
        jMenu1.add(MenuFileBackUp);
        jMenu1.add(jSeparator2);

        MenuFileRefresh.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        MenuFileRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/Menu_Refresh_Black.png"))); // NOI18N
        MenuFileRefresh.setText("Refresh");
        MenuFileRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFileRefreshActionPerformed(evt);
            }
        });
        jMenu1.add(MenuFileRefresh);
        jMenu1.add(jSeparator4);

        MenuFileHome.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuFileHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/Menu_Home_Black.png"))); // NOI18N
        MenuFileHome.setText("Menu");
        MenuFileHome.setToolTipText("Go back to Menu");
        MenuFileHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFileHomeActionPerformed(evt);
            }
        });
        jMenu1.add(MenuFileHome);
        jMenu1.add(jSeparator1);

        MenuFileQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuFileQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/Menu_Quit_Red.png"))); // NOI18N
        MenuFileQuit.setText("Quit");
        MenuFileQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFileQuitActionPerformed(evt);
            }
        });
        jMenu1.add(MenuFileQuit);

        MenuBar.add(jMenu1);

        MenuMoveMenu.setForeground(new java.awt.Color(255, 255, 255));
        MenuMoveMenu.setText("Move ");

        MenuMoveToHome.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuMoveToHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/Menu_Home_Black.png"))); // NOI18N
        MenuMoveToHome.setText("Menu");
        MenuMoveToHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMoveToHomeActionPerformed(evt);
            }
        });
        MenuMoveMenu.add(MenuMoveToHome);

        MenuMoveCustomers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuMoveCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/Menu_Customers_Black.png"))); // NOI18N
        MenuMoveCustomers.setText("Customers");
        MenuMoveCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMoveCustomersActionPerformed(evt);
            }
        });
        MenuMoveMenu.add(MenuMoveCustomers);

        MenuMoveHistory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuMoveHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/Menu_History_Black.png"))); // NOI18N
        MenuMoveHistory.setText("History");
        MenuMoveHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMoveHistoryActionPerformed(evt);
            }
        });
        MenuMoveMenu.add(MenuMoveHistory);

        MenuMoveManagement.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuMoveManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Connection/Icons/Menu_Management_Black.png"))); // NOI18N
        MenuMoveManagement.setText("Management");
        MenuMoveManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMoveManagementActionPerformed(evt);
            }
        });
        MenuMoveMenu.add(MenuMoveManagement);

        MenuBar.add(MenuMoveMenu);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       this.setTitle("Library System By Mini Project Team 6");
       
       btnGroup.add(RadISBN);
       btnGroup.add(RadTitle);
       btnGroup.add(RadAuthor);
       btnGroup.add(RadPublisher);
       btnGroup.add(RadShelf);
       btnGroup.add(RadGenre);
       btnGroup.add(RadStatus);
       btnGroup.add(RadNumberOF);
                             
        Tools.SetTableHeader(BooksTable);
         ClearInfo();
         
        // txtTitle.requestFocus();
         // Put Date in Label
         Tools.ToDay(lblDate);
        
    }//GEN-LAST:event_formWindowOpened

    private void BooksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BooksTableMouseClicked
        SelectInfo();
    }//GEN-LAST:event_BooksTableMouseClicked

    private void BooksTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BooksTableKeyReleased
        SelectInfo();
    }//GEN-LAST:event_BooksTableKeyReleased

    private void lblRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseClicked
        ClearInfo();
    }//GEN-LAST:event_lblRefreshMouseClicked

    private void lblRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseEntered
      Tools.PutImageInLable("Refresh-white.png", lblRefresh, 45, 45);
    }//GEN-LAST:event_lblRefreshMouseEntered

    private void lblRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseExited
        Tools.PutImageInLable("Refresh-white.png", lblRefresh, 30, 30);
    }//GEN-LAST:event_lblRefreshMouseExited

    private void lblAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseClicked
        Add();
    }//GEN-LAST:event_lblAddMouseClicked

    private void lblUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUpdateMouseClicked
       Update();
    }//GEN-LAST:event_lblUpdateMouseClicked

    private void lblDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMouseClicked
        Delete();
    }//GEN-LAST:event_lblDeleteMouseClicked

    private void lblSearshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearshMouseClicked
        String Statement = "Select * from Books where ";
        String Statement2 = " like '%"+ txtSearch.getText()+ "%' ";
        if (RadISBN.isSelected()){
            Statement += " ISBN " + Statement2;
        }
        else if (RadTitle.isSelected()){
            Statement += " Title " + Statement2;
        }
        else if (RadShelf.isSelected()){
             Statement += " Shelf " + Statement2;
        }
        else if (RadAuthor.isSelected()){
             Statement += " Author " + Statement2;
        }
        else if (RadGenre.isSelected()){
             Statement += " Genre " + Statement2;
        }
        else if (RadPublisher.isSelected()){
             Statement += " Publisher " + Statement2;
        }
        else if (RadStatus.isSelected()){
             Statement += " Status " + Statement2;
        }
        else {
             Statement += " NumberOfBorrowing " + Statement2;
        }
        
        book.GetSomeRows(Statement, BooksTable);
        int Row = BooksTable.getRowCount();
        if (Row == 0){
            Tools.MsgBoxErrorX("No result!","Searching not found");
            ClearInfo();
            txtSearch.requestFocus();
        }
    }//GEN-LAST:event_lblSearshMouseClicked

    private void lblAscendingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAscendingMouseClicked
        OrderItems("asc");
    }//GEN-LAST:event_lblAscendingMouseClicked

    private void lblDescendingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDescendingMouseClicked
        OrderItems("desc");
    }//GEN-LAST:event_lblDescendingMouseClicked

    private void MenuBarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBarMouseReleased
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_MenuBarMouseReleased

    private void MenuFileAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileAddActionPerformed
        Add();
    }//GEN-LAST:event_MenuFileAddActionPerformed

    private void MenuFileHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileHomeActionPerformed
        this.dispose();
        Tools.OpenForm(new Menu());
    }//GEN-LAST:event_MenuFileHomeActionPerformed

    private void MenuFileQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileQuitActionPerformed
       boolean check = Tools.YesNoChooserBox("Do you want to quit?", "Exit!");
       if(check){
        System.exit(0);
       }
    }//GEN-LAST:event_MenuFileQuitActionPerformed

    private void MenuFileUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileUpdateActionPerformed
        Update();
    }//GEN-LAST:event_MenuFileUpdateActionPerformed

    private void MenuFileDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileDeleteActionPerformed
        Delete();
    }//GEN-LAST:event_MenuFileDeleteActionPerformed

    private void MenuFileRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileRefreshActionPerformed
        ClearInfo();
    }//GEN-LAST:event_MenuFileRefreshActionPerformed

    private void MenuMoveCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMoveCustomersActionPerformed
        this.dispose();
        Tools.OpenForm(new FrmCustomers());
    }//GEN-LAST:event_MenuMoveCustomersActionPerformed

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        boolean check = Tools.YesNoChooserBox("Do you want to quit?", "Exit!");
       if(check){
        System.exit(0);
       }
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
         this.dispose();
        Tools.OpenForm(new Menu());
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseEntered
         Tools.PutImageInLable("add-512-white.png", lblAdd, 45, 45);
    }//GEN-LAST:event_lblAddMouseEntered

    private void lblAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseExited
          Tools.PutImageInLable("add-512-white.png", lblAdd, 30, 30);
    }//GEN-LAST:event_lblAddMouseExited

    private void lblUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUpdateMouseEntered
       Tools.PutImageInLable("pen.png", lblUpdate, 45, 45);
    }//GEN-LAST:event_lblUpdateMouseEntered

    private void lblUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUpdateMouseExited
       Tools.PutImageInLable("pen.png", lblUpdate, 30, 30);
    }//GEN-LAST:event_lblUpdateMouseExited

    private void lblDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMouseEntered
        Tools.PutImageInLable("Delete_Icon_White.png", lblDelete, 45, 45);
    }//GEN-LAST:event_lblDeleteMouseEntered

    private void lblDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMouseExited
         Tools.PutImageInLable("Delete_Icon_White.png", lblDelete, 30, 30);
    }//GEN-LAST:event_lblDeleteMouseExited

    private void lblExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseEntered
       Tools.PutImageInLable("Exit_Red.png", lblExit, 50, 50);
    }//GEN-LAST:event_lblExitMouseEntered

    private void lblExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseExited
        Tools.PutImageInLable("Exit_Red.png", lblExit, 35, 35);
    }//GEN-LAST:event_lblExitMouseExited

    private void lblBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseEntered
         Tools.PutImageInLable("Back_White.png", lblBack, 45, 45);
    }//GEN-LAST:event_lblBackMouseEntered

    private void lblBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseExited
        Tools.PutImageInLable("Back_White.png", lblBack, 30, 30);
    }//GEN-LAST:event_lblBackMouseExited

    private void lblSearshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearshMouseEntered
       Tools.PutImageInLable("Search-icon-White.png", lblSearsh, 45, 45);
    }//GEN-LAST:event_lblSearshMouseEntered

    private void lblSearshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearshMouseExited
       Tools.PutImageInLable("Search-icon-White.png", lblSearsh, 30, 30);
    }//GEN-LAST:event_lblSearshMouseExited

    private void lblAscendingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAscendingMouseEntered
        Tools.PutImageInLable("Ascending_White.png", lblAscending, 45, 45);
    }//GEN-LAST:event_lblAscendingMouseEntered

    private void lblAscendingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAscendingMouseExited
       Tools.PutImageInLable("Ascending_White.png", lblAscending, 30, 30);
    }//GEN-LAST:event_lblAscendingMouseExited

    private void lblDescendingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDescendingMouseEntered
       Tools.PutImageInLable("Descending_White.png", lblDescending, 45, 45);
    }//GEN-LAST:event_lblDescendingMouseEntered

    private void lblDescendingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDescendingMouseExited
       Tools.PutImageInLable("Descending_White.png", lblDescending, 30, 30);
    }//GEN-LAST:event_lblDescendingMouseExited

    private void MenuFileBackUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileBackUpActionPerformed
        Tools.OpenForm(new Loading());
    }//GEN-LAST:event_MenuFileBackUpActionPerformed

    private void MenuMoveHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMoveHistoryActionPerformed
        this.dispose();  
        Tools.OpenForm(new FrmHistory());
    }//GEN-LAST:event_MenuMoveHistoryActionPerformed

    private void MenuMoveManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMoveManagementActionPerformed
        this.dispose();
        Tools.OpenForm(new FrmManagement());
    }//GEN-LAST:event_MenuMoveManagementActionPerformed

    private void MenuMoveToHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMoveToHomeActionPerformed
         this.dispose();
        Tools.OpenForm(new Menu());
    }//GEN-LAST:event_MenuMoveToHomeActionPerformed

    private void txtNumberOfBorrowingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberOfBorrowingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberOfBorrowingActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void txtPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublisherActionPerformed

    private void lblPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintMouseClicked
        try {
            MessageFormat Header = new MessageFormat("Books");
            MessageFormat Footer = new MessageFormat ("Page - {0}");
            BooksTable.print(JTable.PrintMode.NORMAL,Header,Footer);
        } catch (PrinterException ex) {
            Logger.getLogger(FrmBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPrintMouseClicked

    private void lblGoogleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoogleMouseExited
        Tools.PutImageInLable("Google.png", lblGoogle, 30, 30);
    }//GEN-LAST:event_lblGoogleMouseExited

    private void lblGoogleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoogleMouseEntered
        Tools.PutImageInLable("Google.png", lblGoogle, 50, 50);
    }//GEN-LAST:event_lblGoogleMouseEntered

    private void lblGoogleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoogleMouseClicked
        Tools.OpenWebPage("https://www.google.se/");
    }//GEN-LAST:event_lblGoogleMouseClicked

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
            java.util.logging.Logger.getLogger(FrmBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BooksTable;
    private Controls.JCombo ComGenre;
    private Controls.JCombo ComStatus;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuFileAdd;
    private javax.swing.JMenuItem MenuFileBackUp;
    private javax.swing.JMenuItem MenuFileDelete;
    private javax.swing.JMenuItem MenuFileHome;
    private javax.swing.JMenuItem MenuFilePrint;
    private javax.swing.JMenuItem MenuFileQuit;
    private javax.swing.JMenuItem MenuFileRefresh;
    private javax.swing.JMenuItem MenuFileUpdate;
    private javax.swing.JMenuItem MenuMoveCustomers;
    private javax.swing.JMenuItem MenuMoveHistory;
    private javax.swing.JMenuItem MenuMoveManagement;
    private javax.swing.JMenu MenuMoveMenu;
    private javax.swing.JMenuItem MenuMoveToHome;
    private javax.swing.JRadioButton RadAuthor;
    private javax.swing.JRadioButton RadGenre;
    private javax.swing.JRadioButton RadISBN;
    private javax.swing.JRadioButton RadNumberOF;
    private javax.swing.JRadioButton RadPublisher;
    private javax.swing.JRadioButton RadShelf;
    private javax.swing.JRadioButton RadStatus;
    private javax.swing.JRadioButton RadTitle;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblAscending;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JLabel lblDescending;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblGoogle;
    private javax.swing.JLabel lblPrint;
    private javax.swing.JLabel lblRefresh;
    private javax.swing.JLabel lblSearsh;
    private javax.swing.JLabel lblUpdate;
    private Controls.JTextBox txtAuthor;
    private Controls.JTextBox txtISBN;
    private Controls.JTextBox txtNumberOfBorrowing;
    private Controls.JTextBox txtPublisher;
    private Controls.JTextBox txtSearch;
    private Controls.JTextBox txtShelf;
    private Controls.JTextBox txtTitle;
    // End of variables declaration//GEN-END:variables
}
