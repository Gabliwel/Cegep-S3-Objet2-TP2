package outfitting.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import outfitting.model.GenericRepository;
import outfitting.model.entity.Outfitting;
import outfitting.sort.SortOutfittingByName;
import outfitting.sort.SortOutfittingByRegion;
import outfitting.view.View;

public class OutfittingListController implements IOutfittingListController{

	private GenericRepository<Outfitting> repository;
	private IControllerOrchestrator orchestrator;
	private View view;

	public OutfittingListController(IControllerOrchestrator controllerOrchestrator, View view, GenericRepository<Outfitting> repository) {
		this.orchestrator = controllerOrchestrator;
		this.repository = repository;
		this.view = view;
	}
	
	@Override
	public void requestOutfittingList() {
		this.view.display();
	}

	@Override
	public Collection<Outfitting> getOutfittingList() {
		return repository.getList();
	}
	
	@Override
	public Collection<Outfitting> getSortedByNameOutfittingList() {
		Collection<Outfitting> list = repository.getList();
		return list.stream().sorted(new SortOutfittingByName()).collect(Collectors.toList());
	}
	
	@Override
	public Collection<Outfitting> getSortedByRegionOutfittingList() {
		Collection<Outfitting> list = repository.getList();
		return list.stream().sorted(new SortOutfittingByRegion()).collect(Collectors.toList());
	}
}
