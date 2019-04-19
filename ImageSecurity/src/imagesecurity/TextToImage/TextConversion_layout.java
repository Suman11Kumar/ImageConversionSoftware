/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity.TextToImage;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/**
 *
 * @author Suman
 */
public class TextConversion_layout
{
    private Timer timer; 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton restoreImage;
    private javax.swing.JButton saveImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField NameOfImage;
    
    public void run(javax.swing.JPanel TextConverter,Container container)
    {
        jPanel1 = new javax.swing.JPanel();
        NameOfImage = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        restoreImage = new javax.swing.JButton();
        saveImage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        TextConverter.setBackground(new java.awt.Color(204, 204, 255));
        //TextConverter.getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        NameOfImage.setBackground(new java.awt.Color(204, 255, 255));
        NameOfImage.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        NameOfImage.setMaximumSize(new java.awt.Dimension(400, 40));
        jPanel1.add(NameOfImage);
        jPanel1.add(jProgressBar1);

        restoreImage.setBackground(new java.awt.Color(204, 204, 204));
        restoreImage.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
       restoreImage.setText("Restore Image");
        restoreImage.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreImageActionPerformed(evt);
            }

                    private void restoreImageActionPerformed(ActionEvent evt) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
        });
        jPanel1.add(restoreImage);

        saveImage.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        saveImage.setText("Save Image");
        saveImage.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageActionPerformed(evt);
            }
        });
        jPanel1.add(saveImage);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("100%");
        jPanel1.add(jLabel1);

        TextConverter.add(jPanel1);
        jPanel1.setBounds(0, 0, 698, 416);



    }
    private void saveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
  
    } public  class restoreImage implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            new Thread(new thread1()).start(); 
        }
    }
    
     public  class thread1 implements Runnable{
        @Override
        public void run(){
            for (int i=0; i<=100; i++){ //Progressively increment variable i
                jProgressBar1.setValue(i); //Set value
                jProgressBar1.repaint(); //Refresh graphics
                try{Thread.sleep(50);} //Sleep 50 milliseconds
                catch (InterruptedException err){}
            }
        }
    }
    };
    
