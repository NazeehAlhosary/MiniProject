/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;
import Classes.*;
import Connection.Tools;
import Forms.FrmBooks;
/**
 *
 * @author Nazeeh
 */
public class LibrarySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Mini Project");
       Tools.OpenForm(new FrmBooks());
        Books b = new Books();
        b.setISBN(1);
        b.setAuthor("Martin");
        b.setTitle("Anythings");
        b.setGenre("test");
        b.setNumberOfBorrowing(3);
        b.setPublisher("test");
        b.setStatus("test");
        b.setShelf("test");
      //  b.Add();
}
    

}
