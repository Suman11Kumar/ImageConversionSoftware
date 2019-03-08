/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity.ImageTotext;

import java.awt.Container;
import java.awt.CardLayout;
import javax.swing.JPanel;
/**
 *
 * @author Suman
 */
public class History_layout {
    
    public void run(javax.swing.JPanel History, Container container)
    {
        History.setLayout(new java.awt.CardLayout());
        
        JPanel Security = new JPanel();
        History.add(Security,"card1");
        JPanel Past_conversions = new JPanel();
        History.add(Past_conversions,"card2");
        
        
    }
}
