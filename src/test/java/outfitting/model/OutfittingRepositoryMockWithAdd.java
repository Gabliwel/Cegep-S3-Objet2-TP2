package outfitting.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import outfitting.model.entity.Outfitting;

public class OutfittingRepositoryMockWithAdd implements GenericRepository<Outfitting>{

	public boolean getListBeenCalled = false;
	private Map<Integer, Outfitting> outfittings;
	
	public OutfittingRepositoryMockWithAdd() {
		outfittings = new HashMap<>();
	} 
	
	@Override
	public void add(Outfitting o) {
		outfittings.put(o.getId(), o);
	}

	@Override
	public Collection<Outfitting> getList() {
		getListBeenCalled = true;
		return outfittings.values();
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
