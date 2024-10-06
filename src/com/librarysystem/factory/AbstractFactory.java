package src.com.librarysystem.factory;

import src.com.librarysystem.models.Book;
import src.com.librarysystem.magazines.Magazine;

public interface AbstractFactory {
    Book createPhysicalBook(int id, String title, String author, int pages, boolean available);
    Book createEBook(int id, String title, String author, double sizeMB, boolean available);
    Book createAudioBook(int id, String title, String author, double duration, boolean available);
    Magazine createMonthlyMagazine(int id, String title, String editor, boolean available, int issueNumber);
    Magazine createWeeklyMagazine(int id, String title, String editor, boolean available, String weekOfPublication);
}
