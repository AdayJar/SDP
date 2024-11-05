package src.com.librarysystem;

import src.com.librarysystem.service.AuthService;
import src.com.librarysystem.facade.LibraryFacade;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.manager.ClientManager;
import src.com.librarysystem.manager.ReviewManager;
import src.com.librarysystem.models.clients.Client;
import src.com.librarysystem.models.users.Admin;
import src.com.librarysystem.models.users.Person;
import src.com.librarysystem.service.BookService;
import src.com.librarysystem.service.ClientService;
import src.com.librarysystem.service.OperationService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        LibraryFacade libraryFacade = new LibraryFacade();
        BookManager bookManager = new BookManager();
        ClientManager clientManager = new ClientManager();
        BookService bookService = new BookService(bookManager);
        ClientService clientService = new ClientService(clientManager);
        ReviewManager reviewManager = new ReviewManager();
        
        boolean isAuthenticated = false;
        Person role = null;

        System.out.println("Welcome to the library system!");

        // User authentication
        while (!isAuthenticated) {
            System.out.println("Select an action:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            int authChoice = scanner.nextInt();
            scanner.nextLine();

            switch (authChoice) {
                case 1:
                    authService.registerUser();
                    break;
                case 2:
                    role = authService.loginUser(); 
                    isAuthenticated = role != null;
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        if (role instanceof Admin) { // Check if role is an instance of Admin
            showAdminMenu(scanner, libraryFacade, bookService, clientService, reviewManager);
        } else if (role instanceof Client) { // Check if role is an instance of Client
            showUserMenu(scanner, libraryFacade, bookService, clientService, reviewManager);
        } else {
            System.out.println("User role error. Please try again.");
        }

        scanner.close();
    }

    private static void showAdminMenu(Scanner scanner, LibraryFacade libraryFacade, BookService bookService, 
                                      ClientService clientService, ReviewManager reviewManager) {
        OperationService operationService = new OperationService(libraryFacade, clientService, reviewManager);

        int choice;
        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Manage clients");
            System.out.println("4. View reports");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    operationService.addItem();
                    break;
                case 2:
                    operationService.deleteItem();
                    break;
                case 3:
                    operationService.manageClients(scanner);
                    break;
                case 4:
                    operationService.viewReports();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);
    }

    private static void showUserMenu(Scanner scanner, LibraryFacade libraryFacade, BookService bookService, 
                                     ClientService clientService, ReviewManager reviewManager) {
        OperationService operationService = new OperationService(libraryFacade, clientService, reviewManager);

        int choice;
        do {
            System.out.println("\nUser Menu:");
            System.out.println("1. View available books");
            System.out.println("2. View available magazines");
            System.out.println("3. Reserve a book");
            System.out.println("4. Cancel book reservation");
            System.out.println("5. Search for a book");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    operationService.showAvailableBooks();
                    break;
                case 2:
                    operationService.showAvailableMagazines();
                    break;
                case 3:
                    operationService.makeReservation();
                    break;
                case 4:
                    operationService.cancelReservation();
                    break; 
                case 5:
                    operationService.searchBooks();
                    break;
                case 0:
                    System.out.println("Exiting user menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        } while (choice != 0);
    }
}
