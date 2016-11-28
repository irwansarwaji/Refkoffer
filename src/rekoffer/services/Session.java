package rekoffer.services;

import rekoffer.models.User;

/**
 * Users that signs in gets gets stored here. This allows for easy reference to
 * the user whenever user-specific data is needed.
 *
 * @author damon
 */
public class Session {

    private static User sessionUser;

    /**
     * Sets a static variable named sessionUser which holds an user object
     * This can be used to hold the user that signed in through the entire lifecycle of the application
     * @param user 
     */
    public static void setSessionUser(User user) {
        sessionUser = user;
    }

    /**
     * Get the user that is logged in
     * @return (User) Current signed in user
     */
    public static User getSessionUser() {
        return sessionUser;
    }

}
