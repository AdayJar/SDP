package src.com.librarysystem.service;

import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.book.Book;

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
   
    public void changeAvailability(int id, boolean availability) throws BookNotFoundException {
        Book book = bookManager.findBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found."); 
        }
        book.changeAvailability(availability);
    }
}
