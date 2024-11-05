package src.com.librarysystem.service;

import src.com.librarysystem.models.clients.RegularClient;
import src.com.librarysystem.models.clients.PremiumClient;
import src.com.librarysystem.models.users.Admin;
import src.com.librarysystem.models.users.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class AuthService {
    private static final String ADMIN_PASSWORD = "DAR"; // Default admin password

    private Map<String, PremiumClient> premiumClients = new HashMap<>();
    private Map<String, RegularClient> regularClients = new HashMap<>();
    private static Map<String, Admin> admins = new HashMap<>();
    private Map<Integer, String> premiumKeys = new HashMap<>(); // Store premium client keys

    static {
        Admin defaultAdmin1 = new Admin(1, "Aday", "adaydhx@gmail.com");
        Admin defaultAdmin2 = new Admin(2, "Dilyara", "dilyara123@gmail.com");
        Admin defaultAdmin3 = new Admin(3, "Rakhat", "rakhatlukum@gmail.com");

        // It is assumed that the email in the admin collection is unique
        admins.put(defaultAdmin1.getEmail(), defaultAdmin1);
        admins.put(defaultAdmin2.getEmail(), defaultAdmin2);
        admins.put(defaultAdmin3.getEmail(), defaultAdmin3);
    }

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose account type:\n1. Regular Client\n2. Premium Client.");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // The ID should not be entered by the user; it should be assigned automatically.
        // int id = scanner.nextInt();
        // scanner.nextLine(); // consume newline
        int id = generateNextId(); // Generate the next available ID

        String name = "";
        while (true) {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if (isValidName(name)) {
                break;
            } else {
                System.out.println("Name must consist only of English letters and not contain digits or special characters. Please try again.");
            }
        }

        String email = "";
        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                if (regularClients.containsKey(email) || premiumClients.containsKey(email) || admins.containsKey(email)) {
                    System.out.println("A user with this email is already registered.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid email format. Email must contain the '@' symbol. Please try again.");
            }
        }

        if (choice == 1) {
            RegularClient newUser = new RegularClient(id, name, email);
            regularClients.put(email, newUser);
            System.out.println("Regular client registered: " + newUser.showInfo());
        } else if (choice == 2) {
            System.out.println("A payment of 5000 is required to register as a premium client. Pay? (yes/no)");
            String paymentResponse = scanner.nextLine();

            if (paymentResponse.equalsIgnoreCase("yes")) {
                double discount = 10.0; // Set standard discount
                PremiumClient newUser = new PremiumClient(id, name, email, discount);

                // Generate unique key and save it for premium client
                String accessKey = UUID.randomUUID().toString();
                premiumKeys.put(id, accessKey);
                premiumClients.put(email, newUser);

                System.out.println("Payment accepted. Your premium key: " + accessKey);
                System.out.println("Premium client registered: " + newUser.showInfo());
            } else {
                System.out.println("Premium client registration canceled.");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }

    // Method to generate the next available ID
    private int generateNextId() {
        // You need to implement logic here to find the next available ID
        // For example, this could be done by checking the highest ID in the existing clients
        return Math.max(premiumClients.size(), regularClients.size()) + 1; // Basic logic for ID generation
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+"); // Check for English letters only
    }

    private boolean isValidEmail(String email) {
        return email.contains("@"); // Check for '@' symbol
    }

    public Person loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you an administrator or a client? (admin/client): ");
        String userType = scanner.nextLine();

        if (userType.equalsIgnoreCase("admin")) {
            System.out.print("Enter admin email: ");
            String email = scanner.nextLine();
            if (admins.containsKey(email)) {
                System.out.print("Enter admin password: ");
                String inputPassword = scanner.nextLine();
                if (ADMIN_PASSWORD.equals(inputPassword)) {
                    Admin admin = admins.get(email);
                    System.out.println("Login successful. Welcome, admin " + admin.getName() + "!");
                    return admin;
                } else {
                    System.out.println("Incorrect password!");
                }
            } else {
                System.out.println("Admin not found.");
            }
        } else if (userType.equalsIgnoreCase("client")) {
            System.out.print("Are you a premium or regular client? (premium/regular): ");
            String clientType = scanner.nextLine();

            System.out.print("Enter email for login: ");
            String email = scanner.nextLine();

            if (clientType.equalsIgnoreCase("premium")) {
                if (premiumClients.containsKey(email)) {
                    PremiumClient premiumClient = premiumClients.get(email);
                    System.out.print("Enter your premium key: ");
                    String inputKey = scanner.nextLine();
                    String storedKey = premiumKeys.get(premiumClient.getId());

                    if (storedKey != null && storedKey.equals(inputKey)) {
                        System.out.println("Login successful. Welcome, premium client " + premiumClient.getName() + "!");
                        return premiumClient;
                    } else {
                        System.out.println("Incorrect premium key!");
                    }
                } else {
                    System.out.println("Premium client not found.");
                }
            } else if (clientType.equalsIgnoreCase("regular")) {
                if (regularClients.containsKey(email)) {
                    RegularClient regularClient = regularClients.get(email);
                    System.out.println("Login successful. Welcome, " + regularClient.getName() + "!");
                    return regularClient;
                } else {
                    System.out.println("Regular client not found.");
                }
            } else {
                System.out.println("Invalid client type.");
            }
        } else {
            System.out.println("Invalid user type.");
        }
        return null;
    }
}
