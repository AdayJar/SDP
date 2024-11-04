package src.com.librarysystem.strategy;

import src.com.librarysystem.models.book.Book;

import java.util.List;

public interface SearchStrategy {
    List<Integer> search(List<Book> books, String criteria);
}