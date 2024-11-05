package src.com.librarysystem.models.users;

public interface User extends Person {
    int getId();
    String getName();
    String getEmail();
    String showInfo();
    void update(String message);
}
