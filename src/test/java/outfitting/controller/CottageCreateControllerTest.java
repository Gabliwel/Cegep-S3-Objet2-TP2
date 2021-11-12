package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import outfitting.dto.CottageDtoForCreateMock;
import outfitting.model.CottageRepositoryMock;
import outfitting.view.ViewMock;

public class CottageCreateControllerTest {

	@Test
	public void when_requestCreateCottage_then_shouldAskCreateCottageViewToDisplay() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		CottageRepositoryMock repo = new CottageRepositoryMock();
		CottageCreateController controller = new CottageCreateController(orchestrator, view, repo);
		
		controller.requestCottageCreate();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
	
	@Test
	public void when_requestAddCottage_then_shouldAskAddCottageToRepository() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		CottageRepositoryMock repo = new CottageRepositoryMock();
		CottageCreateController controller = new CottageCreateController(orchestrator, view, repo);
		
		controller.add(new CottageDtoForCreateMock());
		
		assertTrue(repo.addHasBeenCalled);
	}
}
