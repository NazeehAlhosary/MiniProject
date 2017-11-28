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
            +"Status='Available',"
            + " where ISBN=" +ISBN +"AND CardNumber= "+CardNumber +";";
     boolean check = Connections.RunNonQuery(update);
     if (check){
         Tools.MsgBoxInfo("Book "+ISBN+" is now available", "Update Status");
     }
    }
     public void UpdateStatusUnavailable(){
    String update = "Update History set "
            +"Status='Unavailable',"
            + " where ISBN=" +ISBN +"AND CardNumber= "+CardNumber +";";
     boolean check = Connections.RunNonQuery(update);
     if (check){
         Tools.MsgBoxInfo("Book "+ISBN+" is now unavailable", "Update Status");
     }
    }
    
}
     
     




