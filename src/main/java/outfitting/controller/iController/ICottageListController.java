package outfitting.controller.iController;

import java.util.Collection;

import java.util.List;

import outfitting.controller.search.CottageSearchType;
import outfitting.dto.CottageDTOForList;
import outfitting.dto.OutfittingDtoForGet;

public interface ICottageListController {
	List<CottageDTOForList> getCottageList();
	void requestCottageList();
	void requestSpecificCottageView(int idCottage);
	OutfittingDtoForGet getOutfittingObject(int id);
	Collection<CottageDTOForList> searchInList(String researchTerm, CottageSearchType type);
}