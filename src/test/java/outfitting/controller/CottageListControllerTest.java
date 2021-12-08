package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.dto.OutfittingDtoForGet;
import outfitting.model.CottageMemoryRepositoryMockWithAdd;
import outfitting.model.OutfittingRepositoryMock;
import outfitting.model.entity.CottageMock;
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
		controller.getCottageList();
		
		assertTrue(repo.getListBeenCalled);
	}
	
	@Test
	public void WHEN_getOutfittingFromID_THEN_nullIsReturnedAndSearchHasBeenCalledIsTrue() 
	{
		assertTrue(controller.getOutfittingObject(ANY_ID) instanceof OutfittingDtoForGet);
		assertTrue(repo2.searchByIdBeenCalled);
	}
	
	@Test
	public void WHEN_requestSpecificCottageView_THEN_requestSpecificCottageHasBeenCalledIsTrue() 
	{
		CottageListControllerMock controllerMock = new CottageListControllerMock();
		controllerMock.requestSpecificCottageView(ANY_ID);
		
		assertTrue(controllerMock.requestSpecificCottageViewHasBeenCalled);
	}
	
	@Test
	public void when_searchByNullType_then_throwError() 
	{
		assertThrows(IllegalArgumentException.class, () ->
		{
			controller.searchInList(null, null);
		});
	}
}