package src.com.librarysystem.manager;

import java.util.ArrayList;
import java.util.List;

import src.com.librarysystem.models.book.Book;

// The BookManager class is responsible for managing the collection of books in the library system.
// It follows the Singleton design pattern to ensure that only one instance of the BookManager exists.
public class BookManager {
    private static BookManager instance; // Singleton instance
    private List<Book> books = new ArrayList<>();
     // List to store books

    // Private constructor prevents instantiation from outside this class
    private BookManager() {
    }

    // Method to get the singleton instance of BookManager
    public static synchronized BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager(); // Create a new instance if it doesn't exist
        }
        return instance; // Return the singleton instance
    }

    // Adds a new book to the collection and logs its information
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.showInfo());
    }

    // Returns a list of all books in the collection
    public List<Book> getAllBooks() {
        return books;
    }

    // Returns the total number of books in the collection
    public int getTotalBooks() {
        return books.size();
    }

    // Finds a book by its unique ID. Returns the book if found, otherwise returns null
    public Book findBookById(int id) {
        return books.stream()
                    .filter(book -> book.getId() == id) // Filter books by ID
                    .findFirst() // Get the first matching book
                    .orElse(null); // Return null if no book is found
    }

    // Removes a book from the collection by its ID and logs a message
    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id); // Remove book if the ID matches
        System.out.println("Book with ID " + id + " has been removed.");
    }
}
