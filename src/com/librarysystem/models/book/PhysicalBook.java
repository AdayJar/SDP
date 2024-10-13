package src.com.librarysystem.models.book;

import src.com.librarysystem.manager.BookManager; 

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
    public Book clone() {
        return new PhysicalBook(id, title, author, pages, available); 
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
        return "Physical Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Pages: " + pages +
                ", Available: " + available;
    }  
    
    public void changeAvailability(boolean availability) {
        this.available = availability;
    }

}
