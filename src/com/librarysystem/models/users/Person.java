package src.com.librarysystem.models.users;

public interface Person {
    int getId();
    String getName();
    String getEmail();
    String showInfo();
    void update(String message);
}
