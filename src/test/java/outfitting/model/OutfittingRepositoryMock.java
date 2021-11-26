package outfitting.model;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


import outfitting.exception.IdDoesNotExistException;
import outfitting.model.entity.Outfitting;
import outfitting.model.entity.OutfittingMock;

public class OutfittingRepositoryMock implements GenericRepository<Outfitting> {

	public boolean getListBeenCalled = false;
	public boolean searchByIdBeenCalled = false;
	
	@Override
	public void add(Outfitting o) {
		Outfitting.lastId = 0;
	}

	@Override
	public Collection<Outfitting> getList() {
		getListBeenCalled = true;
		return Arrays.asList(new OutfittingMock(-1, null, null));
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Outfitting searchById(int id) {
		searchByIdBeenCalled = true;
		if(id == 10) {
			throw new IdDoesNotExistException("");
		}
		return new OutfittingMock(-1, "", "");
	}

	@Override
	public void remove(int id) {

	}
}