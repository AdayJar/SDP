package src.com.librarysystem.manager;

import src.com.librarysystem.models.book.AudioBook;
import src.com.librarysystem.models.book.EBook;
import src.com.librarysystem.models.book.PhysicalBook;
import src.com.librarysystem.models.book.Book;

import java.util.HashMap;
import java.util.Map;

public class BookFactory {
    // Кеш для хранения уникальных книг по ключу "автор + название + тип"
    private final Map<String, Book> booksCache = new HashMap<>();

    // Метод для получения книги
    public Book getBook(String title, String author, String type, double param, String url) {
        String key = author + "_" + title + "_" + type;

        if (!booksCache.containsKey(key)) {
            Book newBook;
            // Создаем экземпляр книги в зависимости от типа
            switch (type) {
                case "AudioBook":
                    newBook = new AudioBook(booksCache.size() + 1, title, author, key, 0, param, true, url);
                    break;
                case "EBook":
                    newBook = new EBook(booksCache.size() + 1, title, author, key, 0, param, true, url);
                    break;
                case "PhysicalBook":
                    newBook = new PhysicalBook(booksCache.size() + 1, title, author, key, (int) param, 0, true, url);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid book type: " + type);
            }
            booksCache.put(key, newBook);
            System.out.println("Creating new book: " + newBook.showInfo());
            return newBook;
        }

        System.out.println("Reusing existing book: " + booksCache.get(key).showInfo());
        return booksCache.get(key);
    }
}
