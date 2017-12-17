/**
 *
 * This class made by M Nazeeh Alhosary.
 *          7/5/2017
 */
package Connection; // Please change package name...

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nazeeh
 */
public class Connections {
    private static String URL = "";
    private static Connection Con;
    private static String DBNama = "librarysystem";

    private static void SetURL() {
        URL = "jdbc:mysql://localhost:3306/" + DBNama;

    }

    public static void SetConnection() {

        try {
            SetURL();
            Con = DriverManager.getConnection(URL, "root", "");
        } catch (SQLException ex) {
            System.out.println("ww");
            Tools.MsgBox(ex.getMessage());
        }

    }

    public static boolean RunNonQuery(String SqlStatement) {
        //For Insert, Update and Delete NOT Select 
        try {
            SetConnection();
            Statement Stmt = Con.createStatement();
            Stmt.execute(SqlStatement);
            Con.close();
            return true;
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
            // Tools.MsgBoxError1("Username , Library Card Number or ISBN Already Exist", "Exists Error");
            return false;
        }
    }
    public static boolean RunNonQueryAdmin(String SqlStatement) {
        //For Insert, Update and Delete NOT Select 
        try {
            SetConnection();
            Statement Stmt = Con.createStatement();
            Stmt.execute(SqlStatement);
            Con.close();
            return true;
        } catch (SQLException ex) {
            Tools.MsgBoxError1("Admin name already EXISTS!", "Exists Error");
            return false;
        }
    }

    public static Tools.Table GetTableData(String Statement) {
        Tools t = new Tools();
        try {
            SetConnection();
            Statement stmt = Con.createStatement();
            ResultSet RS;
            RS = stmt.executeQuery(Statement);

            ResultSetMetaData RSMD = RS.getMetaData();
            int c = RSMD.getColumnCount();

            Tools.Table table = t.new Table(c);

            while (RS.next()) {
                Object row[] = new Object[c];
                for (int i = 0; i < c; i++) {
                    row[i] = RS.getString(i + 1);
                }
                table.addNewRow(row);
            }
            Con.close();
            return table;
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
            return t.new Table(0);
        }
    }

