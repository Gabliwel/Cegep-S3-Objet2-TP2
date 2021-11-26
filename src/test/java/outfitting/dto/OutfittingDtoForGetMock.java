package outfitting.dto;

import outfitting.model.entity.Contact;

public class OutfittingDtoForGetMock extends OutfittingDtoForGet {

	public OutfittingDtoForGetMock() {
		super(0, "", "", "", "", new Contact("", "", ""));
	}
}