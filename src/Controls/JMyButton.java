package Controls;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JTextField;
public class JMyButton extends JButton {
    
    public  JMyButton (){

        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(new Color(255 , 255 , 255));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
//        public  JMyButton (int size){
//        setOpaque(false);
//    }
    @Override
    protected void paintComponent(Graphics g){
    g.setColor(new Color(15, 80 ,90));
    g.fillRoundRect(0, 0, getWidth()-1 , getHeight()-1 , 25, 25);
    super.paintComponent(g);
    }
    
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(new Color(15, 80 ,90));
        g.drawRoundRect(0, 0, getWidth()-1 , getHeight()-1 , 25, 25);
        
    }

    
}
