/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Connection.Connections;
import Connection.Tools;
import javax.swing.JTable;

/**
 *
 * @author Death-PC
 */
public class Customer {
    private int CardNumber;
    private String Name;
    private String Address;
    private String Phone;

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int CardNumber) {
        this.CardNumber = CardNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return Phone;
    }

    public void setPhoneNumber(String Phone) {
        this.Phone = Phone;
    }
    
    
    public void Add() {
        String insert = "Insert into Customer VALUES ("
                + CardNumber + ","
                +"'"+ Name + "',"
                +"'"+ Address + "',"
                +"'"+ Phone + "',";
        boolean check = Connections.RunNonQuery(insert);
        if (check) {
           Tools.MsgBoxInfo("Customer has been added", "Registration succesful");
        }
                         
    }
     
    public void Update() {
        String update = "Update Customer set"
                +"Title='"+ Name + "',"
                +"Address='"+ Address + "',"
                +"phoneNumber='"+ Phone + "',"
                + " where cardNumber=" + CardNumber+";";
        boolean check = Connections.RunNonQuery(update);
        if(check) {
            Tools.MsgBoxInfo("Customer information has been updated", "Update succesful");
        }
    
  
    }
  
      public void Delete() {
        String delete = "Delete from Customer where cardNumber=" + CardNumber;
        boolean check = Connections.RunNonQuery(delete);
        if (check) {
            Tools.MsgBoxInfo("Customer has been deleted", "Customer Deleted");
        }
     }
      public int AutoNumber(){
      return Connections.GetAutoNumbers(" Customer ", "CardNumber");
      }
           
    
}
