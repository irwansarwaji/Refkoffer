/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.services;

/**
 *
 * @author Damon
 */
public class Statements {
    public static String getUser = "SELECT * from users WHERE id = ?;";
    public static String getUserByEmail = "SELECT * from users WHERE email = ?;";
    public static String setUser = "INSERT INTO users (email, password) VALUES (?, ?);";
    public static String getBaggageByLabel = "SELECT * from baggage WHERE label = ?;";
    public static String getBaggageByFirstname = "SELECT * from baggage WHERE firstname = ?;";
    public static String getBaggageByLastname = "SELECT * from baggage WHERE lastname = ?;";
    public static String getBaggageByAddress = "SELECT * from baggage WHERE address = ?;";
    public static String getBaggageByZip = "SELECT * from baggage WHERE zip = ?;";
    public static String getBaggageByCountry = "SELECT * from baggage WHERE country = ?;";
    public static String getBaggageByTelephone = "SELECT * from baggage WHERE telephone = ?;";
    public static String getBaggageByEmail = "SELECT * from baggage WHERE email = ?;";
    public static String getBaggageByColour = "SELECT * from baggage WHERE colour = ?;";
    public static String getBaggageBySuitcasetype = "SELECT * from baggage WHERE suitcase_type = ?;";
    public static String getBaggageBySuitcasebrand = "SELECT * from baggage WHERE suitecasebrand = ?;";
    public static String getID = "SELECT id FROM rekoffer.users WHERE email= ?;";
    public static String setPassword = "UPDATE users SET password = ? WHERE id = ?;";

}
