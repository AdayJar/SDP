package src.com.librarysystem;

import src.com.librarysystem.models.clients.Client;
import src.com.librarysystem.command.AddReviewCommand;
import src.com.librarysystem.command.Command;
import src.com.librarysystem.command.RemoveReviewCommand;
import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.exceptions.ClientNotFoundException;
import src.com.librarysystem.factory.bookAbstractFactory.AbstractFactory;
import src.com.librarysystem.factory.bookAbstractFactory.LibraryFactory;
import src.com.librarysystem.factory.clientFactory.ClientFactory;
import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.models.magazine.Magazine;
import java.time.LocalDate;
import src.com.librarysystem.report.Report;
import src.com.librarysystem.service.BookService;
import src.com.librarysystem.service.ClientService;
import src.com.librarysystem.manager.*;




public class Main {
    public static void main(String[] args) {

        BookManager bookManager = BookManager.getInstance();
        ClientManager clientManager = ClientManager.getInstance();
        BookService bookService = new BookService(bookManager);
        ClientService clientService = new ClientService(clientManager);

        AbstractFactory libraryFactory = new LibraryFactory();

        Book physicalBook = libraryFactory.createPhysicalBook(1, "Physical Book Title", "Author A", 300, true);
        bookManager.addBook(physicalBook); 

        Book eBook = libraryFactory.createEBook(2, "E-Book Title", "Author B", 1.5, true);
        bookManager.addBook(eBook); 

        Book audioBook = libraryFactory.createAudioBook(3, "AudioBook Title", "Author C", 5.0, true);
        bookManager.addBook(audioBook); 

        Magazine monthlyMagazine = libraryFactory.createMonthlyMagazine(4, "Monthly Magazine Title", "Editor A", true, 10);
    

        Magazine weeklyMagazine = libraryFactory.createWeeklyMagazine(5, "Weekly Magazine Title", "Editor B", true, "Week 40");
        

        System.out.println("\n=============================\n");
        System.out.println(physicalBook.showInfo());
        System.out.println(eBook.showInfo());
        System.out.println(audioBook.showInfo());
        System.out.println(monthlyMagazine.showInfo());
        System.out.println(weeklyMagazine.showInfo());

        Client regularClient = ClientFactory.createRegularClient(1, "Akhmetova Dilyara", "akhmetova_dilyara@gmail.com");
        Client premiumClient1 = ClientFactory.createPremiumClient(2, "Beisembay Umitzhan", "beisembay_umitzhan@gmail.com", 0.1);
        Client premiumClient2 = ClientFactory.createPremiumClient(3, "Mustafa Akerke", "mustafa_akerke@gmail.com", 0.05);

        clientManager.addClient(regularClient);
        clientManager.addClient(premiumClient1);
        clientManager.addClient(premiumClient2);

        clientManager.getTotalClients();

        System.out.println("\n=============================\n");
        System.out.println(regularClient);
        System.out.println(premiumClient1);
        System.out.println(premiumClient2);

        System.out.println("\n=============================\n");

        try {
            clientService.reserve(1, 1); 
            clientService.reserve(1, 2); 
            clientService.reserve(1, 3); 
            clientService.reserve(2, 1); 
            clientService.reserve(2, 2); 
            clientService.reserve(2, 3);
        } catch (ClientNotFoundException e) {
            System.out.println("Reservation error: " + e.getMessage());
        }
        System.out.println("\n=============================\n");


        Report monthlyReport = new Report.ReportBuilder()
                .setTitle("Report for September")
                .setContent("In this month 150 books were reserved and 30 new clients were added.")
                .setCreationDate(LocalDate.now())
                .build();

        System.out.println("\n=============================\n");
        System.out.println(monthlyReport);

        try {
            boolean isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available: " + isAvailable);

            isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available after reservation: " + isAvailable);

            isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available after cancellation: " + isAvailable);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        bookManager.removeBook(1);
        System.out.println("Physical Book removed.");

        System.out.println("\nRemaining books in the system:");
        int totalBooks = bookManager.getTotalBooks();
        System.out.println("Total count: " + totalBooks);
        bookManager.getAllBooks().forEach(book -> System.out.println(book.showInfo()));

        System.out.println("\n=============================\n");

        ReviewManager reviewManager = new ReviewManager();
        HistoryManager historyManager = new HistoryManager();

        Command addReview1 = new AddReviewCommand(reviewManager, "Great book!");
        Command addReview2 = new AddReviewCommand(reviewManager, "Not bad.");
        Command removeReview = new RemoveReviewCommand(reviewManager, 0);

        historyManager.executeCommand(addReview1);
        historyManager.executeCommand(addReview2);
        reviewManager.showReviews();

        historyManager.executeCommand(removeReview);
        reviewManager.showReviews();

        historyManager.undoLastCommand(); 
        reviewManager.showReviews();

        historyManager.undoLastCommand(); 
        reviewManager.showReviews();

    
    }
}
