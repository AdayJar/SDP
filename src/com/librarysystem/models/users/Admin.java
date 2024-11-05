package src.com.librarysystem.models.users;

public class Admin implements User {
    private final int id;
    private final String name;
    private final String email;

    public Admin(int id, String name, String email) {
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
        return "Admin ID: " + id + ", Name: " + name + ", Email: " + email;
    }

    @Override
    public void update(String message) {
        System.out.println("Admin notification for " + name + ": " + message);
    }

    public void manageLibrary() {
        System.out.println("Admin " + name + " is managing the library.");
    }
}
