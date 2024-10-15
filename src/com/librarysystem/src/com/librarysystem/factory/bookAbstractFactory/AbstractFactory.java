package src.com.librarysystem.factory.bookAbstractFactory;

import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.models.magazine.Magazine;

public interface AbstractFactory {
    // Методы для создания книг
    Book createPhysicalBook(int id, String title, String author, int pages, boolean available);
    Book createEBook(int id, String title, String author, double sizeMB, boolean available);
    Book createAudioBook(int id, String title, String author, double duration, boolean available);
    
    // Методы для создания журналов
    Magazine createMonthlyMagazine(int id, String title, String editor, boolean available, int issueNumber);
    Magazine createWeeklyMagazine(int id, String title, String editor, boolean available, String weekOfPublication);
}