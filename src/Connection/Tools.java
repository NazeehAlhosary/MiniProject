package Connection;


//import com.sun.xml.internal.ws.util.ReadAllStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.JSplitPane.RIGHT;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;

public class Tools {
 
 //Normal icon, without any title.
  public static void MsgBox(String message){
     JOptionPane.showMessageDialog(null, message);
 }
 // Normal info icon i , with title
  public static void MsgBoxInfo(String message, String title){
     JOptionPane.showMessageDialog(null, message,title,JOptionPane.INFORMATION_MESSAGE);
 }
 // Error icon /i\, with title
  public static void MsgBoxErrorI(String message, String title){
     JOptionPane.showMessageDialog(null, message,title,JOptionPane.WARNING_MESSAGE);
 }
 // Error icon /x\, with title
  public static void MsgBoxErrorX(String message, String title){
     JOptionPane.showMessageDialog(null, message,title,JOptionPane.ERROR_MESSAGE);
 }
 // Box without any icon, with title and message
  public static void MsgBoxWithout(String message, String title){
     JOptionPane.showMessageDialog(null, message,title,JOptionPane.CLOSED_OPTION);
 }
 // Question mark icon ? , with title
  public static void MsgBoxQuestion(String message, String title){
     JOptionPane.showMessageDialog(null, message,title,JOptionPane.QUESTION_MESSAGE);
 }
 // Error icon /i\, with title
  public static void MsgBoxError1(String message, String title){
     JOptionPane.showMessageDialog(null, message,title,JOptionPane.WHEN_FOCUSED);
 }
 
 public static boolean YesNoChooserBox(String message,String title){ //ConfirmBox
     int result = JOptionPane.showConfirmDialog(null, message,title,JOptionPane.INFORMATION_MESSAGE);
     if(result == JOptionPane.YES_OPTION ) {
        return true;
     } else {
     return false;
     }
 }
 public static Object InputBox(String Message,String title){
      Object result = JOptionPane.showInputDialog(null , Message,title,JOptionPane.INFORMATION_MESSAGE);
      return result;
  }
   public static Object InputBoxErrorI(String Message  , String title){
      Object result = JOptionPane.showInputDialog(null  , Message ,title, JOptionPane.CANCEL_OPTION);
      return result;
  }
   public static Object InputBoxWithout(String Message,String title){
      Object result = JOptionPane.showInputDialog(null , Message,title,JOptionPane.CLOSED_OPTION);
      return result;
  }
  public static Object InputBoxErrorX(String Message,String title){
      Object result = JOptionPane.showInputDialog(null , Message,title,JOptionPane.ERROR_MESSAGE);
      return result;
  }
  
 public static void NewFolder (String FolderName){
     File f = new File(FolderName);
     f.mkdir();
 }
 
 public static void NewFolderWithPath (String FolderName , String path){
     File f = new File(path + "/" +FolderName);
     f.mkdir();
 }
 
 public static void OpenForm (JFrame form){
     
     try {
      form.setLocationRelativeTo(null);
      Image img =  ImageIO.read(Tools.class.getResource("001.png"));
      form.setIconImage(img);
      form.setDefaultCloseOperation(2);
      form.getContentPane().setBackground(Color.WHITE);
      form.setVisible(true);
     } catch (IOException e) {
         JOptionPane.showMessageDialog(null, e);
     }
    
 }
  public static void OpenFormWithNewICON (JFrame form , String Icon){   
     try {
      form.setLocationRelativeTo(null);
      Image img =  ImageIO.read(Tools.class.getResource(Icon));
      form.setIconImage(img);
      form.setDefaultCloseOperation(2);
      form.getContentPane().setBackground(Color.WHITE) ;
      form.setVisible(true);
     } catch (IOException e) {
         JOptionPane.showMessageDialog(null, e);
     }
    
 }
  // Select an image from your computer
 
