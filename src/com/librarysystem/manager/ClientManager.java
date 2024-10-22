package src.com.librarysystem.manager;

import java.util.HashMap;
import java.util.Map;

import src.com.librarysystem.clients.Client;

public class ClientManager {
    private static ClientManager instance; // Единственный экземпляр
    private Map<Integer, Client> clients = new HashMap<>(); // Хранилище клиентов

    // Приватный конструктор предотвращает создание экземпляров извне
    private ClientManager() {
    }

    // Метод для получения единственного экземпляра ClientManager
    public static synchronized ClientManager getInstance() {
        if (instance == null) {
            instance = new ClientManager(); // Создаем экземпляр при первом обращении
        }
        return instance; // Возвращаем единственный экземпляр
    }

    // Метод для добавления клиента
    public void addClient(Client client) {
        clients.put(client.getId(), client);
        System.out.println("Client added: " + client);
    }

    // Метод для поиска клиента по ID
    public Client findClientById(int id) {
        return clients.get(id);
    }

    // Метод для удаления клиента по ID
    public void removeClient(int id) {
        clients.remove(id);
        System.out.println("Client with ID " + id + " has been removed.");
    }

    // Метод для получения общего количества клиентов
    public int getTotalClients() {
        return clients.size();
    }
}
