package outfitting.controller;

import outfitting.model.CottageMemoryRepository;
import outfitting.model.GenericRepository;
import outfitting.model.OutfittingMemoryRepository;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.Outfitting;
import outfitting.view.CottageCreateView;
import outfitting.view.CottageListView;
import outfitting.view.CottageSpecificView;
import outfitting.view.OutfittingListView;
import outfitting.view.WelcomeView;

public class ControllerOrchestrator implements IControllerOrchestrator {
	
	private GenericRepository<Cottage> cottageRepository;
	private GenericRepository<Outfitting> outfittingRepository;

	private IWelcomeController welcomeController;
	private WelcomeView welcomeView;
	
	private ICottageCreateController createCottageController;
	private CottageCreateView cottageCreateView;
	
	private ICottageListController cottageListController;
	private CottageListView cottageListView;

	private ICottageSpecificController cottageSpecificController;
	private CottageSpecificView cottageSpecificView;

	private IOutfittingListController outfittingListController;
	private OutfittingListView outfittingListView;
 

	public ControllerOrchestrator(CottageMemoryRepository cottageMemoryRepository, OutfittingMemoryRepository outfittingMemoryRepository) {
		this.cottageRepository = cottageMemoryRepository;
		this.outfittingRepository = outfittingMemoryRepository;
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
		this.createCottageController = new CottageCreateController(this, this.cottageCreateView, this.cottageRepository, this.outfittingRepository);
		this.cottageCreateView.setController(createCottageController);
	}
	
	public void goToCottageList() {
		initCottageList();
		this.cottageListController.requestCottageList();
	}

	private void initCottageList() {
		this.cottageListView = new CottageListView();
		this.cottageListController = new CottageListController(this, cottageListView, this.cottageRepository, this.outfittingRepository);
		this.cottageListView.setController(cottageListController);
	}

	public void goToCottageSpecificView(int id) 
	{
		initCottageSpecific(id);
		this.cottageSpecificController.requestSpecificCottageList();
	}

	private void initCottageSpecific(int id) 
	{
		this.cottageSpecificView = new CottageSpecificView();
		this.cottageSpecificController = new CottageSpecificController(id, cottageRepository,outfittingRepository, this, cottageSpecificView);
		this.cottageSpecificView.setController(cottageSpecificController);
	}
	
	public void goToOutfittingList()
	{
		initOutfittingList();
		this.outfittingListController.requestOutfittingList();
	}

	private void initOutfittingList() {
		this.outfittingListView = new OutfittingListView();
		this.outfittingListController = new OutfittingListController(this, outfittingListView, outfittingRepository);
		this.outfittingListView.setController(outfittingListController);
	}
}