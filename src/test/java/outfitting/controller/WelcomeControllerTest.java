package outfitting.controller;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import outfitting.view.ViewMock;

public class WelcomeControllerTest {

	@Test
	public void when_requestWelcome_then_shouldAskWelcomeViewToDisplay() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		WelcomeController controller = new WelcomeController(orchestrator, view);
		
		controller.requestWelcome();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
	
	@Test
	public void when_requestCreateCottage_then_shouldAskToGoToCreateCottageToOrchestrator() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		WelcomeController controller = new WelcomeController(orchestrator, view);
		
		controller.resquestCreateCottage();
		
		assertTrue(orchestrator.goToCreateCottageHasBeenCalled);
	}
	
	@Test
	public void when_requestCottageList_then_shouldAskToGoToCottageListToOrchestrator() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		WelcomeController controller = new WelcomeController(orchestrator, view);
		
		controller.resquestCottageList();
		
		assertTrue(orchestrator.goToCottageListHasBeenCalled);
	}
	
	@Test
	public void when_requestOutfittingList_then_shouldAskToGoToCottageListToOrchestrator() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		WelcomeController controller = new WelcomeController(orchestrator, view);
		
		controller.requestOutfittingList();
		
		assertTrue(orchestrator.goToOutfittingListHasBeenCalled);
	}
}
