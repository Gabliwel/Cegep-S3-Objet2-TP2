package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.dto.CottageDTOForList;
import outfitting.model.CottageRepositoryMock;
import outfitting.view.ViewMock;

public class CottageSpecificControllerTest {

	private static final int ANY_ID = 3;
	
	ControllerOrchestratorMock orchestrator = null;
	ViewMock view = null;
	CottageRepositoryMock repo = null;
	CottageSpecificController controller = null;
	
	@BeforeEach
	public void setUp() 
	{
		orchestrator = new ControllerOrchestratorMock();
		view = new ViewMock();
		repo = new CottageRepositoryMock();
		controller = new CottageSpecificController(ANY_ID, repo, orchestrator, view);
	}
	
	@Test
	public void WHEN_requestSpecificViewIsCalled_THEN_displayMethodHasBeenCalled() { 
		controller.requestSpecificCottageList();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
	
	@Test
	public void WHEN_getCottageDTOForViewIsCalled_THEN_searchByIdMethodHasBeenCalled() {		
		CottageDTOForList cottage = controller.getCottageDTOForList();
		
		assertTrue(repo.searchByIdHasBeenCalled);
	}
	
}
