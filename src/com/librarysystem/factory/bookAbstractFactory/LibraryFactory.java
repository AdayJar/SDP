package src.com.librarysystem.factory.bookabstractfactory;

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
    public Book createPhysicalBook(int id, String title, String author, String genre, int publicationYear, int pages, boolean available, String url) {
        return new PhysicalBook(id, title, author, genre, publicationYear, pages, available, url); 
    }

    @Override
    public Book createEBook(int id, String title, String author, String genre, int publicationYear, double sizeMB, boolean available, String url) {
        return new EBook(id, title, author, genre, publicationYear, sizeMB, available, url);
    }

    @Override
    public Book createAudioBook(int id, String title, String author, String genre, int publicationYear, double duration, boolean available, String url) {
        return new AudioBook(id, title, author, genre, publicationYear, duration, available, url);
    }

    // Создание журналов
    @Override
<<<<<<< HEAD
    public Magazine createMonthlyMagazine(int id, String title, String editor, boolean available, int issueNumber, String url) {
        return new MonthlyMagazine(id, title,editor,available,issueNumber,url);
=======
    public Magazine createMonthlyMagazine(int id, String title, String editor, boolean available, int issueNumber) {
        return new MonthlyMagazine(id, title, editor, available, issueNumber);
>>>>>>> f4eb250d602450aecb24f7ac5391b3b1ec9def49
    }

    @Override
    public Magazine createWeeklyMagazine(int id, String title, String editor, boolean available, String weekOfPublication) {
        return new WeeklyMagazine(id, title, editor, available, weekOfPublication);
    }
}