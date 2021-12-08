package outfitting.convertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import outfitting.dto.OutfittingDtoForAdd;
import outfitting.dto.OutfittingDtoForGet;
import outfitting.convertor.OutfittingConverter;
import outfitting.model.entity.Contact;
import outfitting.model.entity.Outfitting;

public class OutfittingConverterTest {
	
	public final static OutfittingConverter CONVERTER = new OutfittingConverter();
	public final static String ANY_STRING1 = "a";
	public final static String ANY_STRING2 = "b";
	public final static String ANY_STRING3 = "c";
	public final static String ANY_STRING4 = "d";
	public final static String ANY_STRING5 = "e";
	public final static String ANY_STRING6 = "f";
	public final static String ANY_STRING7 = "g";
	public final static int ANY_ID = -1;
	
	@Test
	public void when_convertsOutfittingToOutfittingDto_then_returnOutfittingDtoWithExpectedValue() {
		Outfitting o = new Outfitting(ANY_STRING1, ANY_STRING2, ANY_STRING3, ANY_STRING4, new Contact(ANY_STRING5, ANY_STRING6, ANY_STRING7));
		
		OutfittingDtoForGet dto = CONVERTER.getConvertTo(o);
		
		assertEquals(dto.getId(), o.getId());
		assertEquals(dto.getName(), o.getName());
		assertEquals(dto.getRegion(), o.getRegion());
		assertEquals(dto.getPhoneNumber(), o.getPhoneNumber());
		assertEquals(dto.getEmail(), o.getEmail());
		assertEquals(dto.getContactName(), o.getContact().getName());
		assertEquals(dto.getContactPhoneNumber(), o.getContact().getPhoneNumber());
		assertEquals(dto.getContactEmail(), o.getContact().getEmail());
	}
	
	@Test
	public void when_convertsOutfittingDtoToOutfitting_then_returnOutfittingWithExpectedValue() {
		OutfittingDtoForAdd dto = new OutfittingDtoForAdd(ANY_STRING1, ANY_STRING2, ANY_STRING3, ANY_STRING4, new Contact(ANY_STRING5, ANY_STRING6, ANY_STRING7));
		
		Outfitting o = CONVERTER.addConvertTo(dto);
		
		assertEquals(o.getName(), dto.getName());
		assertEquals(o.getRegion(), dto.getRegion());
		assertEquals(o.getPhoneNumber(), dto.getPhoneNumber());
		assertEquals(o.getEmail(), dto.getEmail());
		assertEquals(o.getContact().getName(), dto.getContact().getName());
		assertEquals(o.getContact().getPhoneNumber(), dto.getContact().getPhoneNumber());
		assertEquals(o.getContact().getEmail(), dto.getContact().getEmail());
	}
	
	@Test
	public void when_convertsOutfittingListToOutfittingDtoList_then_returnOutfittingDtoListWithExpectedValue() {
		Outfitting o = new Outfitting(ANY_STRING1, ANY_STRING2, ANY_STRING3, ANY_STRING4, new Contact(ANY_STRING5, ANY_STRING6, ANY_STRING7));
		Outfitting o2 = new Outfitting(ANY_STRING2, ANY_STRING1, ANY_STRING3, ANY_STRING4, new Contact(ANY_STRING5, ANY_STRING6, ANY_STRING7));
		List<Outfitting> list =  Arrays.asList(o, o2);
		
		List<OutfittingDtoForGet> dtoList = CONVERTER.getConvertTo(list);
		
		assertEquals(list.get(0).getId(), dtoList.get(0).getId());
		assertEquals(list.get(1).getId(), dtoList.get(1).getId());
	}
}