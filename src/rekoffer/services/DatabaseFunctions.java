/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import static rekoffer.services.Connect.getConnection;
import static rekoffer.services.Statements.*;


/**
 *
 * @author Damon
 */
public class DatabaseFunctions {
    
    public static java.sql.Connection con;
    public static PreparedStatement preparedStatement;
    public static ResultSet res;
    
    
    public static void connect()
    {
        con = getConnection();
       
    }
    public static void disconnect() throws SQLException
    {
        con.close();
        res.close();
        preparedStatement.close();
    }
    
    public static ResultSet getUser() throws SQLException
    {
        connect();
        preparedStatement = con.prepareStatement(getUsers);
        preparedStatement.setString(1, "1");
        res = preparedStatement.executeQuery();

     
        return res;
    }
}
