package outfitting.controller;

import java.util.Collection;

import outfitting.model.GenericRepository;
import outfitting.model.entity.Cottage;
import outfitting.view.View;

public class CottageListController implements ICottageListController {

	private GenericRepository repository;
	private IControllerOrchestrator orchestrator;
	private View view;

	public CottageListController(IControllerOrchestrator controllerOrchestrator, View view, GenericRepository repository) {
		this.orchestrator = controllerOrchestrator;
		this.repository = repository;
		this.view = view;
	}

	@Override
	public void requestCottageList() {
		this.view.display();
	}
	
	@Override
	public Collection<Cottage> getCottageList() {
		return repository.getList();
	}
}
