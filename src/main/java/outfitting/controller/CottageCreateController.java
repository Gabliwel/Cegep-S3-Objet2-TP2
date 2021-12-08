package outfitting.controller;

import outfitting.controller.iController.IControllerOrchestrator;
import outfitting.controller.iController.ICottageCreateController;
import java.util.List;
import java.util.stream.Collectors;

import outfitting.convertor.CottageCreateDTOToCottageConvertor;
import outfitting.dto.CottageDtoForCreate;
import outfitting.convertor.OutfittingConverter;
import outfitting.dto.OutfittingDtoForAdd;
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
	private OutfittingConverter outifittingConvertor;

	public CottageCreateController(IControllerOrchestrator controllerOrchestrator, View view, 
				GenericRepository<Cottage> repository, GenericRepository<Outfitting> repositoryOfOutfitting) {
		this.orchestrator = controllerOrchestrator;
		this.view = view;
		this.repository = repository;
		this.repositoryOfOutfitting = repositoryOfOutfitting;
		this.cottageConvertor = new CottageCreateDTOToCottageConvertor();
		this.outifittingConvertor = new OutfittingConverter();
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
			this.view.displaySuccess(cottageDTO.getName() + " à bien été ajouté");
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
	
	@Override 
	public List<OutfittingDtoForAdd> getOutfittingDtoForCreateCollection()
	{
		return this.repositoryOfOutfitting.getList().stream()
			.map(o -> new OutfittingDtoForAdd(o.getName(),o.getRegion(),o.getPhoneNumber(),o.getEmail(),o.getContact()))
			.collect(Collectors.toList());
	}
	
}
