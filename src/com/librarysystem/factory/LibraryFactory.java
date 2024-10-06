package src.com.librarysystem.factory;

import src.com.librarysystem.models.Book;
import src.com.librarysystem.models.AudioBook;
import src.com.librarysystem.models.EBook;
import src.com.librarysystem.models.PhysicalBook;
import src.com.librarysystem.magazines.Magazine;
import src.com.librarysystem.magazines.MonthlyMagazine;
import src.com.librarysystem.magazines.WeeklyMagazine;

public class LibraryFactory implements AbstractFactory {
    
    @Override
    public Book createPhysicalBook(int id, String title, String author, int pages, boolean available) {
        return new PhysicalBook(id, title, author, pages, available);
    }

    @Override
    public Book createEBook(int id, String title, String author, double sizeMB, boolean available) {
        return new EBook(id, title, author, sizeMB, available);
    }

    @Override
    public Book createAudioBook(int id, String title, String author, double duration, boolean available) {
        return new AudioBook(id, title, author, duration, available);
    }

    @Override
    public Magazine createMonthlyMagazine(int id, String title, String editor, boolean available, int issueNumber) {
        return new MonthlyMagazine(id, title, editor, available, issueNumber);
    }

    @Override
    public Magazine createWeeklyMagazine(int id, String title, String editor, boolean available, String weekOfPublication) {
        return new WeeklyMagazine(id, title, editor, available, weekOfPublication);
    }
}
