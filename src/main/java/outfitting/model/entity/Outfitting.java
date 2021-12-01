package outfitting.model.entity;

public class Outfitting {

	public static final int ID_ADDED_VALUE = 1;
	
	public static int lastId = 0;
	
	private int id;
	private String name;
	private String region;
	private String phoneNumber;
	private String email;
	
	public Outfitting(String name, String region, String phoneNumber, String email) {
		lastId += ID_ADDED_VALUE;
		this.id = lastId;
		this.name = name;
		this.region = region;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public String getRegion() {
		return region;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() 
	{
		return this.name;
	}
}