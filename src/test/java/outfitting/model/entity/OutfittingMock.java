package outfitting.model.entity;

public class OutfittingMock extends Outfitting {

	private int id;
	
	public OutfittingMock(int id, String name, String region) {
		super(name, region, "", "", new Contact("", "", ""));
		Outfitting.lastId = 0;
		this.id = id;
	}
	
	public OutfittingMock(int id, String name, String region, String phoneNumber, String email, Contact contact) {
		super(name, region, phoneNumber, email, contact);
		Outfitting.lastId = 0;
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
}