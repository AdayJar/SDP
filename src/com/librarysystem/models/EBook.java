package SDP.src.com.librarysystem.models;

public class EBook implements Book {
    private int id;
    private String title;
    private String author;
    private double sizeMB;
    private boolean available;

    // Конструктор
    public EBook(int id, String title, String author, double sizeMB, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.sizeMB = sizeMB;
        this.available = available;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String showInfo() {
        return "E-Book - Title: " + title + ", Author: " + author + ", Size: " + sizeMB + " MB, Available: " + available;
    }

    // Реализация методов бронирования
    @Override
    public void reserve() {
        if (available) {
            available = false; // Забронировать книгу
            System.out.println("E-Book " + title + " has been reserved.");
        } else {
            System.out.println("E-Book " + title + " is not available for reservation.");
        }
    }

    @Override
    public void cancelReservation() {
        available = true; // Отмена бронирования
        System.out.println("Reservation for E-Book " + title + " has been cancelled.");
    }
}
