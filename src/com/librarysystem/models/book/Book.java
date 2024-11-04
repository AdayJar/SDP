package src.com.librarysystem.models.book;

public interface Book {
    int getId();
    String getTitle();
    String getAuthor();
    boolean isAvailable();
    String showInfo();
    void changeAvailability(boolean availability);
    void delete();
    Book clone();
    String getUrl();
    String getGenre(); 
    int getPublicationYear();
}
