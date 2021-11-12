package outfitting.controller;

import outfitting.dto.CottageDtoForCreate;

public class CottageCreateControllerMock implements ICottageCreateController {

	public boolean addHasBeenCalled = false;
	
	@Override
	public void requestCottageCreate() {
	}

	@Override
	public void add(CottageDtoForCreate cottageDTO) {
		addHasBeenCalled = true;
	}

}