import java.util.ArrayList;
import java.util.List;

interface BookInfo {
    void printBookInfo();
}

interface LibraryInterface {
    void addBook(BookInfo book);
    void removeBook(BookInfo book);
    void listBooks();
}

abstract class BaseBook implements BookInfo {
    private String title;
    private String author;

    public BaseBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Book extends BaseBook {
    private String isbn;

    public Book(String title, String author, String isbn) {
        super(title, author);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public void printBookInfo() {
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", ISBN: " + isbn);
    }
}

class EBook extends BaseBook {
    private String fileFormat;

    public EBook(String title, String author, String fileFormat) {
        super(title, author);
        this.fileFormat = fileFormat;
    }

    @Override
    public void printBookInfo() {
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", Format: " + fileFormat);
    }
}

class AudioBook extends BaseBook {
    private String duration;

    public AudioBook(String title, String author, String duration) {
        super(title, author);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public void printBookInfo() {
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor() + ", Duration: " + duration);
    }
}

class Library implements LibraryInterface {
    private List<BookInfo> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(BookInfo book) {
        books.add(book);
    }

    @Override
    public void removeBook(BookInfo book) {
        books.remove(book);
    }

    @Override
    public void listBooks() {
        for (BookInfo book : books) {
            book.printBookInfo();
        }
    }
}

class LibraryService {
    private LibraryInterface library; 

    public LibraryService(LibraryInterface library) {
        this.library = library;
    }

    public void addBook(String title, String author, String isbn) {
        Book newBook = new Book(title, author, isbn);
        library.addBook(newBook);
    }

    public void addEBook(String title, String author, String fileFormat) {
        EBook newEBook = new EBook(title, author, fileFormat);
        library.addBook(newEBook);
    }

    public void addAudioBook(String title, String author, String duration) {
        AudioBook newAudioBook = new AudioBook(title, author, duration);
        library.addBook(newAudioBook);
    }

    public void removeBook(BookInfo book) {
        library.removeBook(book);
    }

    public void displayBooks() {
        library.listBooks();
    }
}

public class Main1 {
    public static void main(String[] args) {
        LibraryInterface library = new Library(); 
        LibraryService libraryService = new LibraryService(library);

        libraryService.addBook("1984", "George Orwell", "1234567890");
        libraryService.addBook("To Kill a Mockingbird", "Harper Lee", "0987654321");
        libraryService.addEBook("Digital Fortress", "Dan Brown", "PDF");
        libraryService.addAudioBook("New Moon", "Karl Marlin", "360 min");

        System.out.println("\nBooks in the library:");
        libraryService.displayBooks();
    }
}