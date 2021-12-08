package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import outfitting.dto.OutfittingDtoForAdd;
import outfitting.model.OutfittingRepositoryMock;
import outfitting.model.entity.Contact;
import outfitting.view.ViewMock;

public class OutfittingAddControllerTest {

	@Test
	public void when_requestOutfittingAdd_then_shouldAskOutfittingAddViewToDisplay() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingAddController controller = new OutfittingAddController(orchestrator, view, repo);
		
		controller.requestOutfittingAdd();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
	
	@Test
	public void when_requestToAddWithValidInfo_then_requestSuccessToView() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingAddController controller = new OutfittingAddController(orchestrator, view, repo);
		
		controller.addDtoOutfitting(new OutfittingDtoForAdd("a", "a", "a", "a", new Contact("a", "a", "a")));
		
		assertTrue(view.displaySuccessMethodHasBeenCalled);
	}
	
	@Test
	public void when_requestToAddWithInalidInfo_then_requestErrorToView() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingAddController controller = new OutfittingAddController(orchestrator, view, repo);
		
		controller.addDtoOutfitting(new OutfittingDtoForAdd(OutfittingRepositoryMock.THROW_ID_ALREADY_EXIST_EXCEPTION_NAME, "a", "a", "a", new Contact("a", "a", "a")));
		
		assertTrue(view.displayErrorMethodHasBeenCalled);
	}
}