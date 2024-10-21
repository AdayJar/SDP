package src.com.librarysystem.iterator;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.book.Book;

// Iterator for the BookManager class
public class BookIterator implements Iterator<Book> {
    private BookManager bookManager; // Reference to the BookManager
    private int currentIndex = 0; // Current index for iteration

    // Constructor accepts BookManager
    public BookIterator(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    // Checks if there is a next book
    @Override
    public boolean hasNext() {
        return currentIndex < bookManager.getTotal();
    }

    // Returns the next book
    @Override
    public Book next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more books available.");
        }
        Book book = bookManager.getItems().get(currentIndex); // Get the book by index
        currentIndex++;
        return book;
    }
}
