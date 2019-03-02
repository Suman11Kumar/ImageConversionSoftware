/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity;

import imagesecurity.ImageTotext.ProgressCircleUI;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
/**
 *
 * @author Suman
 */
public class MainLayout extends javax.swing.JFrame {

    /**
     * Creates new form MainLayout
     */
    private String path;
    public MainLayout() {
        initComponents();
        //createcustompanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DashBoard = new javax.swing.JPanel();
        navigation = new javax.swing.JButton();
        ImageChooser = new javax.swing.JPanel();
        camera = new javax.swing.JButton();
        open = new javax.swing.JButton();
        next = new javax.swing.JButton();
        ImageConversion = new javax.swing.JPanel();
        ImageLoad = new javax.swing.JLabel();
        ImageStatus = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        SaveText = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        History = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 700));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        DashBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navigation.setText("Show My page");
        navigation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigationActionPerformed(evt);
            }
        });
        DashBoard.add(navigation, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 330, 70));

        getContentPane().add(DashBoard, "card2");

        ImageChooser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        camera.setText("camera");
        camera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cameraActionPerformed(evt);
            }
        });
        ImageChooser.add(camera, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 100, 30));

        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        ImageChooser.add(open, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 100, 30));

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        ImageChooser.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 293, 120, 30));

        getContentPane().add(ImageChooser, "card3");

        ImageLoad.setBackground(new java.awt.Color(204, 255, 204));
        ImageLoad.setMaximumSize(null);
        ImageLoad.setMinimumSize(null);
        ImageLoad.setPreferredSize(new java.awt.Dimension(300, 300));
        ImageLoad.setVerifyInputWhenFocusTarget(false);

        ImageStatus.setLayout(new javax.swing.BoxLayout(ImageStatus, javax.swing.BoxLayout.Y_AXIS));

        jProgressBar1.setBackground(new java.awt.Color(153, 153, 0));
        jProgressBar1.setMaximumSize(new java.awt.Dimension(32767, 100));
        jProgressBar1.setMinimumSize(new java.awt.Dimension(10, 100));
        jProgressBar1.setPreferredSize(new java.awt.Dimension(146, 100));
        ImageStatus.add(jProgressBar1);

        jLabel2.setBackground(new java.awt.Color(51, 255, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Convertion Status");
        jLabel2.setMaximumSize(new java.awt.Dimension(32800, 100));
        jLabel2.setMinimumSize(new java.awt.Dimension(34, 100));
        jLabel2.setPreferredSize(new java.awt.Dimension(32800, 100));
        ImageStatus.add(jLabel2);

        SaveText.setText("jButton1");

        name.setText("jLabel1");

        javax.swing.GroupLayout ImageConversionLayout = new javax.swing.GroupLayout(ImageConversion);
        ImageConversion.setLayout(ImageConversionLayout);
        ImageConversionLayout.setHorizontalGroup(
            ImageConversionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImageConversionLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(ImageLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ImageConversionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ImageStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                .addGap(121, 121, 121))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImageConversionLayout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(SaveText, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
        );
        ImageConversionLayout.setVerticalGroup(
            ImageConversionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImageConversionLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(ImageConversionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ImageLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ImageConversionLayout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ImageStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(SaveText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

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
        /*ImageStatus.setLayout(new javax.swing.BoxLayout(ImageStatus, javax.swing.BoxLayout.Y_AXIS));
        JLabel name = new JLabel("Name of the Image");
        ImageStatus.add(name);
        JProgressBar ProgressBar = new JProgressBar();
        ProgressBar.setUI(new ProgressCircleUI());
        ImageStatus.add(ProgressBar);
        JLabel Convert = new JLabel("Converting");
        ImageStatus.add(Convert);*/
        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        name.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        // Code adding the component to the parent container - not shown here
        int index = path.lastIndexOf('\\');
        path = path.substring(index+1);

        name.setText(path);

        getContentPane().add(ImageConversion, "card4");

        javax.swing.GroupLayout HistoryLayout = new javax.swing.GroupLayout(History);
        History.setLayout(HistoryLayout);
        HistoryLayout.setHorizontalGroup(
            HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 955, Short.MAX_VALUE)
        );
        HistoryLayout.setVerticalGroup(
            HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );

        getContentPane().add(History, "card5");

        MenuBar.setBackground(new java.awt.Color(255, 0, 51));
        MenuBar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MenuBar.setMaximumSize(new java.awt.Dimension(60, 50));
        MenuBar.setMinimumSize(new java.awt.Dimension(60, 50));
        MenuBar.setName(""); // NOI18N
        MenuBar.setPreferredSize(new java.awt.Dimension(60, 50));

        file.setText("File");
        MenuBar.add(file);

        jMenu2.setText("Edit");
        MenuBar.add(jMenu2);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void navigationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigationActionPerformed
        CardLayout card = (CardLayout) getContentPane().getLayout();
        card.show(getContentPane(), "card3");
    }//GEN-LAST:event_navigationActionPerformed

    private void cameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cameraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cameraActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
         CardLayout card = (CardLayout) getContentPane().getLayout();
        card.show(getContentPane(), "card4");
    }//GEN-LAST:event_nextActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        JFileChooser file=new JFileChooser();
                    int fc=file.showOpenDialog(null);

    }//GEN-LAST:event_openActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainLayout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DashBoard;
    private javax.swing.JPanel History;
    private javax.swing.JPanel ImageChooser;
    private javax.swing.JPanel ImageConversion;
    private javax.swing.JLabel ImageLoad;
    private javax.swing.JPanel ImageStatus;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton SaveText;
    private javax.swing.JButton camera;
    private javax.swing.JMenu file;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel name;
    private javax.swing.JButton navigation;
    private javax.swing.JButton next;
    private javax.swing.JButton open;
    // End of variables declaration//GEN-END:variables

}