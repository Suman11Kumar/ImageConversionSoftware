/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagesecurity;

/**
 *
 * @author max
 */
import java.sql.*;
public class ConnectionManager {
    
   //  private static String url = "jdbc:mysql://db:3306/prototypeeop";    
    private static String driverName = "com.mysql.jdbc.Driver";   
 //   private static String username = "root";   
 //   private static String password = "triala";
    private static Connection con;
  //  private static String urlstring;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/imagesecurity","imagedb","12345678");
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
    
}
