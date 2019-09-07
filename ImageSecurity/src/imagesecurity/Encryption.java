/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suman
 */
public class Encryption {
    
    private String file1;
    private String file2;
    private long filesize;
    private String filedata;

    public Encryption(String in) throws FileNotFoundException{
        file1 = in;
        file2 = file1 + "e";
    }
    
    public void encrypt(){
        //step 1: rotation
        //step 2: vignere
        //step 3: vignere on key
        //step 4: chaining

        rotation();
        //filedata contains rotated result
        
        /*FileWriter output = null;
        try{
            output = new FileWriter(file2);
            output.write(filedata);
        }
        catch(Exception e){
            e.printStackTrace();
        }*/
        
        vignere();
    }
    
    private void rotation(){

        int ch,count = 0;
        try {
            /*filedata = new String (Files.readAllBytes(Paths.get(file1)));
            filesize = filedata.length();
            System.out.println(filedata);*/
            File f1 = new File(file1);
            BufferedReader reader = new BufferedReader(new FileReader(f1));
            FileWriter f2 = new FileWriter(file2);
            
            filesize = f1.length();
            System.out.println(filesize);
            Random rand = new Random();
            int n = rand.nextInt((65535 - 100 + 1)) +100;
            
            reader.skip(n);
            while((ch = reader.read()) != -1){
                f2.append((char)ch);
            }
            reader.close();
            reader = new BufferedReader(new FileReader(f1));
            while(count < n && (ch = reader.read()) != -1){
                f2.append((char)ch);
                count++;
            }
            StringBuffer key = new StringBuffer(Integer.toBinaryString(n));
            if(key.length() < 16){
                while(key.length() < 16){
                   key.insert(0, "0");
                }
            }
            f2.append(key);
            filesize += 16;
        } 
        catch (IOException ex) {
            Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void vignere(){
        
        StringBuffer l1 , r1 , newl1 , result , lr1,rr1 ;
        BufferedReader reader = null;
        int ch, i;
        long l1size = filesize / 2, r1size = l1size, lr1size = r1size / 2, count = 0;      //size of all the segments l1,r1,lr1 = rr1
        
        
        if(filesize % 2 == 1)
        {
            l1size += 1;
        }
        try{
            
            l1 = new StringBuffer(1000000000);
            r1 = new StringBuffer(1000000000);
            lr1 = new StringBuffer(1000000000);
            rr1 = new StringBuffer(1000000000);
            result = new StringBuffer(1000000000);
            newl1 = new StringBuffer(1000000000);
            reader = new BufferedReader(new FileReader(file2));
            while((ch = reader.read()) != -1 && count < l1size){
                l1 = l1.append(Character.toString((char)ch));
                count++;
            }
            count = 0;
            while((ch = reader.read()) != -1 && count < r1size){
                r1 = r1.append(Character.toString((char)ch));
                count++;
            }
            for(i = 0; i < r1size; i++){
                if(l1.charAt(i) == r1.charAt(i))
                    l1.setCharAt(i, '0'); //= newl1.append("0");
                else
                    l1.setCharAt(i, '1');
            }
            /*if(l1size > r1size)
                newl1 = newl1.append(l1.charAt(l1.length() - 1));*/
            
            for(i = 0; i < lr1size ; i++){
                lr1.append(r1.charAt(i));
            }
            for(;i < r1size; i++){
                rr1.append(r1.charAt(i));
            }
            for(i = 0; i < lr1size; i++){
                if(lr1.charAt(i) == rr1.charAt(i))
                    r1.setCharAt(i, '0');
                else
                    r1.setCharAt(i, '1');
            }
            FileWriter file = new FileWriter(file1);
            file.write(l1.toString());
            file.append(r1.toString());
            StringBuffer key = new StringBuffer(Long.toBinaryString(filesize));
            while(key.length() < 30){
                key.insert(0, "0");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /*private void chaining(){
        //input in file1;
        //output in file2;
        
        int r = new Random().nextInt(100-10+1)+1;
        BufferedReader in;
        try{
            in = new BufferedReader(new FileReader(file1));
            long size_of_block = filesize / r;
            for(int i = 0; i < r; i++){
                in.skip(filesize / 2);
            }
            
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
    }*/
    
}
