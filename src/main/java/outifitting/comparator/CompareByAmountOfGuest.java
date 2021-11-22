package outifitting.comparator;

import java.util.Comparator;

import outfitting.model.entity.Cottage;

public class CompareByAmountOfGuest implements Comparator<Cottage>{
	
	@Override
	public int compare(Cottage o1, Cottage o2) {
		Integer cottageNbOfChamber = o1.getNbOfGuests();
		Integer cottageNbOfChamber2 = o2.getNbOfGuests();
		
		return cottageNbOfChamber.compareTo(cottageNbOfChamber2);
	}

}
