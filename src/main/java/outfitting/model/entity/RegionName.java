package outfitting.model.entity;

public enum RegionName {
	QUEBEC("Qu�bec"), ONTARIO("Ontario"), MANITOBA("Manitoba"), NUNAVUT("Nunavut");

	public final String name;
	
	RegionName(String name) {
		this.name = name;
	}
}