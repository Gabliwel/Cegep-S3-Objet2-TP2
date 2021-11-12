package outfitting;

import outfitting.controller.ControllerOrchestrator;
import outfitting.model.CottageMemoryRepository;

public class MainApp {

	public static void main(String[] args) {
		new MainApp();
	}

	public MainApp() {
		this.createOrchestrator();
	}

	private void createOrchestrator() {
		new ControllerOrchestrator(new CottageMemoryRepository());
	}
}
