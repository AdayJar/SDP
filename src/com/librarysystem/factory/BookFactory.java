package SDP.src.com.librarysystem.factory;

import SDP.src.com.librarysystem.models.Book;

public interface BookFactory {
    Book createPhysicalBook(int id, String title, String author, int pages, boolean available);
    Book createEBook(int id, String title, String author, double sizeMB, boolean available);
    Book createAudioBook(int id, String title, String author, double duration, boolean available);
}
