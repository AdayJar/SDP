package src.com.librarysystem.manager;

import java.util.HashMap;
import java.util.Map;
import src.com.librarysystem.iterator.ClientIterator;
import src.com.librarysystem.models.clients.Client;

// Manager for managing clients
public class ClientManager {
    private static ClientManager instance; // Static variable to hold the singleton instance of ClientManager
    private Map<Integer, Client> clients = new HashMap<>(); // Collection to store clients with their IDs

    // Private constructor to prevent object creation from outside (Singleton)
    private ClientManager() {
    }

    // Method to get the singleton instance of ClientManager
    public static synchronized ClientManager getInstance() {
        if (instance == null) {
            instance = new ClientManager(); // Create a new instance if it does not exist
        }
        return instance; // Return the singleton instance
    }

    // Method to add a client
    public void addClient(Client client) {
        clients.put(client.getId(), client);
        System.out.println("Client added: " + client);
    }

    // Method to find a client by ID
    public Client findClientById(int id) {
        return clients.get(id);
    }

    // Method to remove a client by ID
    public void removeClient(int id) {
        clients.remove(id);
        System.out.println("Client with ID " + id + " has been removed.");
    }

    // Method to get the total number of clients
    public int getTotalClients() {
        return clients.size();
    }

    // Method to get the map of clients
    public Map<Integer, Client> getClientsMap() {
        return clients;
    }

    // Method to create a client iterator
    public ClientIterator createIterator() {
        return new ClientIterator(this); // Return a new instance of the client iterator
    }
}
