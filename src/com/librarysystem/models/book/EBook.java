package src.com.librarysystem.models.book;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.state.BookContext;

public class EBook implements Book { // EBook implements the Book interface
    private int id; // Unique identifier for the eBook
    private String title; // Title of the eBook
    private String author; // Author of the eBook
    private double sizeMB; // Size of the eBook in megabytes
    private boolean available; // Availability status of the eBook
    private BookManager bookManager;
    // Constructor to initialize eBook attributes
    public EBook(int id, String title, String author, double sizeMB, boolean available) {
        this.id = id; // Set the unique ID
        this.title = title; // Set the title
        this.author = author; // Set the author
        this.sizeMB = sizeMB; // Set the size in MB
        this.available = available; // Set the availability status
    }

    // Method to create a clone of the EBook
    @Override
    public Book clone() {
        return new EBook(id, title, author, sizeMB, available); // Return a new instance with the same attributes
    }

    // Getter for eBook ID
    @Override
    public int getId() {
        return id; // Return the unique ID
    }

    // Getter for eBook title
    @Override
    public String getTitle() {
        return title; // Return the title
    }

    // Getter for eBook author
    @Override
    public String getAuthor() {
        return author; // Return the author
    }

    // Method to check if the eBook is available
    @Override
    public boolean isAvailable() {
        return available; // Return the availability status
    }

    // Method to show eBook information
    @Override
    public String showInfo() {
        return "E-Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Size (MB): " + sizeMB +
                ", Available: " + available; // Return formatted information about the eBook
    }

    // Method to reserve the eBook
   

    // Method to change the availability status of the eBook
    public void delete() {
        // Здесь мы можем использовать контекст состояния для удаления
        BookContext context = new BookContext();
        context.delete(this, bookManager); // Удаляем книгу через состояние
    }

    // Method to change the availability status of the book
    @Override
    public void changeAvailability(boolean availability) {
        this.available = availability;
    }
}
