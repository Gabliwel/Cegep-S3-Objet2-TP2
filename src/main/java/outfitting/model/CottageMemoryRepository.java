package outfitting.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import outfitting.exception.IDAlreadyExistException;
import outfitting.exception.IDDoesNotExistException;
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
		if(!cottages.containsKey(cottage.getId())) 
		{
			cottages.put(cottage.getId(), cottage);
		}
		else 
		{
			throw new IDAlreadyExistException("Le ID" + cottage.getId()+ " existe deja");
		}
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
	public Cottage searchById(int id) 
	{
		if(cottages.containsKey(id)) 
		{
			return cottages.get(id);
		}
		else 
		{
			throw new IDDoesNotExistException("Le ID" + id+ " n'existe pas");
		}
	}
	
	@Override
	public void remove(int id) 
	{
		if(cottages.containsKey(id)) 
		{
			this.cottages.remove(id);
		}
		else 
		{
			throw new IDDoesNotExistException("Le ID" + id+ " n'existe pas");
		}
	}

	private void dataSeed() {
		Cottage cottage1 = new Cottage("Nar Shaddaa's Cottage", 5, 20, 70);
		Cottage cottage2 = new Cottage("Teepee", 3, 16, 50);
		Cottage cottage3 = new Cottage("The Max Int Cottage", 4, 16, 60);
		Cottage cottage4 = new Cottage("Japan", 2, 7, 100);

		cottages.put(cottage1.getId(), cottage1);
		cottages.put(cottage2.getId(), cottage2);
		cottages.put(cottage3.getId(), cottage3);
		cottages.put(cottage4.getId(), cottage4);
	}
}
