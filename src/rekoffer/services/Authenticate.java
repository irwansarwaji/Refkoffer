
package rekoffer.services;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Damon
 */
public class Authenticate {
    
    /**
     * checks if user password was correct
     * @param plainPassword password from user input
     * @param dbPassword hash from the database
     * @return true if the user password is correct
     */
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
    
    /**
     * 
     * @param plainPassword plain userinput password
     * @return hashed password fit for the database (includes salt)
     */
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
