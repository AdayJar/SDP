// Пакет, к которому относится класс ClientManager
package src.com.librarysystem.manager;

// Необходимые импорты
import src.com.librarysystem.models.clients.Client;
import java.util.HashMap;
import java.util.Map;

// Менеджер для управления клиентами
public class ClientManager {
    // Статическая переменная для хранения единственного экземпляра ClientManager
    private static ClientManager instance;

    // Коллекция для хранения клиентов с их идентификаторами
    private Map<Integer, Client> clients = new HashMap<>();

    // Приватный конструктор для предотвращения создания объектов извне (Singleton)
    private ClientManager() {
    }

    // Метод для получения единственного экземпляра ClientManager
    public static synchronized ClientManager getInstance() {
        if (instance == null) {
            instance = new ClientManager();
        }
        return instance;
    }

    // Метод для добавления клиента
    public void addClient(Client client) {
        clients.put(client.getId(), client);
        System.out.println("Клиент добавлен: " + client);
    }

    // Метод для поиска клиента по идентификатору
    public Client findClientById(int id) {
        return clients.get(id);
    }

    // Метод для удаления клиента по идентификатору
    public void removeClient(int id) {
        clients.remove(id);
        System.out.println("Клиент с ID " + id + " был удалён.");
    }

    // Метод для получения общего количества клиентов
    public int getTotalClients() {
        return clients.size();
    }

    // Метод для получения всех клиентов (опционально)
    public Map<Integer, Client> getAllClients() {
        return new HashMap<>(clients); // Возвращает копию коллекции клиентов
    }
}
