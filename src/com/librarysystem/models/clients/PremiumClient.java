package src.com.librarysystem.models.clients;

import src.com.librarysystem.models.users.UserRole;

public class PremiumClient implements Client {
    private final int id;
    private final String name;
    private final String email;
    private final double discount;

    public PremiumClient(int id, String name, String email, double discount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.discount = discount;
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

    public double getDiscount() {
        return discount;
    }
    @Override
    public String showInfo() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email + ", Discount: " + discount ;
    }

    @Override
    public void update(String message) {
        System.out.println("Уведомление для премиум-клиента " + name + ": " + message);
    }

    @Override
    public UserRole getRole() {
        return UserRole.PREMIUM_CLIENT;
    }
    
    @Override
    public String toString() {
        return "PremiumClient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", discount=" + discount + "%" +
                '}';
    }
}
