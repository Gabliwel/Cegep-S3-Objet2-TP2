package outfitting.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import outfitting.model.CottageRepository;
import outfitting.model.entity.Cottage;
import outfitting.view.View;
import outifitting.comparator.CompareByAmountOfGuest;

public class CottageListController implements ICottageListController {

	private CottageRepository repository;
	private IControllerOrchestrator orchestrator;
	private View view;

	public CottageListController(IControllerOrchestrator controllerOrchestrator, View view, CottageRepository repository) {
		this.orchestrator = controllerOrchestrator;
		this.repository = repository;
		this.view = view;
	}

	@Override
	public void requestCottageList() {
		this.view.display();
	}
	
	@Override
	public Collection<Cottage> getCottageList() {
		return listAscendingByNbGuest(repository.getList());
		//return repository.getList();
	}
	
	public List<Cottage> listAscendingByNbGuest(Collection<Cottage> cottageCollection)
	{
		Comparator<Cottage> comparatorType;
		comparatorType = new CompareByAmountOfGuest();
		
		return cottageCollection.stream()
				.sorted(comparatorType)
				.collect(Collectors.toList());
	}
}
