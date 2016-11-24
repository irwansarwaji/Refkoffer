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

    public static void setSessionUser(User user) {
        sessionUser = user;
    }

    public User getSessionUser() {
        return sessionUser;
    }

}
