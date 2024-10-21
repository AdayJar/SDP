package src.com.librarysystem.manager;

import java.util.Map;

import src.com.librarysystem.models.clients.Client;

import java.util.HashMap;

public class ClientManager {
    private static ClientManager instance; 
    private Map<Integer, Client> clients = new HashMap<>();
    private Map<Integer, Integer> clientReservations = new HashMap<>();

    private ClientManager() {
    }

    public static synchronized ClientManager getInstance() {
        if (instance == null) {
            instance = new ClientManager(); 
        }
        return instance; 
    }

    public void addClient(Client client) {
        clients.put(client.getId(), client);
        System.out.println("Client added: "+ client);
    }

    public Client findClientById(int id) {
        return clients.get(id);
    }

    public void removeClient(int id) {
        clients.remove(id);
        System.out.println("Client with ID " + id + " has been removed.");
    }

    public int getClientReservations(int clientId) {
        return clientReservations.getOrDefault(clientId, 0);
    }
    public void addReservation(int clientId) {
        clientReservations.put(clientId, getClientReservations(clientId) + 1);
    }
    public void deleteReservation(int clientId) {
        clientReservations.put(clientId, getClientReservations(clientId) - 1);
    }

    public int getTotalClients() {
        System.out.println("Total clients count: " + clients.size());
        return clients.size();
    }
    public Client getClientById(int clientId) {
        return clients.get(clientId); 
    }
}
