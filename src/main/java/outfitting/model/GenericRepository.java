package outfitting.model;

import java.util.Collection;

import outfitting.model.entity.Cottage;

public interface GenericRepository<T> {
	void add(T o);
	Collection<T> getList();
	int size();
	T searchById(int id);
	void remove(int id, T o);
}
