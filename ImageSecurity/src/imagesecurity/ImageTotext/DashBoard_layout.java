/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity.ImageTotext;

import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author Suman
 */
public class DashBoard_layout {
    private javax.swing.JButton RestoreImage;
    private javax.swing.JButton ImageToText;
    private javax.swing.JButton TextToImage;

    public void run(javax.swing.JPanel DashBoard,Container container){
        
        DashBoard.setBackground(new java.awt.Color(191, 181, 173));
        DashBoard.setLayout(null);
        RestoreImage = new javax.swing.JButton();
        ImageToText = new javax.swing.JButton();
        TextToImage = new javax.swing.JButton();
        RestoreImage.setBackground(new java.awt.Color(150, 145, 183));
        RestoreImage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RestoreImage.setText("Unable to Restore Image");
        RestoreImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardLayout card = (CardLayout) container.getLayout();
                card.show(container, "card5");
            }
        });
        DashBoard.add(RestoreImage);
        RestoreImage.setBounds(250, 220, 280, 60);

        ImageToText.setBackground(new java.awt.Color(150, 145, 183));
        ImageToText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ImageToText.setText("Image Converter");
        ImageToText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardLayout card = (CardLayout) container.getLayout();
                card.show(container, "card3");
            }
        });
        DashBoard.add(ImageToText);
        ImageToText.setBounds(70, 100, 280, 60);

        TextToImage.setBackground(new java.awt.Color(150, 145, 183));
        TextToImage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TextToImage.setText("Text Converter");
        TextToImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        DashBoard.add(TextToImage);
        TextToImage.setBounds(440, 100, 280, 60);
    
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
