package src.com.librarysystem.models.clients;

import src.com.librarysystem.models.users.UserRole;

public class RegularClient implements Client {
    private final int id;
    private final String name;
    private final String email;

    public RegularClient(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String showInfo() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email;
    }

    @Override
    public void update(String message) {
        System.out.println("Уведомление для регулярного клиента " + name + ": " + message);
    }

    @Override
    public UserRole getRole() { 
        return UserRole.REGULAR_CLIENT;
    }
    
    @Override
    public String toString() {
        return "RegularClient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
