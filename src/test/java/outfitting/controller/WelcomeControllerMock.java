package outfitting.controller;

public class WelcomeControllerMock implements IWelcomeController {

	public boolean resquestCreateCottageHasBeenCalled = false;
	public boolean resquestCottageListHasBeenCalled = false;
	
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
}