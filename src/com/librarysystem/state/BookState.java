package src.com.librarysystem.state;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.book.Book;

public interface BookState {
    void delete(Book book, BookManager bookManager);
}
