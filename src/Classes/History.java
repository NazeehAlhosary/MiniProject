/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Connection.Connections;
import Connection.Tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;

/**
 *
 * @author marts
 */
public class History {
    private int cardNumber;
    private int ISBN;
    private String title;
    private String author;
    private String status;
    private String rentalDate;
    private String returnedDate;
    Books book = new Books() ;

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }
    
    public void Add() {
        String insert = "insert into History VALUES ("
                + cardNumber + ","
                + ISBN + "," 
                + "'" +title + "',"
                + "'" +author + "',"
                + "'" +"borrowed" + "',"
                + "'" +rentalDate + "',"
                + "'" +returnedDate + "'"
                + ");";
        if(Connections.RunNonQuery(insert)) {
            Tools.MsgBoxInfo("History has been added", "History");
        }
                
    }
    public void UpdateReturned(){
         String update = "Update History Set "
            +"Status = '"+"returned"+"',"
            + "returnedDate = '" +returnedDate + "'"
            + " where ISBN = " +ISBN +";";
     boolean check = Connections.RunNonQuery(update);
     if (check){
         Tools.MsgBoxInfo("Book "+ISBN + " has been returned", "Update");
     }
    
    }
       public void GetSomeRows(String Statement, JTable table){
        Connections.FillCustomRows(Statement, table);
    }

    public void GetTableInfo(String TableNameInDB, JTable table){
        Connections.FillTable(TableNameInDB, table);
    }
    
    public void setAttributes() throws SQLException {
        String query = "SELECT Title,Author,Status FROM Books "
                + "WHERE ISBN = "
                + ISBN + ";";
        
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem","root","");
        Connections.SetConnection();
        Statement Stmt = Con.createStatement();
        ResultSet rs = Stmt.executeQuery(query);
        
        rs.next();
        this.title = rs.getString("Title");
        this.status = rs.getString("Status");
        this.author = rs.getString("Author");
        
    }
     
    
}
