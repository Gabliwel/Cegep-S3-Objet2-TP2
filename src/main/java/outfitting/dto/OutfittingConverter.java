package outfitting.dto;

import java.util.List;
import java.util.stream.Collectors;

import outfitting.model.entity.Outfitting;

public class OutfittingConverter {
	
	public List<OutfittingDtoForGet> getConvertTo(List<Outfitting> outfitting) {
		return outfitting.stream()
			.map(c -> new OutfittingDtoForGet(c.getId(), c.getName(), c.getRegion(), c.getPhoneNumber(), c.getEmail(), c.getContact()))
					.collect(Collectors.toList());
	}
	
	public OutfittingDtoForGet getConvertTo(Outfitting outfitting) {
		return new OutfittingDtoForGet(outfitting.getId(), outfitting.getName(), outfitting.getRegion(), outfitting.getPhoneNumber(), outfitting.getEmail(), outfitting.getContact());
	}
}