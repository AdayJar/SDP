<<<<<<< HEAD
package SDP.src.com.librarysystem.factory;

import SDP.src.com.librarysystem.models.Book;
import SDP.src.com.librarysystem.models.AudioBook;
import SDP.src.com.librarysystem.models.EBook;
import SDP.src.com.librarysystem.models.PhysicalBook;

public class SimpleBookFactory implements BookFactory {
=======
package src.com.librarysystem.factory;

import src.com.librarysystem.models.Book;
import src.com.librarysystem.models.AudioBook;
import src.com.librarysystem.models.EBook;
import src.com.librarysystem.models.PhysicalBook;

// The SimpleBookFactory class implements the BookFactory interface
// and is responsible for creating instances of different types of books.
public class SimpleBookFactory implements BookFactory {
    // Creates and returns a new PhysicalBook instance
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public Book createPhysicalBook(int id, String title, String author, int pages, boolean available) {
        return new PhysicalBook(id, title, author, pages, available);
    }

<<<<<<< HEAD
=======
    // Creates and returns a new EBook instance
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public Book createEBook(int id, String title, String author, double sizeMB, boolean available) {
        return new EBook(id, title, author, sizeMB, available);
    }

<<<<<<< HEAD
=======
    // Creates and returns a new AudioBook instance
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public Book createAudioBook(int id, String title, String author, double duration, boolean available) {
        return new AudioBook(id, title, author, duration, available);
    }
}
