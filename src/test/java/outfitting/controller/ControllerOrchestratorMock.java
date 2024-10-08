package outfitting.controller;

import outfitting.controller.iController.IControllerOrchestrator;

public class ControllerOrchestratorMock implements IControllerOrchestrator {

	public boolean goToCreateCottageHasBeenCalled = false;
	public boolean goToCottageListHasBeenCalled = false;
	public boolean goToCottageSpecificHasBeenCalled = false;
	public boolean goToOutfittingListHasBeenCalled = false;
	public boolean goToOutfittingAddHasBeenCalled = false;
	
	@Override
	public void goToCreateCottage() {
		goToCreateCottageHasBeenCalled = true;
	}

	@Override
	public void goToCottageList() {
		goToCottageListHasBeenCalled = true;
	}

	@Override
	public void goToCottageSpecificView(int id) 
	{
		goToCottageSpecificHasBeenCalled = true;
	}


	public void goToOutfittingList() {
		goToOutfittingListHasBeenCalled = true;
	}

	@Override
	public void goToOutfittingAdd() {
		goToOutfittingAddHasBeenCalled = true;
	}
}