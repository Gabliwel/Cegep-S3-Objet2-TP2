package outfitting.controller;

import outfitting.dto.CottageDtoForCreate;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Cottage;
import outfitting.view.View;

public class CottageCreateController implements ICottageCreateController {

	private GenericRepository<Cottage> repository;
	private IControllerOrchestrator orchestrator;
	private View view;

	public CottageCreateController(IControllerOrchestrator controllerOrchestrator, View view, GenericRepository<Cottage> repository) {
		this.orchestrator = controllerOrchestrator;
		this.view = view;
		this.repository = repository;
	}

	@Override
	public void requestCottageCreate() {
		this.view.display();
	}

	@Override
	public void add(CottageDtoForCreate cottageDTO) {
		this.repository.add(new Cottage(cottageDTO.getName(), cottageDTO.getGuest()));
	}
}
