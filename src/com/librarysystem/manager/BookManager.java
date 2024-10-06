package src.com.librarysystem.manager;

import src.com.librarysystem.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books = new ArrayList<>();

  
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.showInfo());
    }

    public List<Book> getAllBooks() {
        return books;
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

   
}
