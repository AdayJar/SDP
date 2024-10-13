package src.com.librarysystem.iterator;

import src.com.librarysystem.manager.ClientManager;
import src.com.librarysystem.models.clients.Client;

import java.util.Iterator;
import java.util.Map;

// Iterator for the ClientManager class
public class ClientIterator implements Iterator<Client> {
    private Iterator<Map.Entry<Integer, Client>> iterator; // Iterator for the hash map

    // Constructor accepts ClientManager
    public ClientIterator(ClientManager clientManager) {
        this.iterator = clientManager.getClientsMap().entrySet().iterator(); // Initialize the iterator for the hash map
    }

    // Checks if there is a next client
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    // Returns the next client
    @Override
    public Client next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more clients available."); 
        }
        return iterator.next().getValue(); // Get the client from the entry
    }
}
