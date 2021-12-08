package outfitting.controller;

import outfitting.controller.iController.IControllerOrchestrator;
import outfitting.controller.iController.ICottageSpecificController;
import outfitting.convertor.CottageListDTOToCottageConvertor;
import outfitting.convertor.OutfittingConverter;
import outfitting.dto.CottageDTOForList;
import outfitting.dto.OutfittingDtoForAdd;
import outfitting.dto.OutfittingDtoForGet;
import outfitting.exception.IdDoesNotExistException;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.Outfitting;
import outfitting.view.View;

public class CottageSpecificController implements ICottageSpecificController
{
	private int id;
	private GenericRepository<Cottage> repository;
	private GenericRepository<Outfitting> repositoryOfOutfitting;
	private IControllerOrchestrator orchestrator;
	private View view;
	private CottageListDTOToCottageConvertor cottageConvertor;
	private OutfittingConverter outfittingConvertor;
	
	public CottageSpecificController(int id, GenericRepository<Cottage> repository, GenericRepository<Outfitting> repositoryOfOutfitting, IControllerOrchestrator orchestrator, View view) 
	{
		this.id = id;
		this.orchestrator = orchestrator;
		this.repository = repository;
		this.repositoryOfOutfitting = repositoryOfOutfitting;
		this.view = view;
		this.cottageConvertor = new CottageListDTOToCottageConvertor();
		this.outfittingConvertor = new OutfittingConverter();
	}
	
	@Override
	public void requestSpecificCottageList() {
		this.view.display();
	}
	
	public CottageDTOForList getCottageDTOForList() 
	{
		return cottageConvertor.cottageToDTO(this.repository.searchById(id));
	}
	
	@Override
	public OutfittingDtoForGet getOutfittingObject(int id) 
	{
		return outfittingConvertor.getConvertTo(this.repositoryOfOutfitting.searchById(id));
	}

	@Override
	public void deleteCottage(int id) {
		try 
		{
			this.repository.remove(id);
		}
		catch(IdDoesNotExistException e)
		{
			this.view.displayError(e.getMessage());
		}
	}	
}
