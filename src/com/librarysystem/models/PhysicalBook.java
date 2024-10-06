package src.com.librarysystem.models;

public class PhysicalBook implements Book {
    private int id;
    private String title;
    private String author;
    private int pages;
    private boolean available;
    
 
    public PhysicalBook(int id, String title, String author, int pages, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
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
        return "Physical Book - Title: " + title + ", Author: " + author + ", Pages: " + pages + ", Available: " + available;
    }


    @Override
    public void reserve() {
        if (available) {
            available = false; 
            System.out.println("Book " + title + " has been reserved.");
        } else {
            System.out.println("Book " + title + " is not available for reservation.");
        }
    }

    @Override
    public void cancelReservation() {
        available = true; 
        System.out.println("Reservation for book " + title + " has been cancelled.");
    }
}
