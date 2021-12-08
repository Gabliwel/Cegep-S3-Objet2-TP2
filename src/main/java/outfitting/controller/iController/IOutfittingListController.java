package outfitting.controller.iController;

import java.util.Collection;

import outfitting.dto.OutfittingDtoForGet;
import outfitting.sort.SortOutfittingType;

public interface IOutfittingListController {
	void requestOutfittingList(); 
	OutfittingDtoForGet getOutfittingById(int id);
	Collection<OutfittingDtoForGet> getSortedList(SortOutfittingType type);
}
