package outfitting.controller;

import outfitting.controller.iController.IControllerOrchestrator;
import outfitting.controller.iController.IWelcomeController;
import outfitting.view.View;

public class WelcomeController implements IWelcomeController {

	private IControllerOrchestrator orchestrator;
	private View welcomeView;

	public WelcomeController(IControllerOrchestrator controllerOrchestrator, View welcomeView) {
		this.orchestrator = controllerOrchestrator;
		this.welcomeView = welcomeView;
	}
	
	@Override
	public void resquestCreateCottage()
	{
		orchestrator.goToCreateCottage();
	}

	@Override
	public void requestWelcome() {
		this.welcomeView.display();
	}

	@Override
	public void resquestCottageList() {
		orchestrator.goToCottageList();
	}

	@Override
	public void requestOutfittingList() {
		orchestrator.goToOutfittingList();
	}

	@Override
	public void resquestAddOutfitting() {
		orchestrator.goToOutfittingAdd();
	}
}
