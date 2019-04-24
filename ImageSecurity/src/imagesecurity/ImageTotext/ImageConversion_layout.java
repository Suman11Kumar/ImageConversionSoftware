 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity.ImageTotext;

import imagesecurity.Global;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Suman
 */
public final class ImageConversion_layout {
    
    private javax.swing.JPanel main;
    private javax.swing.JLabel ImageLoad;
    private javax.swing.JPanel ImageStatus;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel ConversionStatus;
    private javax.swing.JButton SaveText;
    private javax.swing.JLabel name;
    private javax.swing.JButton convert;
    private String path;
    private Thread t1,t2;
    
    public ImageConversion_layout(JPanel ImageConversion, Container contentPane) {
        build(ImageConversion,contentPane); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void build(javax.swing.JPanel ImageConversion, Container container)
    {
        path = null;
        main = new javax.swing.JPanel();
        SaveText = new javax.swing.JButton();
        ImageLoad = new javax.swing.JLabel();
        ImageStatus = new javax.swing.JPanel();
        ProgressBar = new javax.swing.JProgressBar();
        ConversionStatus = new javax.swing.JLabel();
        convert = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        
        ImageConversion.setBackground(new java.awt.Color(191, 181, 173));
        
        main.setLayout(new javax.swing.BoxLayout(main, javax.swing.BoxLayout.X_AXIS));
        main.setMaximumSize(new java.awt.Dimension(500, 300));
        //main.setMaximumSize(maximumSize);
        ImageLoad.setMaximumSize(new java.awt.Dimension(270, 240));
        ImageLoad.setPreferredSize(new java.awt.Dimension(270, 240));
        ImageLoad.setMinimumSize(new java.awt.Dimension(270, 240));
        ImageLoad.setVerifyInputWhenFocusTarget(false);
        ImageLoad.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        main.add(ImageLoad);
        //Imagechoose();
        
        ImageStatus.setLayout(new javax.swing.BoxLayout(ImageStatus, javax.swing.BoxLayout.Y_AXIS));

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ImageStatus.add(name);
        name.setBorder(BorderFactory.createEmptyBorder(20,0,30,0));
                
        ProgressBar.setBackground(new java.awt.Color(153, 153, 0));
        ProgressBar.setMaximumSize(new java.awt.Dimension(350, 50));
        ProgressBar.setMinimumSize(new java.awt.Dimension(10, 50));
        ProgressBar.setPreferredSize(new java.awt.Dimension(146, 50));
        
        ImageStatus.add(ProgressBar);

        ConversionStatus.setBackground(new java.awt.Color(51, 255, 51));
        ConversionStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ConversionStatus.setHorizontalAlignment(SwingConstants.LEFT);
        ConversionStatus.setText("Convertion Status...");
        ConversionStatus.setMaximumSize(new java.awt.Dimension(32800, 50));
        ConversionStatus.setMinimumSize(new java.awt.Dimension(34, 50));
        ConversionStatus.setPreferredSize(new java.awt.Dimension(32800, 50));
        ImageStatus.add(ConversionStatus);
        ImageStatus.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        convert.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        convert.setText("Convert");
        convert.setMargin(new java.awt.Insets(10, 50, 10, 50));
        convert.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                t2 = new Thread(new progress());
                t2.start();
            }
        });
        ImageStatus.add(convert);
        
        SaveText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SaveText.setText("Save Text File");
        SaveText.setMargin(new java.awt.Insets(10, 50, 10, 50));
        SaveText.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(ImageStatus);
        ImageConversion.add(main);
        ImageConversion.add(SaveText);
        main.setOpaque(true);
    }
   
    public void loadData(){

        new Thread(new imagechoose()).start();
    }
    
    private class progress implements Runnable{

        @Override
        public void run() {
            convert.setEnabled(false);
            Global tmp = Global.getInstance();
            for (int i=0; i<=100; i++){ //Progressively increment variable i
                ProgressBar.setValue(i); //Set value
                ProgressBar.repaint(); //Refresh graphics
                try{Thread.sleep(50);} //Sleep 50 milliseconds
                catch (InterruptedException err){}
            }
        }
    }
    
    private class imagechoose implements Runnable{

        @Override
        public void run() {
            Global tmp = Global.getInstance();
        path = tmp.getImageFile();
        ImageLoad.setSize(270,240);
        System.out.println("Path is: " + path);
        try
        {
            if(path != null){
                name.setText(path.substring(path.lastIndexOf('\\')+1));
                System.out.println(name.getText());
                File file = new File(path);
                Image image = ImageIO.read(file);
                Image scaledInstance = image.getScaledInstance(ImageLoad.getWidth(), ImageLoad.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon img = new ImageIcon(scaledInstance);
                ImageLoad.setIcon(img);
            }
            else
                JOptionPane.showMessageDialog(null, "Selct an Image");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
    }
}