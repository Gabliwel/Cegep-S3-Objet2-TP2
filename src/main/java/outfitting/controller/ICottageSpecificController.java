package outfitting.controller;

import outfitting.dto.CottageDTOForList;

public interface ICottageSpecificController 
{
	void requestSpecificCottageList();
	CottageDTOForList getCottageDTOForList();
	void deleteChalet(int id);
}
