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
 * @author User
 */
public class Return {
    private int ISBN;
     private String Status;
      private int CardNumber;
    
     public void UpdateStatusAvailable(){
    String update = "Update History set "
            +"Status='Returned' "
            + " where ISBN=" + ISBN +" AND CardNumber= "+ CardNumber +" ;";
     boolean check = Connections.RunNonQuery(update);
     if (check){
         Tools.MsgBoxInfo("Book "+getISBN()+" is now available", "Update Status");
     }
    }
     public void UpdateStatusUnavailable(){
    String update = "Update History set "
            +"Status='Unavailable',"
            + " where ISBN=" +getISBN() +"AND CardNumber= "+getCardNumber() +";";
     boolean check = Connections.RunNonQuery(update);
     if (check){
         Tools.MsgBoxInfo("Book "+getISBN()+" is now unavailable", "Update Status");
     }
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int CardNumber) {
        this.CardNumber = CardNumber;
    }

    
    
}
     
     




