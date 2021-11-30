package outfitting.controller;

import outfitting.convertor.CottageListDTOToCottageConvertor;
import outfitting.dto.CottageDTOForList;
import outfitting.exception.IDDoesNotExistException;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Cottage;
import outfitting.view.View;

public class CottageSpecificController implements ICottageSpecificController
{
	private int id;
	private GenericRepository<Cottage> repository;
	private IControllerOrchestrator orchestrator;
	private View view;
	private CottageListDTOToCottageConvertor cottageConvertor;
	
	public CottageSpecificController(int id, GenericRepository<Cottage> repository, IControllerOrchestrator orchestrator, View view) 
	{
		this.id = id;
		this.orchestrator = orchestrator;
		this.repository = repository;
		this.view = view;
		this.cottageConvertor = new CottageListDTOToCottageConvertor();
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
	public void deleteCottage(int id) {
		try 
		{
			this.repository.remove(id);
		}
		catch(IDDoesNotExistException e)
		{
			this.view.displayError(e.getMessage());
		}
	}	
}
