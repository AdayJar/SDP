package src.com.librarysystem.factory;

import src.com.librarysystem.models.Book;
import src.com.librarysystem.models.AudioBook;
import src.com.librarysystem.models.EBook;
import src.com.librarysystem.models.PhysicalBook;

public class SimpleBookFactory implements BookFactory {
    @Override
    public Book createPhysicalBook(int id, String title, String author, int pages, boolean available) {
        return new PhysicalBook(id, title, author, pages, available);
    }

    @Override
    public Book createEBook(int id, String title, String author, double sizeMB, boolean available) {
        return new EBook(id, title, author, sizeMB, available);
    }

    @Override
    public Book createAudioBook(int id, String title, String author, double duration, boolean available) {
        return new AudioBook(id, title, author, duration, available);
    }
}
