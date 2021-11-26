package outfitting.dto;

public class CottageDTOForList 
{
	private final int id;
	private final String name;
	private final int guest;
	private final int nbOfChamber;
	private final int pricePerNight;
	
	public CottageDTOForList(int id, String name, int guest, int nbOfChamber, int pricePerNight)
	{
		this.id = id;
		this.name = name;
		this.guest = guest;
		this.nbOfChamber = nbOfChamber;
		this.pricePerNight = pricePerNight;
	}
	
	public int getID() 
	{
		return this.id;
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
	
	public int getNbOfGuests()
	{
		return this.guest;
	}
}