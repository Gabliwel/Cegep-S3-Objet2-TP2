package outfitting.model;

import java.util.Collection;

import outfitting.model.entity.Cottage;

public interface CottageRepository {
	void add(Cottage cottage);
	Collection<Cottage> getList();
	int size();
	Cottage searchById(int id);
}
