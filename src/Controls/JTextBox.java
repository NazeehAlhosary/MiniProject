/**
 * 
 * This class made by M Nazeeh Alhosary.
 *          1/5/2017
 */
package Controls;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextField;
public class JTextBox extends JTextField {
    
    public  JTextBox (){
//        super (size);
        setOpaque(false);
    }
        public  JTextBox (int size){
        super (size);
        setOpaque(false);
    }
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
