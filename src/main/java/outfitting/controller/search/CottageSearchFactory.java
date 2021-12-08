package outfitting.controller.search;

import java.util.List;
import java.util.stream.Collectors;

import outfitting.convertor.CottageListDTOToCottageConvertor;
import outfitting.dto.CottageDTOForList;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.Outfitting;

public class CottageSearchFactory {
	public List<CottageDTOForList> giveMeStrategyForSortType(String researchTerm, CottageSearchType type, GenericRepository<Cottage> r1, GenericRepository<Outfitting> r2) {
		if(type != null) {
			CottageListDTOToCottageConvertor cottageConvertor = new CottageListDTOToCottageConvertor();
			List<CottageDTOForList> list = switch(type) {
				case BY_NB_OF_ROOM -> cottageConvertor.listOfCottageToDTO(r1.getList().stream().filter(c -> String.valueOf(c.getNbOfChamber()).equals(researchTerm)).collect(Collectors.toList()));
				case BY_REGION_NAME -> cottageConvertor.listOfCottageToDTO(r1.getList().stream().filter(c -> r2.searchById(c.getIdOfOutfitting()).getRegion().contains(researchTerm)).collect(Collectors.toList()));
			};
			return list;
		}
		throw new IllegalArgumentException("Cottage search type must exist");
	}
}