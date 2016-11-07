/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.services;

import config.database;
import com.mysql.jdbc.Connection;
import java.sql.*;
import javafx.application.Application;



/**
 *
 * @author Damon
 */
public class Connect {
    
    public static java.sql.Connection con = null;
   
    public static void establishConnection() 
    {
        try
        {
            Class.forName(database.DRIVER);
            String url = database.URL;
            String name = database.DB_USERNAME;
            String password = database.DB_PASSWORD;
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Database connected");
        }
            catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("ConnectError");
            System.out.println(e.toString());
        }  
    }
    
    public static java.sql.Connection getConnection()
    {
        establishConnection();
        return con;
    }
    
    
}
