package outfitting.controller;

import java.util.List;

import outfitting.dto.CottageDtoForCreate;
import outfitting.model.entity.Outfitting;

public interface ICottageCreateController {

	void requestCottageCreate();
	void add(CottageDtoForCreate cottageDTO);
	List<Outfitting> getOutfittingCollection();
}
