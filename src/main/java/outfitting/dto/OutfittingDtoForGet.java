package outfitting.dto;

import outfitting.model.entity.Contact;

public class OutfittingDtoForGet {
	private int id;
	private String name;
	private String region;
	private String phoneNumber;
	private String email;
	private String contactName;
	private String contactPhoneNumber;
	private String contactEmail;
	
	public OutfittingDtoForGet(int id, String name, String region, String phoneNumber, String email, Contact contact) {
		this.id = id;
		this.name = name;
		this.region = region;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.contactName = contact.getName();
		this.contactPhoneNumber = contact.getPhoneNumber();
		this.contactEmail = contact.getEmail();
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

	public String getContactName() {
		return contactName;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}
}
