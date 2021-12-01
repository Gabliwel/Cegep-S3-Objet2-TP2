package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import outfitting.dto.CottageDTOForList;
import outfitting.model.CottageMemoryRepositoryMockWithAdd;
import outfitting.model.CottageRepositoryMock;
import outfitting.model.OutfittingRepositoryMock;
import outfitting.model.entity.CottageMock;
import outfitting.view.ViewMock;

public class CottageListControllerTest {
	
	@Test
	public void when_requestCottageList_then_shouldAskCottageListViewToDisplay() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		CottageRepositoryMock repo = new CottageRepositoryMock();
		OutfittingRepositoryMock repo2 = new OutfittingRepositoryMock();
		CottageListController controller = new CottageListController(orchestrator, view, repo, repo2);
		
		controller.requestCottageList();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
	 
	@Test
	public void WHEN_getListIsCalled_THEN_assuredThatGetListHasBeenCalled() 
	{
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock(); 
		CottageMemoryRepositoryMockWithAdd repo = new CottageMemoryRepositoryMockWithAdd();
		OutfittingRepositoryMock repo2 = new OutfittingRepositoryMock();
		CottageListController controller = new CottageListController(orchestrator, view, repo, repo2);
		CottageMock cottage = new CottageMock("bob", 1, 2, 3,0);
		
		repo.add(cottage);
		Collection<CottageDTOForList> cottageCollection = controller.getCottageList();
		
		assertTrue(repo.getListBeenCalled);
	}
}