/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Connection.Connections;
import Connection.Tools;

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
    
    public void addHistory() {
        String insert = "INSERT INTO History VALUES ("
                + cardNumber + ","
                + ISBN + "," 
                + "'" +title + "',"
                + "'" +author + "',"
                + "'" +status + "',"
                + "'" +rentalDate + "',"
                + "'" +returnedDate + "'"
                + ");";
        if(Connections.RunNonQuery(insert)) {
            Tools.MsgBoxInfo("History has been added", "History");
        }
                
    }
    

    
}
