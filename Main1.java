import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void listBooks() {
        for (Book book : books) {
            book.printBookInfo();
        }
    }
}

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void printBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
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

    public void removeBook(Book book) {
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

        System.out.println("Books in the library:");
        libraryService.displayBooks();
    }
}


