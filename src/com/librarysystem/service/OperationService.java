package src.com.librarysystem.service;

import src.com.librarysystem.facade.LibraryFacade;
import src.com.librarysystem.manager.ReviewManager;
import src.com.librarysystem.manager.SessionManager;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.book.AudioBook;
import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.models.book.EBook;
import src.com.librarysystem.models.book.PhysicalBook;
import src.com.librarysystem.report.Report;
import src.com.librarysystem.strategy.AuthorSearchStrategy;
import src.com.librarysystem.strategy.GenreSearchStrategy;
import src.com.librarysystem.strategy.TitleSearchStrategy;
import src.com.librarysystem.models.clients.Client;
import src.com.librarysystem.models.magazine.Magazine;
import src.com.librarysystem.models.magazine.MonthlyMagazine;
import src.com.librarysystem.models.magazine.WeeklyMagazine;
import src.com.librarysystem.command.*;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class OperationService {
    private LibraryFacade libraryFacade;
    private ClientService clientService;
    private ReviewManager reviewManager;
    AuthService authService = new AuthService();

    public OperationService(LibraryFacade libraryFacade, ClientService clientService,
                           ReviewManager reviewManager) {
        this.libraryFacade = libraryFacade;
        this.clientService = clientService;
        this.reviewManager = reviewManager;
    }

    public void addItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose type to add: 1. Book 2. Magazine");
        int typeChoice = scanner.nextInt();

        if (typeChoice == 1) {
            System.out.println("Choose book type: 1. PhysicalBook 2. EBook 3. AudioBook");
            int bookChoice = scanner.nextInt();

            System.out.println("Enter ID:");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Title:");
            String title = scanner.nextLine();
            System.out.println("Enter Author:");
            String author = scanner.nextLine();
            System.out.println("Enter Genre:");
            String genre = scanner.nextLine();
            System.out.println("Enter Publication Year:");
            int publicationYear = scanner.nextInt();

            Book book;
            switch (bookChoice) {
                case 1 -> {
                    System.out.println("Enter Number of Pages:");
                    int pages = scanner.nextInt();
                    System.out.println("Enter URL:");
                    String url = scanner.next();
                    book = new PhysicalBook(id, title, author, genre, publicationYear, pages, true, url);
                }
                case 2 -> {
                    System.out.println("Enter File Size (MB):");
                    double sizeMB = scanner.nextDouble();
                    System.out.println("Enter URL:");
                    String url = scanner.next();
                    book = new EBook(id, title, author, genre, publicationYear, sizeMB, true, url);
                }
                case 3 -> {
                    System.out.println("Enter Duration (hours):");
                    double duration = scanner.nextDouble();
                    System.out.println("Enter URL:");
                    String url = scanner.next();
                    book = new AudioBook(id, title, author, genre, publicationYear, duration, true, url);
                }
                default -> {
                    System.out.println("Invalid choice");
                    return;
                }
            }

            libraryFacade.addBook(book);

        } else if (typeChoice == 2) {
            System.out.println("Choose magazine type: 1. Monthly Magazine 2. Weekly Magazine");
            int magazineChoice = scanner.nextInt();

            System.out.println("Enter ID:");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Enter Title:");
            String title = scanner.nextLine();
            System.out.println("Enter Editor:");
            String editor = scanner.nextLine();

            Magazine magazine;
            switch (magazineChoice) {
                case 1 -> {
                    System.out.println("Enter Issue Number:");
                    int issueNumber = scanner.nextInt();
                    System.out.println("Enter URL:");
                    String url = scanner.next();
                    magazine = new MonthlyMagazine(id, title, editor, true, issueNumber, url);
                }
                case 2 -> {
                    System.out.println("Enter Week of Publication:");
                    String weekOfPublication = scanner.next();
                    System.out.println("Enter URL:");
                    String url = scanner.next();
                    magazine = new WeeklyMagazine(id, title, editor, true, weekOfPublication, url);
                }
                default -> {
                    System.out.println("Invalid choice");
                    return;
                }
            }

            libraryFacade.addMagazine(magazine);
        } else {
            System.out.println("Invalid type choice");
        }
    }

    public void deleteItem() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter type to delete (1 - Book, 2 - Magazine): ");
        int choice = scanner.nextInt();
    
        System.out.print("Enter ID to delete: ");
        int itemId = scanner.nextInt();
    
        try {
            if (choice == 1) { 
                Book book = libraryFacade.findBookById(itemId);
                if (book != null) {
                    libraryFacade.removeBook(itemId);
                    System.out.println("Book deleted: " + book.showInfo());
                } else {
                    System.out.println("Book with ID " + itemId + " not found.");
                }
            } else if (choice == 2) {
                Magazine magazine = libraryFacade.findMagazineById(itemId);
                if (magazine != null) {
                    libraryFacade.removeMagazine(itemId);
                    System.out.println("Magazine deleted: " + magazine.showInfo());
                } else {
                    System.out.println("Magazine with ID " + itemId + " not found.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Error during deletion: " + e.getMessage());
        }
    }

    public void manageClients(Scanner scanner) {
        System.out.println("1. Add Client\n2. Remove Client\n3. Find Client");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
            case 1 -> authService.registerUser();
            case 2 -> deleteClient(scanner);
            case 3 -> findClient(scanner);
            default -> System.out.println("Invalid choice.");
        }
    }

    private void deleteClient(Scanner scanner) {
        System.out.print("Enter Client ID to delete: ");
        int id = scanner.nextInt();
        Client client = libraryFacade.findClientById(id);
        
        if (client != null) {
            libraryFacade.removeClient(id);
            System.out.println("Client removed: " + client.showInfo());
        } else {
            System.out.println("Client with ID " + id + " not found.");
        }
    }

    private void findClient(Scanner scanner) {
        System.out.print("Enter Client ID to find: ");
        int id = scanner.nextInt();
        Client client = libraryFacade.findClientById(id);
        if (client != null) {
            System.out.println("Found client: " + client.showInfo());
        } else {
            System.out.println("Client not found.");
        }
    }

    public void viewReports() {
        Scanner scanner = new Scanner(System.in);

        String monthName = LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());

        int totalBooks = libraryFacade.getTotalBooks();
        int totalMagazines = libraryFacade.getTotalMagazines();
        int totalClients = libraryFacade.getTotalClients();

        String content = "This month, " + totalBooks +
                         " books were reserved, " + totalMagazines + " magazines were reserved, and " + totalClients + " clients are in the system.";
    
        // Build and display the report
        Report monthlyReport = new Report.ReportBuilder()
                .setTitle("Report for " + monthName)
                .setContent(content)
                .setCreationDate(LocalDate.now())
                .build();
    
        System.out.println(monthlyReport);
    }

    public void manageReviews() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your review: ");
        String userReview1 = scanner.nextLine();
        Command addReview1 = new AddReviewCommand(reviewManager, userReview1);
    }

    public void showAvailableMagazines() {
        libraryFacade.showMagazines();
    }

    public void showAvailableBooks() {
        libraryFacade.showBooks();
    }

    public void makeReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book ID you wish to reserve: ");
        
        if (scanner.hasNextInt()) {
            int bookId = scanner.nextInt(); 
            
            try {
                int clientId = SessionManager.getInstance().getCurrentClientId(); 
                clientService.reserve(clientId, bookId); 
                System.out.println("Reservation successful for client ID " + clientId + " and book ID " + bookId);
            } catch (Exception e) {
                System.out.println("Error during reservation: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid input! Please enter a numeric book ID.");
            scanner.next(); 
        }
    }
    
    public void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book ID you wish to cancel the reservation for: ");
        int bookId = scanner.nextInt(); 
    
        try {
            int clientId = SessionManager.getInstance().getCurrentClientId(); 
            clientService.cancelReserve(clientId, bookId);
            System.out.println("Reservation canceled for client ID " + clientId + " and book ID " + bookId);
        } catch (Exception e) {
            System.out.println("Error during cancellation: " + e.getMessage());
        }
    }

    public void searchBooks() {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        System.out.println("Select search criterion:");
        System.out.println("1. Author");
        System.out.println("2. Title");
        System.out.println("3. Genre");
        System.out.print("Enter your choice (1-3): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String criterion = "";
        switch (choice) {
            case 1:
                System.out.print("Enter author name: ");
                criterion = scanner.nextLine();
                bookManager.setSearchStrategy(new AuthorSearchStrategy());
                break;
            case 2:
                System.out.print("Enter book title: ");
                criterion = scanner.nextLine();
                bookManager.setSearchStrategy(new TitleSearchStrategy());
                break;
            case 3:
                System.out.print("Enter genre: ");
                criterion = scanner.nextLine();
                bookManager.setSearchStrategy(new GenreSearchStrategy());
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        List<Integer> foundBookIds = bookManager.searchBooks(criterion);
        System.out.println("Books found with the given criterion (IDs): " + foundBookIds);
    }

}