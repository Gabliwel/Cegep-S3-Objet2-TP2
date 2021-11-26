package outfitting.controller;

import java.util.Collection;

import outfitting.dto.OutfittingDtoForGet;
import outfitting.sort.SortOutfittingType;

public class OutfittingListControllerMock implements IOutfittingListController {

	public boolean getSortedListHasBeenCalled = false;
	
	@Override
	public void requestOutfittingList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OutfittingDtoForGet getOutfittingById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<OutfittingDtoForGet> getSortedList(SortOutfittingType type) {
		getSortedListHasBeenCalled = true;
		return null;
	}

}
