package outfitting.model.entity;

public enum RegionName {
	QUEBEC("Québec"), ONTARIO("Ontario"), MANITOBA("Manitoba"), NUNAVUT("Nunavut");

	public final String name;
	
	RegionName(String name) {
		this.name = name;
	}
	
	public static String[] getAllRegionNames()
	{
		String[] names = new String[RegionName.values().length];

	    for (int i = 0; i < RegionName.values().length; i++) {
	        names[i] = RegionName.values()[i].name;
	    }

	    return names;
	}
}