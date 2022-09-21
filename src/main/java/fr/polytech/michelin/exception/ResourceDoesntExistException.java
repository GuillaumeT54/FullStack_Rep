package fr.polytech.michelin.exception;

public class ResourceDoesntExistException extends RuntimeException {

    public ResourceDoesntExistException(String message) {
        super(message);
    }
}
