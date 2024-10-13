package src.com.librarysystem.service;

import src.com.librarysystem.exceptions.ClientNotFoundException;
import src.com.librarysystem.manager.BookManager;
import src.com.librarysystem.manager.ClientManager;
import src.com.librarysystem.models.clients.Client; 
import src.com.librarysystem.handlers.AvailabilityHandler;
import src.com.librarysystem.handlers.AuthorizationHandler;
import src.com.librarysystem.handlers.ReservationLimitHandler;
import src.com.librarysystem.handlers.Handler;
import src.com.librarysystem.models.book.*;


public class ClientService {
    private final ClientManager clientManager;
    private Handler chain;

    public ClientService(ClientManager clientManager) {
        this.clientManager = clientManager;

        this.chain = new AuthorizationHandler();
        Handler reservationLimitHandler = new ReservationLimitHandler();
        Handler availabilityHandler = new AvailabilityHandler();

        chain.setNext(reservationLimitHandler);
        reservationLimitHandler.setNext(availabilityHandler);
    }

    public void reserve(int clientId, int bookId) throws ClientNotFoundException {
        Client client = clientManager.findClientById(clientId);
        if (client == null) {
            throw new ClientNotFoundException("Client with ID " + clientId + " not found."); 
        }

        chain.handleRequest(client, bookId);
    }

    public void cancelReserve(int clientId, int bookId) throws ClientNotFoundException {
        Book book = BookManager.getInstance().findBookById(bookId);
        Client client = clientManager.findClientById(clientId);
        if (client == null) {
            throw new ClientNotFoundException("Client with ID " + clientId + " not found."); 
        }
        book.changeAvailability(true);
        clientManager.deleteReservation(clientId);
        System.out.println("Client " + client.getName() + " has canceled the reservation for book ID " + bookId + ".");
    }
}
