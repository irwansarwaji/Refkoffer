
package rekoffer.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import rekoffer.models.Baggage;
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
        if(res != null)
        {
          res.close();
        }
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
     * @return List of all non manager users
     * @throws SQLException 
     */
    public static ResultSet getAllUsers() throws SQLException{
        connect();
        preparedStatement = con.prepareStatement(getAllUsers);
        res = preparedStatement.executeQuery();
        return res;
    }

    /**
     * Saves a lost suitcase
     * @param label
     * @param owner
     * @param firstName
     * @param lastName
     * @param country
     * @param address
     * @param zip
     * @param phone
     * @param email
     * @param colour
     * @param other
     * @param model
     * @param brand
     * @throws SQLException 
     */
    public static void createNewLostBaggage(Baggage baggage) throws SQLException
    {
        connect();
        preparedStatement = con.prepareStatement(createLostBaggage);
        preparedStatement.setString(1, baggage.getFirstName());
        preparedStatement.setString(2, baggage.getLastName());
        preparedStatement.setString(3, baggage.getAddress());
        preparedStatement.setString(4, baggage.getZip());
        preparedStatement.setString(5, baggage.getCountry());
        preparedStatement.setString(6, baggage.getPhone());
        preparedStatement.setString(7, baggage.getEmail());
        preparedStatement.setInt(8, 1);
        preparedStatement.setString(9, baggage.getLabel());
        preparedStatement.setString(10, baggage.getSuitcaseBrand());
        preparedStatement.setString(11, baggage.getSuitcaseColour());
        preparedStatement.setString(12, baggage.getSuitcaseOther());
        preparedStatement.setString(13, baggage.getSuitcaseModel());
        preparedStatement.executeUpdate();
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
     * @param label - Label van de koffer
     * @return alle koffers met ingevoerd label
     * @throws SQLException 
     */
    public static ResultSet getBaggageByLabel(String label) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByLabel);
        preparedStatement.setString(1, label);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageByFirstname(String firstname) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByFirstname);
        preparedStatement.setString(1, firstname);
        res = preparedStatement.executeQuery();

        return res;
    }
    
    public static ResultSet getBaggageByLastname(String lastname) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByLastname);
        preparedStatement.setString(1, lastname);
        res = preparedStatement.executeQuery();

        return res;
    }

    public static ResultSet getBaggageByAddress(String address) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageByAddress);
        preparedStatement.setString(1, address);
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

    public static ResultSet getBaggageBySuitcasetype(int suitcasetype) throws SQLException {
        connect();
        preparedStatement = con.prepareStatement(getBaggageBySuitcasetype);
        preparedStatement.setInt(1, suitcasetype);
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
     * 
     * @param repeatPassword - wachtwoord van de nieuwe gebruiker om te check of het wachtwoord
     * goed is getypt
     * 
     * @throws SQLException
     */
    public static void createNewUser(String userEmail, String newPassword, String repeatPassword, String firstName, String lastName, String phoneNumber) throws SQLException {
        String cryptedPassword = Authenticate.createPassword(newPassword);
        connect();
        preparedStatement = con.prepareStatement(setUser);
        preparedStatement.setString(1, userEmail);
        preparedStatement.setString(2, cryptedPassword);
        preparedStatement.setString(3, firstName);
        preparedStatement.setString(4, lastName);
        preparedStatement.setString(5, phoneNumber);
        preparedStatement.executeUpdate();
    }
    
    
    //needs editing. Want to get an INT from this
    public static ResultSet getID(String email) throws SQLException{
        preparedStatement = con.prepareStatement(getID);
        preparedStatement.setString(1, email);
        res  = preparedStatement.executeQuery();
        
        return res;
    }
    
    
    /**
     * 
     * @param userEmail - Emailadres van de gebruiker waarvan het mailadres wordt verandert
     * @param newPassword - Nieuw wachtwoord voor de gebruiker
     * @throws SQLException 
     */
    public static void setNewPasswordByEmail(String userEmail, String newPassword) throws SQLException{
        connect();
        String cryptedPassword = Authenticate.createPassword(newPassword);
        preparedStatement = con.prepareStatement(setPasswordByEmail);
        preparedStatement.setString(1, cryptedPassword);
        preparedStatement.setString(2, userEmail);
        preparedStatement.executeUpdate();
    }
    
    public static ResultSet getAllBaggage() throws SQLException{
        connect();
        preparedStatement = con.prepareStatement(getAllBaggage);
        res  = preparedStatement.executeQuery();
        
        return res;
    }
}
