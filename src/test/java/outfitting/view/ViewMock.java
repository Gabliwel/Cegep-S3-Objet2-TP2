package outfitting.view;

public class ViewMock implements View {  //ViewSpy

	public boolean displayMethodHasBeenCalled = false;
	public boolean displayErrorHasBeenCalled = false;
	
	@Override
	public void display() {
		displayMethodHasBeenCalled = true;
	}

	@Override
	public void displayError(String message)
	{
		displayErrorHasBeenCalled = true;
	}

}
