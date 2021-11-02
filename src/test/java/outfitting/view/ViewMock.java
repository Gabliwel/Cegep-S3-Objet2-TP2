package outfitting.view;

public class ViewMock implements View {  //ViewSpy

	public boolean displayMethodHasBeenCalled = false;

	@Override
	public void display() {
		displayMethodHasBeenCalled = true;
	}

}
