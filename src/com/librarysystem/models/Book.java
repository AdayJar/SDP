
package src.com.librarysystem.models;

// The Book interface defines the contract for book-related functionalities in the library system.
public interface Book {
    // Method to get the unique ID of the book
    int getId();
    
    // Method to get the title of the book
    String getTitle();
    
    // Method to get the author of the book
    String getAuthor();
    
    // Method to check if the book is currently available for borrowing
    boolean isAvailable();
    
    // Method to return a string representation of the book's information
    String showInfo();

    // Method to reserve the book, marking it as unavailable
    void reserve();
    
    // Method to cancel the reservation of the book, making it available again
    void cancelReservation();
    
    // Method to change the availability status of the book
    void changeAvailability(boolean availability);
    
    // Method to create a clone of the book object
    Book clone(); 

}
