<<<<<<< HEAD
package SDP.src.com.librarysystem;

import SDP.src.com.librarysystem.exceptions.BookNotFoundException;
import SDP.src.com.librarysystem.factory.SimpleBookFactory;
import SDP.src.com.librarysystem.manager.BookManager;
import SDP.src.com.librarysystem.models.Book;
import SDP.src.com.librarysystem.service.BookService;

public class Main {
    public static void main(String[] args) {
     
        BookManager bookManager = new BookManager();

    
        SimpleBookFactory bookFactory = new SimpleBookFactory();

    
        BookService bookService = new BookService(bookManager);

        
        Book physicalBook = bookFactory.createPhysicalBook(1, "Physical Book Title", "Author 1", 300, true);
        Book eBook = bookFactory.createEBook(2, "EBook Title", "Author 2", 2.5, true);
        Book audioBook = bookFactory.createAudioBook(3, "AudioBook Title", "Author 3", 5.0, true);

=======
package src.com.librarysystem;

import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.factory.SimpleBookFactory;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.Book;
import src.com.librarysystem.service.BookService;

public class Main {
    public static void main(String[] args) {

       
        BookManager bookManager = BookManager.getInstance();

        SimpleBookFactory bookFactory = new SimpleBookFactory();

        BookService bookService = new BookService(bookManager);


        Book physicalBook = bookFactory.createPhysicalBook(1, "Head First Design Patterns", "Elisabeth Robson", 694, true);
        Book eBook = bookFactory.createEBook(2, "Grokking Algorithms", " Aditya Bhargava", 10.2, true);
        Book audioBook = bookFactory.createAudioBook(3, "Язык Go для начинающих", "Максим Жашкевич", 40.0, true);

       
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
        bookManager.addBook(physicalBook);
        bookManager.addBook(eBook);
        bookManager.addBook(audioBook);

<<<<<<< HEAD
  
=======
        System.out.println("\n=============================\n");


>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
        try {
            boolean isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available: " + isAvailable);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

<<<<<<< HEAD
    
=======
        System.out.println("\n-----------------------------\n");

     
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
        try {
            bookService.reserveBook(1);
            System.out.println("Physical Book reserved successfully.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

<<<<<<< HEAD
    
=======
        System.out.println("\n-----------------------------\n");

        try {
            boolean isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available: " + isAvailable);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

 
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
        try {
            bookService.cancelReservation(1);
            System.out.println("Reservation for Physical Book cancelled.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

<<<<<<< HEAD
       
        bookManager.removeBook(1);
        System.out.println("Physical Book removed.");

   
        System.out.println("Remaining books in the system:");
        bookManager.getAllBooks().forEach(book -> System.out.println(book.showInfo()));
=======
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
        
        
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    }
}
