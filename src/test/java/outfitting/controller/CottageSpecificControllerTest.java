package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.model.CottageMemoryRepositoryMockWithAdd;
import outfitting.model.CottageRepositoryMock;
import outfitting.model.entity.CottageMock;
import outfitting.view.ViewMock;

public class CottageSpecificControllerTest {

	private static final String ANY_NAME = "Bob";
	private static final int ANY_NUMBER = 4;
	private static final int ANY_ID = 1;
	private static final int WRONG_ID = 9;
	
	ControllerOrchestratorMock orchestrator = null;
	ViewMock view = null;
	CottageMemoryRepositoryMockWithAdd repo = null;
	CottageSpecificController controller = null;
	
	@BeforeEach
	public void setUp() 
	{
		orchestrator = new ControllerOrchestratorMock();
		view = new ViewMock();
		repo = new CottageMemoryRepositoryMockWithAdd();
		controller = new CottageSpecificController(ANY_ID, repo, orchestrator, view);
	}
	
	@Test
	public void WHEN_requestSpecificViewIsCalled_THEN_displayMethodHasBeenCalled() 
	{ 
		controller.requestSpecificCottageList();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
	
	@Test
	public void WHEN_getCottageDTOForListIsCalled_THEN_correctCottageIsCalled() 
	{
		CottageMock cottageMock = new CottageMock(ANY_NAME,ANY_NUMBER,ANY_NUMBER,ANY_NUMBER);
		
		repo.add(cottageMock);
		controller.getCottageDTOForList();
		
		assertTrue(repo.searchByIdHasBeenCalled);
	}
	
	@Test
	public void WHEN_remove_THEN_deleteIsCalled() 
	{
		CottageMock cottageMock = new CottageMock(ANY_NAME,ANY_NUMBER,ANY_NUMBER,ANY_NUMBER);
		
		repo.add(cottageMock);
		controller.deleteCottage(cottageMock.getId());
		
		assertTrue(repo.removeHasBeenCalled);
	}
	
	@Test
	public void WHEN_requestSpecifiViewisCalledWithWrongValue_THEN_displayErrorIsTrue() 
	{		
		controller.deleteCottage(WRONG_ID);
		
		assertTrue(view.displayErrorHasBeenCalled);
	}
}