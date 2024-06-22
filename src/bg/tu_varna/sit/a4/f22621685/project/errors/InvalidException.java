package bg.tu_varna.sit.a4.f22621685.project.errors;

/**
 * The InvalidException class represents a custom exception
 * that is thrown when an invalid operation is performed.
 */
public class InvalidException extends Exception {

    /**
     * Constructs a new InvalidException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidException(String message) {
        super(message);
    }
}
