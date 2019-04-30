/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity;

import java.io.File;

/**
 *
 * @author Suman
 */
public class Global {
    private String username = null;
    private static Global object = new Global();
    private String ImagePath = null;
    private String TextPath = null;

    private Global(){
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String user){
        username = user;
    }
    
    public static Global getInstance(){
        return object;
    }
    
    public String getImageFile(){
        return ImagePath;
    }
    
    public String getTextFile(){
        return TextPath;
    }
    
    public void setImageFile(File file){
        ImagePath = file.getAbsolutePath();
        //System.out.println(ImagePath);
    }
    
    public void setTextFile(File file){
        TextPath = file.getAbsolutePath();
    }
}
