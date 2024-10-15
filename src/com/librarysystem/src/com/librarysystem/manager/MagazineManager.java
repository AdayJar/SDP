package src.com.librarysystem.manager;

import java.util.ArrayList;
import java.util.List;

import src.com.librarysystem.iterator.Iterator;
import src.com.librarysystem.iterator.MagazineIterator;
import src.com.librarysystem.models.magazine.Magazine;

// The MagazineManager class is responsible for managing the collection of magazines in the library system.
public class MagazineManager {
    private static MagazineManager instance; // Singleton instance
    private List<Magazine> magazines = new ArrayList<>(); // List to store magazines

    // Private constructor prevents instantiation from outside this class
    private MagazineManager() {
    }

    // Method to get the singleton instance of MagazineManager
    public static synchronized MagazineManager getInstance() {
        if (instance == null) {
            instance = new MagazineManager(); // Create a new instance if it doesn't exist
        }
        return instance; // Return the singleton instance
    }

    // Adds a new magazine to the collection and logs its information
    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
        System.out.println("Magazine added: " + magazine.showInfo());
    }

    // Returns a list of all magazines in the collection
    public List<Magazine> getAllMagazines() {
        return magazines;
    }

    // Returns the total number of magazines in the collection
    public int getTotalMagazines() {
        return magazines.size(); // Correctly return the number of magazines
    }

    // Finds a magazine by its unique ID. Returns the magazine if found, otherwise returns null
    public Magazine findMagazineById(int id) {
        return magazines.stream()
                        .filter(magazine -> magazine.getId() == id) // Filter magazines by ID
                        .findFirst() // Get the first matching magazine
                        .orElse(null); // Return null if no magazine is found
    }

    // Removes a magazine from the collection by its ID and logs a message
    public void removeMagazine(int id) {
        magazines.removeIf(magazine -> magazine.getId() == id); // Remove magazine if the ID matches
        System.out.println("Magazine with ID " + id + " has been removed.");
    }

     public Iterator<Magazine> iterator() {
        return new MagazineIterator(this);
    }
}
