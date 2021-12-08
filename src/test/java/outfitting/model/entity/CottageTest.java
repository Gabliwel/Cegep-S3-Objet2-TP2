package outfitting.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CottageTest {
	
	public static final int FIRST_ID_VALUE = 1;
	
	@BeforeEach
	public void init()
	{
		Cottage.lastId = 0;
	}
	
	@AfterAll
	public static void end()
	{
		Cottage.lastId = 0;

	}
 
	@Test
	public void when_creatingNewCottage_then_firstNewCottageHasIdOf1() {
		Cottage cottage1 = new Cottage("a", 1,3, 34,0);
		
		int id = cottage1.getId();
		
		assertEquals(id, FIRST_ID_VALUE);
	}
	
	@Test
	public void when_creatingSecondNewCottage_then_newCottageIdIsFirstIdValuePlus1() {
		new Cottage("a", 1,3, 34,0);
		Cottage cottage2 = new Cottage("a", 1,3, 34,0);
		
		int id = cottage2.getId();
		
		assertEquals(id, FIRST_ID_VALUE+1);
	}
}