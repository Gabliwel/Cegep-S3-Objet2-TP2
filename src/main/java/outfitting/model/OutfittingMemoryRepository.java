package outfitting.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import outfitting.model.entity.Outfitting;
import outfitting.model.entity.RegionName;

public class OutfittingMemoryRepository implements GenericRepository<Outfitting> {

	private Map<Integer, Outfitting> outfittings;
	
	public OutfittingMemoryRepository() {
		outfittings = new HashMap<>();
		dataSeed();
	}
	
	@Override
	public void add(Outfitting o) {
		outfittings.put(o.getId(), o);
	}

	@Override
	public Collection<Outfitting> getList() {
		return outfittings.values();
	}

	@Override
	public int size() {
		return outfittings.size();
	}

	@Override
	public Outfitting searchById(int id) {
		return outfittings.get(id);
	}
	
	private void dataSeed() {
		Outfitting o1 = new Outfitting("La Terre � Roger", RegionName.QUEBEC.name, "911", "terrederoger@chibougamau.qc.ca");
		Outfitting o2 = new Outfitting("The Universe", RegionName.ONTARIO.name, "000-000-0000", "42@universe.com");
		Outfitting o3 = new Outfitting("La Terre des Perdues", RegionName.NUNAVUT.name, "123-456-7890", "jesuisou@help.ca");
		outfittings.put(o1.getId(), o1);
		outfittings.put(o2.getId(), o2);
		outfittings.put(o3.getId(), o3);
	}
}