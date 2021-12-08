package outfitting.controller.iController;

import outfitting.dto.CottageDTOForList;
import outfitting.dto.OutfittingDtoForGet;

public interface ICottageSpecificController 
{
	void requestSpecificCottageList();
	CottageDTOForList getCottageDTOForList();
	void deleteCottage(int id);
	OutfittingDtoForGet getOutfittingObject(int id);
}
