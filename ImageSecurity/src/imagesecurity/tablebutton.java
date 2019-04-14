/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity;

/**
 *
 * @author max
 */
import java.awt.Component;
import java.awt.Container;
import javax.swing.table.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import javax.swing.JScrollPane;
public class tablebutton {
    JTable table;
    public tablebutton(javax.swing.JPanel history,Container container)
    {
       
     // history.setBackground(new java.awt.Color(191, 181, 173));
     // history.setLayout(null);
        
        
        
        
        
        Object [][]data={{"1","max","click here"},
                            {"2","ahmad","main bhi hun"},   
          
          };
          String[] col={"Image","Image Details","Restoration"};
          JTable table=new JTable(data,col);
          table.setRowHeight(100);
          table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
          table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JTextField()));
          table.getColumnModel().getColumn(0).setCellRenderer(new Renderer());
          JScrollPane pane=new JScrollPane(table);
          
          history.add(pane);
          
         //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
}

class  ButtonRenderer extends JButton implements TableCellRenderer
{
    public ButtonRenderer()
    {
          setOpaque(true);
          
    }
    
    
    
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus,int row, int column)
      { 
            setText((obj==null)?"":obj.toString());
       return this;
      }

}

class ButtonEditor extends DefaultCellEditor
{
     protected JButton btn;
     protected String lbl;
     protected Boolean clicked;

    public ButtonEditor(JTextField txt) {
        
        super(txt);
        btn=new JButton();
        btn.setOpaque(true);
        
        btn.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              fireEditingStopped();
          }
        });
        
        
        
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj, boolean isSelected, int row, int column) {
      
        lbl=(obj==null)?"":obj.toString();
        btn.setText(lbl);
        clicked=true;
        
        return btn;
    }

    @Override
    public Object getCellEditorValue() {
        
        if(clicked)
        {
              JOptionPane.showMessageDialog(btn,lbl+"clicked");
        }
        clicked=false;
        
        return new String(lbl);
        
            }

    @Override
    public boolean stopCellEditing() {
        clicked=false;
        return super.stopCellEditing(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void fireEditingStopped() {
        
        super.fireEditingStopped(); //To change body of generated methods, choose Tools | Templates.
    }

    private Object String(String lbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     
}

//for image 

class Renderer extends DefaultTableCellRenderer
{
      JLabel  lbl=new JLabel();
      ImageIcon []images={new ImageIcon("C:\\Users\\max\\Desktop\\capture.JPG"),new ImageIcon("C:\\Users\\max\\Desktop\\ab.JPG)")};
      

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       lbl.setIcon(images[row]);
       return lbl;
    }
      
}
