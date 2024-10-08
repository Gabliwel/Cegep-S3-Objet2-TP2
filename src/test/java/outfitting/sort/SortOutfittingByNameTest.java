package outfitting.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import outfitting.model.entity.OutfittingMock;
import outfitting.model.entity.RegionName;

public class SortOutfittingByNameTest {
	
	public final String ANY_REGION = RegionName.QUEBEC.name;
	public final int ANY_ID = -1;
	@Test
	public void when_firstOutfittingThatIsCompareHasAlphabeticallyNameSecond_then_returnTheValueIntMinus1() {
		OutfittingMock o1 = new OutfittingMock(ANY_ID, "A", ANY_REGION);
		OutfittingMock o2 = new OutfittingMock(ANY_ID, "B", ANY_REGION);
		SortOutfittingByName comparator = new SortOutfittingByName();
		
		int compareResult = comparator.compare(o1, o2);
		
		assertTrue(compareResult < 0);
	}
	
	@Test
	public void when_firstOutfttingThatIsCompareHasAlphabeticallyNameFirst_then_returnTheValueInt1() {
		OutfittingMock o1 = new OutfittingMock(ANY_ID, "A", ANY_REGION);
		OutfittingMock o2 = new OutfittingMock(ANY_ID, "B", ANY_REGION);
		SortOutfittingByName comparator = new SortOutfittingByName();
		
		int compareResult = comparator.compare(o2, o1);
		
		assertTrue(compareResult > 0);
	}
	
	@Test
	public void when_firstOutfittingThatIsCompareHasAlphabeticallyNameEqual_then_returnTheValueInt0() {
		OutfittingMock o1 = new OutfittingMock(ANY_ID, "A", ANY_REGION);
		SortOutfittingByName comparator = new SortOutfittingByName();
		
		int compareResult = comparator.compare(o1, o1);
		
		assertTrue(compareResult == 0);
	}
}
