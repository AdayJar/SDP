package src.com.librarysystem.factory;

import src.com.librarysystem.clients.Client;
import src.com.librarysystem.clients.RegularClient;
import src.com.librarysystem.clients.PremiumClient;

public class ClientFactory {
    public static Client createRegularClient(int id, String name, String email) {
        return new RegularClient(id, name, email);
    }
    public static Client createPremiumClient(int id, String name, String email, double discount) {
        return new PremiumClient(id, name, email, discount);
    }
}
