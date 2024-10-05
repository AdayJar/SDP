package src.com.librarysystem;

import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.factory.SimpleBookFactory;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.Book;
import src.com.librarysystem.service.BookService;

public class Main {
    public static void main(String[] args) {
    
        BookManager bookManager = new BookManager();

      
        SimpleBookFactory bookFactory = new SimpleBookFactory();

    
        BookService bookService = new BookService(bookManager);

    
        Book physicalBook = bookFactory.createPhysicalBook(1, "Physical Book Title", "Author 1", 300, true);
        Book eBook = bookFactory.createEBook(2, "EBook Title", "Author 2", 2.5, true);
        Book audioBook = bookFactory.createAudioBook(3, "AudioBook Title", "Author 3", 5.0, true);

        bookManager.addBook(physicalBook);
        bookManager.addBook(eBook);
        bookManager.addBook(audioBook);

        
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
            bookService.cancelReservation(1);
            System.out.println("Reservation for Physical Book cancelled.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

        
        bookManager.removeBook(1);
        System.out.println("Physical Book removed.");

        System.out.println("\n=============================\n");

       
        System.out.println("Remaining books in the system:");
        bookManager.getAllBooks().forEach(book -> System.out.println(book.showInfo()));
        
        System.out.println("\n=============================\n");
    }
}
