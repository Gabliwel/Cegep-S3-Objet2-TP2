package outfitting.controller;

public class ControllerOrchestratorMock implements IControllerOrchestrator {

	public boolean goToCreateCottageHasBeenCalled = false;
	public boolean goToCottageListHasBeenCalled = false;
	public boolean goToOutfittingListHasBeenCalled = false;
	
	@Override
	public void goToCreateCottage() {
		goToCreateCottageHasBeenCalled = true;
	}

	@Override
	public void goToCottageList() {
		goToCottageListHasBeenCalled = true;
	}

	@Override
	public void goToOutfittingList() {
		goToOutfittingListHasBeenCalled = true;
	}
}