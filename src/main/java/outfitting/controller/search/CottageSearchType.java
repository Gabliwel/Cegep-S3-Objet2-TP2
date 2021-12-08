package outfitting.controller.search;

public enum CottageSearchType {
	BY_NB_OF_ROOM("Par nombre de chambre"), BY_REGION_NAME("Par nom de région");
	
public final String string;
	
	CottageSearchType(String string) {
		this.string = string;
	}
	
	public static String[] getAllTypeInString()
	{
		String[] names = new String[CottageSearchType.values().length];

	    for (int i = 0; i < CottageSearchType.values().length; i++) {
	        names[i] = CottageSearchType.values()[i].string;
	    }

	    return names;
	}
}