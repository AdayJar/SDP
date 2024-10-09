package src.com.librarysystem;

import src.com.librarysystem.clients.Client;
import src.com.librarysystem.exceptions.BookNotFoundException;
import src.com.librarysystem.factory.bookAbstractFactory.AbstractFactory;
import src.com.librarysystem.factory.bookAbstractFactory.LibraryFactory;
import src.com.librarysystem.factory.clientFactory.ClientFactory;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.models.magazine.Magazine;
import src.com.librarysystem.service.BookService;
import java.time.LocalDate;
import src.com.librarysystem.report.Report;

public class Main {
    public static void main(String[] args) {

        // Инициализация менеджера и сервисов
        BookManager bookManager = BookManager.getInstance();
        BookService bookService = new BookService(bookManager);

        // Использование абстрактной фабрики для создания книг и журналов
        AbstractFactory libraryFactory = new LibraryFactory();

        // Создание различных типов книг с помощью фабрики
        Book physicalBook = libraryFactory.createPhysicalBook(1, "Physical Book Title", "Author A", 300, true);
        bookManager.addBook(physicalBook); // Добавление книги

        Book eBook = libraryFactory.createEBook(2, "E-Book Title", "Author B", 1.5, true);
        bookManager.addBook(eBook); // Добавление книги

        Book audioBook = libraryFactory.createAudioBook(3, "AudioBook Title", "Author C", 5.0, true);
        bookManager.addBook(audioBook); // Добавление книги

        // Создание различных типов журналов с помощью фабрики
        Magazine monthlyMagazine = libraryFactory.createMonthlyMagazine(4, "Monthly Magazine Title", "Editor A", true, 10);
    

        Magazine weeklyMagazine = libraryFactory.createWeeklyMagazine(5, "Weekly Magazine Title", "Editor B", true, "Week 40");
        

        // Вывод информации о созданных книгах и журналах
        System.out.println("\n=============================\n");
        System.out.println(physicalBook.showInfo());
        System.out.println(eBook.showInfo());
        System.out.println(audioBook.showInfo());
        System.out.println(monthlyMagazine.showInfo());
        System.out.println(weeklyMagazine.showInfo());

        // Использование фабрики клиентов для создания клиентов
        Client regularClient = ClientFactory.createRegularClient(1, "Akhmetova Dilyara", "akhmetova_dilyara@gmail.com");
        Client premiumClient1 = ClientFactory.createPremiumClient(2, "Beisembay Umitzhan", "beisembay_umitzhan@gmail.com", 0.1);
        Client premiumClient2 = ClientFactory.createPremiumClient(3, "Mustafa Akerke", "mustafa_akerke@gmail.com", 0.05);

        // Вывод информации о клиентах
        System.out.println("\n=============================\n");
        System.out.println(regularClient);
        System.out.println(premiumClient1);
        System.out.println(premiumClient2);

        // Создание отчёта с помощью билдера
        Report monthlyReport = new Report.ReportBuilder()
                .setTitle("Report for September")
                .setContent("In this month 150 books were reserved and 30 new clients were added.")
                .setCreationDate(LocalDate.now())
                .build();

        System.out.println("\n=============================\n");
        System.out.println(monthlyReport);

        // Проверка доступности книги, бронирование и отмена бронирования
        try {
            boolean isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available: " + isAvailable);

            bookService.reserveBook(1);
            System.out.println("Physical Book reserved successfully.");

            isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available after reservation: " + isAvailable);

            bookService.cancelReservation(1);
            System.out.println("Reservation for Physical Book cancelled.");

            isAvailable = bookService.isBookAvailable(1);
            System.out.println("Physical Book Available after cancellation: " + isAvailable);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Удаление книги и вывод информации об оставшихся книгах
        bookManager.removeBook(1);
        System.out.println("Physical Book removed.");

        System.out.println("\nRemaining books in the system:");
        int totalBooks = bookManager.getTotalBooks();
        System.out.println("Total count: " + totalBooks);
        bookManager.getAllBooks().forEach(book -> System.out.println(book.showInfo()));

        System.out.println("\n=============================\n");
    }
}