    public static void FillTable(String TableNme, JTable jtable) {
        try {
            SetConnection();
            Statement stmt = Con.createStatement();
            ResultSet RS;
            String strSelect;
            strSelect = "select * from " + TableNme;
            //
            RS = stmt.executeQuery(strSelect);
            ResultSetMetaData RSMD = RS.getMetaData();
            int C = RSMD.getColumnCount();
            //
            DefaultTableModel model = (DefaultTableModel) jtable.getModel();
            Vector row = new Vector();
            model.setRowCount(0);
            //
            while (RS.next()) {
                row = new Vector(C);
                for (int i = 1; i <= C; i++) {
                    row.add(RS.getString(i));
                }
                model.addRow(row);
            }
            //Show Message if there is a wrong
            if (jtable.getColumnCount() != C) {
                Tools.MsgBox("JTable's columns count is NOT EGUAL to Query's columns count \nJTable's columns count is: " + jtable.getColumnCount() + "\n Query's columns count is: " + C);
            }

        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
    }

    public static void FillCustomRows(String Statement, JTable jtable) {
        try {
            SetConnection();
            Statement stmt = Con.createStatement();
            ResultSet RS;
            String strSelect = Statement;

            RS = stmt.executeQuery(strSelect);
            ResultSetMetaData RSMD = RS.getMetaData();
            int C = RSMD.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) jtable.getModel();
            Vector row = new Vector();
            model.setRowCount(0);

            while (RS.next()) {
                row = new Vector(C);
                for (int i = 1; i <= C; i++) {
                    row.add(RS.getString(i));
                }
                model.addRow(row);
            }
            //Show Message if there is a wrong
            if (jtable.getColumnCount() != C) {
                Tools.MsgBox("JTable's columns count is NOT EGUAL to Query's columns count \nJTable's columns count is: " + jtable.getColumnCount() + "\n Query's columns count is: " + C);
            }

        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
    }

    public static void FillComboBox(String TableName, String ColumnName, JComboBox Combo) {
        try {
            SetConnection();
            Statement stmt = Con.createStatement();
            ResultSet RS;
            String StrSclect = "Select " + ColumnName + " from " + TableName;
            RS = stmt.executeQuery(StrSclect);
            // To Get Rows number
            RS.last();
            int R = RS.getRow();
            // To return to the first
            RS.beforeFirst();
            String Values[] = new String[R];
            int i = 0;
            while (RS.next()) {
                Values[i] = RS.getString(1);
                i++;
            }
            Con.close();
            Combo.setModel(new DefaultComboBoxModel(Values));
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
    }

    public static boolean CheckLogIn(String UserName, String PassWord) {
        try {
            SetConnection();
            Statement Stmt = Con.createStatement();
            String Check = "Select * From loginl Where "
                    + "UserName='" + UserName + "' and "
                    + "PassWord='" + PassWord + "'";
            Stmt.executeQuery(Check);
            while (Stmt.getResultSet().next()) {
                Con.close();
                return true;
            }
            Con.close();
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return false;
    }

    public static int GetAutoNumbers(String TableName, String ColumnName) {
        try {
            SetConnection();
            Statement Stmt = Con.createStatement();
            String Auto = "select max(" + ColumnName + ")+1 as AutoNumber from " + TableName;
            Stmt.executeQuery(Auto);
            String Number = "";
            while (Stmt.getResultSet().next()) {
                Number = Stmt.getResultSet().getString("AutoNumber");
            }
            Con.close();
            if (Number == null || Number.equals("")) {
                return 1;
            } else {
                return Integer.parseInt(Number);
            }
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
            return 0;
        }
    }
    public static String ReturnPassWord(int CardNumber, String Question, String Answer) {
        try {
            SetConnection();
            Statement Stmt = Con.createStatement();
            String ReturnPass = "Select PassWord as 'ReturnPass' FROM customerlogin where "
                    + " CardNumber= " + CardNumber
                    + " AND Question= '" + Question + "' "
                    + " AND Answer= '" + Answer + "' ;";
            Stmt.executeQuery(ReturnPass);
            String ResultOFPassWord = "";
            while (Stmt.getResultSet().next()) {
                ResultOFPassWord = Stmt.getResultSet().getString("ReturnPass");
            }
            Con.close();
            if (ResultOFPassWord == null || ResultOFPassWord.equals("")) {
                return "";
            } else {
                return (ResultOFPassWord);
            }
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
            return "";
        }
    }

    public static int CheckSerial() {
        try {
            int numberOfAdmins = 0;
            SetConnection();
            Statement Stmt = Con.createStatement();
            String Count = "SELECT count(*) AS total FROM loginl;";
            ResultSet num = Stmt.executeQuery(Count);
            while (num.next()) {
                numberOfAdmins  = num.getInt("total");
            }
            Con.close();
            if (numberOfAdmins  == 0) {
                return 0;
            }
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return 1;
    }

    public static boolean CheckLogInCustomer (String CardNumberOREmail , String PassWord){
        try {
            SetConnection();
            Statement Stmt = Con.createStatement();
            String Check = "Select * From customerlogin Where "
                    + " Email='" + CardNumberOREmail +"' and "
                    + " PassWord='" +PassWord + "' ;";
            Stmt.executeQuery(Check);
            while (Stmt.getResultSet().next()){
                Con.close();
                return true;
            }
            Con.close();
        }
        catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return false;
    }
        public static boolean CheckEmail( String Email) {
        try {
            SetConnection();
            Statement Stmt = Con.createStatement();
            String Statement = "Select CardNumber as 'Card' from customerlogin where Email='" +Email+"'; ";
            Stmt.executeQuery(Statement);
            String Result=  "";
            while (Stmt.getResultSet().next()) {
                Result = Stmt.getResultSet().getString("Card");
            }
            Con.close();
            if (Result == null || Result.equals("")) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
            return false;
        }
    }

}
