package outfitting.observer;

public class SubjectMock implements Subject{

	public boolean addObserverHasBeenCalled = false;
	public boolean removeObserverHasBeenCalled = false;
	public boolean notifyObserverHasBeenCalled = false;
	
	@Override
	public void addObserver(Observer o) {
		addObserverHasBeenCalled = true;
	}

	@Override
	public void removeObserver(Observer o) {
		removeObserverHasBeenCalled = true;
		
	}

	@Override
	public void notifyAllObserver() {
		notifyObserverHasBeenCalled = true;
		
	}

}
