package outfitting.model;

import java.util.Collection;

import outfitting.model.entity.Outfitting;

public class OutfittingRepositoryMock implements GenericRepository<Outfitting> {

	public boolean getListBeenCalled = false;
	
	@Override
	public void add(Outfitting o) {
		Outfitting.lastId = 0;
	}

	@Override 
	public Collection<Outfitting> getList() {
		// TODO Auto-generated method stub
		getListBeenCalled = true;
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Outfitting searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

}