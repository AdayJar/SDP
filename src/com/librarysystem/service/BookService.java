package src.com.librarysystem.service;

import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.book.Book;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BookService {
    private final BookManager bookManager;

    public BookService(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    public boolean isBookAvailable(int id) throws BookNotFoundException {
        Book book = bookManager.findById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
        return book.isAvailable();
    }

    public void changeAvailability(int id, boolean availability) throws BookNotFoundException {
        Book book = bookManager.findById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
        book.changeAvailability(availability);
    }

    // Метод для открытия книги сразу в браузере
    public void openBook(int id) throws BookNotFoundException, IOException, URISyntaxException {
        Book book = bookManager.findById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }

        // Открываем URL книги
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(book.getUrl())); // Открывает URL в браузере по умолчанию
        } else {
            System.out.println("Desktop не поддерживается на данной платформе.");
        }
    }
}
