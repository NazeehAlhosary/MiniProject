/**
 * 
 * This class made by M Nazeeh Alhosary.
 *          13/11/2017
 */

package Connection; // Please change package name...

import static com.sun.management.jmx.Trace.isSelected;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Nazeeh
 */
public class TableNewColors extends DefaultTableCellRenderer{
private Component componente;

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        componente = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
        componente.setForeground(Color.black);
        if (i %2 ==0){
           componente.setBackground(new Color (204,204,255));
        }
        else {
        componente.setBackground( new Color (255,255,255));
        }
        if (bln){
           componente.setBackground(Color.GRAY);
           componente.setForeground(Color.white);
        }
        return componente;
    }
    
    /*
    Then in the form constructor we put
    TableNme.setDefaultRenderer(Object.class, new TableNewColors());

    */
    /* Change table header font, color and size
     JTableHeader t = TableName.getTableHeader();
               t.setBackground(Color.GRAY);
               t.setForeground(Color.white);
               t.setFont(new Font ("Tahome", Font.ITALIC,20));
    */
    
    
    
}
