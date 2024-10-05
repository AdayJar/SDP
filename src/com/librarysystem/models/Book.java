package src.com.librarysystem.models;

public interface Book {
    int getId();
    String getTitle();
    String getAuthor();
    boolean isAvailable();
    String showInfo();


    void reserve();
    void cancelReservation();
}
