package outfitting.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import outfitting.exception.IdAlreadyExistException;
import outfitting.exception.IdDoesNotExistException;
import outfitting.model.entity.Contact;
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
		if(!outfittings.containsKey(o.getId())) {
			outfittings.put(o.getId(), o);
		}
		else {
			throw new IdAlreadyExistException("Outfitting id already exist");
		}
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
		if(outfittings.containsKey(id)) {
			return outfittings.get(id);
		}
		else {
			throw new IdDoesNotExistException("Outfitting id does not exist");
		}
	}
	
	private void dataSeed() {
		Outfitting o1 = new Outfitting("La Terre de Roger", RegionName.QUEBEC.name, "911", "terrederoger@chibougamau.qc.ca", new Contact("Bob1", "444-444-4444", "a@b.com"));
		Outfitting o2 = new Outfitting("The Universe", RegionName.ONTARIO.name, "000-000-0000", "42@universe.com", new Contact("Bob2", "444-444-4444", "a@b.com"));
		Outfitting o3 = new Outfitting("La Terre des Perdues", RegionName.NUNAVUT.name, "123-456-7890", "jesuisou@help.ca", new Contact("Robert3", "123-456-7890", "z@y.com"));
		outfittings.put(o1.getId(), o1);
		outfittings.put(o2.getId(), o2);
		outfittings.put(o3.getId(), o3);
	}

	@Override
	public void remove(int id) { }
}