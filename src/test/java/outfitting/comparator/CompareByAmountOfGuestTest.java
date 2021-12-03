package outfitting.comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import outfitting.model.entity.CottageMock;

public class CompareByAmountOfGuestTest {
	
	private static final String ANY_NAME = "La cabane chez Roger Pierre";
	private static final int ANY_AMOUNT_OF_GUEST = 4;
	private static final int ANY_AMOUNT_OF_GUEST2 = 3;
	private static final int ANY_INT = 2;

	@Test
	public void WHEN_compareMethodIsCalledWithO1HigherThenO2_THEN_resultIsEqualsToOne() 
	{
		CottageMock cottageMock = new CottageMock(ANY_NAME,ANY_AMOUNT_OF_GUEST,ANY_INT,ANY_INT,ANY_INT);
		CottageMock cottageMock2 = new CottageMock(ANY_NAME,ANY_AMOUNT_OF_GUEST2,ANY_INT,ANY_INT,ANY_INT);
		CompareByAmountOfGuest comparator = new CompareByAmountOfGuest();
		 
		int resultOfCompare = comparator.compare(cottageMock, cottageMock2);
		
		assertTrue(1 == resultOfCompare);
	}
	
	@Test
	public void WHEN_compareMethodIsCalledWithO2HigherThenO1_THEN_resultIsEqualsToMinusOne() 
	{
		CottageMock cottageMock = new CottageMock(ANY_NAME,ANY_AMOUNT_OF_GUEST2,ANY_INT,ANY_INT,ANY_INT);
		CottageMock cottageMock2 = new CottageMock(ANY_NAME,ANY_AMOUNT_OF_GUEST,ANY_INT,ANY_INT,ANY_INT);
		CompareByAmountOfGuest comparator = new CompareByAmountOfGuest();
		
		int resultOfCompare = comparator.compare(cottageMock, cottageMock2);
		
		assertTrue(-1 == resultOfCompare);
	}
	
	@Test
	public void WHEN_compareMethodIsCalledWithO1EqualsToO2_THEN_resultIsEqualsToZero() 
	{
		CottageMock cottageMock = new CottageMock(ANY_NAME,ANY_AMOUNT_OF_GUEST,ANY_INT,ANY_INT,ANY_INT);
		CottageMock cottageMock2 = new CottageMock(ANY_NAME,ANY_AMOUNT_OF_GUEST,ANY_INT,ANY_INT,ANY_INT);
		CompareByAmountOfGuest comparator = new CompareByAmountOfGuest();
		
		int resultOfCompare = comparator.compare(cottageMock, cottageMock2);
		
		assertTrue(0 == resultOfCompare);
	}
}
