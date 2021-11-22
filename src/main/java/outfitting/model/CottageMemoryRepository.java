package outfitting.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import outfitting.model.entity.Cottage;

public class CottageMemoryRepository implements GenericRepository<Cottage> {

	private Map<Integer, Cottage> cottages;
	
	public CottageMemoryRepository()
	{
		cottages = new HashMap<>();
		dataSeed();
	}
	
	@Override
	public void add(Cottage cottage) {
		cottages.put(cottage.getId(), cottage);
	}

	@Override
	public Collection<Cottage> getList() {
		return cottages.values();
	}

	@Override
	public int size() {
		return cottages.size();
	}

	@Override
	public Cottage searchById(int id) {
		return cottages.get(id);
	}

	private void dataSeed() {
		Cottage cottage1 = new Cottage("Nar Shaddaa's Cottage", 2,3, 34);
		Cottage cottage2 = new Cottage("Teepee", 1,3, 34);
		Cottage cottage3 = new Cottage("The Max Int Cottage", 3,3, 34);
		Cottage cottage4 = new Cottage("Japan", 4,3, 34);
		cottages.put(cottage1.getId(), cottage1);
		cottages.put(cottage2.getId(), cottage2);
		cottages.put(cottage3.getId(), cottage3);
		cottages.put(cottage4.getId(), cottage4);
		
	}
}
