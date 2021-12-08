package outfitting.controller;

import java.util.List;
import java.util.stream.Collectors;

import outfitting.convertor.CottageCreateDTOToCottageConvertor;
import outfitting.dto.CottageDtoForCreate;
import outfitting.exception.IdAlreadyExistException;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.Outfitting;
import outfitting.view.View;

public class CottageCreateController implements ICottageCreateController {

	private GenericRepository<Cottage> repository;
	private GenericRepository<Outfitting> repositoryOfOutfitting;
	private IControllerOrchestrator orchestrator;
	private View view;
	private CottageCreateDTOToCottageConvertor cottageConvertor;

	public CottageCreateController(IControllerOrchestrator controllerOrchestrator, View view, 
				GenericRepository<Cottage> repository, GenericRepository<Outfitting> repositoryOfOutfitting) {
		this.orchestrator = controllerOrchestrator;
		this.view = view;
		this.repository = repository;
		this.repositoryOfOutfitting = repositoryOfOutfitting;
		this.cottageConvertor = new CottageCreateDTOToCottageConvertor();
	}

	@Override
	public void requestCottageCreate() {
		this.view.display();
	}

	@Override
	public void add(CottageDtoForCreate cottageDTO) {
		try 
		{
			this.repository.add(cottageConvertor.DTOToCottage(cottageDTO));
		}
		catch(IdAlreadyExistException e)
		{
			this.view.displayError(e.getMessage());
		}
	}
	
	@Override
	public List<Outfitting> getOutfittingCollection()
	{
		return this.repositoryOfOutfitting.getList().stream()
				.collect(Collectors.toList());
	}
	
}
