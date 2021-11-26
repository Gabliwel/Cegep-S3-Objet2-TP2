package outfitting.sort;

import java.util.Comparator;

import outfitting.model.entity.Outfitting;

public class OutfittingSortFactory {
	public Comparator<Outfitting> giveMeStrategyForSortType(SortOutfittingType type) {
		if(type != null) {
			Comparator<Outfitting> comparator = switch(type) {
				case NON_SORTED -> throw new IllegalArgumentException("Outfiting sort must have a specific type other than non-sorted");
				case BY_NAME -> new SortOutfittingByName();
				case BY_REGION -> new SortOutfittingByRegion();
			};
			return comparator;
		}
		throw new IllegalArgumentException("Outfiting sort type must exist");
	}
}
