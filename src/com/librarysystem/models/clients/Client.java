package src.com.librarysystem.models.clients;
import src.com.librarysystem.models.users.Person;

public interface Client extends Person {
    int getId();
    String getName();
    String getEmail();
    void update(String message);
    String showInfo();
}
