package outfitting.exception;

public class IdAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public IdAlreadyExistException(String message)
	{
		super(message);
	}

}
