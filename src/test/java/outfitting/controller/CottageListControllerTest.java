package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.dto.CottageDTOForList;
import outfitting.model.CottageMemoryRepositoryMockWithAdd;
import outfitting.model.OutfittingRepositoryMock;
import outfitting.model.entity.CottageMock;
import outfitting.model.entity.OutfittingMock;
import outfitting.view.ViewMock;

public class CottageListControllerTest {
	
	private static final int ANY_ID = 1;
	ControllerOrchestratorMock orchestrator = null;
	ViewMock view = null;
	CottageMemoryRepositoryMockWithAdd repo = null;
	OutfittingRepositoryMock repo2 = null;
	CottageListController controller = null;
	
	@BeforeEach
	public void setUp() 
	{
		orchestrator = new ControllerOrchestratorMock();
		view = new ViewMock();
		repo = new CottageMemoryRepositoryMockWithAdd();
		repo2 = new OutfittingRepositoryMock();
		controller = new CottageListController(orchestrator, view, repo, repo2);
	}
	
	@Test
	public void when_requestCottageList_then_shouldAskCottageListViewToDisplay() {
		
		controller.requestCottageList();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
	 
	@Test
	public void WHEN_getListIsCalled_THEN_assuredThatGetListHasBeenCalled() 
	{
		CottageMock cottage = new CottageMock("bob", 1, 2, 3,0);
		
		repo.add(cottage);
		Collection<CottageDTOForList> cottageCollection = controller.getCottageList();
		
		assertTrue(repo.getListBeenCalled);
	}
	
	@Test
	public void WHEN_getOutfittingFromID_THEN_nullIsReturnedAndSearchHasBeenCalledIsTrue() 
	{
		assertTrue(controller.getOutfittingObject(ANY_ID) instanceof OutfittingMock);
		assertTrue(repo2.searchByIdBeenCalled);
	}
	
	@Test
	public void WHEN_requestSpecificCottageView_THEN_requestSpecificCottageHasBeenCalledIsTrue() 
	{
		CottageListControllerMock controllerMock = new CottageListControllerMock();
		controllerMock.requestSpecificCottageView(ANY_ID);
		
		assertTrue(controllerMock.requestSpecificCottageViewHasBeenCalled);
	}
}