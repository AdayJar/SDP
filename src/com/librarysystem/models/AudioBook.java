package src.com.librarysystem.models;

import src.com.librarysystem.manager.BookManager;

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
    public Book clone() {
        return new AudioBook(id, title, author, duration, available);
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
        return "Physical Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Duration: " + duration +
                ", Available: " + available ;
    }



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

 
    public void changeAvailability(boolean availability) {
       this.available = availability; 
       String status = availability ? "available" : "not available";
       System.out.println("Book " + title + " is now " + status + ".");
    }

}
