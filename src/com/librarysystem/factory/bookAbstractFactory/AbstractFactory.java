package src.com.librarysystem.factory.bookabstractfactory;

import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.models.magazine.Magazine;

public interface AbstractFactory {
    // Методы для создания книг
    Book createPhysicalBook(int id, String title, String author, String genre, int publicationYear, int pages, boolean available, String url);
    Book createEBook(int id, String title, String author, String genre, int publicationYear, double sizeMB, boolean available, String url);
    Book createAudioBook(int id, String title, String author, String genre, int publicationYear, double duration, boolean available, String url);
    
    // Методы для создания журналов
    Magazine createMonthlyMagazine(int id, String title, String editor, boolean available, int issueNumber);
    Magazine createWeeklyMagazine(int id, String title, String editor, boolean available, String weekOfPublication);
}
