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
 * @author M Nazeeh Alhosary
 */
public class CustomerLogIn {
   private int CardNumber;
   private String PassWord;
   private String Question;
   private String Answer;
   private String Email;

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
    
    public boolean Add(){
    String insert = "Insert into customerlogin VALUES ("
                + CardNumber + ", "
                +"'"+ Email +"', "
                +"'"+ PassWord + "', "
                +"'"+ Question + "', "
                +"'"+ Answer + "' ) ;";
        boolean check = Connections.RunNonQuery(insert);
        if (check) {
           Tools.MsgBoxInfo("New Access for the cardholder with the number ("+CardNumber+") has been added", "Registration succesful");
           return true;
        }
        return false;
    }
    public void ChangePass(String newPassWord){
        String Update = "Update customerlogin set PassWord='"+ newPassWord+"' where " 
                + "Email= '"+ Email + "' ;";
         boolean check=  Connections.RunNonQuery(Update);
          if (check){
             Tools.MsgBoxInfo("Done","Done");
     }
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
