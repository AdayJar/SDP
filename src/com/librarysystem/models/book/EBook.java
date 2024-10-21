package src.com.librarysystem.models.book;

public class EBook implements Book {
    private int id; 
    private String title; 
    private String author; 
    private double sizeMB; 
    private boolean available; 
    private String genre; 
    private int publicationYear; 

    public EBook(int id, String title, String author, String genre, int publicationYear, double sizeMB, boolean available) {
        this.id = id; 
        this.title = title; 
        this.author = author; 
        this.genre = genre; 
        this.publicationYear = publicationYear; 
        this.sizeMB = sizeMB; 
        this.available = available; 
    }

    @Override
    public Book clone() {
        return new EBook(id, title, author, genre, publicationYear, sizeMB, available);
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

    public void changeAvailability(boolean availability) {
        this.available = availability;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
