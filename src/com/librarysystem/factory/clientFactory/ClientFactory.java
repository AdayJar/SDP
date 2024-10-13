package src.com.librarysystem.factory.clientFactory;

import src.com.librarysystem.models.clients.Client;
import src.com.librarysystem.models.clients.PremiumClient;
import src.com.librarysystem.models.clients.RegularClient;

public class ClientFactory {
    public static Client createRegularClient(int id, String name, String email) {
        return new RegularClient(id, name, email);
    }
    public static Client createPremiumClient(int id, String name, String email, double discount) {
        return new PremiumClient(id, name, email, discount);
    }
}
