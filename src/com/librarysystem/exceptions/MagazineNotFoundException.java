package src.com.librarysystem.exceptions;

// Исключение для случая, когда журнал не найден
public class MagazineNotFoundException extends Exception {
    // Конструктор без параметров
    public MagazineNotFoundException() {
        super();
    }

    // Конструктор с сообщением об ошибке
    public MagazineNotFoundException(String message) {
        super(message);
    }

    // Конструктор с сообщением об ошибке и причиной
    public MagazineNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Конструктор с причиной
    public MagazineNotFoundException(Throwable cause) {
        super(cause);
    }
}
