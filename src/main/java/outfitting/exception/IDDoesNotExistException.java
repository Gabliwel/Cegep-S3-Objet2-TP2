package outfitting.exception;

public class IDDoesNotExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public IDDoesNotExistException(String message) 
	{
		super(message);
	}

}
