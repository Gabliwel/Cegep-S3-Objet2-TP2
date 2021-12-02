package outfitting.dto;

import outfitting.model.entity.Contact;

public class OutfittingDtoForAdd {
	
	private String name;
	private String region;
	private String phoneNumber;
	private String email;
	private Contact contact;
	
	public OutfittingDtoForAdd(String name, String region, String phoneNumber, String email, Contact contact) {
		this.name = name;
		this.region = region;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.contact = contact;
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

	public Contact getContact() {
		return contact;
	}
}