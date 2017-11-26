/**
 * 
 * This class made by M Nazeeh Alhosary.
 *          1/5/2017
 */
package Controls;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JComboBox;
import javax.swing.JTextField;
public class JCombo extends JComboBox {
    
    public  JCombo (){
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
//        public  JCombo (int size){
//        setOpaque(false);
//    }
    @Override
    protected void paintComponent(Graphics g){
    g.setColor(getBackground());
    setBackground(new Color(66 , 00 , 66));
    setForeground(new Color(255 , 255 , 255));
    g.fillRoundRect(0, 0, getWidth()-1 , getHeight()-1 , 20, 20);
    super.paintComponent(g);
    }
    
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(new Color(66 , 00 , 66));
        g.drawRoundRect(0, 0, getWidth()-1 , getHeight()-1 , 20, 20);
        
    }

    
}
