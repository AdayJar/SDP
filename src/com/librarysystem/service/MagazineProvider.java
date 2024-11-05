package src.com.librarysystem.service;

import src.com.librarysystem.models.magazine.Magazine;

public interface MagazineProvider {
    Magazine findById(int id);
    void changeAvailability(int id, boolean availability);
    boolean isMagazineAvailable(int id);
}
