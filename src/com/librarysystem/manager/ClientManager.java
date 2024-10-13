package src.com.librarysystem.manager;

import java.util.HashMap;
import java.util.Map;
import src.com.librarysystem.iterator.ClientIterator;
import src.com.librarysystem.models.clients.Client;

// Менеджер для управления клиентами
public class ClientManager {
    private static ClientManager instance; // Статическая переменная для хранения единственного экземпляра ClientManager
    private Map<Integer, Client> clients = new HashMap<>(); // Коллекция для хранения клиентов с их идентификаторами

    // Приватный конструктор для предотвращения создания объектов извне (Singleton)
    private ClientManager() {
    }

    // Метод для получения единственного экземпляра ClientManager
    public static synchronized ClientManager getInstance() {
        if (instance == null) {
            instance = new ClientManager(); // Создаем новый экземпляр, если он не существует
        }
        return instance; // Возвращаем единственный экземпляр
    }

    // Метод для добавления клиента
    public void addClient(Client client) {
        clients.put(client.getId(), client);
        System.out.println("Client added: " + client);
    }

    // Метод для поиска клиента по идентификатору
    public Client findClientById(int id) {
        return clients.get(id);
    }

    // Метод для удаления клиента по идентификатору
    public void removeClient(int id) {
        clients.remove(id);
        System.out.println("Client with ID " + id + " has been removed.");
    }

    // Метод для получения общего количества клиентов
    public int getTotalClients() {
        return clients.size();
    }

    // Метод для получения карты клиентов
    public Map<Integer, Client> getClientsMap() {
        return clients;
    }

    // Метод для создания итератора клиентов
    public ClientIterator createIterator() {
        return new ClientIterator(this); // Возвращаем новый экземпляр итератора клиентов
    }
}
