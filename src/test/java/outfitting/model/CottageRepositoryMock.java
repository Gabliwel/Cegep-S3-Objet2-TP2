package outfitting.model;

import java.util.Collection;

import outfitting.exception.IDAlreadyExistException;
import outfitting.model.entity.Cottage;

public class CottageRepositoryMock implements GenericRepository<Cottage> {

	public boolean addHasBeenCalled = false;
	public boolean getListBeenCalled = false;
	public boolean removeHasBeenCalled = false;
	public boolean searchByIdHasBeenCalled = false; 
	
	@Override
	public void add(Cottage cottage) {
		if(addHasBeenCalled) 
		{
			throw new IDAlreadyExistException("it either work or it didnt");
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
}