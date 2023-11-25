package de.graefe.java.restangulardnd.data.exception;

/**
 * The type No characters exist exception.
 */
public class NoCharactersExistException extends RuntimeException {
    /**
     * Instantiates a new No characters exist exception.
     */
    public NoCharactersExistException() {
        super("No characters exist for this user.");
    }
}
