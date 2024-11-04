package src.com.librarysystem;


import src.com.librarysystem.models.clients.Client;
import src.com.librarysystem.command.AddReviewCommand;
import src.com.librarysystem.command.Command;
import src.com.librarysystem.command.RemoveReviewCommand;
import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.exceptions.ClientNotFoundException;
import src.com.librarysystem.factory.bookabstractfactory.*;
import src.com.librarysystem.factory.clientFactory.ClientFactory;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.manager.ClientManager;
import src.com.librarysystem.manager.HistoryManager;
import src.com.librarysystem.manager.MagazineManager;
import src.com.librarysystem.manager.ReviewManager;
import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.models.magazine.Magazine;
import src.com.librarysystem.service.BookService;
import src.com.librarysystem.service.ClientService;
import src.com.librarysystem.service.MagazineService;
import src.com.librarysystem.report.Report;
import src.com.librarysystem.state.BookContext;
import src.com.librarysystem.strategy.AuthorSearchStrategy;
import src.com.librarysystem.strategy.GenreSearchStrategy;
import src.com.librarysystem.strategy.TitleSearchStrategy;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // Initialize managers and services
        BookManager bookManager = new BookManager();
        ClientManager clientManager = new ClientManager();
        BookService bookService = new BookService(bookManager);
        ClientService clientService = new ClientService(clientManager);
    
        MagazineManager magazineManager=new MagazineManager();
        MagazineService magazineServie=new MagazineService(magazineManager);

        // Create a factory for library objects
        AbstractFactory libraryFactory = new LibraryFactory();

        // Create and add books
        Book physicalBook = libraryFactory.createPhysicalBook(1, "1984", "George Orwell", "Dystopian", 1949, 328, true, "https://klex.ru/1718");
        bookManager.add(physicalBook);

        Book physicalBook2 = libraryFactory.createPhysicalBook(2, "To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, 281, true, "https://www.imdb.com/title/tt0056592/");
        bookManager.add(physicalBook2); 

        Book eBook = libraryFactory.createEBook(3, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925, 1.5, true, "https://flibusta.su/book/701-desyat-negrityat/");
        bookManager.add(eBook);

        Book audioBook = libraryFactory.createAudioBook(4, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951, 10.0, true, "https://flibusta.su/book/701-desyat-negrityat/");
        bookManager.add(audioBook);

        // Create magazines
        Magazine monthlyMagazine = libraryFactory.createMonthlyMagazine(5, "Monthly Magazine Title", "Editor A", true, 10);
        Magazine weeklyMagazine = libraryFactory.createWeeklyMagazine(6, "Weekly Magazine Title", "Editor B", true, "Week 40");
        magazineManager.add(monthlyMagazine);
        magazineManager.add(weeklyMagazine);

        // Output book information

        System.out.println("\n=============================\n");

        Iterator<Book> bookIterator = bookManager.getItems().iterator();
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
        clientManager.add(regularClient);
        clientManager.add(premiumClient1);
        clientManager.add(premiumClient2);

        // Output client information
        System.out.println("\n=============================\n");
       
        clientManager.getTotal();

        System.out.println("\n=============================\n");
        System.out.println(regularClient);
        System.out.println(premiumClient1);
        System.out.println(premiumClient2);

        System.out.println("\n=============================\n");
        // Reservation system
        try {
            clientService.reserve(1, 1); 
            clientService.reserve(1, 2); 
            clientService.reserve(1, 3); 
            clientService.reserve(2, 1); 
            clientService.reserve(2, 2); 
            clientService.reserve(2, 3);
            clientService.reserve(3, 1); 
        } catch (ClientNotFoundException e) {
            System.out.println("Reservation error: " + e.getMessage());
        }
        System.out.println("\n=============================\n");

        //Strategy pattern for searching books
        bookManager.setSearchStrategy(new AuthorSearchStrategy());
        List<Integer> foundBookIdsByAuthor = bookManager.searchBooks("George Orwell");
        System.out.println("Books found by author IDs: " + foundBookIdsByAuthor);

        bookManager.setSearchStrategy(new TitleSearchStrategy());
        List<Integer> foundBookIdsByTitle = bookManager.searchBooks("1984");
        System.out.println("Books found by title IDs: " + foundBookIdsByTitle);

        bookManager.setSearchStrategy(new GenreSearchStrategy());
        List<Integer> foundBookIdsByGenre = bookManager.searchBooks("Fiction");
        System.out.println("Books found by genre IDs: " + foundBookIdsByGenre);


        // Report system 
        Report monthlyReport = new Report.ReportBuilder()
                .setTitle("Report for September")
                .setContent("In this month 150 books were reserved and 30 new clients were added.")
                .setCreationDate(LocalDate.now())
                .build();

        System.out.println("\n=============================\n");
        System.out.println(monthlyReport); // Show report

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
       try {
          bookService.openBook(1);
       } catch (BookNotFoundException e) {
          System.out.println(e.getMessage());
       } catch (IOException | URISyntaxException e) {
         System.out.println("Не удалось открыть ссылку: " + e.getMessage());
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
        int totalBooks = bookManager.getTotal();
        System.out.println("Total count: " + totalBooks);

        System.out.println("Remaining books:");
        bookIterator = bookManager.getItems().iterator();
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            System.out.println(book.showInfo()); // Show remaining books info
        }

        System.out.println("\n=============================\n");


        int totalMagazine = magazineManager.getTotal();
        System.out.println("Total count: " + totalMagazine);

        System.out.println("Remaining magazines:");

        Iterator<Magazine> magazineIterator = magazineManager.getItems().iterator();
        while (magazineIterator.hasNext()) {
            Magazine magazine = magazineIterator.next();
            System.out.println(magazine.showInfo()); // Show remaining books info
        }

        System.out.println("\n=============================\n");
        

        int totalClients = clientManager.getTotal();
        System.out.println("Total count: " + totalClients);

        System.out.println("Remaining clients:");


        Iterator<Client> clientIterator = clientManager.getItems().iterator();
        while (clientIterator.hasNext()) {
            Client client = clientIterator.next();
            System.out.println(client.showInfo()); 
        }
        
        // Review system
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
