package outfitting.controller.iController;

import outfitting.dto.CottageDTOForList;

public interface ICottageSpecificController 
{
	void requestSpecificCottageList();
	CottageDTOForList getCottageDTOForView();
	void deleteChalet(int id);
}
