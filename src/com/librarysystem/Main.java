package src.com.librarysystem;

import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.factory.SimpleBookFactory;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.Book;
import src.com.librarysystem.service.BookService;

public class Main {
    public static void main(String[] args) {

        // Получаем единственный экземпляр BookManager
        BookManager bookManager = BookManager.getInstance();

        SimpleBookFactory bookFactory = new SimpleBookFactory();

        BookService bookService = new BookService(bookManager);

        // Создаем книги
        Book physicalBook = bookFactory.createPhysicalBook(1, "Head First Design Patterns", "Elisabeth Robson", 694, true);
        Book eBook = bookFactory.createEBook(2, "Grokking Algorithms", " Aditya Bhargava", 10.2, true);
        Book audioBook = bookFactory.createAudioBook(3, "Язык Go для начинающих", "Максим Жашкевич", 40.0, true);

        // Добавляем книги в менеджер
        bookManager.addBook(physicalBook);
        bookManager.addBook(eBook);
        bookManager.addBook(audioBook);

        System.out.println("\n=============================\n");

        // Проверяем доступность книги
        try {
            boolean isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available: " + isAvailable);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

        // Резервируем книгу
        try {
            bookService.reserveBook(1);
            System.out.println("Physical Book reserved successfully.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

        // Отменяем резервирование
        try {
            bookService.cancelReservation(1);
            System.out.println("Reservation for Physical Book cancelled.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-----------------------------\n");

        // Удаляем книгу
        bookManager.removeBook(1);
        System.out.println("Physical Book removed.");

        System.out.println("\n=============================\n");

        

        // Отображаем оставшиеся книги
        System.out.println("Remaining books in the system:");
        bookManager.getAllBooks().forEach(book -> System.out.println(book.showInfo()));
        
        System.out.println("\n=============================\n");
    }
}
