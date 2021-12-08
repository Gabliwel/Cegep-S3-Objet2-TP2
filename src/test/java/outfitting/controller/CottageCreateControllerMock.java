package outfitting.controller;

import java.util.List;

import outfitting.dto.CottageDtoForCreate;
import outfitting.dto.OutfittingDtoForAdd;
import outfitting.model.entity.Outfitting;

public class CottageCreateControllerMock implements ICottageCreateController {

	public boolean addHasBeenCalled = false;
	
	@Override
	public void requestCottageCreate() {
	}

	@Override
	public void add(CottageDtoForCreate cottageDTO) {
		addHasBeenCalled = true;
	}

	@Override
	public List<Outfitting> getOutfittingCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OutfittingDtoForAdd> getOutfittingDtoForCreateCollection() {
		// TODO Auto-generated method stub
		return null;
	}

}