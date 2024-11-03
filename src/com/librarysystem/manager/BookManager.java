package src.com.librarysystem.manager;

import java.util.ArrayList;
import java.util.List;

import src.com.librarysystem.iterator.BookIterator;
import src.com.librarysystem.iterator.Iterator;
import src.com.librarysystem.models.book.Book;

public class BookManager implements CollectionManager<Book> {
    private List<Book> books = new ArrayList<>(); // Массив книг

    @Override
    public void add(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.showInfo());
    }

    @Override
    public void remove(int id) {
        books.removeIf(book -> book.getId() == id);
        System.out.println("Book with ID " + id + " has been removed.");
    }

    @Override
    public Book findById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    @Override
    public int getTotal() {
        return books.size();
    }

    @Override
    public void showAll() {
        books.forEach(book -> System.out.println(book.showInfo()));
    }

    @Override
    public List<Book> getItems() {
        return books; 
    }

    @Override
    public Iterator<Book> iterator() {
    return new BookIterator(this); 
}


    
}
