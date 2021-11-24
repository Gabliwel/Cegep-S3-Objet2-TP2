package outfitting.model.entity;

public class Cottage implements ICottage{ 

	public static final int idAddedValue = 1;
	
	public static int lastId = 0;
	
	private int id;
	private String name;
	private int maxOfGuests;
	private int nbOfChamber;
	private int pricePerNight;

	public Cottage(String name, int maxOfGuest, int nbOfChamber, int pricePerNight) {
		lastId += idAddedValue;
		this.id = lastId;
		this.name = name;
		this.maxOfGuests = maxOfGuest;
		this.nbOfChamber = nbOfChamber;
		this.pricePerNight = pricePerNight;
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
	
	public int getNbOfChamber() 
	{
		return this.nbOfChamber;
	}

	public int getPricePerNight()
	{
		return this.pricePerNight;
	}
}