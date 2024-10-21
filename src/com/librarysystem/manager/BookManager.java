package src.com.librarysystem.manager;

import java.util.ArrayList;
import java.util.List;

import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.strategy.SearchStrategy;

public class BookManager {
    private static BookManager instance;
    private List<Book> books = new ArrayList<>();
    private SearchStrategy searchStrategy;

    private BookManager() {
    }

    public static synchronized BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager(); 
        }
        return instance; 
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.showInfo());
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public int getTotalBooks() {
        return books.size();
    }

    public Book findBookById(int id) {
        return books.stream()
                    .filter(book -> book.getId() == id) 
                    .findFirst()
                    .orElse(null); 
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id); 
        System.out.println("Book with ID " + id + " has been removed.");
    }
    
    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy; 
    }

    public List<Integer> searchBooks(String criteria) {
        return searchStrategy.search(books, criteria);
    }
}
