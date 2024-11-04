package src.com.librarysystem.service;
import src.com.librarysystem.exceptions.BookNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class BookServiceDecorator implements IBookService {
    protected final IBookService bookService;

    public BookServiceDecorator(IBookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public boolean isBookAvailable(int id) throws BookNotFoundException {
        return bookService.isBookAvailable(id);
    }

    @Override
    public void changeAvailability(int id, boolean availability) throws BookNotFoundException {
        bookService.changeAvailability(id, availability);
    }

    @Override
    public void openBook(int id) throws BookNotFoundException, IOException, URISyntaxException {
        bookService.openBook(id);
    }

    // Добавьте дополнительные методы или абстрактные методы для новых функций
}
