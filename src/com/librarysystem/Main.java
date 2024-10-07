package src.com.librarysystem;

import src.com.librarysystem.clients.Client;
import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.factory.ClientFactory;
import src.com.librarysystem.factory.LibraryFactory;
import src.com.librarysystem.factory.SimpleBookFactory;
import src.com.librarysystem.magazines.Magazine;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.Book;
import src.com.librarysystem.service.BookService;
import java.time.LocalDate;
import src.com.librarysystem.report.Report;
import src.com.librarysystem.factory.AbstractFactory;


public class Main {
    public static void main(String[] args) {
       
        BookManager bookManager = BookManager.getInstance();
        SimpleBookFactory bookFactory = new SimpleBookFactory();
        BookService bookService = new BookService(bookManager);
        
        AbstractFactory libraryFactory = new LibraryFactory();
        
        Book physicalBook = libraryFactory.createPhysicalBook(1, "Physical Book Title", "Author A", 300, true);
        Book eBook = libraryFactory.createEBook(2, "E-Book Title", "Author B", 1.5, true);
        Book audioBook = libraryFactory.createAudioBook(3, "AudioBook Title", "Author 3", 5.0, true);
        Magazine monthlyMagazine = libraryFactory.createMonthlyMagazine(3, "Monthly Magazine Title", "Editor A", true, 10);
        Magazine weeklyMagazine = libraryFactory.createWeeklyMagazine(4, "Weekly Magazine Title", "Editor B", true, "Week 40");
        
        System.out.println("\n=============================\n");

        System.out.println(physicalBook.showInfo());
        System.out.println(eBook.showInfo());
        System.out.println(audioBook.showInfo());
        System.out.println(monthlyMagazine.showInfo());
        System.out.println(weeklyMagazine.showInfo());

        Client regularClient = ClientFactory.createRegularClient(1, "Akhmetova Dilyara", "akhmetova_dilyara@gmail.com");
        Client premiumClient1 = ClientFactory.createPremiumClient(2, "Beisembay Umitzhan", "beisembay_umitzhan@gmail.com", 0.1);
        Client premiumClient2 = ClientFactory.createPremiumClient(3, "Mustafa Akerke", "mustafa_akerke@gmail.com", 0.05);

        System.out.println("\n=============================\n");

        System.out.println(regularClient);
        System.out.println(premiumClient1);
        System.out.println(premiumClient2);

        System.out.println("\n=============================\n");
        // Builder
        Report monthlyReport = new Report.ReportBuilder()
                .setTitle("Report for September")
                .setContent("In this month 150 books were reserved and 30 new clients were added.")
                .setCreationDate(LocalDate.now())
                .build();

        System.out.println(monthlyReport);
        

        System.out.println("\n=============================\n");


        try {
            boolean isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available: " + isAvailable);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

     
        try {
            bookService.reserveBook(1);
            System.out.println("Physical Book reserved successfully.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

        try {
            boolean isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available: " + isAvailable);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

 
        try {
            bookService.cancelReservation(1);
            System.out.println("Reservation for Physical Book cancelled.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");
        try {
            boolean isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available: " + isAvailable);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\n-----------------------------\n");

     
      
        bookManager.removeBook(1);
        System.out.println("Physical Book removed.");

        System.out.println("\n=============================\n");

        Book oldBook = bookManager.findBookById(2);
        Book updatedBook = oldBook.clone();
        
   
        
    
      
        bookManager.addBook(updatedBook);


        System.out.println("\n=============================\n");

        Book bookend=bookManager.findBookById(3);
       
        try {
            bookend.changeAvailability(false); 
            System.out.println("Book availability changed to: " + updatedBook.isAvailable());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Remaining books in the system:");

        System.out.println("");

        int totalBooks = bookManager.getTotalBooks();
        
        System.out.println("Total count: " + totalBooks);
        System.out.println("");

        bookManager.getAllBooks().forEach(book -> System.out.println(book.showInfo()));

        System.out.println("\n=============================\n");
        
        
    }
}
