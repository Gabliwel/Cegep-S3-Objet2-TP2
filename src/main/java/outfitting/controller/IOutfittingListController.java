package outfitting.controller;

import java.util.Collection;

import outfitting.model.entity.Outfitting;

public interface IOutfittingListController {
	void requestOutfittingList(); 
	Collection<Outfitting> getOutfittingList();
	Collection<Outfitting> getSortedByNameOutfittingList();
}
