package outfitting.controller;

import outfitting.dto.CottageDTOForList;

public interface ICottageSpecificController 
{
	void requestSpecificCottageList();
	CottageDTOForList getCottageDTOForView();
	void deleteChalet(int id, CottageDTOForList cottageDTOForView);
}
