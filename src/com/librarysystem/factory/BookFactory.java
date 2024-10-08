package src.com.librarysystem.factory;

import src.com.librarysystem.models.Book;

// The BookFactory interface defines methods for creating different types of books.
// Implementing classes must provide the actual logic for creating these book instances.
public interface BookFactory {
    
    // Method to create a PhysicalBook instance with specified attributes.
    Book createPhysicalBook(int id, String title, String author, int pages, boolean available);
    
    // Method to create an EBook instance with specified attributes.
    Book createEBook(int id, String title, String author, double sizeMB, boolean available);
    
    // Method to create an AudioBook instance with specified attributes.

    Book createAudioBook(int id, String title, String author, double duration, boolean available);
}
