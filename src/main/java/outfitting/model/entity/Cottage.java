package outfitting.model.entity;

public class Cottage { 

	public static final int ID_ADDED_VALUE = 1;
	
	public static int lastId = 0;
	
	private int id;
	private String name;
	private int maxOfGuests;
	private int nbOfChamber;
	private int pricePerNight;
	private int idOfOutfitting;

	public Cottage(String name, int maxOfGuest, int nbOfChamber, int pricePerNight, int idOfOutfitting) {
		lastId += ID_ADDED_VALUE;
		this.id = lastId;
		this.name = name;
		this.maxOfGuests = maxOfGuest;
		this.nbOfChamber = nbOfChamber;
		this.pricePerNight = pricePerNight;
		this.idOfOutfitting = idOfOutfitting;
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
	
	public int getIdOfOutfitting() 
	{
		return this.idOfOutfitting;
	}
}