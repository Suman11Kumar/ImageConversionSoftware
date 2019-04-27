/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity.TextToImage;
import imagesecurity.Global;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
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
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel NameOfText;
    private String path;
    private final Container container;
    
    public TextConversion_layout(javax.swing.JPanel TextConverter,Container container){
        this.container = container;
        build(TextConverter);
    }
    
    private void build(javax.swing.JPanel TextConverter)
    {
        path = null;
        main = new javax.swing.JPanel();
        NameOfText = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        restoreImage = new javax.swing.JButton();
        saveImage = new javax.swing.JButton();
        Percent = new javax.swing.JLabel();

        TextConverter.setBackground(new java.awt.Color(191, 181, 173));
        TextConverter.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER, 100, 100));
        //TextConverter.getContentPane().setLayout(null);

        main.setBackground(new java.awt.Color(204, 204, 255));
        main.setLayout(new javax.swing.BoxLayout(main, javax.swing.BoxLayout.Y_AXIS));
        main.setMaximumSize(new java.awt.Dimension(300, 200));
        main.setPreferredSize(new java.awt.Dimension(300, 200));

        NameOfText.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        NameOfText.setBorder(BorderFactory.createEmptyBorder(20, 20, 30, 30));
        main.add(NameOfText);
        
        ProgressBar.setBorder(BorderFactory.createEmptyBorder(20, 20, 30, 30));
        ProgressBar.setBackground(new java.awt.Color(153, 153, 0));
        ProgressBar.setMaximumSize(new java.awt.Dimension(250, 50));
        ProgressBar.setMinimumSize(new java.awt.Dimension(10, 50));
        ProgressBar.setPreferredSize(new java.awt.Dimension(146, 50));
        main.add(ProgressBar);

        restoreImage.setBackground(new java.awt.Color(204, 204, 204));
        restoreImage.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        restoreImage.setText("Restore Image");
        restoreImage.setBorder(BorderFactory.createEmptyBorder(20, 20, 30, 30));
        restoreImage.setMargin(new java.awt.Insets(10, 50, 10, 50));
        restoreImage.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreImageActionPerformed(evt);
            }
            private void restoreImageActionPerformed(ActionEvent evt) {
                new Thread(new progress()).start();  //To change body of generated methods, choose Tools | Templates.
            }
        });
        main.add(restoreImage);

        saveImage.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        saveImage.setText("Save Image");
        saveImage.setMargin(new java.awt.Insets(10, 50, 10, 50));
        saveImage.setHorizontalAlignment(SwingConstants.CENTER);
        saveImage.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageActionPerformed(evt);
            }
        });
        main.add(saveImage);

        Percent.setBackground(new java.awt.Color(51, 255, 51));
        Percent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Percent.setHorizontalAlignment(SwingConstants.LEFT);
        Percent.setText("Convertion Status...");
        Percent.setMaximumSize(new java.awt.Dimension(32800, 50));
        Percent.setMinimumSize(new java.awt.Dimension(34, 50));
        Percent.setPreferredSize(new java.awt.Dimension(32800, 50));
        Percent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        main.add(Percent);

        TextConverter.add(main);
        //main.setBounds(0, 0, 698, 416);
    }
    private void saveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
  
    } 
       
    public void loadData(){

        new Thread(new textchoose()).start();
    }
    
    private class progress implements Runnable{

        @Override
        public void run() {
            restoreImage.setEnabled(false);
            Global tmp = Global.getInstance();
            for (int i=0; i<=100; i++){ //Progressively increment variable i
                ProgressBar.setValue(i); //Set value
                ProgressBar.repaint();
                Percent.setText("Convertion Status..." + i + "%");//Refresh graphics//Refresh graphics
                try{Thread.sleep(50);} //Sleep 50 milliseconds
                catch (InterruptedException err){}
            }
        }
    }
    
    private class textchoose implements Runnable{

        @Override
        public void run() {
            Global tmp = Global.getInstance();
            path = tmp.getTextFile();
            //System.out.println("Path is: " + path);
            try
            {
                if(path != null){
                    NameOfText.setText(path.substring(path.lastIndexOf('\\')+1));
                    //System.out.println(name.getText());
                    File file = new File(path);
                }
                else
                {
                    /*JOptionPane.showMessageDialog(null, "Select Text File");
                    CardLayout cards = (CardLayout) container.getLayout();
                    cards.show(container, "card7");*/
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
    
