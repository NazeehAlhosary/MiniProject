/**
 * 
 * This class made by M Nazeeh Alhosary.
 *          1/5/2017
 */
package Controls;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComboBox;
import javax.swing.JTextField;
public class JCombo extends JComboBox {
    
    public  JCombo (){
        setOpaque(false);
    }
//        public  JCombo (int size){
//        setOpaque(false);
//    }
    @Override
    protected void paintComponent(Graphics g){
    g.setColor(getBackground());
    g.fillRoundRect(0, 0, getWidth()-1 , getHeight()-1 , 20, 20);
    super.paintComponent(g);
    }
    
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(Color.blue);
        g.drawRoundRect(0, 0, getWidth()-1 , getHeight()-1 , 20, 20);
        
    }

    
}
