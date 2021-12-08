package outfitting.model;

import java.util.Arrays;
import java.util.Collection;

import outfitting.exception.IdAlreadyExistException;
import outfitting.exception.IdDoesNotExistException;
import outfitting.model.entity.Outfitting;
import outfitting.model.entity.OutfittingMock;

public class OutfittingRepositoryMock implements GenericRepository<Outfitting> {

	public boolean getListBeenCalled = false;
	public boolean searchByIdBeenCalled = false;
	public static final String EXPECTED_NAME_FOR_SEARCH = "EXPECTED_NAME";
	public static final String UNEXPECTED_NAME_FOR_SEARCH = "UNEXPECTED_NAME";
	public static final String THROW_ID_ALREADY_EXIST_EXCEPTION_NAME = "EXPECTED_NAME";
	
	public String region = "";
	
	@Override
	public void add(Outfitting o) {
		Outfitting.lastId = 0;
		if(o.getName()==THROW_ID_ALREADY_EXIST_EXCEPTION_NAME)
		{
			throw new IdAlreadyExistException("");
		}
	}

	@Override 
	public Collection<Outfitting> getList() {
		getListBeenCalled = true;
		return Arrays.asList(new OutfittingMock(-1, EXPECTED_NAME_FOR_SEARCH, null));
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
		return new OutfittingMock(-1, "", region);
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}
}