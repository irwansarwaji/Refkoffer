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
    public static String getID = "SELECT id FROM rekoffer.users WHERE email= ?;";
    public static String setPassword = "UPDATE users SET password = ? WHERE id = ?;";
}
