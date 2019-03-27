/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity.ImageTotext;

import java.awt.Container;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 *
 * @author Suman
 */
public class ImageConversion_layout {
    private javax.swing.JPanel main;
    private javax.swing.JLabel ImageLoad;
    private javax.swing.JPanel ImageStatus;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel ConversionStatus;
    private javax.swing.JButton SaveText;
    private javax.swing.JLabel name;
    private String path;
    public void run(javax.swing.JPanel ImageConversion, Container container)
    {
        ImageConversion.setBackground(new java.awt.Color(191, 181, 173));
        path = null;
        main = new javax.swing.JPanel();
        SaveText = new javax.swing.JButton();
        ImageLoad = new javax.swing.JLabel();
        ImageStatus = new javax.swing.JPanel();
        ProgressBar = new javax.swing.JProgressBar();
        ConversionStatus = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        
        main.setLayout(new javax.swing.BoxLayout(main, javax.swing.BoxLayout.X_AXIS));
        main.setPreferredSize(new java.awt.Dimension(500, 300));
                
        ImageLoad.setPreferredSize(new java.awt.Dimension(350, 320));
        ImageLoad.setVerifyInputWhenFocusTarget(false);
        ImageLoad.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        main.add(ImageLoad);
        Imagechoose();
        
        ImageStatus.setLayout(new javax.swing.BoxLayout(ImageStatus, javax.swing.BoxLayout.Y_AXIS));

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        // Code adding the component to the parent container - not shown here
        int index = path.lastIndexOf('\\');
        path = path.substring(index+1);
        name.setText(path);
        ImageStatus.add(name);
        name.setBorder(BorderFactory.createEmptyBorder(20,0,30,0));
        
        ProgressBar.setBackground(new java.awt.Color(153, 153, 0));
        ProgressBar.setMaximumSize(new java.awt.Dimension(32767, 75));
        ProgressBar.setMinimumSize(new java.awt.Dimension(10, 75));
        ProgressBar.setPreferredSize(new java.awt.Dimension(146, 75));
        ProgressBar.setUI(new ProgressCircleUI());
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
        
        SaveText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SaveText.setText("Save Text File");
        SaveText.setMargin(new java.awt.Insets(10, 50, 10, 50));
        ImageStatus.add(SaveText);
        
        main.add(ImageStatus);
        ImageConversion.add(main);
        
    }
    
    private void Imagechoose()
    {
        ImageLoad.setSize(new java.awt.Dimension(219, 236));
        try
        {
            File file = new File("/Users/Suman/Downloads/suman.jpg");
            path = file.getAbsolutePath();
            Image image = ImageIO.read(file);
            Image scaledInstance = image.getScaledInstance(ImageLoad.getWidth(), ImageLoad.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledInstance);
            ImageLoad.setIcon(img);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
