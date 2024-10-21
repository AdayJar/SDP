package src.com.librarysystem.iterator;

import src.com.librarysystem.manager.ClientManager;
import src.com.librarysystem.models.clients.Client;

import java.util.List;

// Iterator for the ClientManager class
public class ClientIterator implements Iterator<Client> {
    private List<Client> clients; // List of clients
    private int currentIndex = 0; // Current index for iteration

    // Constructor accepts ClientManager
    public ClientIterator(ClientManager clientManager) {
        this.clients = clientManager.getItems(); // Initialize the list of clients
    }

    // Checks if there is a next client
    @Override
    public boolean hasNext() {
        return currentIndex < clients.size();
    }

    // Returns the next client
    @Override
    public Client next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more clients available.");
        }
        Client client = clients.get(currentIndex); // Get the client by index
        currentIndex++;
        return client;
    }
}
