package src.com.librarysystem.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Abstract class to manage collections of objects with common functionality
public abstract class AbstractManager<T> {
    protected List<T> items = new ArrayList<>();

    // Adds a new item to the collection
    public void addItem(T item) {
        items.add(item);
        System.out.println("Item added: " + showInfo(item));
    }

    // Removes an item from the collection by its ID (specific implementation of ID retrieval is left for subclasses)
    public void removeItem(int id) {
        items.removeIf(item -> getId(item) == id);
        System.out.println("Item with ID " + id + " has been removed.");
    }

    // Finds an item by its ID
    public T findItemById(int id) {
        return items.stream()
                    .filter(item -> getId(item) == id)
                    .findFirst()
                    .orElse(null);
    }

    // Returns the total number of items in the collection
    public int getTotalItems() {
        return items.size();
    }

    // Method for getting ID from the item (must be implemented by subclasses)
    protected abstract int getId(T item);

    // Method for displaying information about the item (must be implemented by subclasses)
    protected abstract String showInfo(T item);

    // Returns the list of all items
    public List<T> getAllItems() {
        return items;
    }
}
