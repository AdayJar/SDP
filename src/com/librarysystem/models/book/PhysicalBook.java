package src.com.librarysystem.models.book;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.state.BookContext;


public class PhysicalBook implements Book { 
    private int id; 
    private String title; 
    private String author;
    private int pages; 
    private boolean available;
    private final String url; 
    private BookManager bookManager;
    private String genre; 
    private int publicationYear; 

    // Constructor for initializing PhysicalBook attributes

    public PhysicalBook(int id, String title, String author, String genre, int publicationYear, int pages, boolean available, String url) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre; 
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.available = available;
        this.url = url;
    }

    @Override
    public Book clone() {
        return new PhysicalBook(id, title, author, genre, publicationYear, pages, available, url); 
    }

    @Override
    public int getId() {
        return id;
    }

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

    @Override
    public String showInfo() {
        return "Physical Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Pages: " + pages +
                ", Genre: " + genre + ", Year: " + publicationYear + ", Available: " + available;
    }  
    

    // Method to change the availability status of the book
    @Override
    public void changeAvailability(boolean availability) {
        this.available = availability;
    }

    public void delete() {
        BookContext context = new BookContext();
        context.delete(this, bookManager); 
    }
    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public int getPublicationYear() {
        return publicationYear;
    }
}
