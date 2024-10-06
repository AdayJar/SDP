package src.com.librarysystem.service;

import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.Book;

public class BookService {
    private final BookManager bookManager; 

    
    public BookService(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    
    public boolean isBookAvailable(int id) throws BookNotFoundException {
        Book book = bookManager.findBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
        return book.isAvailable();
    }

    // Метод для бронирования книги
    public void reserveBook(int id) throws BookNotFoundException {
        Book book = bookManager.findBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
        book.reserve();
    }

    // Метод для отмены бронирования книги
    public void cancelReservation(int id) throws BookNotFoundException {
        Book book = bookManager.findBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
        book.cancelReservation();
    }
}
