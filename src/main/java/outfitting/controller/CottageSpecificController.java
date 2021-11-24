package outfitting.controller;

import outfitting.convertor.CottageListDTOToCottageConvertor;
import outfitting.dto.CottageDTOForList;
import outfitting.model.CottageRepository;
import outfitting.view.View;

public class CottageSpecificController implements ICottageSpecificController
{
	private int id;
	private CottageRepository repository;
	private IControllerOrchestrator orchestrator;
	private View view;
	private CottageListDTOToCottageConvertor cottageConvertor;
	
	public CottageSpecificController(int id, CottageRepository repository, IControllerOrchestrator orchestrator, View view) 
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
	
	public CottageDTOForList getCottageDTOForView() 
	{
		return cottageConvertor.cottageToDTO(this.repository.searchById(id));
	}

	@Override
	public void deleteChalet(int id, CottageDTOForList cottageDTOForView)
	{
		this.repository.remove(id, cottageConvertor.DTOToCottage(cottageDTOForView));
	}
	
}
