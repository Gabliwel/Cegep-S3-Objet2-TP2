package outfitting.dto;

public class CottageDtoForCreate 
{
	private final String name;
	private final int guest;
	
	public CottageDtoForCreate(String name, int guest)
	{
		this.name = name;
		this.guest = guest;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getGuest()
	{
		return this.guest;
	}
}
