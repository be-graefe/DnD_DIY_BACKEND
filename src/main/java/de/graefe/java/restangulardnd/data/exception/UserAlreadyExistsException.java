package de.graefe.java.restangulardnd.data.exception;

/**
 * The type User already exists exception.
 */
public class UserAlreadyExistsException extends RuntimeException {
    /**
     * Instantiates a new User already exists exception.
     */
    public UserAlreadyExistsException() {
        super("User already exists");
    }
}
