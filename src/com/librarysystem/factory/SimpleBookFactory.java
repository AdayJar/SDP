package src.com.librarysystem.factory;

import src.com.librarysystem.models.Book;
import src.com.librarysystem.models.AudioBook;
import src.com.librarysystem.models.EBook;
import src.com.librarysystem.models.PhysicalBook;

// The SimpleBookFactory class implements the BookFactory interface
// and is responsible for creating instances of different types of books.
public class SimpleBookFactory implements BookFactory {
    // Creates and returns a new PhysicalBook instance
    @Override
    public Book createPhysicalBook(int id, String title, String author, int pages, boolean available) {
        return new PhysicalBook(id, title, author, pages, available);
    }

    // Creates and returns a new EBook instance
    @Override
    public Book createEBook(int id, String title, String author, double sizeMB, boolean available) {
        return new EBook(id, title, author, sizeMB, available);
    }

    // Creates and returns a new AudioBook instance
    @Override
    public Book createAudioBook(int id, String title, String author, double duration, boolean available) {
        return new AudioBook(id, title, author, duration, available);
    }
}
