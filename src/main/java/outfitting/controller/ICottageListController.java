package outfitting.controller;

import java.util.Collection;

import outfitting.model.entity.Cottage;

public interface ICottageListController {
	Collection<Cottage> getCottageList();
	void requestCottageList();
}
