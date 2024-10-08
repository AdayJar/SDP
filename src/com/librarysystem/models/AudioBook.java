<<<<<<< HEAD
package SDP.src.com.librarysystem.models;

public class AudioBook implements Book {
    private final int id;
    private final String title;
    private final String author;
    private final double duration; 
    private boolean available;

=======
package src.com.librarysystem.models;

import src.com.librarysystem.manager.BookManager;

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
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    public AudioBook(int id, String title, String author, double duration, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.duration = duration;
        this.available = available;
    }

<<<<<<< HEAD
=======
    // Creates a clone of the current AudioBook instance
    @Override
    public Book clone() {
        return new AudioBook(id, title, author, duration, available);
    }

    // Gets the unique ID of the audiobook
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public int getId() {
        return id;
    }

<<<<<<< HEAD
=======
    // Gets the title of the audiobook
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public String getTitle() {
        return title;
    }

<<<<<<< HEAD
=======
    // Gets the author of the audiobook
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public String getAuthor() {
        return author;
    }

<<<<<<< HEAD
=======
    // Checks if the audiobook is available for borrowing
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public boolean isAvailable() {
        return available;
    }

<<<<<<< HEAD
    @Override
    public String showInfo() {
        return "Audio Book: ID=" + id + ", Title='" + title + "', Author='" + author + "', Duration=" + duration + " hours, Available=" + available;
    }

    public void listen() {
        System.out.println("Listening to " + title);
    }

    public void reserve() {
        if (available) {
            available = false; // Забронировать книгу
            System.out.println("Book " + title + " has been reserved.");
        } else {
            System.out.println("Book " + title + " is not available for reservation.");
        }
    }

    @Override
    public void cancelReservation() {
        available = true; // Отмена бронирования
        System.out.println("Reservation for book " + title + " has been cancelled.");
=======
    // Returns a string representation of the audiobook's information
    @Override
    public String showInfo() {
        return "Audio Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Duration: " + duration +
                " hours, Available: " + available;
    }

    // Reserves the audiobook, marking it as unavailable
    public void reserve() {
        if (available) {
            available = false; 
            System.out.println("Audiobook " + title + " has been reserved.");
        } else {
            System.out.println("Audiobook " + title + " is not available for reservation.");
        }
    }

    // Cancels the reservation of the audiobook, making it available again
    @Override
    public void cancelReservation() {
        available = true; 
        System.out.println("Reservation for audiobook " + title + " has been cancelled.");
    }

    // Changes the availability status of the audiobook
    public void changeAvailability(boolean availability) {
        this.available = availability; 
        String status = availability ? "available" : "not available";
        System.out.println("Audiobook " + title + " is now " + status + ".");
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    }
}
