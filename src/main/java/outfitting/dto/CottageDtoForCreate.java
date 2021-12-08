package outfitting.dto;

public class CottageDtoForCreate 
{
	private final String name;
	private final int guest;
	private final int nbOfChamber;
	private final int pricePerNight;
	private final int idOfOutfitting;
	
	public CottageDtoForCreate(String name, int guest, int nbOfChamber, int pricePerNight, int idOfOutfitting)
	{
		this.name = name;
		this.guest = guest;
		this.nbOfChamber = nbOfChamber;
		this.pricePerNight = pricePerNight;
		this.idOfOutfitting = idOfOutfitting;
	}
	
	public int getNbOfChamber() 
	{
		return this.nbOfChamber;
	}

	public int getPricePerNight() 
	{
		return this.pricePerNight;
	}

	public String getName()
	{
		return this.name;
	}
	
	public int getGuest()
	{
		return this.guest;
	}
	
	public int getIdOfOutfitting() 
	{
		return this.idOfOutfitting;
	}
}
