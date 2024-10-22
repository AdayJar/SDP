package src.com.librarysystem.models.book;

import src.com.librarysystem.manager.BookManager; // Import book manager interface

public class PhysicalBook implements Book { // PhysicalBook implements the Book interface
    private int id; // Unique identifier for the book
    private String title; // Title of the book
    private String author; // Author of the book
    private int pages; // Number of pages in the book
    private boolean available; // Availability status of the book

    // Constructor for initializing PhysicalBook attributes

    public PhysicalBook(int id, String title, String author, int pages, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.available = available;
    }


    // Method to create a clone of the PhysicalBook
    @Override
    public Book clone() {
        return new PhysicalBook(id, title, author, pages, available); // Return a new instance with the same attributes
    }

    // Getter for book ID

    @Override
    public int getId() {
        return id;
    }


    // Getter for book title

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }


    @Override
    public boolean isAvailable() {
        return available;
    }


   
    // Method to show book information
    @Override
    public String showInfo() {
        return "Physical Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Pages: " + pages +
                ", Available: " + available;
    }

    // Method to reserve the book
    

    // Method to change the availability status of the book
    public void changeAvailability(boolean availability) {
        this.available = availability;
    }

}
