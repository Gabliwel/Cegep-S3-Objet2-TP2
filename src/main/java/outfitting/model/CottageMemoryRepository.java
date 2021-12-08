package outfitting.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import outfitting.exception.IdAlreadyExistException;
import outfitting.exception.IdDoesNotExistException;
import outfitting.model.entity.Cottage;
import outfitting.observer.Observer;
import outfitting.observer.Subject;

public class CottageMemoryRepository implements Subject, GenericRepository<Cottage>{

	private Map<Integer, Cottage> cottages;
	private List<Observer> observers;
	
	public CottageMemoryRepository()
	{
		cottages = new HashMap<>();
		this.observers = new ArrayList<Observer>();
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
			throw new IdAlreadyExistException("Le ID" + cottage.getId()+ " existe deja");
		}
		this.notifyAllObserver();
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
			throw new IdDoesNotExistException("Le ID" + id+ " n'existe pas");
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
			throw new IdDoesNotExistException("Le ID" + id+ " n'existe pas");
		}
		this.notifyAllObserver();
	}

	private void dataSeed() {
		Cottage cottage1 = new Cottage("Nar Shaddaa's Cottage", 5, 20, 70,1);
		Cottage cottage2 = new Cottage("Teepee", 3, 16, 50, 2);
		Cottage cottage3 = new Cottage("The Max Int Cottage", 4, 16, 60, 3);
		Cottage cottage4 = new Cottage("Japan", 2, 7, 100, 1);

		cottages.put(cottage1.getId(), cottage1);
		cottages.put(cottage2.getId(), cottage2);
		cottages.put(cottage3.getId(), cottage3);
		cottages.put(cottage4.getId(), cottage4);
	}

	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		this.observers.remove(o);
	}

	@Override
	public void notifyAllObserver() {
		this.observers.forEach(o->o.react());
	}
}
