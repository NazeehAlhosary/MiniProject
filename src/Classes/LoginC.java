/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Connection.Connections;
import static Connection.Connections.SetConnection;
import Connection.Tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mnaze
 */
public class LoginC {
    private int CardNumber;
    private String PassWord;
    private String Question;
    private String Answer;

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int CardNumber) {
        this.CardNumber = CardNumber;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = Tools.hashPassword(PassWord);
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }
    public void Add(){
     String insert = "Insert customerlogin  VALUES ("
                +CardNumber+", "
                 +"'"+ PassWord +"',"
                 +"'"+Question+"'"
                 +"'"+ Answer +"' );";
          boolean check = Connections.RunNonQuery(insert); 
            if (check){
             Tools.MsgBoxInfo("Customer "+ CardNumber+ " has been registered" ,"Registeration");
            }
    }
   
    public void UpdatePassWord(){
    String update = "Update customerlogin set "
             +"PassWord = '"+PassWord+"'"
             + " where CardNumber=" + CardNumber;
       boolean check = Connections.RunNonQuery(update); 
         if (check){
             Tools.MsgBoxInfo("PassWord has been updated" ,"Update");
         }
    }
    
    public String ReturnPassWord() {
       return Connections.ReturnPassWord(CardNumber,Question,Answer);
    }
    
}

