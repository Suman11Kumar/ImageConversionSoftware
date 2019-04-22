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
    private javax.swing.JLabel Percent;
    private javax.swing.JPanel main;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField NameOfImage;
    
    public void run(javax.swing.JPanel TextConverter,Container container)
    {
        main = new javax.swing.JPanel();
        NameOfImage = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        restoreImage = new javax.swing.JButton();
        saveImage = new javax.swing.JButton();
        Percent = new javax.swing.JLabel();

        TextConverter.setBackground(new java.awt.Color(204, 204, 255));
        //TextConverter.getContentPane().setLayout(null);

        main.setBackground(new java.awt.Color(204, 204, 255));
        main.setLayout(new javax.swing.BoxLayout(main, javax.swing.BoxLayout.Y_AXIS));
        main.setPreferredSize(new java.awt.Dimension(250, 500));

        NameOfImage.setBackground(new java.awt.Color(204, 255, 255));
        NameOfImage.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        NameOfImage.setMaximumSize(new java.awt.Dimension(400, 40));
        main.add(NameOfImage);
        main.add(jProgressBar1);

        restoreImage.setBackground(new java.awt.Color(204, 204, 204));
        restoreImage.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        restoreImage.setText("Restore Image");
        restoreImage.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreImageActionPerformed(evt);
            }
            private void restoreImageActionPerformed(ActionEvent evt) {
                new Thread(new thread1()).start();  //To change body of generated methods, choose Tools | Templates.
            }
        });
        main.add(restoreImage);

        saveImage.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        saveImage.setText("Save Image");
        saveImage.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageActionPerformed(evt);
            }
        });
        main.add(saveImage);

        Percent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Percent.setText("100%");
        main.add(Percent);

        TextConverter.add(main);
        main.setBounds(0, 0, 698, 416);
    }
    private void saveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
  
    } 
      
    private  class thread1 implements Runnable{
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
}
    
