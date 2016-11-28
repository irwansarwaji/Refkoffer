
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


    //connecten met de database
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
     * @return - return de uitvoer van de query
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

    //database for missing baggage
    public static ResultSet getBaggageByLabel(String label) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByLabel);
        preparedStatement.setString(1, label);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageByName(String name) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByName);
        preparedStatement.setString(1, name);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageByAddress(String adress) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByAddress);
        preparedStatement.setString(1, adress);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageByZip(String zip) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByZip);
        preparedStatement.setString(1, zip);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageByCountry(String country) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByCountry);
        preparedStatement.setString(1, country);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageByTelephone(String telephone) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByTelephone);
        preparedStatement.setString(1, telephone);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageByEmail(String email) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByEmail);
        preparedStatement.setString(1, email);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageByColour(String colour) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByColour);
        preparedStatement.setString(1, colour);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageBySuitcasetype(String suitcasetype) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageBySuitcasetype);
        preparedStatement.setString(1, suitcasetype);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageBySuitcasebrand(String suitcasebrand) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageBySuitcasebrand);
        preparedStatement.setString(1, suitcasebrand);
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
