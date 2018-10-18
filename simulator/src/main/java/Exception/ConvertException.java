package Exception;

public class ConvertException extends Exception {
    public ConvertException(String message, Exception cause) {
        super(message, cause);
    }

    public ConvertException(String message) {
        super(message);
    }

}
