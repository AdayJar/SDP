import java.util.ArrayList;
import java.util.List;

//Class for all types
abstract class BaseBook {
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

    public abstract void printBookInfo(); 
}

//Class for paper books
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

//Class for ebooks
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

class Library {
    private List<BaseBook> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(BaseBook book) {
        books.add(book);
    }

    public void removeBook(BaseBook book) {
        books.remove(book);
    }

    public void listBooks() {
        for (BaseBook book : books) {
            book.printBookInfo();
        }
    }
}

class LibraryService {
    private Library library;

    public LibraryService(Library library) {
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

    public void removeBook(BaseBook book) {
        library.removeBook(book);
    }

    public void displayBooks() {
        library.listBooks();
    }
}

public class Main1 {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryService libraryService = new LibraryService(library);

        libraryService.addBook("1984", "George Orwell", "1234567890");
        libraryService.addBook("To Kill a Mockingbird", "Harper Lee", "0987654321");
        libraryService.addEBook("Digital Fortress", "Dan Brown", "PDF");

        System.out.println("\nBooks in the library:");
        libraryService.displayBooks();
    }
}
