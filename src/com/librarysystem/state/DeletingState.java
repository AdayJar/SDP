package src.com.librarysystem.state;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.book.Book;

public class DeletingState implements BookState {
    @Override
    public void delete(Book book, BookManager bookManager) {
        bookManager.removeBook(book.getId()); 
        System.out.println("Book " + book.getTitle() + " is in the process of being deleted.");
    }
}
