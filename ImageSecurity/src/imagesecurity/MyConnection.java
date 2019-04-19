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
            Class.forName("conn.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/imagesecurity";
            conn=DriverManager.getConnection(url,"imagedb","12345678");
        }catch(ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        }
        return conn;
    }
    public static void main(String args[]){
        Connection con = MyConnection.getConnection();
    }
}

