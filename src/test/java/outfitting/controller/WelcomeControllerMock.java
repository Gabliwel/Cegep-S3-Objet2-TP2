package outfitting.controller;

import outfitting.controller.iController.IWelcomeController;

public class WelcomeControllerMock implements IWelcomeController {

	public boolean resquestCreateCottageHasBeenCalled = false;
	public boolean resquestCottageListHasBeenCalled = false;
	public boolean requestOutfittingListHasBeenCalled = false;
	public boolean requestOutfittingAddHasBeenCalled = false;
	
	@Override
	public void requestWelcome() {}

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

	@Override
	public void resquestAddOutfitting() {
		requestOutfittingAddHasBeenCalled = true;
	}
}