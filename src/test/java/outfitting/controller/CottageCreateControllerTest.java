package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.dto.CottageDtoForCreateMock;
import outfitting.model.CottageRepositoryMock;
import outfitting.model.OutfittingRepositoryMock;
import outfitting.model.entity.Cottage;
import outfitting.view.ViewMock;

public class CottageCreateControllerTest {

	@BeforeEach
	public void init()
	{
		Cottage.lastId = 0;
	}
	
	@Test
	public void when_requestCreateCottage_then_shouldAskCreateCottageViewToDisplay() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock(); 
		CottageRepositoryMock repo = new CottageRepositoryMock();
		OutfittingRepositoryMock repo2 = new OutfittingRepositoryMock();
		CottageCreateController controller = new CottageCreateController(orchestrator, view, repo, repo2);
		
		controller.requestCottageCreate();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
	
	@Test
	public void when_requestAddCottage_then_shouldAskAddCottageToRepository() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		CottageRepositoryMock repo = new CottageRepositoryMock();
		OutfittingRepositoryMock repo2 = new OutfittingRepositoryMock();
		CottageCreateController controller = new CottageCreateController(orchestrator, view, repo, repo2);
		
		controller.add(new CottageDtoForCreateMock());
		
		assertTrue(repo.addHasBeenCalled);
	}
	
	@Test
	public void WHEN_addIsCalledWithWrongValue_THEN_exceptionIsThrown() 
	{
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		CottageRepositoryMock repo = new CottageRepositoryMock();
		OutfittingRepositoryMock repo2 = new OutfittingRepositoryMock();

		CottageCreateController controller = new CottageCreateController(orchestrator, view, repo, repo2);
		CottageDtoForCreateMock c = new CottageDtoForCreateMock();
		
		controller.add(c);
		Cottage.lastId = 0;
		controller.add(c);
		
		assertTrue(view.displayErrorHasBeenCalled);
	}
}
