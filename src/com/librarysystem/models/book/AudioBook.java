package src.com.librarysystem.models.book;

public class AudioBook implements Book {
    private final int id;
    private final String title;
    private final String author;
    private String genre; 
    private int publicationYear; 
    private final double duration; 
    private boolean available;

    public AudioBook(int id, String title, String author, String genre, int publicationYear, double duration, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.duration = duration;
        this.available = available;

    }

    @Override
    public Book clone() {
        return new AudioBook(id, title, author, genre, publicationYear, duration, available);
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
