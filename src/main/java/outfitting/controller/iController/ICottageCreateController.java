package outfitting.controller.iController;

import java.util.List;

import outfitting.dto.CottageDtoForCreate;
import outfitting.dto.OutfittingDtoForAdd;
import outfitting.model.entity.Outfitting;

public interface ICottageCreateController {

	void requestCottageCreate();
	void add(CottageDtoForCreate cottageDTO);
	List<Outfitting> getOutfittingCollection();
	List<OutfittingDtoForAdd> getOutfittingDtoForCreateCollection();
}
