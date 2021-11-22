package outfitting.controller;

import outfitting.model.CottageMemoryRepository;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Cottage;
import outfitting.view.CottageCreateView;
import outfitting.view.CottageListView;
import outfitting.view.WelcomeView;

public class ControllerOrchestrator implements IControllerOrchestrator {
	
	private GenericRepository<Cottage> cottageRepository;

	private IWelcomeController welcomeController;
	private WelcomeView welcomeView;
	
	private ICottageCreateController createCottageController;
	private CottageCreateView cottageCreateView;
	
	private ICottageListController cottageListController;
	private CottageListView cottageListView;

	public ControllerOrchestrator(CottageMemoryRepository cottageMemoryRepository) {
		this.cottageRepository = cottageMemoryRepository;
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
		this.createCottageController = new CottageCreateController(this, this.cottageCreateView, this.cottageRepository);
		this.cottageCreateView.setController(createCottageController);
	}
	
	public void goToCottageList() {
		initCottageList();
		this.cottageListController.requestCottageList();
	}

	private void initCottageList() {
		this.cottageListView = new CottageListView();
		this.cottageListController = new CottageListController(this, cottageListView, this.cottageRepository);
		this.cottageListView.setController(cottageListController);
	}
}