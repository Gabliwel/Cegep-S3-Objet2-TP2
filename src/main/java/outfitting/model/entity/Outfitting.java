package outfitting.model.entity;


public class Outfitting {

	public static final int ID_ADDED_VALUE = 1;
	
	public static int lastId = 0;
	
	private int id;
	private String name;
	private String region;
	private String phoneNumber;
	private String email;
	private Contact contact;
	
	public Outfitting(String name, String region, String phoneNumber, String email, Contact contact) {
		lastId += ID_ADDED_VALUE;
		this.id = lastId;
		this.name = name;
		this.region = region;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.contact = contact;
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
	public Contact getContact() {
		return contact;
	}
}