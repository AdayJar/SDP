package src.com.librarysystem.models.book;


import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.state.BookContext;

public class AudioBook implements Book {
    private final int id;
    private final String title;
    private final String author;
    private final double duration;
    private String genre; 
    private int publicationYear; 
    private boolean available;
    private final String url; // URL для аудиокниги
    private BookManager bookManager;


    public AudioBook(int id, String title, String author, String genre, int publicationYear, double duration, boolean available, String url) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.duration = duration;
        this.available = available;
        this.url = url;
    }

    @Override
    public Book clone() {
        return new AudioBook(id, title, author, genre, publicationYear, duration, available, url);
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
        return "Audio Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Duration: " + duration +
                " hours, Genre: " + genre + ", Year: " + publicationYear + ", Available: " + available;
    }

    @Override
    public void changeAvailability(boolean availability) {
        this.available = availability;
    }

    @Override
    public void delete() {
        BookContext context = new BookContext();
        context.delete(this, bookManager);
    }

    // Реализуем метод для получения URL
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
