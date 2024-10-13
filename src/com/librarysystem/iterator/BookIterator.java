package src.com.librarysystem.iterator;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.book.Book;

// Итератор для класса BookManager
public class BookIterator implements Iterator<Book> {
    private BookManager bookManager; // Ссылка на менеджер книг
    private int currentIndex = 0; // Текущий индекс для итерации

    // Конструктор принимает BookManager
    public BookIterator(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    // Проверяет, есть ли следующая книга
    @Override
    public boolean hasNext() {
        return currentIndex < bookManager.getTotalBooks();
    }

    // Возвращает следующую книгу
    @Override
    public Book next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more books available.");
        }
        Book book = bookManager.getAllBooks().get(currentIndex); // Получаем книгу по индексу
        currentIndex++;
        return book;
    }
}
