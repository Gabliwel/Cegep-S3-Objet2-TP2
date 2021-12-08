package outfitting.convertor;

import outfitting.dto.CottageDtoForCreate;
import outfitting.model.entity.Cottage;

public class CottageCreateDTOToCottageConvertor {
	
	public Cottage DTOToCottage(CottageDtoForCreate cottageDTO) 
	{
		return new Cottage(cottageDTO.getName(), cottageDTO.getGuest(), cottageDTO.getNbOfChamber(), cottageDTO.getPricePerNight(), cottageDTO.getIdOfOutfitting());
	}
	
	public CottageDtoForCreate cottageToDTO(Cottage cottage) 
	{
		return new CottageDtoForCreate(cottage.getName(), cottage.getNbOfGuests(), cottage.getNbOfChamber(), cottage.getPricePerNight(), cottage.getIdOfOutfitting());
	}

}
