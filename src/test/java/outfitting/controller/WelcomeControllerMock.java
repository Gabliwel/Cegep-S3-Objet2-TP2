package outfitting.controller;

public class WelcomeControllerMock implements IWelcomeController {

	public boolean resquestCreateCottageHasBeenCalled = false;
	public boolean resquestCottageListHasBeenCalled = false;
	public boolean requestOutfittingListHasBeenCalled = false;
	
	@Override
	public void requestWelcome() {
		
	}

	@Override
	public void resquestCreateCottage() {
		resquestCreateCottageHasBeenCalled = true;
	}

	@Override
	public void resquestCottageList() {
		resquestCottageListHasBeenCalled = true;
	}

	@Override
	public void requestOutfittingList() {
		requestOutfittingListHasBeenCalled = true;
	}
}