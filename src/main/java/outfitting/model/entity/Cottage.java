package outfitting.model.entity;

public class Cottage { 

	private int id;
	private String name;
	private int maxOfGuests; // accommodationCapacity //sleeps

	public Cottage(String name, int maxOfGuest) {
		//TODO: calculer l'id --> un no unique pour identifier un chien
		this.name = name;
		this.maxOfGuests = maxOfGuest;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getNbOfGuests() {
		return this.maxOfGuests;
	}
}