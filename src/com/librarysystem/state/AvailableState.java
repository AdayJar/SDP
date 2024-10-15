package src.com.librarysystem.state;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.book.Book;

public class AvailableState implements BookState {
    @Override
    public void delete(Book book, BookManager bookManager) {
        System.out.println("Switching to deleting state for book " + book.getTitle() + "...");
        BookState deletingState = new DeletingState(); // Transitioning to deleting state
        deletingState.delete(book, bookManager); // Invoking the delete method
    }
}
