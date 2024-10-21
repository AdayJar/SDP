package src.com.librarysystem.iterator;

import src.com.librarysystem.manager.MagazineManager;
import src.com.librarysystem.models.magazine.Magazine;

// Iterator for the MagazineManager class
public class MagazineIterator implements Iterator<Magazine> {
    private MagazineManager magazineManager; // Reference to the magazine manager
    private int currentIndex = 0; // Current index for iteration

    // Constructor accepts MagazineManager
    public MagazineIterator(MagazineManager magazineManager) {
        this.magazineManager = magazineManager;
    }

    // Checks if there is a next magazine
    @Override
    public boolean hasNext() {
        return currentIndex < magazineManager.getTotal();
    }

    // Returns the next magazine
    @Override
    public Magazine next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more magazines available.");
        }
        Magazine magazine = magazineManager.getItems().get(currentIndex); // Get the magazine by index
        currentIndex++;
        return magazine;
    }
}
