package src.com.librarysystem.models.book;

public class PhysicalBook implements Book { 
    private int id; 
    private String title; 
    private String author; 
    private int pages; 
    private boolean available;
    private String genre; 
    private int publicationYear; 

    public PhysicalBook(int id, String title, String author, String genre, int publicationYear, int pages, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre; 
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.available = available;
    }

    @Override
    public Book clone() {
        return new PhysicalBook(id, title, author, genre, publicationYear, pages, available); 
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
    
    public void changeAvailability(boolean availability) {
        this.available = availability;
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
