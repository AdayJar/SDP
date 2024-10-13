package src.com.librarysystem.handlers;

import src.com.librarysystem.models.clients.Client;

public interface Handler {
    void setNext(Handler nextHandler);  
    void handleRequest(Client client, int bookId); 
}
