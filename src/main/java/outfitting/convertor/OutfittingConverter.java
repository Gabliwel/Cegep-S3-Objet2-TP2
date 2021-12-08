package outfitting.convertor;

import java.util.List;
import java.util.stream.Collectors;

import outfitting.dto.OutfittingDtoForAdd;
import outfitting.dto.OutfittingDtoForGet;
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
	
	public Outfitting addConvertTo(OutfittingDtoForAdd outfitting) {
		return new Outfitting(outfitting.getName(), outfitting.getRegion(), outfitting.getPhoneNumber(), outfitting.getEmail(), outfitting.getContact());
	}
}