package src.com.librarysystem.service;

import src.com.librarysystem.exceptions.BookNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public interface IBookService {
    boolean isBookAvailable(int id) throws BookNotFoundException;

    void changeAvailability(int id, boolean availability) throws BookNotFoundException;

    void openBook(int id) throws BookNotFoundException, IOException, URISyntaxException;

    // Добавьте дополнительные методы, если необходимо
}
