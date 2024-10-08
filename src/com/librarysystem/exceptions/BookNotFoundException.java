<<<<<<< HEAD
package SDP.src.com.librarysystem.exceptions;
=======
package src.com.librarysystem.exceptions;
>>>>>>> 5e8001b233b8557f28f0b1a16f467d223a5fbcdb


public class BookNotFoundException extends Exception {

    public BookNotFoundException(String message) {
        super(message);
    }


    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