  public static void PutImageInLable(String ImageName,JLabel lable,int lableLength ,int lableWidth){
      try {
           Image img = ImageIO.read(Tools.class.getResource(ImageName));
           Image newImg = img.getScaledInstance(lableLength, lableWidth, Image.SCALE_AREA_AVERAGING);
           ImageIcon icon = new ImageIcon(newImg);
           lable.setIcon(icon);
      } catch (IOException ex) {
          Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
  public static void SelectImageInLable(JLabel lable,int lableLength ,int lableWidth){
      try {
           JFileChooser file = new JFileChooser();
           FileNameExtensionFilter filter = new FileNameExtensionFilter ("Image Files","jpg","png","ico");// File title, formulas
           file.setFileFilter(filter);
           file.showDialog(null, "Select Image"); // Button title
           Image img = ImageIO.read(file.getSelectedFile());
           Image newImg = img.getScaledInstance(lableLength, lableWidth, Image.SCALE_AREA_AVERAGING);
           ImageIcon icon = new ImageIcon(newImg);
           lable.setIcon(icon);
      } catch (IOException ex) {
          Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
   public static void ScreenShot (String ImageName, JFrame form){
     try {
         form.setState(1);
         Robot r = new Robot();
         Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
         BufferedImage img;
         img = r.createScreenCapture(rec);
         ImageIO.write(img, "jpg", new File(ImageName + ".jpg"));
         form.setState(0);
     } catch (Exception ex) {
         Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
 public static void ScreenShotWhitForm (String ImageName){
     try {
         Robot r = new Robot();
         Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
         BufferedImage img = r.createScreenCapture(rec);
         ImageIO.write(img, "jpg", new File(ImageName + ".jpg"));
     } catch (Exception ex) {
         Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
     }
 }

 public static void SetTableHeader(JTable Table){
     
     Table.getTableHeader().setBackground(new Color (0,0,100));
     Table.getTableHeader().setForeground(Color.white);
     Table.getTableHeader().setReorderingAllowed(false); // Change column order
     Table.getTableHeader().setResizingAllowed(false);  // Change column size

     /* 
     JTableHeader t = Table.getTableHeader();
               t.setBackground(Color.GRAY);
               t.setForeground(Color.white);
               t.setFont(new Font ("Tahome", Font.ITALIC,20));
     */
     
 }
 
 public static void ToDay(JLabel lable){
     // Date
     /*
     SimpleDateFormat("yyyy/MM/dd");
     yy or yyyy for Year
     MM for Months
     dd for Days
     hh for Hours
     mm for Minutes
     ss for Seconds
     a to show am or pm
     */
        java.util.Date Today = new java.util.Date();
        SimpleDateFormat SMF = new SimpleDateFormat("yyyy/MM/dd");
        String T = String.valueOf(SMF.format(Today));
        lable.setText(T);
 }
 public class Table {

    public int columns;
    public Object[][] Items;
    
    public Table(int columns){
        this.columns = columns;
        Items = new Object[0][columns];
    }
    
    public void addNewRow(Object row[]){
        Object TempItems[][] = Items;
        Items = new Object[Items.length + 1][columns];
        for (int x = 0; x < TempItems.length ; x++){
            Items[x] = TempItems[x];
        }
        Items[Items.length - 1] = row;
    }
    
    public void printItems(){
        for(Object objs[] : Items){
            for(Object obj : objs){
                System.out.print(obj + " ; ");
            }
            System.out.println();
        }
    }
    
    public void editRow(int rowIndex, int columnIndex, Object newData){
        Items[rowIndex][columnIndex] = newData;
    }
    
}
 public static void ClearTexts(Container form){
     for (Component c : form.getComponents()){
       if (c instanceof JTextField) {
           JTextField text = (JTextField) c;
           text.setText("");
       }
       else if ( c instanceof Container){
           ClearTexts((Container)c);
       }
     }
 
 }
 
 public static void CreateEmptyFile(String FileName)
 {
    try {
         File f = new File(FileName + ".txt");
         f.createNewFile();
     } catch (IOException ex) {
         Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
 
  public static void CreateFile(String FileName , Object data []){
     try {
         try (PrintWriter p = new PrintWriter(FileName + ".txt")) {
             for (Object o : data){
                 p.println(o);
             }
         }
     } catch (FileNotFoundException ex) {
         Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
     }
   

  }
  public static void CreatFiles(String FileNames[], Object allData[] []  ){
      for (int x = 0; x < FileNames.length; x++) {
          CreateFile(FileNames[x], allData[x]);
          
      }
  }

 
  public static String GetNumbers (String text) {
   String val = "";
   for (char c : text.toCharArray()){
     if (c=='0' || c=='1'|| c=='2' || c=='3'||c=='4' || c=='5'||c=='6' || c=='7'||c=='8' || c=='9'){
      val +=c;
     }
   }
   return (val);
      
  }
  public static int GetNumbers (Object text) {
   String val = "";
   for (char c : text.toString().toCharArray()){
     if (c=='0' || c=='1'|| c=='2' || c=='3'||c=='4' || c=='5'||c=='6' || c=='7'||c=='8' || c=='9'){
      val +=c;
     }
   }
   return Integer.parseInt(val);
      
  }
public static String RemoveNumbers (Object text) {
   String val = "";
   for (char c : text.toString().toCharArray()){
     if ( !(c=='0' || c=='1'|| c=='2' || c=='3'||c=='4' || c=='5'||c=='6' || c=='7'||c=='8' || c=='9')){
      val +=c;
     }
   }
   return(val);
      
  }
 public static void CreateEmptyFiles(String Names[]){
     for (String s : Names){
         CreateEmptyFile(s);
     }
 }
 
  String text;
  private String inversetext;
  String texts[];
  String textArray;
 public void PrintCharbyChar(){
 for(char c : text.toCharArray()){
     System.out.println(c);
  }
 }
 public void PrintCharbyCharInverse() {
 StringBuilder sb = new StringBuilder (text);
 inversetext = sb.reverse().toString();
 for (char c : inversetext.toCharArray()){
     System.out.println(c);
 }
 }
 public void PrintArry(){
  for (String s : texts) {
      System.out.println(s);
  }
 }
 public String SetFromArray(){
  for(String s : texts){
    textArray += s + " || " ;
   }
  return textArray;
 }
 public class MergeArrays{

  public  Object array1[];
  public  Object array2[];
  private int a1,a2;
    public MergeArrays (Object array1[],Object array2[]){
    this.array1 = array1;
    this.array2 = array2;
    }
    public Object[] Merge(){
    a1 = array1.length;
    a2 = array2.length;
    Object arrayR[] = new Object [a1 + a2 ];
    System.arraycopy(array1, 0, arrayR, 0, a1);
    System.arraycopy(array2, 0, arrayR, a1, a2);
    return arrayR;
    }
}
 
}