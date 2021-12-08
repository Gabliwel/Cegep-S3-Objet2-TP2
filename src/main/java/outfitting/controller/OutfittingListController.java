package outfitting.controller;

import java.util.Collection;

import java.util.List;
import java.util.stream.Collectors;

import outfitting.dto.OutfittingConverter;
import outfitting.dto.OutfittingDtoForGet;
import outfitting.exception.IdDoesNotExistException;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Outfitting;
import outfitting.sort.OutfittingSortFactory;
import outfitting.sort.SortOutfittingType;
import outfitting.view.View;

public class OutfittingListController implements IOutfittingListController{

	private GenericRepository<Outfitting> repository;
	private IControllerOrchestrator orchestrator;
	private View view;
	private OutfittingConverter converter;

	public OutfittingListController(IControllerOrchestrator controllerOrchestrator, View view, GenericRepository<Outfitting> repository) {
		this.orchestrator = controllerOrchestrator;
		this.repository = repository;
		this.view = view;
		this.converter = new OutfittingConverter();;
	}
	
	@Override
	public void requestOutfittingList() {
		this.view.display();
	}
	
	@Override
	public OutfittingDtoForGet getOutfittingById(int id) {
		OutfittingDtoForGet dto = null;
		try {
			dto = converter.getConvertTo(repository.searchById(id));
		}
		catch(IdDoesNotExistException e) {
			view.displayError(e.getMessage());
		}
		
		return dto;
	}

	@Override
	public List<OutfittingDtoForGet> getSortedList(SortOutfittingType type) {
		if(type == SortOutfittingType.NON_SORTED) {
			return converter.getConvertTo(repository.getList().stream().collect(Collectors.toList()));
		} else {
			Collection<Outfitting> list = repository.getList();
			return converter.getConvertTo(list.stream().sorted(new OutfittingSortFactory().giveMeStrategyForSortType(type)).collect(Collectors.toList()));
		}
	}

	@Override
	public Collection<OutfittingDtoForGet> searchInList(String researchTerm) {
		Collection<Outfitting> list = repository.getList();
		return converter.getConvertTo(list.stream().filter(c -> c.getName().contains(researchTerm)).collect(Collectors.toList()));
	}
}