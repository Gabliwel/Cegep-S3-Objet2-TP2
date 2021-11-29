package outfitting.controller;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import outfitting.comparator.CompareByAmountOfGuest;
import outfitting.convertor.CottageListDTOToCottageConvertor;
import outfitting.dto.CottageDTOForList;
import outfitting.exception.IDDoesNotExistException;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Cottage;
import outfitting.view.View;

public class CottageListController implements ICottageListController {

	private GenericRepository<Cottage> repository;
	private IControllerOrchestrator orchestrator;
	private View view;
	private CottageListDTOToCottageConvertor cottageConvertor;
	

	public CottageListController(IControllerOrchestrator controllerOrchestrator, View view, GenericRepository<Cottage> repository) {
		this.orchestrator = controllerOrchestrator;
		this.repository = repository;
		this.view = view;
		this.cottageConvertor = new CottageListDTOToCottageConvertor();
	}

	@Override
	public void requestCottageList() {
		this.view.display();
	}
	
	@Override
	public List<CottageDTOForList> getCottageList() {
		List<Cottage> list = listAscendingByNbGuest(repository.getList());
		
		return cottageConvertor.listOfCottageToDTO(list);
	}
	
	@Override
	public List<Cottage> listAscendingByNbGuest(Collection<Cottage> cottageCollection)
	{
		Comparator<Cottage> comparatorType;
		comparatorType = new CompareByAmountOfGuest();
		
		return cottageCollection.stream()
				.sorted(comparatorType)
				.collect(Collectors.toList());
	}
	
	public void requestSpecificCottageView(int id) 
	{
		this.orchestrator.goToCottageSpecificView(id);
	}
}
