package outfitting.exception;

public class IdDoesNotExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IdDoesNotExistException(String message) {
        super(message);
    }
}