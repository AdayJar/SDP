package src.com.librarysystem.manager;

import src.com.librarysystem.models.clients.PremiumClient;
import src.com.librarysystem.models.clients.RegularClient;
import src.com.librarysystem.models.users.Person;

public class SessionManager {
    private static SessionManager instance;
    private Person currentUser; 

    private SessionManager() { }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void setCurrentUser(Person user) {
        this.currentUser = user;
    }

    public Person getCurrentUser() {
        return currentUser;
    }

    public int getCurrentClientId() {
        if (currentUser instanceof RegularClient) {
            return ((RegularClient) currentUser).getId();
        } else if (currentUser instanceof PremiumClient) {
            return ((PremiumClient) currentUser).getId();
        }
        throw new IllegalStateException("No client is currently logged in.");
    }
}
