/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity.ImageTotext;

import java.awt.Container;
import java.awt.CardLayout;
import javax.swing.JPanel;
import imagesecurity.CaptchaImage;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Suman
 */
public class History_layout {
    
    private JPanel Security;
    private JPanel Captcha_submit;
    
    public void run(javax.swing.JPanel Validate, Container container) 
    {
        
        JLabel captchaImage;
        JButton Refresh;
        JTextField Enter_cap;
        ImageIcon icon;
        JButton Submit;
        
        Captcha_submit = new JPanel();
        Security = new JPanel();
        captchaImage = new JLabel();
        Refresh = new JButton();
        Enter_cap = new JTextField();
        Submit = new JButton();
        
        Captcha_submit.setBackground(new java.awt.Color(209, 193, 180));
        Captcha_submit.setPreferredSize(new java.awt.Dimension(300, 500));
        Captcha_submit.setLayout(new javax.swing.BoxLayout(Captcha_submit, javax.swing.BoxLayout.Y_AXIS));

        Security.setBackground(new java.awt.Color(217, 186, 212));
        Security.setMaximumSize(new java.awt.Dimension(550, 200));
        Security.setPreferredSize(new java.awt.Dimension(100, 100));
        Security.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 25));

        captchaImage.setToolTipText("");
        captchaImage.setPreferredSize(new java.awt.Dimension(160, 100));
        Security.add(captchaImage);
        CaptchaImage obj = new CaptchaImage();
        BufferedImage image = obj.getCaptchaImage();
        //captchaImage.setPreferredSize(new java.awt.Dimension(300,300));
        icon = new ImageIcon(image);
        captchaImage.setIcon(icon);
        Security.add(Refresh);
        BufferedImage refresh_btn;
        try{
            Refresh.setBounds(0,0,30,40);
            File f = new File("./build/classes/imagesecurity/Icons/refresh.jpg");
            String path = f.getAbsoluteFile().toString();
            System.out.println(path);
            refresh_btn = ImageIO.read(f);
            Image scaled = refresh_btn.getScaledInstance(Refresh.getWidth(),Refresh.getHeight() , Image.SCALE_SMOOTH);
            ImageIcon ref = new ImageIcon(scaled);
            Refresh.setIcon(ref);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        Enter_cap.setMargin(new java.awt.Insets(1, 4, 10, 4));
        Enter_cap.setPreferredSize(new java.awt.Dimension(250, 50));
        Security.add(Enter_cap);

        Captcha_submit.add(Security);

        Submit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Submit.setText("Submit");
        Submit.setAutoscrolls(true);
        Submit.setMaximumSize(new java.awt.Dimension(500, 50));
        Submit.setMinimumSize(new java.awt.Dimension(300, 50));
        Submit.setPreferredSize(new java.awt.Dimension(500, 50));
        Captcha_submit.add(Submit);
        Submit.setHorizontalAlignment(SwingConstants.CENTER);

        Validate.add(Captcha_submit);
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = obj.getCaptchaImage();
                ImageIcon icon = new ImageIcon(image);
                captchaImage.setIcon(icon);
                
            }
        });
        
        Submit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               CardLayout card = (CardLayout) container.getLayout();
               card.show(container, "card6");
            }
        });
        
        
    }
}
