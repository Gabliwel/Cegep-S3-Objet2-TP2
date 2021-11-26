package outfitting.dto;

import org.junit.jupiter.api.Test;

import outfitting.model.entity.OutfittingMock;

public class OutfittingConverterTest {
	
	public final static OutfittingConverter CONVERTER = new OutfittingConverter();
	public final static String ANY_STRING1 = "Abbdjfeifdjsbdhsfjrnevjehvoivejivreiv";
	public final static String ANY_STRING2 = "jivjirjsfokfaoskosfofoevoejsvoj";
	public final static int ANY_ID = -1;
	
	@Test
	public void when_convertsOutfittingToOutfittingDto_then_returnOutfittingDtoWithExpectedValue() {
		OutfittingMock mock = new OutfittingMock(ANY_ID, ANY_STRING1, ANY_STRING2);
		
		OutfittingDtoForGet dto = CONVERTER.getConvertTo(mock);
		
		
	}

}