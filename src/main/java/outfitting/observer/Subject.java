package outfitting.observer;

public interface Subject {

	void addObserver(Observer o);

	void removeObserver(Observer o);

	void notifyAllObserver();

}
