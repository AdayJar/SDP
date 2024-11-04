package src.com.librarysystem.service;

import java.util.logging.Logger;
import src.com.librarysystem.exceptions.BookNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class LoggingBookService extends BookServiceDecorator {
    private static final Logger logger = Logger.getLogger(LoggingBookService.class.getName());

    public LoggingBookService(IBookService bookService) {
        super(bookService);
    }

    @Override
    public boolean isBookAvailable(int id) throws BookNotFoundException {
        logger.info("Checking availability for book ID: " + id);
        return super.isBookAvailable(id);
    }

    @Override
    public void changeAvailability(int id, boolean availability) throws BookNotFoundException {
        logger.info("Changing availability for book ID: " + id + " to " + availability);
        super.changeAvailability(id, availability);
    }

    @Override
    public void openBook(int id) throws BookNotFoundException, IOException, URISyntaxException {
        logger.info("Opening book ID: " + id);
        super.openBook(id);
    }
}
