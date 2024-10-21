package src.com.librarysystem.strategy;

import src.com.librarysystem.models.book.Book;

import java.util.List;
import java.util.stream.Collectors;

public class GenreSearchStrategy implements SearchStrategy {
    @Override
    public List<Integer> search(List<Book> books, String criteria) {
        return books.stream()
                    .filter(book -> book.getGenre().toLowerCase().contains(criteria.toLowerCase()))
                    .map(Book::getId) 
                    .collect(Collectors.toList());
    }
}
