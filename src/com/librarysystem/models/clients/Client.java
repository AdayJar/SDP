package src.com.librarysystem.models.clients;

public interface Client {
    int getId();
    String getName();
    String getEmail();
    void update(String message); // Метод для получения уведомлений
}
