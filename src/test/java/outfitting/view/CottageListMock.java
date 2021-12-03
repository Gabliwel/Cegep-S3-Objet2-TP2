package outfitting.view;

public class CottageListMock implements View {

	private static final long serialVersionUID = 1L;
	public boolean displayHasBeenCalled = false;
	public boolean displayErrorHasBeenCalled = false;

	@Override
	public void display() 
	{
		displayHasBeenCalled = true;
	}

	@Override
	public void displayError(String message) 
	{
		displayErrorHasBeenCalled = true;
	}
}
