package be.kdg.simulator.Exception;

public class GeneratorException extends Exception {
    public GeneratorException(String message, Exception cause) {
        super(message, cause);
    }

    public GeneratorException(String message) {
        super(message);
    }
}
