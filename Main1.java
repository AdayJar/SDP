import java.util.ArrayList;
import java.util.List;

// Interface for printing book information
interface BookInfo {
    void printBookInfo();
}

// Interface for the library
interface LibraryInterface {
    void addBook(BookInfo book);
    void removeBook(BookInfo book);
    void listBooks();
}

// Base class for all types of books
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

// Class for physical books
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

// Class for eBooks
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

// Implementation of the library
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

// Library service
class LibraryService {
    private LibraryInterface library; // Dependency is now on the interface

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

    public void removeBook(BookInfo book) {
        library.removeBook(book);
    }

    public void displayBooks() {
        library.listBooks();
    }
}

public class Main1 {
    public static void main(String[] args) {
        LibraryInterface library = new Library(); // Using the interface
        LibraryService libraryService = new LibraryService(library);

        libraryService.addBook("1984", "George Orwell", "1234567890");
        libraryService.addBook("To Kill a Mockingbird", "Harper Lee", "0987654321");
        libraryService.addEBook("Digital Fortress", "Dan Brown", "PDF");

        System.out.println("\nBooks in the library:");
        libraryService.displayBooks();
    }
}