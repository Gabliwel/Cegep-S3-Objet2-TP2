package outfitting.observer;

public class ObserverMock implements Observer{

	private boolean reactHasBeenCalled = false;
	
	@Override
	public void react() {
		reactHasBeenCalled = true;
	}
}
