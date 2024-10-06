package src.com.librarysystem.models;

public class AudioBook implements Book {
    private final int id;
    private final String title;
    private final String author;
    private final double duration; 
    private boolean available;

    public AudioBook(int id, String title, String author, double duration, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.duration = duration;
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
        return "Audio Book: ID=" + id + ", Title='" + title + "', Author='" + author + "', Duration=" + duration + " hours, Available=" + available;
    }

    public void listen() {
        System.out.println("Listening to " + title);
    }

    public void reserve() {
        if (available) {
            available = false; // Забронировать книгу
            System.out.println("Book " + title + " has been reserved.");
        } else {
            System.out.println("Book " + title + " is not available for reservation.");
        }
    }

    @Override
    public void cancelReservation() {
        available = true; // Отмена бронирования
        System.out.println("Reservation for book " + title + " has been cancelled.");
    }
}
