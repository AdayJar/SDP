package src.com.librarysystem.models.book;



// The AudioBook class represents an audiobook in the library system, implementing the Book interface.
public class AudioBook implements Book {
    // Unique identifier for the audiobook
    private final int id;
    // Title of the audiobook
    private final String title;
    // Author of the audiobook
    private final String author;
    // Duration of the audiobook in hours
    private final double duration; 
    // Availability status of the audiobook
    private boolean available;

    // Constructor to initialize an AudioBook instance

    public AudioBook(int id, String title, String author, double duration, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.duration = duration;
        this.available = available;
    }


    // Creates a clone of the current AudioBook instance
    @Override
    public Book clone() {
        return new AudioBook(id, title, author, duration, available);
    }

    // Gets the unique ID of the audiobook

    @Override
    public int getId() {
        return id;
    }

    // Gets the title of the audiobook

    @Override
    public String getTitle() {
        return title;
    }


    // Gets the author of the audiobook

    @Override
    public String getAuthor() {
        return author;
    }
    

    // Checks if the audiobook is available for borrowing

    @Override
    public boolean isAvailable() {
        return available;
    }


  

    // Returns a string representation of the audiobook's information
    @Override
    public String showInfo() {
        return "Audio Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Duration: " + duration +
                " hours, Available: " + available;
    }

    // Reserves the audiobook, marking it as unavailable
    public void changeAvailability(boolean availability) {
        this.available = availability;
    }
   
}
