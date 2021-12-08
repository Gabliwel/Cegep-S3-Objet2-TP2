package outfitting.view;

public class CottageSpecificViewMock implements View{

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

	@Override
	public void displaySuccess(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
}