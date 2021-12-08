package outfitting.controller.iController;

import outfitting.dto.CottageDtoForCreate;

public interface ICottageCreateController {

	void requestCottageCreate();
	void add(CottageDtoForCreate cottageDTO);
}
