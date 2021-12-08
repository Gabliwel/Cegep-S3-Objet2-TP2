package outfitting.view;

public interface View {
	public void display();

	public void displayError(String message);
	public void displaySuccess(String message);
	public void refresh();
}