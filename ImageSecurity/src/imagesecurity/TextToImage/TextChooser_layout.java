/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imagesecurity.TextToImage;

/**
 *
 * @author max
 */

import java.io.File;
import imagesecurity.ImageTotext.*;
import imagesecurity.TextToImage.TextConversion_layout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;


public class TextChooser_layout {
    
    
 private javax.swing.JButton browseButtton; 
     private javax.swing.JLabel fileName;
      private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextButton;
    private Container container;
    
    
     public void run(javax.swing.JPanel TextChooser,Container container)
     {
     
     jPanel1 = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        browseButtton = new javax.swing.JButton();
        fileName = new javax.swing.JLabel();
        
        this.container =container;
        
         jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                  
              nextButtonActionPerformed(evt);
            }

   /*      private void nextButtonActionPerformed(ActionEvent evt) {
             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }*/
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("               Choose Text");

        browseButtton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        browseButtton.setText("Browse");
        browseButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButttonActionPerformed(evt);
            }
        });

        fileName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(browseButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(browseButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
                 javax.swing.GroupLayout TextChooserLayout = new javax.swing.GroupLayout(TextChooser);
        TextChooser.setLayout(TextChooserLayout);
        TextChooserLayout.setHorizontalGroup(
            TextChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextChooserLayout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        TextChooserLayout.setVerticalGroup(
            TextChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextChooserLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

     
        
    
     
     
     }
     
     public void browseButttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
                     JFileChooser file=new JFileChooser();
                     
         FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text"); 
        file.setFileFilter(filter);
        file.showOpenDialog(null);
       
        //File file=new file("E:\WORK SPACE\import.txt");
        File f = file.getSelectedFile();
        System.out.println(f.getAbsolutePath());
        String name=file.getSelectedFile().getName();
        fileName.setText(name);
    }                                             

   public void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        CardLayout card = (CardLayout)this.container.getLayout();
                   card.show(container,"card8");             
       // TODO add your handling code here:
    }           
     
     
     
     
  
    
}

