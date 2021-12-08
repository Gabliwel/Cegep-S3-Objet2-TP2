package outfitting.controller;

import java.util.Collection;
import java.util.List;

import outfitting.controller.iController.ICottageListController;
import outfitting.dto.CottageDTOForList;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.Outfitting;
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
	public List<Cottage> listAscendingByNbGuest(Collection<Cottage> cottageList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void requestSpecificCottageView(int idCottage) {
		requestSpecificCottageViewHasBeenCalled = true;
	}

	@Override
	public Outfitting getOutfittingObject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void react() {
		reactHasBeenCalled = true;		
	}
}
