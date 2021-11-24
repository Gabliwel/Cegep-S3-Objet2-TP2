package outfitting.convertor;

import java.util.List;
import java.util.stream.Collectors;

import outfitting.dto.CottageDTOForList;
import outfitting.model.entity.Cottage;

public class CottageListDTOToCottageConvertor {
	
	public Cottage DTOToCottage(CottageDTOForList cottageDTO) 
	{
		Cottage c = new Cottage(cottageDTO.getName(), cottageDTO.getNbOfGuests(), cottageDTO.getNbOfChamber(), cottageDTO.getPricePerNight());
		c.setId(cottageDTO.getID());
		return c;
	}
	
	public List<CottageDTOForList> listOfCottageToDTO(List<Cottage> list) 
	{
		return list.stream()
				.map(c -> new CottageDTOForList(c.getId(), c.getName(), c.getNbOfGuests(), c.getNbOfChamber(), c.getPricePerNight()))
				.collect(Collectors.toList());
	}
	
	public CottageDTOForList cottageToDTO(Cottage cottage) 
	{
		return new CottageDTOForList(cottage.getId(), cottage.getName(), cottage.getNbOfGuests(), cottage.getNbOfChamber(), cottage.getPricePerNight());
	}

}
