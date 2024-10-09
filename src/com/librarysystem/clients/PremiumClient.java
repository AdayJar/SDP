package src.com.librarysystem.clients;

public class PremiumClient implements Client {
    private int id;
    private String name;
    private String email;
    private double discount; 

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
    public String toString() {
        return "PremiumClient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", discount=" + discount + "%" +
                '}';
    }
}
