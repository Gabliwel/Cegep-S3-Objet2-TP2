package outfitting.controller;

import outfitting.controller.iController.IControllerOrchestrator;
import outfitting.controller.iController.ICottageCreateController;
import outfitting.convertor.CottageCreateDTOToCottageConvertor;
import outfitting.dto.CottageDtoForCreate;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Cottage;
import outfitting.view.View;

public class CottageCreateController implements ICottageCreateController {

	private GenericRepository<Cottage> repository;
	private IControllerOrchestrator orchestrator;
	private View view;
	private CottageCreateDTOToCottageConvertor cottageConvertor;

	public CottageCreateController(IControllerOrchestrator controllerOrchestrator, View view, GenericRepository<Cottage> repository) {
		this.orchestrator = controllerOrchestrator;
		this.view = view;
		this.repository = repository;
		this.cottageConvertor = new CottageCreateDTOToCottageConvertor();
	}

	@Override
	public void requestCottageCreate() {
		this.view.display();
	}

	@Override
	public void add(CottageDtoForCreate cottageDTO) {
		this.repository.add(cottageConvertor.DTOToCottage(cottageDTO));
	}
}
