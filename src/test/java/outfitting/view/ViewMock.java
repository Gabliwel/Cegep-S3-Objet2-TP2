package outfitting.view;

public class ViewMock implements View {  //ViewSpy

	public boolean displayMethodHasBeenCalled = false;
	public boolean displayErrorMethodHasBeenCalled = false;

	@Override
	public void display() {
		displayMethodHasBeenCalled = true;
	}

	@Override
	public void displayError(String message) {
		displayErrorMethodHasBeenCalled = true;
	}
}