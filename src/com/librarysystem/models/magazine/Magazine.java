package src.com.librarysystem.models.magazine;

import src.com.librarysystem.observer.Observer;

public interface Magazine {
    int getId();
    String getTitle();
    String getEditor(); 
    boolean isAvailable();
    String showInfo(); 
    void changeAvailability(boolean availability);
    
    // Method Observer
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}
