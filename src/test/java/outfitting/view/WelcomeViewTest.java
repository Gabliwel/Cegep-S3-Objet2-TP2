package outfitting.view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.junit.jupiter.api.Test;

import outfitting.controller.WelcomeControllerMock;

public class WelcomeViewTest {
	
	@Test
	public void when_clickAddCottageJButton_then_resquestCreateCottageToController()
	{
		WelcomeView view = new WelcomeView();
		WelcomeControllerMock controller = new WelcomeControllerMock();
		view.setController(controller);
		
		view.actionPerformed(new ActionEvent(JButton.class, 0, "Ajouter un chalet"));
		
		assertTrue(controller.resquestCreateCottageHasBeenCalled);
	}
	
	@Test
	public void when_clickCottageListJButton_then_resquestCottageListToController()
	{
		WelcomeView view = new WelcomeView();
		WelcomeControllerMock controller = new WelcomeControllerMock();
		view.setController(controller);
		
		view.actionPerformed(new ActionEvent(JButton.class, 0, "Liste des chalets"));
		
		assertTrue(controller.resquestCottageListHasBeenCalled);
	}
}