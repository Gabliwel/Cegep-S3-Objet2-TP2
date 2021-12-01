package outfitting.controller;

import outfitting.dto.CottageDTOForList;
import outfitting.model.entity.Outfitting;

public interface ICottageSpecificController 
{
	void requestSpecificCottageList();
	CottageDTOForList getCottageDTOForList();
	void deleteCottage(int id);
	Outfitting getOutfittingObject(int id);
}
