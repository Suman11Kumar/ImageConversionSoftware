package imagesecurity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author azam
 */
public class MyConnection
{
    
    public static Connection getConnection()
    {
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        System.out.println("driver loaded"); // THIS IS BEING RETURNED
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        System.err.println(ex);
    }
    
       
        try{
            String url = "jdbc:mysql://(host=127.0.0.1,port=3306)/imagesecurity";
            conn=DriverManager.getConnection(url,"root","");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String args[])
    {
        getConnection();
    }
}

