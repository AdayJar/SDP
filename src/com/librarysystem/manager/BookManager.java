package src.com.librarysystem.manager;

import java.util.ArrayList;
import java.util.List;

import src.com.librarysystem.iterator.BookIterator;
import src.com.librarysystem.iterator.Iterator;
import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.strategy.SearchStrategy;

public class BookManager {
    private final List<Book> books = new ArrayList<>();
    private final BookFactory bookFactory = new BookFactory();
    private SearchStrategy searchStrategy;
    public void add(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.showInfo());
    }

    public void addBook(String title, String author, String type, double param, String url) {
        Book book = bookFactory.getBook(title, author, type, param, url);
        add(book);
    }

    // Other methods remain unchanged


    
    public void remove(int id) {
        books.removeIf(book -> book.getId() == id);
        System.out.println("Book with ID " + id + " has been removed.");
    }

    
    public Book findById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    
    public int getTotal() {
        return books.size();
    }


    public void showAll() {
        books.forEach(book -> System.out.println(book.showInfo()));
    }


    public List<Book> getItems() {
        return books; 
    }

    
    public Iterator<Book> iterator() {
        return new BookIterator(this); 

    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy; 
    }

    public List<Integer> searchBooks(String criteria) {
        return searchStrategy.search(books, criteria);

    }
    
    


}
