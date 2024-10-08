<<<<<<< HEAD
package SDP.src.com.librarysystem.models;

public class PhysicalBook implements Book {
    private int id;
    private String title;
    private String author;
    private int pages;
    private boolean available;
    
 
=======
package src.com.librarysystem.models;

import src.com.librarysystem.manager.BookManager; // Import book manager interface

public class PhysicalBook implements Book { // PhysicalBook implements the Book interface
    private int id; // Unique identifier for the book
    private String title; // Title of the book
    private String author; // Author of the book
    private int pages; // Number of pages in the book
    private boolean available; // Availability status of the book

    // Constructor for initializing PhysicalBook attributes
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    public PhysicalBook(int id, String title, String author, int pages, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.available = available;
    }

<<<<<<< HEAD
=======
    // Method to create a clone of the PhysicalBook
    @Override
    public Book clone() {
        return new PhysicalBook(id, title, author, pages, available); // Return a new instance with the same attributes
    }

    // Getter for book ID
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public int getId() {
        return id;
    }

<<<<<<< HEAD
=======
    // Getter for book title
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public String getTitle() {
        return title;
    }

<<<<<<< HEAD
=======
    // Getter for book author
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public String getAuthor() {
        return author;
    }

<<<<<<< HEAD
=======
    // Method to check if the book is available
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
    @Override
    public boolean isAvailable() {
        return available;
    }

<<<<<<< HEAD
    @Override
    public String showInfo() {
        return "Physical Book - Title: " + title + ", Author: " + author + ", Pages: " + pages + ", Available: " + available;
    }


    @Override
    public void reserve() {
        if (available) {
            available = false; 
=======
    // Method to show book information
    @Override
    public String showInfo() {
        return "Physical Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Pages: " + pages +
                ", Available: " + available;
    }

    // Method to reserve the book
    @Override
    public void reserve() {
        if (available) { // Check if the book is available for reservation
            available = false; // Mark the book as not available
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
            System.out.println("Book " + title + " has been reserved.");
        } else {
            System.out.println("Book " + title + " is not available for reservation.");
        }
    }

<<<<<<< HEAD
    @Override
    public void cancelReservation() {
        available = true; 
        System.out.println("Reservation for book " + title + " has been cancelled.");
    }
=======
    // Method to cancel the reservation of the book
    @Override
    public void cancelReservation() {
        available = true; // Mark the book as available
        System.out.println("Reservation for book " + title + " has been cancelled.");
    }

    // Method to change the availability status of the book
    public void changeAvailability(boolean availability) {
        this.available = availability; // Set the availability status
        String status = availability ? "available" : "not available"; // Determine status message
        System.out.println("Book " + title + " is now " + status + ".");
    }
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb
}
