package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import outfitting.model.OutfittingRepositoryMock;
import outfitting.view.ViewMock;

public class OutfittingListControllerTest {
	
	@Test
	public void when_requestCreateCottage_then_shouldAskCreateCottageViewToDisplay() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingListController controller = new OutfittingListController(orchestrator, view, repo);
		
		controller.requestOutfittingList();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
}