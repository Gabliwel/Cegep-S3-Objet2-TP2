package outfitting.controller;

import outfitting.controller.iController.IControllerOrchestrator;
import outfitting.controller.iController.IOutfittingAddController;
import outfitting.convertor.OutfittingConverter;
import outfitting.dto.OutfittingDtoForAdd;
import outfitting.exception.IdAlreadyExistException;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Outfitting;
import outfitting.view.View;

public class OutfittingAddController implements IOutfittingAddController {
	private GenericRepository<Outfitting> repository;
	private IControllerOrchestrator orchestrator;
	private View view;
	private OutfittingConverter converter;

	public OutfittingAddController(IControllerOrchestrator controllerOrchestrator, View view, GenericRepository<Outfitting> repository) {
		this.orchestrator = controllerOrchestrator;
		this.repository = repository;
		this.view = view;
		this.converter = new OutfittingConverter();
	}

	@Override
	public void requestOutfittingAdd() {
		this.view.display();
	}

	@Override
	public void addDtoOutfitting(OutfittingDtoForAdd outfittingDtoForAdd) {
		try {
			repository.add(converter.addConvertTo(outfittingDtoForAdd));
			view.displaySuccess(outfittingDtoForAdd.getName() + " a bien été ajouté.");
		}
		catch(IdAlreadyExistException e) {
			view.displayError(e.getMessage());
		}
	}
}