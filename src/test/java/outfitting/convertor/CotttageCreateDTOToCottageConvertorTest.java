package outfitting.convertor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.dto.CottageDtoForCreateMock;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.CottageMock;
import outfitting.dto.CottageDtoForCreate;

public class CotttageCreateDTOToCottageConvertorTest {
	
	private static final String ANY_STRING = "name";
	private static final int ANY_INT = 3;
	
	CottageCreateDTOToCottageConvertor aConvertor = null;
	
	@BeforeEach
	public void setUp() 
	{
		aConvertor = new CottageCreateDTOToCottageConvertor();
	}
	
	@Test
	public void WHEN_dtoToCottageIsCalled_THEN_instanceofCottageIsTrue() 
	{
		CottageDtoForCreateMock cottageDtoForCreateMock = new CottageDtoForCreateMock();
		
		assertTrue(aConvertor.DTOToCottage(cottageDtoForCreateMock) instanceof Cottage);
	}
	
	@Test
	public void WHEN_cottageToDTOIsCalled_THEN_instanceofDTOFotCreateIsTrue() 
	{
		CottageMock cottageMock = new CottageMock(ANY_STRING, ANY_INT, ANY_INT, ANY_INT);
		
		assertTrue(aConvertor.cottageToDTO(cottageMock) instanceof CottageDtoForCreate);
	}
}
