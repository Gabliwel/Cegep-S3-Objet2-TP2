package outfitting.controller;

import java.util.Collection;

import java.util.List;

import outfitting.controller.iController.ICottageListController;
import outfitting.controller.search.CottageSearchType;
import outfitting.dto.CottageDTOForList;
import outfitting.dto.OutfittingDtoForGet;
import outfitting.observer.Observer;

public class CottageListControllerMock implements ICottageListController, Observer{

	public boolean requestSpecificCottageViewHasBeenCalled = false;
	public boolean reactHasBeenCalled = false;
	
	@Override
	public List<CottageDTOForList> getCottageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void requestCottageList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestSpecificCottageView(int idCottage) {
		requestSpecificCottageViewHasBeenCalled = true;
	}

	@Override
	public OutfittingDtoForGet getOutfittingObject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void react() {
		reactHasBeenCalled = true;		
	}

	@Override
	public Collection<CottageDTOForList> searchInList(String researchTerm, CottageSearchType type) {
		// TODO Auto-generated method stub
		return null;
	}
}
