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
    private JPanel Past_conversions;
    private CardLayout card;
    
    public void run(javax.swing.JPanel History, Container container) 
    {
        JPanel Captcha;
        JLabel captchaImage;
        JButton Refresh;
        JTextField Enter_Cap;
        ImageIcon icon;
        JPanel spanel1,spanel2;
        JButton Submit;
        History.setLayout(new java.awt.CardLayout());
        
        Security = new JPanel();
        Past_conversions = new JPanel();
        spanel1 = new JPanel();
        spanel2 = new JPanel();
        Captcha = new JPanel();
        captchaImage = new JLabel();
        Refresh = new JButton();
        Enter_Cap = new JTextField();
        Submit = new JButton();
        card = (CardLayout) History.getLayout();
        spanel1.setBounds(200,200,Security.getWidth()/2,Security.getHeight()/2);
        spanel2.setBounds(300,300,400,400);
        spanel1.add(spanel2);
        History.add(Security,"card6");
        History.add(Past_conversions,"card7");
        
        CaptchaImage obj = new CaptchaImage();
        BufferedImage image = obj.getCaptchaImage();
        
        Captcha.setLayout(new javax.swing.BoxLayout(Captcha, BoxLayout.X_AXIS));
        Captcha.setPreferredSize(new java.awt.Dimension(500, 300));
        
        //captchaImage.setPreferredSize(new java.awt.Dimension(300,300));
        icon = new ImageIcon(image);
        captchaImage.setIcon(icon);
        spanel2.add(captchaImage);
        
        BufferedImage refresh_btn;
        try{
             Refresh.setPreferredSize(new java.awt.Dimension(100,50));
             Refresh.setBounds(300, 300, 20 , 30);
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
        
        spanel2.add(Refresh);
        spanel2.add(Enter_Cap);
        Captcha.add(spanel1);
        Security.add(Captcha);
        Security.add(Submit);
        Enter_Cap.setPreferredSize(new java.awt.Dimension(300, 50));
        
        
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
               
            }
        });
    }
}
