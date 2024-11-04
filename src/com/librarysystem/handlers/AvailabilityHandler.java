package src.com.librarysystem.handlers;

import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.manager.ClientManager;
import src.com.librarysystem.models.book.Book;
import src.com.librarysystem.models.clients.Client;

public class AvailabilityHandler implements Handler {
    private Handler nextHandler;
    BookManager bookManager = new BookManager();
    ClientManager clientManager = new ClientManager();

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Client client, int bookId) {
        Book book = bookManager.findById(bookId);

        if (book != null && book.isAvailable()) {
            System.out.println("Book " + book.getTitle() + " is available.");
            clientManager.addReservation(client.getId());
            book.changeAvailability(false);  
            System.out.println("Book " + book.getTitle() + " has been reserved by " + client.getName() + ".");
        } else {
            System.out.println("Book is not available.");
        }
    }
}
