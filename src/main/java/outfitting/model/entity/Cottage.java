package outfitting.model.entity;

public class Cottage { 

	public static final int idAddedValue = 1;
	
	public static int lastId = 0;
	
	private int id;
	private String name;
	private int maxOfGuests; // accommodationCapacity //sleeps

	public Cottage(String name, int maxOfGuest) {
		lastId += idAddedValue;
		this.id = lastId;
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