/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imagesecurity.ImageTotext;
import imagesecurity.Global;
import imagesecurity.camera;
import java.awt.Container;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class ImageChooser_layout {
    
    private javax.swing.JButton camera_btn;
    private javax.swing.JButton browse_btn;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel choose;
    private javax.swing.JLabel camera_lbl;
    private javax.swing.JLabel browse_lbl;
    private javax.swing.JPanel camera;
    private javax.swing.JPanel browse;
    private javax.swing.JPanel Next;
    private javax.swing.JLabel ImageSelected;
    
    
    public void run(javax.swing.JPanel ImageChooser,Container container)
    {
        choose = new javax.swing.JPanel();
        camera = new javax.swing.JPanel();
        browse = new javax.swing.JPanel();
        camera_btn = new javax.swing.JButton();
        browse_btn = new javax.swing.JButton();
        camera_lbl = new javax.swing.JLabel();
        browse_lbl = new javax.swing.JLabel();
        ImageSelected = new javax.swing.JLabel();
        
        ImageChooser.setBackground(new java.awt.Color(191, 181, 173));
        choose.setLayout(new javax.swing.BoxLayout(choose, javax.swing.BoxLayout.X_AXIS));
        choose.setPreferredSize(new java.awt.Dimension(container.getWidth(), container.getHeight() * 3 / 4));
                
        camera.setBackground(new java.awt.Color(191, 181, 173));
        browse.setBackground(new java.awt.Color(191, 181, 173));
               
        camera.setLayout(new java.awt.FlowLayout(FlowLayout.LEFT, 100, 25));
        browse.setLayout(new java.awt.FlowLayout(FlowLayout.LEFT, 100, 25));

        camera_lbl.setText("Capture Image By Camera");
        camera_lbl.setPreferredSize(new java.awt.Dimension(300, 100));
        camera_lbl.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18));
        
        camera_btn.setFont(new java.awt.Font("Dialog", 0, 18));
        camera_btn.setText("Open Camera");
        camera_btn.setBackground(new java.awt.Color(136, 181, 215));
        camera_btn.setPreferredSize(new java.awt.Dimension(200, 50));
        camera_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camera f=new camera();
                f.setVisible(true);
                f.start1();
                ImageSelected.setText(Global.getInstance().getImageFile());
            }
        });
        camera.setPreferredSize(new java.awt.Dimension(200,choose.getHeight()));
        camera.add(camera_lbl);
        camera.add(camera_btn);
        choose.add(camera);
        System.out.println("camera panel created");
        
        browse_lbl.setText("Browse Image");
        browse_lbl.setPreferredSize(new java.awt.Dimension(200, 100));
        browse_lbl.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18));
        //browse_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
        browse_lbl.setHorizontalAlignment(SwingConstants.CENTER);
        
        browse_btn.setBackground(new java.awt.Color(136, 181, 215));
        browse_btn.setFont(new java.awt.Font("Dialog", 0, 18));
        browse_btn.setText("Browse");
        browse_btn.setPreferredSize(new java.awt.Dimension(200, 50));
        browse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                JFileChooser file=new JFileChooser();
                int fc = file.showOpenDialog(null);
                File f = file.getSelectedFile();
                String path = f.getAbsolutePath();
                String ext = path.substring(path.lastIndexOf('.')+1);
                if(f != null && (ext.equals("jpg")|| ext.equals("jpeg") || ext.equals("png")))
                {
                    Global tmp = Global.getInstance();
                    tmp.setImageFile(f);
                    ImageSelected.setText(Global.getInstance().getImageFile());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Select An Image File");
                    f = null;
                }
            }
        });
        
        browse.setPreferredSize(new java.awt.Dimension(200,choose.getHeight()));
        browse.add(browse_lbl);
        browse.add(browse_btn);
        choose.add(browse);
        System.out.println("browse panel created");
        ImageChooser.add(choose);
        System.out.println("choose panel created");
        
        Next = new javax.swing.JPanel();
        Next.setBackground(new java.awt.Color(191, 181, 173));
        Next.setPreferredSize(new java.awt.Dimension(container.getWidth(), container.getHeight() / 3));
        Next.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
       
        nextButton = new javax.swing.JButton();
        nextButton.setText("Next");
        nextButton.setMargin(new java.awt.Insets(10, 50, 10, 50));
        nextButton.setFont(new java.awt.Font("Dialog", 0, 18));
        nextButton.setVerticalAlignment(SwingConstants.CENTER);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                CardLayout card = (CardLayout) container.getLayout();
                card.show(container,"card4");
            }
        });
        //ImageSelected.setPreferredSize(new java.awt.Dimension(100, 50));
        
        Next.add(ImageSelected);
        Next.add(nextButton);
        ImageChooser.add(Next);
        System.out.println("next panel created");
    }
}
