package src.com.librarysystem.service;

import src.com.librarysystem.exceptions.ClientNotFoundException; // Исключение на случай, если клиент не найден
import src.com.librarysystem.manager.ClientManager; // Менеджер для управления клиентами
import src.com.librarysystem.models.clients.Client; // Интерфейс клиента

public class ClientService {
    private final ClientManager clientManager; // Менеджер для управления клиентами

    // Конструктор для инициализации ClientManager
    public ClientService(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    // Метод для резервирования клиентом книги
    public void reserve(int clientId) throws ClientNotFoundException {
        // Найти клиента по его ID
        Client client = clientManager.findClientById(clientId);
        // Проверить, существует ли клиент
        if (client == null) {
            throw new ClientNotFoundException("Client with ID " + clientId + " not found."); // Исключение, если клиент не найден
        }
        // Выполнить действия по резервированию
        System.out.println("Client " + client.getName() + " has reserved a book.");
    }

    // Метод для отмены резервирования клиентом
    public void cancelReserve(int clientId) throws ClientNotFoundException {
        // Найти клиента по его ID
        Client client = clientManager.findClientById(clientId);
        // Проверить, существует ли клиент
        if (client == null) {
            throw new ClientNotFoundException("Client with ID " + clientId + " not found."); // Исключение, если клиент не найден
        }
        // Выполнить действия по отмене резервирования
        System.out.println("Client " + client.getName() + " has canceled the reservation.");
    }

    // Дополнительные методы для управления клиентами могут быть добавлены по мере необходимости
}
