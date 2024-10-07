package src.com.librarysystem.magazines;

public interface Magazine {
    int getId();
    String getTitle();
    String getEditor(); 
    boolean isAvailable();
    String showInfo(); 
    void reserve(); 
    void cancelReservation(); 
}
