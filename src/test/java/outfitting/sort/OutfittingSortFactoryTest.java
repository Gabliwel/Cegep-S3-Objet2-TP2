package outfitting.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class OutfittingSortFactoryTest {

	@Test
	void  when_givenStragtegyTypeInFactoryIsByName_then_returnNewOutfittingSortByNameComparator() 
	{
		SortOutfittingByName comparator = new SortOutfittingByName();
		OutfittingSortFactory factory = new OutfittingSortFactory();
		assertEquals(comparator.getClass(), factory.giveMeStrategyForSortType(SortOutfittingType.BY_NAME).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryIsByRegion_then_returnNewOutfittingSortByRegionComparator() 
	{
		SortOutfittingByRegion comparator = new SortOutfittingByRegion();
		OutfittingSortFactory factory = new OutfittingSortFactory();
		assertEquals(comparator.getClass(), factory.giveMeStrategyForSortType(SortOutfittingType.BY_REGION).getClass());
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryIsNonSorted_then_returnIllegalArgumentException() 
	{
		OutfittingSortFactory factory = new OutfittingSortFactory();
		assertThrows(IllegalArgumentException.class, () -> 
		factory.giveMeStrategyForSortType(SortOutfittingType.NON_SORTED));
	}
	
	@Test
	void  when_givenStragtegyTypeInFactoryIsNull_then_returnIllegalArgumentException() 
	{
		OutfittingSortFactory factory = new OutfittingSortFactory();
		assertThrows(IllegalArgumentException.class, () -> 
		factory.giveMeStrategyForSortType(null));
	}
}