package outfitting.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import outfitting.model.entity.OutfittingMock;

public class SortOutfittingByRegionTest {
	public String ANY_NAME = "BOB";
	@Test
	public void when_firstOutfittingThatIsCompareHasAlphabeticallyRegionSecond_then_returnTheValueIntMinus1() {
		OutfittingMock o1 = new OutfittingMock(ANY_NAME, "A");
		OutfittingMock o2 = new OutfittingMock(ANY_NAME, "B");
		SortOutfittingByRegion comparator = new SortOutfittingByRegion();
		
		int compareResult = comparator.compare(o1, o2);
		
		assertTrue(compareResult < 0);
	}

	@Test
	public void when_firstOutfttingThatIsCompareHasAlphabeticallyRegionFirst_then_returnTheValueInt1() {
		OutfittingMock o1 = new OutfittingMock(ANY_NAME, "A");
		OutfittingMock o2 = new OutfittingMock(ANY_NAME, "B");
		SortOutfittingByRegion comparator = new SortOutfittingByRegion();
		
		int compareResult = comparator.compare(o2, o1);
		
		assertTrue(compareResult > 0);
	}
	
	@Test
	public void when_firstOutfittingThatIsCompareHasAlphabeticallyRegionEqual_then_returnTheValueInt0() {
		OutfittingMock o1 = new OutfittingMock(ANY_NAME, "A");
		SortOutfittingByRegion comparator = new SortOutfittingByRegion();
		
		int compareResult = comparator.compare(o1, o1);
		
		assertTrue(compareResult == 0);
	}
}
