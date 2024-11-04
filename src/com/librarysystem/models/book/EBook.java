package src.com.librarysystem.models.book;


import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.state.BookContext;

public class EBook implements Book { 
    private int id;
    private String title;
    private String author;
    private double sizeMB; 
    private boolean available;
    private final String url; 
    private String genre; 
    private int publicationYear; 
    private BookManager bookManager;

    public EBook(int id, String title, String author, String genre, int publicationYear, double sizeMB, boolean available, String url) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.available = available;
        this.url = url;
    }

    @Override
    public Book clone() {
        return new EBook(id, title, author, genre, publicationYear, sizeMB, available, url); // Return a new instance with the same attributes
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
        return "E-Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Size (MB): " + sizeMB +
                ", Genre: " + genre + ", Year: " + publicationYear + ", Available: " + available; 
    }

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

    @Override
    public String getUrl() {
        return url;
    }
    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
