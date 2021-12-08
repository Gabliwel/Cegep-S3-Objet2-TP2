package outfitting.model;

import java.util.Collection;

import outfitting.exception.IdAlreadyExistException;
import outfitting.model.entity.Cottage;
import outfitting.observer.Subject;
import outfitting.observer.Observer;

public class CottageRepositoryMock implements GenericRepository<Cottage>, Subject {

	public boolean addHasBeenCalled = false;
	public boolean getListBeenCalled = false;
	public boolean removeHasBeenCalled = false;
	public boolean searchByIdHasBeenCalled = false; 
	
	@Override
	public void add(Cottage cottage) {
		if(addHasBeenCalled) 
		{
			throw new IdAlreadyExistException("it either work or it didnt");
		}
		addHasBeenCalled = true;
		Cottage.lastId = 0;
	}

	@Override
	public Collection<Cottage> getList() {
		getListBeenCalled = true;
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Cottage searchById(int id) {
		searchByIdHasBeenCalled = true;
		return null;
	}

	@Override
	public void remove(int id) {
		removeHasBeenCalled = true;
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