package outfitting.sort;

import java.util.Comparator;
import outfitting.model.entity.Outfitting;

public class SortOutfittingByRegion implements Comparator<Outfitting> {
	
	@Override
	public int compare(Outfitting o1, Outfitting o2) {
		return o1.getRegion().toLowerCase().compareTo(o2.getRegion().toLowerCase());
	}
}