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
 * @author Nazeeh
 */
public class Books {
    private int ISBN;
    private String Title;
    private String Author;
    private String Publisher;
    private String Shelf;
    private String Genre;
    private String Status;
    private int NumberOfBorrowing;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public String getShelf() {
        return Shelf;
    }

    public void setShelf(String Shelf) {
        this.Shelf = Shelf;
    }

    public String getGenre() {
        return Genre;
    }

    
    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getNumberOfBorrowing() {
        return NumberOfBorrowing;
    }

    public void setNumberOfBorrowing(int NumberOfBorrowing) {
        this.NumberOfBorrowing = NumberOfBorrowing;
    }
 
    public void Add(){
        String insert = "Insert into Books VALUES ("
                + ISBN +","
                +"'"+Title+"',"
                +"'"+Author+"',"
                +"'"+Publisher+"',"
                +"'"+Shelf+"',"
                +"'"+Genre+"',"
                +"'"+Status+"',"
                + NumberOfBorrowing +");";
        boolean check = Connections.RunNonQuery(insert);
        if (check){
            Tools.MsgBoxInfo("Book has been added","Add");
        }
    }
    public void Update(){
    String update = "Update Books set "
            +"Title='" + Title +"',"
            +"Author='"+Author+"',"
            +"Publisher='"+Publisher +"',"
            +"Shelf='"+Shelf +"',"
            +"Genre='"+Genre +"',"
            +"Status='"+Status+"',"
            +"NumberOfBorrowing=" + NumberOfBorrowing
            + " where ISBN=" +ISBN +";";
     boolean check = Connections.RunNonQuery(update);
     if (check){
         Tools.MsgBoxInfo("Book "+ISBN + " has been updated", "Update");
     }
    }
    public void Delete(){
    String delete = "Delete from Books where ISBN=" + ISBN + ";";
    boolean check = Connections.RunNonQuery(delete);
     if (check){
         Tools.MsgBoxInfo("Book "+ISBN + " has been deleted", "Delete");
     }
    }
    
    public void UpdateBorrowing(){
         String update = "Update Books set "
            +"Status='"+"Out"+"',"
            +"NumberOfBorrowing=" + NumberOfBorrowing
            + " where ISBN=" +ISBN +";";
     boolean check = Connections.RunNonQuery(update);
     if (check){
         Tools.MsgBoxInfo("Book "+ISBN + " has been borrowed", "Update");
     }
}
     public void UpdateReturned(){
         String update = "Update Books set "
            +"Status='"+"In"+"',"
            + " where ISBN=" +ISBN +";";
     boolean check = Connections.RunNonQuery(update);
     if (check){
         Tools.MsgBoxInfo("Book "+ISBN + " has been returned", "Update");
     }
}
    public void GetTableInfo(String TableNameInDB, JTable table){
        Connections.FillTable(TableNameInDB, table);
    }
    
    public void GetSomeRows(String Statement, JTable table){
    Connections.FillCustomRows(Statement, table);
    }
}
