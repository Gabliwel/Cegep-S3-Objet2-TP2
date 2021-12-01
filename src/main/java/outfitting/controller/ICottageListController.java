package outfitting.controller;

import java.util.Collection;
import java.util.List;

import outfitting.dto.CottageDTOForList;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.Outfitting;

public interface ICottageListController {
	List<CottageDTOForList> getCottageList();
	void requestCottageList();
	List<Cottage> listAscendingByNbGuest(Collection<Cottage> cottageList);
	void requestSpecificCottageView(int idCottage);
	Outfitting getOutfittingObject(int id);
}
