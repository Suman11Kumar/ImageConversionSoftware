/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import  java.lang.Thread;

/**
 *
 * @author max
 */
public class camera extends javax.swing.JFrame {

    protected Dimension ds=new Dimension(700,700);
    protected Dimension cs=WebcamResolution.VGA.getSize();
    protected Webcam wcam=Webcam.getDefault();
    protected WebcamPanel wpanel=new WebcamPanel(wcam,ds,false);
    
    public camera() {
        initComponents();
        wcam.setViewSize(cs);
        wpanel.setFillArea(true);
        panelcam.setLayout(new FlowLayout());
        panelcam.add(wpanel);        
    }
    
    public void start1()
    {
        Thread t=new Thread(new Runnable(){
            @Override
            public void run() {
                wpanel.start();
            }
        });
        t.setDaemon(true);
        t.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelcam = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        capture = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        panelcam.setBackground(new java.awt.Color(0, 0, 0));
        panelcam.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout panelcamLayout = new javax.swing.GroupLayout(panelcam);
        panelcam.setLayout(panelcamLayout);
        panelcamLayout.setHorizontalGroup(
            panelcamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        panelcamLayout.setVerticalGroup(
            panelcamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel1.add(panelcam, java.awt.BorderLayout.PAGE_START);

        capture.setText("Capture");
        capture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(capture, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(capture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void captureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureActionPerformed
      try{
            File file=new File(String.format("capture-%d.jpg",System.currentTimeMillis()));
        
            ImageIO.write(wcam.getImage(),"JPG", file);
            
            Global tmp = Global.getInstance();
            tmp.setImageFile(file);
            
        }
        catch(IOException e)
        {
             JOptionPane.showMessageDialog(this ,"nahi ho payega","camera",0);
        }
    }//GEN-LAST:event_captureActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton capture;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelcam;
    // End of variables declaration//GEN-END:variables
}
