package outfitting.view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.junit.jupiter.api.Test;

import outfitting.controller.OutfittingListControllerMock;

public class OutfittingListViewTest {

	@Test
	public void when_clickSortById_then_resquestGetSortedListToController()
	{
		OutfittingListView view = new OutfittingListView();
		OutfittingListControllerMock controller = new OutfittingListControllerMock();
		view.setController(controller);
		
		view.actionPerformed(new ActionEvent(JButton.class, 0, "TRIER PAR ID"));
		
		assertTrue(controller.getSortedListHasBeenCalled);
	}
	
	@Test
	public void when_clickSortByName_then_resquestGetSortedListToController()
	{
		OutfittingListView view = new OutfittingListView();
		OutfittingListControllerMock controller = new OutfittingListControllerMock();
		view.setController(controller);
		
		view.actionPerformed(new ActionEvent(JButton.class, 0, "TRIER PAR NOM"));
		
		assertTrue(controller.getSortedListHasBeenCalled);
	}
	
	@Test
	public void when_clickSortByRegion_then_resquestGetSortedListToController()
	{
		OutfittingListView view = new OutfittingListView();
		OutfittingListControllerMock controller = new OutfittingListControllerMock();
		view.setController(controller);
		
		view.actionPerformed(new ActionEvent(JButton.class, 0, "TRIER PAR RÉGION"));
		
		assertTrue(controller.getSortedListHasBeenCalled);
	}
}