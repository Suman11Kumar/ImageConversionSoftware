/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imagesecurity.ImageTotext;
import imagesecurity.camera;
import java.awt.Container;
import java.awt.CardLayout;
import javax.swing.JFileChooser;
/**
 *
 * @author Suman
 */
public class ImageChooser_layout {
    
    private javax.swing.JButton camera;
    private javax.swing.JButton open;
    private javax.swing.JButton next;
    public void run(javax.swing.JPanel ImageChooser,Container container)
    {
        camera = new javax.swing.JButton();
        open = new javax.swing.JButton();
        next = new javax.swing.JButton();
        ImageChooser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        camera.setText("camera");
        camera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camera f=new camera();
                f.setVisible(true);
                f.start1();
            }
        });
        ImageChooser.add(camera, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 100, 30));

        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser file=new JFileChooser();
                    int fc=file.showOpenDialog(null);
            }
        });
        ImageChooser.add(open, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 100, 30));

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardLayout card = (CardLayout) container.getLayout();
                card.show(container,"card4");
            }
        });
        ImageChooser.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 293, 120, 30));
    }
}
