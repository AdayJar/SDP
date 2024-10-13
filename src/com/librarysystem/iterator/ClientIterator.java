package src.com.librarysystem.iterator;

import src.com.librarysystem.manager.ClientManager;
import src.com.librarysystem.models.clients.Client;

import java.util.Iterator;
import java.util.Map;

// Итератор для класса ClientManager
public class ClientIterator implements Iterator<Client> {
    private Iterator<Map.Entry<Integer, Client>> iterator; // Итератор для хэш-карты

    // Конструктор принимает ClientManager
    public ClientIterator(ClientManager clientManager) {
        this.iterator = clientManager.getClientsMap().entrySet().iterator(); // Инициализация итератора для хэш-карты
    }

    // Проверяет, есть ли следующий клиент
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    // Возвращает следующего клиента
    @Override
    public Client next() {
        if (!hasNext()) {
            throw new  IndexOutOfBoundsException("No more clients available."); 
        }
        return iterator.next().getValue(); // Получаем клиента из записи
    }
}
