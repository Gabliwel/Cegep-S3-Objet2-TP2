package outfitting.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutfittingTest {
public static final int FIRST_ID_VALUE = 1;
	
	@BeforeEach
	public void init()
	{
		Outfitting.lastId = 0;
	}
	
	@AfterAll
	public static void end()
	{
		Outfitting.lastId = 0;

	}

	@Test
	public void when_creatingNewOutfitting_then_firstNewOutfittingHasIdOf1() {
		Outfitting o1 = new Outfitting(null, null, null, null);
		
		int id = o1.getId();
		
		assertEquals(id, FIRST_ID_VALUE);
	}
	
	@Test
	public void when_creatingSecondNewOutfitting_then_newOutfittingIdIsFirstIdValuePlus1() {
		new Outfitting(null, null, null, null);
		Outfitting o2 = new Outfitting(null, null, null, null);
		
		int id = o2.getId();
		
		assertEquals(id, FIRST_ID_VALUE+1);
	}
}