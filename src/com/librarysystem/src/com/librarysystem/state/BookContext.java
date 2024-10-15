package src.com.librarysystem.state;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.book.Book;

public class BookContext {
    private BookState state;

    public BookContext() {
        this.state = new AvailableState(); // initial state
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public void delete(Book book, BookManager bookManager) {
        state.delete(book, bookManager);
    }
}
