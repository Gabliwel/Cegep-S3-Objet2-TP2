package outfitting.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import outfitting.exception.IdDoesNotExistException;
import outfitting.model.entity.Cottage;
import outfitting.observer.Subject;
import outfitting.observer.Observer;

public class CottageMemoryRepositoryMockWithAdd implements GenericRepository<Cottage>, Subject {
	
	public boolean addHasBeenCalled = false;
	public boolean getListBeenCalled = false; 
	public boolean removeHasBeenCalled = false;
	public boolean searchByIdHasBeenCalled = false;
	
	private Map<Integer, Cottage> cottages;
	
	public CottageMemoryRepositoryMockWithAdd()
	{
		cottages = new HashMap<>();
	}
	
	@Override
	public void add(Cottage cottage) {
		cottages.put(cottage.getId(), cottage);
	}

	@Override
	public Collection<Cottage> getList() {
		getListBeenCalled = true;
		return cottages.values();
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Cottage searchById(int id) {
		searchByIdHasBeenCalled = true;
		return cottages.get(id);
	}

	@Override
	public void remove(int id) 
	{
		if(cottages.containsKey(id)) 
		{
			this.cottages.remove(id);
			this.removeHasBeenCalled = true;
		}
		else 
		{
			throw new IdDoesNotExistException("Le ID" + id+ " n'existe pas");
		}
	}

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyAllObserver() {
		// TODO Auto-generated method stub
		
	}
}
