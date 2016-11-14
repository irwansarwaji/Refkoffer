/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.services;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Damon
 */
public class Authenticate {
    
    public static boolean authenticateUser(String plainPassword, String dbPassword)
    {
        // Check unencrypted password with one that is hashed
        if (BCrypt.checkpw(plainPassword, dbPassword))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static String createPassword(String plainPassword)
    {
         // Hash a password
        String hashed = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        // gensalt's log_rounds parameter determines the complexity
        // the work factor is 2**log_rounds, and the default is 10
        hashed = BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
        
        return hashed;
    }
}
