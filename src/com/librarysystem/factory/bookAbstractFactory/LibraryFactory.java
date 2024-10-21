package src.com.librarysystem.factory.bookAbstractFactory;

import src.com.librarysystem.models.book.AudioBook;
import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.models.book.EBook;
import src.com.librarysystem.models.book.PhysicalBook;
import src.com.librarysystem.models.magazine.Magazine;
import src.com.librarysystem.models.magazine.MonthlyMagazine;
import src.com.librarysystem.models.magazine.WeeklyMagazine;

public class LibraryFactory implements AbstractFactory {
    
    // Создание книг
    @Override
    public Book createPhysicalBook(int id, String title, String author, String genre, int publicationYear, int pages, boolean available) {
        return new PhysicalBook(id, title, author, genre, publicationYear, pages, available); 
    }

    @Override
    public Book createEBook(int id, String title, String author, String genre, int publicationYear, double sizeMB, boolean available) {
        return new EBook(id, title, author, genre, publicationYear, sizeMB, available);
    }

    @Override
    public Book createAudioBook(int id, String title, String author, String genre, int publicationYear, double duration, boolean available) {
        return new AudioBook(id, title, author, genre, publicationYear, duration, available);
    }

    // Создание журналов
    @Override
    public Magazine createMonthlyMagazine(int id, String title, String editor, boolean available, int issueNumber) {
        return new MonthlyMagazine(id, title, editor, available, issueNumber);
    }

    @Override
    public Magazine createWeeklyMagazine(int id, String title, String editor, boolean available, String weekOfPublication) {
        return new WeeklyMagazine(id, title, editor, available, weekOfPublication);
    }
}
