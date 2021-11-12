package outfitting.controller;

import outfitting.model.CottageMemoryRepository;
import outfitting.model.CottageRepository;
import outfitting.view.CottageCreateView;
import outfitting.view.CottageListView;
import outfitting.view.WelcomeView;

public class ControllerOrchestrator implements IControllerOrchestrator {
	
	private CottageRepository repository;

	private IWelcomeController welcomeController;
	private WelcomeView welcomeView;
	
	private ICottageCreateController createCottageController;
	private CottageCreateView cottageCreateView;
	
	private ICottageListController cottageListController;
	private CottageListView cottageListView;

	public ControllerOrchestrator(CottageMemoryRepository cottageMemoryRepository) {
		repository = cottageMemoryRepository;
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
	
	public void goToCreateCottage() {
		initCreateCottage();
		this.createCottageController.requestCottageCreate();
	}
	
	private void initCreateCottage() {
		this.cottageCreateView = new CottageCreateView();
		this.createCottageController = new CottageCreateController(this, this.cottageCreateView, this.repository);
		this.cottageCreateView.setController(createCottageController);
	}
	
	public void goToCottageList() {
		initCottageList();
		this.cottageListController.requestCottageList();
	}

	private void initCottageList() {
		this.cottageListView = new CottageListView();
		this.cottageListController = new CottageListController(this, cottageListView, this.repository);
		this.cottageListView.setController(cottageListController);
	}
}