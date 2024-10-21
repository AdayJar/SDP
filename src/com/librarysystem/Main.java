package src.com.librarysystem;

import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.exceptions.ClientNotFoundException;
import src.com.librarysystem.factory.bookAbstractFactory.AbstractFactory;
import src.com.librarysystem.factory.bookAbstractFactory.LibraryFactory;
import src.com.librarysystem.factory.clientFactory.ClientFactory;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.manager.ClientManager;
import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.models.clients.Client;
import src.com.librarysystem.models.magazine.Magazine;
import src.com.librarysystem.service.BookService;
import src.com.librarysystem.service.ClientService;
import src.com.librarysystem.report.Report;
import src.com.librarysystem.state.BookContext;
import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        
        // Initialize managers and services
        BookManager bookManager = BookManager.getInstance();
        ClientManager clientManager = ClientManager.getInstance();
        BookService bookService = new BookService(bookManager);
        ClientService clientService = new ClientService(clientManager);

        // Create a factory for library objects
        AbstractFactory libraryFactory = new LibraryFactory();

        // Create and add books
        Book physicalBook = libraryFactory.createPhysicalBook(1, "Physical Book Title", "Author A", 300, true);
        bookManager.addBook(physicalBook);

        Book eBook = libraryFactory.createEBook(2, "E-Book Title", "Author B", 1.5, true);
        bookManager.addBook(eBook);

        Book audioBook = libraryFactory.createAudioBook(3, "AudioBook Title", "Author C", 5.0, true);
        bookManager.addBook(audioBook);

        // Create magazines
        Magazine monthlyMagazine = libraryFactory.createMonthlyMagazine(4, "Monthly Magazine Title", "Editor A", true, 10);
        Magazine weeklyMagazine = libraryFactory.createWeeklyMagazine(5, "Weekly Magazine Title", "Editor B", true, "Week 40");

        // Output book information
        System.out.println("\n=============================\n");
        Iterator<Book> bookIterator = bookManager.getAllBooks().iterator();
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            System.out.println(book.showInfo()); // Show book info
        }

        // Output magazine information
        System.out.println(monthlyMagazine.showInfo());
        System.out.println(weeklyMagazine.showInfo());

        // Create clients
        Client regularClient = ClientFactory.createRegularClient(1, "Akhmetova Dilyara", "akhmetova_dilyara@gmail.com");
        Client premiumClient1 = ClientFactory.createPremiumClient(2, "Beisembay Umitzhan", "beisembay_umitzhan@gmail.com", 0.1);
        Client premiumClient2 = ClientFactory.createPremiumClient(3, "Mustafa Akerke", "mustafa_akerke@gmail.com", 0.05);

        // Add clients to manager
        clientManager.addClient(regularClient);
        clientManager.addClient(premiumClient1);
        clientManager.addClient(premiumClient2);

        // Output client information
        System.out.println("\n=============================\n");
        Iterator<Client> clientIterator = clientManager.createIterator(); 
        while (clientIterator.hasNext()) {
            Client client = clientIterator.next();
            System.out.println(client); // Show client info
        }

        // Create and output a report
        Report monthlyReport = new Report.ReportBuilder()
                .setTitle("Report for September")
                .setContent("In this month 150 books were reserved and 30 new clients were added.")
                .setCreationDate(LocalDate.now())
                .build();

        System.out.println("\n=============================\n");
        System.out.println(monthlyReport); // Show report

        // Check book availability and manage reservations
        try {
            boolean isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available: " + isAvailable);

            clientService.reserve(1); // Reserve book
            System.out.println("Physical Book reserved successfully.");

            isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available after reservation: " + isAvailable);

            clientService.cancelReserve(1); // Cancel reservation
            System.out.println("Reservation for Physical Book cancelled.");

            isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available after cancellation: " + isAvailable);
        } catch (BookNotFoundException | ClientNotFoundException e) {
            System.out.println(e.getMessage()); // Handle exceptions
        }

        // Change book availability
        try {
            bookService.changeAvailability(1, false); // Change book availability
            System.out.println("Physical Book availability changed to: false");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Delete book
        BookContext bookContext = new BookContext();
        try {
            bookContext.delete(physicalBook, bookManager); // Delete book
            System.out.println("Physical Book removed.");
        } catch (Exception e) {
            System.out.println("Failed to delete the book: " + e.getMessage());
        }

        // Output remaining books in the system
        System.out.println("\nRemaining books in the system:");
        int totalBooks = bookManager.getTotalBooks();
        System.out.println("Total count: " + totalBooks);

        System.out.println("Remaining books:");
        bookIterator = bookManager.getAllBooks().iterator();
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            System.out.println(book.showInfo()); // Show remaining books info
        }

        System.out.println("\n=============================\n");
    }
}
