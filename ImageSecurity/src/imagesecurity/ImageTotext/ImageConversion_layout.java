 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity.ImageTotext;

import imagesecurity.Encryption;
import imagesecurity.Global;
import imagesecurity.LZW;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
    private Thread t2;
    private final Container container;
    private File ImageFIle;
    private File TextFile;
            
    public ImageConversion_layout(JPanel ImageConversion, Container contentPane) {
        this.container = contentPane;
        build(ImageConversion);
    }
    
    private void build(javax.swing.JPanel ImageConversion)
    {
        path = null;
        main = new javax.swing.JPanel();
        //SaveText = new javax.swing.JButton();
        ImageLoad = new javax.swing.JLabel();
        ImageStatus = new javax.swing.JPanel();
        ProgressBar = new javax.swing.JProgressBar();
        ConversionStatus = new javax.swing.JLabel();
        convert = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        
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
            new image().Convert();
            /*for (int i=0; i<=100; i++){ //Progressively increment variable i
                ProgressBar.setValue(i); //Set value
                ProgressBar.repaint();
                ConversionStatus.setText("Convertion Status..." + i + "%");//Refresh graphics
                try{Thread.sleep(50);} //Sleep 50 milliseconds
                catch (InterruptedException err){}
            }*/
        }
    }
    
    private class imagechoose implements Runnable{

        @Override
        public void run() {
            Global tmp = Global.getInstance();
            path = tmp.getImageFile();
            ImageLoad.setSize(270,240);
            //System.out.println("Path is: " + path);
            try
            {
                if(path != null){
                    name.setText(path.substring(path.lastIndexOf('\\')+1));
                    String ext = path.substring(path.lastIndexOf('.')+1);
                    if(ext.equals("jpg")|| ext.equals("jpeg") || ext.equals("png")){
                        ImageFIle = new File(path);
                        Image image = ImageIO.read(ImageFIle);
                        Image scaledInstance = image.getScaledInstance(ImageLoad.getWidth(), ImageLoad.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon img = new ImageIcon(scaledInstance);
                        ImageLoad.setIcon(img);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Select An Image File");
                        CardLayout cards = (CardLayout) container.getLayout();
                        cards.show(container, "card3");
                    }
                    //System.out.println(name.getText());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Select Image File");
                    CardLayout cards = (CardLayout) container.getLayout();
                    cards.show(container, "card3");
                }
            }
            catch(HeadlessException | IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private class image
    {
        private String inputfile;
        private String byteoutputfile;
        private String compressedFile;
        private String bitoutputfile;
        
        image(){
            inputfile = null;
            byteoutputfile = null;
            bitoutputfile = null;
            compressedFile = null;
        }
        
	public void Convert()
	{
                inputfile =  name.getText().substring(0, name.getText().lastIndexOf('.') - 1);
                System.out.println(inputfile);
                byteoutputfile = inputfile + "oa";
                bitoutputfile = inputfile + "obit";
                compressedFile = inputfile + "c";
		
                convertByte();
		/*FileOutputStream b = null;
		try{
			a = new FileReader(file);
			b = new FileOutputStream("4.txt");
			img.revert(a,b);
		} 
		catch(FileNotFoundException e){
			e.printStackTrace();
		}

		finally{
			try{
				a.close();
				b.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}*/
	}

	private void convertByte()
	{
            InputStream in;
            OutputStream out;
            byte[] buffer = new byte[1024];
            String s = null;
            int count;
            
            try{
                in = new FileInputStream(ImageFIle);
                out = new FileOutputStream(byteoutputfile);
		while((count = in.read(buffer)) != -1)
		{
                    out.write(buffer , 0 , count);
                        
				/*System.out.println("Printing:....        " + buffer.toString());
				s = new String(buffer , "ASCII");
				System.out.println("String Format :      " + s); 
				//ascii.write(s);
				//bits = new BitArray(buffer);*/
		}
                ProgressBar.setValue(0);
		for (int i=ProgressBar.getValue(); i<=20; i++){ //Progressively increment variable i
                    ProgressBar.setValue(i); //Set value
                    ProgressBar.repaint();
                    ConversionStatus.setText("Convertion Status..." + i + "%");//Refresh graphics
                    try{Thread.sleep(50);} //Sleep 50 milliseconds
                    catch (InterruptedException err){}
                }
                out.flush();
                in.close();
                out.close();
                convertBit();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

        private void convertBit(){
            InputStream in;
            FileWriter out;
            byte[] buffer = new byte[1024];
            String s = null;
            
            try{
                
                in = new FileInputStream(byteoutputfile);
                out = new FileWriter(bitoutputfile);
                //compress(in,compressout);
                for(byte b:buffer){
                    s = String.format("%8s", Integer.toBinaryString(b & 0xff)).replace(' ','0');
                    out.write(s);
                }
                for (int i=ProgressBar.getValue(); i<=40; i++){ //Progressively increment variable i
                    ProgressBar.setValue(i); //Set value
                    ProgressBar.repaint();
                    ConversionStatus.setText("Convertion Status..." + i + "%");//Refresh graphics
                    try{Thread.sleep(50);} //Sleep 50 milliseconds
                    catch (InterruptedException err){}
                }
                out.flush();
                in.close();
                out.close();
                compress();
            }
            catch(IOException e)
            {
		e.printStackTrace();
            }
        }
        
	public String toString(char[] buffer)
	{
		String s = null;
		for(int i = 0; i < buffer.length ;i++){
			s += buffer[i];
			s += ' ';
		}
		return s;
	}

	public void revert(final FileReader in, final FileOutputStream out){
		char[] buffer = new char[8];
		String s ;
		int i = 0, k = 7;
		try{
			while(in.read(buffer,0,8) != -1){
				s = new String(buffer);
				i = Integer.parseInt(s,2);
				byte b = (byte)i;
				out.write(b);
				i = 0;
				k = 7;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
        }

        private void compress() {
            
            LZW comp = new LZW();
            comp.encode(bitoutputfile, compressedFile);
            for (int i=ProgressBar.getValue(); i<=70; i++){ //Progressively increment variable i
                ProgressBar.setValue(i); //Set value
                ProgressBar.repaint();
                ConversionStatus.setText("Convertion Status..." + i + "%");//Refresh graphics
                try{Thread.sleep(50);} //Sleep 50 milliseconds
                catch (InterruptedException err){}
            }
            try{
                Encryption encrypt = new Encryption(compressedFile);
                for (int i=ProgressBar.getValue(); i<=100; i++){ //Progressively increment variable i
                    ProgressBar.setValue(i); //Set value
                    ProgressBar.repaint();
                    ConversionStatus.setText("Convertion Status..." + i + "%");//Refresh graphics
                    try{Thread.sleep(50);} //Sleep 50 milliseconds
                    catch (InterruptedException err){}
                }
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
              
    }
    
}


