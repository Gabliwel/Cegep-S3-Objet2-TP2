package outfitting.controller;

import outfitting.view.WelcomeView;

public class ControllerOrchestrator implements IControllerOrchestrator {

	private IWelcomeController welcomeController;
	private WelcomeView welcomeView;

	public ControllerOrchestrator() {
		this.initWelcome();
		this.goToWelcome();
	}

	private void initWelcome() {
		this.welcomeView = new WelcomeView();
		this.welcomeController = new WelcomeController(this, this.welcomeView);
		this.welcomeView.setController(this.welcomeController);
	}

	private void goToWelcome() {
		this.welcomeController.requestWelcome();
	}
}
