package src.com.librarysystem.handlers;

import src.com.librarysystem.models.clients.Client;
import src.com.librarysystem.models.clients.PremiumClient;
import src.com.librarysystem.manager.ClientManager;

public class ReservationLimitHandler implements Handler {
    private Handler nextHandler;
    private static final int MAX_RESERVATIONS = 2;  

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Client client, int bookId) {
        int currentReservations = ClientManager.getInstance().getClientReservations(client.getId());

        if (currentReservations < MAX_RESERVATIONS || client instanceof PremiumClient) {
            System.out.println("Client " + client.getName() + " can reserve more books.");
            ClientManager.getInstance().addReservation(client.getId());
            if (nextHandler != null) {
                nextHandler.handleRequest(client, bookId);
            }
        } else {
            System.out.println("Client " + client.getName() + " has exceeded the reservation limit.");
        }
    }
}
