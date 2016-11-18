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

    //connecen met de database
    public static void connect() {
        con = getConnection();

    }
    //disconnecten van de database

    public static void disconnect() throws SQLException {
        con.close();
        res.close();
        preparedStatement.close();
        System.out.println("Database disconnected");
    }

    /**
     *
     * @param userId - ID van de user die wordt opgehaald
     * @return - returnt de uitvoer van de query
     * @throws SQLException
     */
    public static ResultSet getUser(String userId) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getUser);
        preparedStatement.setString(1, userId);
        preparedStatement.setMaxRows(1);
        res = preparedStatement.executeQuery();

        return res;
    }

    /**
     *
     * @param userEmail - email van de gebruiker
     * @return gebruiker die de userEmail heeft
     * @throws SQLException
     */
    public static ResultSet getUserByEmail(String userEmail) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getUserByEmail);
        preparedStatement.setString(1, userEmail);
        preparedStatement.setMaxRows(1);
        res = preparedStatement.executeQuery();

        return res;
    }

    /**
     *
     * @param userEmail - email van de nieuwe gebruiker
     * @param newPassword - wachtwoord van de nieuwe gebruiker. Wachtwoord wordt
     * encrypted
     * @param repeatPassword
     * @throws SQLException
     */
    public static void createNewUser(String userEmail, String newPassword, String repeatPassword) throws SQLException {
        String cryptedPassword = Authenticate.createPassword(newPassword);
        connect();
        preparedStatement = con.prepareStatement(setUser);
        preparedStatement.setString(1, userEmail);
        preparedStatement.setString(2, cryptedPassword);
        preparedStatement.executeUpdate();
    }
}
