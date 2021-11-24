package outfitting.controller;

import java.util.Collection;
import java.util.List;

import outfitting.dto.CottageDTOForList;
import outfitting.model.entity.Cottage;

public interface ICottageListController {
	List<CottageDTOForList> getCottageList();
	void requestCottageList();
	List<Cottage> listAscendingByNbGuest(Collection<Cottage> cottageList);
	void requestSpecificCottageView(int idCottage);
}
