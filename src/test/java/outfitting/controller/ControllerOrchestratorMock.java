package outfitting.controller;

public class ControllerOrchestratorMock implements IControllerOrchestrator {

	public boolean goToCreateCottageHasBeenCalled = false;
	public boolean goToCottageListHasBeenCalled = false;
	public boolean goToCottageSpecificHasBeenCalled = false;
	
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
}
