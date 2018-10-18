package Exception;

public class MessageException extends Exception {
    public MessageException(String message, Exception cause) {
        super(message, cause);
    }

    public MessageException(String message) {
        super(message);
    }
}