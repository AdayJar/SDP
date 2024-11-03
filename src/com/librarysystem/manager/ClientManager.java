package src.com.librarysystem.manager;

import java.util.ArrayList;
import java.util.List;

import src.com.librarysystem.iterator.ClientIterator;
import src.com.librarysystem.iterator.Iterator;
import src.com.librarysystem.models.clients.Client;

public class ClientManager implements CollectionManager<Client> {
    private List<Client> clients = new ArrayList<>(); 

    @Override
    public void add(Client client) {
        clients.add(client);
        System.out.println("Client added: " + client.toString());
    }

    @Override
    public void remove(int id) {
        clients.removeIf(client -> client.getId() == id);
        System.out.println("Client with ID " + id + " has been removed.");
    }

    @Override
    public Client findById(int id) {
        return clients.stream().filter(client -> client.getId() == id).findFirst().orElse(null);
    }

    @Override
    public int getTotal() {
        return clients.size();
    }

    @Override
    public void showAll() {
        clients.forEach(client -> System.out.println(client.toString()));
    }
    @Override
    public List<Client> getItems(){
        return clients;
    }

    @Override
    public Iterator<Client> iterator() {
    return new ClientIterator(this); 
}

}
