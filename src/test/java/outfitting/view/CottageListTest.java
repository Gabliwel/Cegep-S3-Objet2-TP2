package outfitting.view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CottageListTest {


	private static final String ANY_STRING = "allo";
	
	@Test
	public void WHEN_displayIsCalled_THEN_displayHasBeenCalledIsTrue() 
	{
		CottageListMock mock = new CottageListMock();
		
		mock.display();
		
		assertTrue(mock.displayHasBeenCalled);
	}
	
	@Test
	public void WHEN_displayErrorIsCalled_THEN_displayErrorHasBeenCalledIsTrue() 
	{
		CottageListMock mock = new CottageListMock();
		
		mock.displayError(ANY_STRING);
		
		assertTrue(mock.displayErrorHasBeenCalled);
	}
}
