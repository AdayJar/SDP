package src.com.librarysystem;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.service.BookService;
import src.com.librarysystem.service.LoggingBookService;
import src.com.librarysystem.exceptions.BookNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляра BookManager
        BookManager bookManager = new BookManager();

        // Добавление книг
        bookManager.addBook("The Silent Patient", "Alex Michaelides", "EBook", 1.5, "https://klex.ru/1718");
        bookManager.addBook("Becoming", "Michelle Obama", "AudioBook", 11.0, "http://example.com/becoming");
        bookManager.addBook("The Great Gatsby", "F. Scott Fitzgerald", "PhysicalBook", 180, "http://example.com/gatsby");

        // Показать все книги
        System.out.println("\nСписок всех книг:");
        bookManager.showAll();

        // Найти книгу по ID
        int searchId = 1; // Пример ID для поиска
        System.out.println("\nПоиск книги с ID " + searchId + ":");
        var foundBook = bookManager.findById(searchId);
        if (foundBook != null) {
            System.out.println("Найдена книга: " + foundBook.showInfo());
        } else {
            System.out.println("Книга с ID " + searchId + " не найдена.");
        }

        // Удалить книгу по ID
        int removeId = 1; // Пример ID для удаления
        bookManager.remove(removeId);
        
        // Показать обновленный список книг
        System.out.println("\nОбновленный список книг:");
        bookManager.showAll();

        // Создание экземпляра BookService
        BookService bookService = new BookService(bookManager);
        // Оборачивание BookService в LoggingBookService
        LoggingBookService loggingBookService = new LoggingBookService(bookService);

        // Проверка доступности книги
        try {
            int checkId = 2; // Пример ID для проверки доступности
            boolean isAvailable = loggingBookService.isBookAvailable(checkId);
            System.out.println("\nКнига с ID " + checkId + " доступна: " + isAvailable);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Изменение доступности книги
        try {
            int changeId = 2; // Пример ID для изменения доступности
            loggingBookService.changeAvailability(changeId, false);
            System.out.println("Доступность книги с ID " + changeId + " изменена.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            int checkId = 2; // Пример ID для проверки доступности
            boolean isAvailable = loggingBookService.isBookAvailable(checkId);
            System.out.println("\nКнига с ID " + checkId + " доступна: " + isAvailable);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Открытие книги по URL
        try {
            int openId = 2; // Пример ID для открытия книги
            loggingBookService.openBook(openId);
        } catch (BookNotFoundException | IOException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }
}
