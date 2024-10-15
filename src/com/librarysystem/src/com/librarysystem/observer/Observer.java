package src.com.librarysystem.observer;

import src.com.librarysystem.models.magazine.Magazine;

public interface Observer {
    void update(Magazine magazine);
}
