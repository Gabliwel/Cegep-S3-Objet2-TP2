package outfitting.model;

import java.util.Collection;

public interface GenericRepository<T> {
	void add(T o);
	Collection<T> getList();
	int size();
	T searchById(int id);
}
