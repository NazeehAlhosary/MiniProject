/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import Connection.Connections;
import Connection.Tools;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ranim
 */
public class Loginl {
    
    private String Username;
    private String Password;
    
    
    
    public String getPassword() {
        return Password;
    }
    public String getUsername() {
        return Username;
    }
    
    
    public void setPassword(String Password) {
        this.Password = Tools.hashPassword(Password);
    }
    
    
    public void Add(){
         String insert = "Insert into Loginl VALUES ("
                 +"'"+ Username +"',"
                 +"'"+Password+"';";
          boolean check = Connections.RunNonQuery(insert); 
         if (check){
             Tools.MsgBoxInfo("User "+ Username+ " has been registered" ,"Registeration");
         }
    }
     public void Update(){
     String update = "Update Loginl set "
             +"Username = '"+Username+"' where Password= '"
             + Password+ "';";
       boolean check = Connections.RunNonQuery(update); 
         if (check){
             Tools.MsgBoxInfo("Username "+ Username+ " has been updated" ,"Update");
         }
     }
     
      public void Delete(){
     String delete = "Delete from Loginl where Username = '" + Username + "' ;";
     boolean check = Connections.RunNonQuery(delete);
      if (check){
          Tools.MsgBoxInfo("User "+Username + " has been deleted", "Delete");
      }
     }
      
      
      
    
      
    
    
}