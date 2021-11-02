package outfitting.controller;

import outfitting.view.View;

public class WelcomeController implements IWelcomeController {

	private IControllerOrchestrator orchestrator; // FIXME utiliser cette propriété pour réaliser le récit R2
	private View welcomeView;

	public WelcomeController(IControllerOrchestrator controllerOrchestrator, View welcomeView) {
		this.orchestrator = controllerOrchestrator;
		this.welcomeView = welcomeView;
	}

	@Override
	public void requestWelcome() {
		this.welcomeView.display();
	}
}
