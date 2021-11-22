package outfitting.controller;

import java.util.Collection;
import java.util.List;

import outfitting.model.entity.Cottage;

public interface ICottageListController {
	Collection<Cottage> getCottageList();
	void requestCottageList();
	List<Cottage> listAscendingByNbGuest(Collection<Cottage> cottageList);
}
