package src.com.librarysystem.handlers;

import src.com.librarysystem.models.clients.Client;

public class AuthorizationHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Client client, int bookId) {
        if (client != null) {
            System.out.println("Client " + client.getName() + " is authorized.");
            if (nextHandler != null) {
                nextHandler.handleRequest(client, bookId);
            }
        } else {
            System.out.println("Client is not authorized.");
        }
    }
}
