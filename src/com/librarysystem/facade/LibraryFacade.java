package src.com.librarysystem.facade;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.manager.ClientManager;
import src.com.librarysystem.manager.MagazineManager;
import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.models.magazine.Magazine;
import src.com.librarysystem.models.clients.Client;

import java.util.List;

public class LibraryFacade {
    private BookManager bookManager;
    private ClientManager clientManager;
    private MagazineManager magazineManager;

    public LibraryFacade() {
        bookManager = new BookManager();
        clientManager = new ClientManager();
        magazineManager = new MagazineManager();
    }

    // Методы для работы с книгами
    public void addBook(Book book) {
        bookManager.add(book);
    }

    public void removeBook(int id) {
        bookManager.remove(id);
    }

    public Book findBookById(int id) {
        return bookManager.findById(id);
    }

    public int getTotalBooks() {
        return bookManager.getTotal();
    }

    public List<Book> getBooks() {
        return bookManager.getItems();
    }

    public void showBooks() {
        for (Book book : bookManager.getItems()) {
            System.out.println(book.showInfo());
        }
    }

    public src.com.librarysystem.iterator.Iterator<Book> bookIterator() {
        return bookManager.iterator();
    }

    // Методы для работы с клиентами
    public void addClient(Client client) {
        clientManager.add(client);
    }

    public void removeClient(int id) {
        clientManager.remove(id);
    }

    public Client findClientById(int id) {
        return clientManager.findById(id);
    }

    public int getTotalClients() {
        return clientManager.getTotal();
    }

    public List<Client> getClients() {
        return clientManager.getItems();
    }

    public void showClients() {
        for (Client client : clientManager.getItems()) {
            System.out.println(client.showInfo());
        }
    }

    public src.com.librarysystem.iterator.Iterator<Client> clientIterator() {
        return clientManager.iterator();
    }

    // Методы для работы с журналами
    public void addMagazine(Magazine magazine) {
        magazineManager.add(magazine);
    }

    public void removeMagazine(int id) {
        magazineManager.remove(id);
    }

    public Magazine findMagazineById(int id) {
        return magazineManager.findById(id);
    }

    public int getTotalMagazines() {
        return magazineManager.getTotal();
    }

    public List<Magazine> getMagazines() {
        return magazineManager.getItems();
    }

    public void showMagazines() {
        for (Magazine magazine : magazineManager.getItems()) {
            System.out.println(magazine.showInfo());
        }
    }

    public src.com.librarysystem.iterator.Iterator<Magazine> magazineIterator() {
        return magazineManager.iterator();
    }
}