/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity.ImageTotext;

import imagesecurity.ConnectionManager;
import imagesecurity.MyConnection;
import java.awt.Container;
import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author max
 */
public class tableimage {
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JTable jTable1;
 //   private ImageIcon image;
    private ImageIcon image,myimage;
    private Image img1,img2;
    private byte[] image1;
//    private String[][] a;
    
    public void run(javax.swing.JPanel ViewHistory,Container container)
    {
         jPanel2 = new javax.swing.JPanel();
         jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
       // image =new ImageIcon("C:\\Users\\max\\Desktop\\max.jpg");
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        
  //      fetch();
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 994, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );
         
       /* getContentPane()*/container.add(jPanel2, "card9");
        
       jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                /*{"image1.jpg"},
                {"image2.jpg"},
                {"image3.jpg"},
                {"image4.jpg"}*/
            },
            new String [] {
                "Image Detail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showname();
        
        
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
         ViewHistory.add(jPanel1);

        jPanel3.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jButton2.setText("Restore Image");
        jPanel3.add(jButton2, java.awt.BorderLayout.PAGE_END);

        ViewHistory.add(jPanel3);

        
        
        
    }
     private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
       
      int row=jTable1.getSelectedRow();
       String t=jTable1.getModel().getValueAt(row,0).toString();
      System.out.println(t);
      image1=fetchimage(t);
      
      /* ImageIcon*/ myimage=new ImageIcon(image1);       
         /*  Image*/ img1=myimage.getImage();
      /* Image*/ img2=img1.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(),Image.SCALE_SMOOTH);    
       image=new ImageIcon(img2);
       jLabel1.setIcon(image);  
         

//  int row=jTable1.getSelectedRow();
     //  String t=jTable1.getModel().getValueAt(row,0).toString();
     //  image=new ImageIcon("C:\\Users\\max\\Documents\\NetBeansProjects\\ImageConversionSoftware\\ImageSecurity\\"+t);
    //   jLabel1.setIcon(image);
    }
     
     
public ArrayList<String> imagename()
{
   ArrayList<String> name=new ArrayList<>();
   
     Connection pa = null;
        ResultSet r = null;
        Statement stmt = null;
        String a;
        try
        {
            String query1="select Image_Name from Image_Information where User_Name='max'";
            pa=ConnectionManager.getConnection(); //prepareStatement(query1);
            stmt=pa.createStatement();
            r=stmt.executeQuery(query1);
            System.out.println("Hello 1");
            while(r.next())
            {
               
                name.add(new String(r.getString("Image_Name")));
            }  
        }
         
       catch(Exception e) 
       {
           JOptionPane.showMessageDialog(null,e);
       }
    return name;

}
public void showname()
{
    ArrayList<String>name=imagename();
    
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    Object[] row=new Object[1];
    for(int i=0;i<name.size();i++)
    { row[0]=name.get(i);
       model.addRow(row);
    }

}
     
     
     
     
     
     
    public byte[] fetchimage(String t)
    {    byte[] image = null;
        String a;
        PreparedStatement pa = null;
        ResultSet r = null;
        Statement stmt = null;
        int i=0;
        try
        {
            String query1="select  Image from Image_Information where User_Name='max' and Image_Name=?";
            pa=(PreparedStatement) ConnectionManager.getConnection().prepareStatement(query1); //prepareStatement(query1);
           // stmt=pa.createStatement();
          //  r=stmt.executeQuery(query1);
            pa.setString(1,t);
            r=pa.executeQuery();
            System.out.println("Hello 1");
            while(r.next())
            {
                image=r.getBytes("image");
               // System.out.println( + "hello");
            }  
        }
         
       catch(Exception e) 
       {
           JOptionPane.showMessageDialog(null,e);
       }
       
   return image; 
}
}