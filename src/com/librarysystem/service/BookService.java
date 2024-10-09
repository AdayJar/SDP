package src.com.librarysystem.service;

import src.com.librarysystem.exceptions.BookNotFoundException; // Import exception for when a book is not found
import src.com.librarysystem.manager.BookManager; // Import book manager
import src.com.librarysystem.models.book.Book;

public class BookService {
    private final BookManager bookManager; // Manager for handling books

    // Constructor for initializing BookManager
    public BookService(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    // Method to check the availability of a book by its ID
    public boolean isBookAvailable(int id) throws BookNotFoundException {
        // Find the book by its ID
        Book book = bookManager.findBookById(id);
        // Check if the book exists
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found."); // Throw exception if the book is not found
        }
        // Return the availability of the book
        return book.isAvailable();
    }

    // Method to reserve a book by its ID
    public void reserveBook(int id) throws BookNotFoundException {
        // Find the book by its ID
        Book book = bookManager.findBookById(id);
        // Check if the book exists
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found."); // Throw exception if the book is not found
        }
        // Reserve the book
        book.reserve();
    }

    // Method to cancel the reservation of a book by its ID
    public void cancelReservation(int id) throws BookNotFoundException {
        // Find the book by its ID
        Book book = bookManager.findBookById(id);
        // Check if the book exists
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found."); // Throw exception if the book is not found
        }
        // Cancel the reservation of the book
        book.cancelReservation();
    }

    // Method to change the availability of a book by its ID
    public void changeAvailability(int id, boolean availability) throws BookNotFoundException {
        // Find the book by its ID
        Book book = bookManager.findBookById(id);
        // Check if the book exists
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found."); // Throw exception if the book is not found
        }
        // Change the availability status of the book
        book.changeAvailability(availability);
    }
}
