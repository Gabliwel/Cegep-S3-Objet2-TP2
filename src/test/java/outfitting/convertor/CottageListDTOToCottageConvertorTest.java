package outfitting.convertor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.dto.CottageDTOForList;
import outfitting.dto.CottageDTOForListMock;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.CottageMock;

public class CottageListDTOToCottageConvertorTest {
	
	private static final String ANY_STRING = "name";
	private static final int ANY_INT = 2;
	private static final int INDEX = 0;
	
	CottageListDTOToCottageConvertor aConvertor = null;
	
	@BeforeEach
	public void setUp() 
	{
		aConvertor = new CottageListDTOToCottageConvertor();
	}
	
	@Test
	public void WHEN_DTOToCottageIsCalled_THEN_DTOBecomesACottage() 
	{
		CottageDTOForListMock dtoForList = new CottageDTOForListMock(ANY_INT,ANY_STRING,ANY_INT,ANY_INT,ANY_INT,ANY_INT);
		
		assertTrue(aConvertor.DTOToCottage(dtoForList) instanceof Cottage);
	} 
	
	@Test
	public void WHEN_cottageToDTOIsCalled_THEN_CottageBecomesACottageDTOForList() 
	{
		CottageMock cottageMock = new CottageMock(ANY_STRING,ANY_INT,ANY_INT,ANY_INT,ANY_INT);
		
		assertTrue(aConvertor.cottageToDTO(cottageMock) instanceof CottageDTOForList);
	} 
	
	@Test
	public void WHEN_listOfCottageToDTOIsCalled_THEN_AListOfCottageBecomesAListOfCottageForList() 
	{
		List<Cottage> listOfCottage = new ArrayList<Cottage>();
		CottageMock cottageMock = new CottageMock(ANY_STRING,ANY_INT,ANY_INT,ANY_INT,ANY_INT);
		List<CottageDTOForList> listOfDTO = null;
		
		listOfCottage.add(cottageMock);
		listOfDTO =  aConvertor.listOfCottageToDTO(listOfCottage);
		
		
		assertTrue(listOfDTO.get(INDEX) instanceof CottageDTOForList);
	}
}
