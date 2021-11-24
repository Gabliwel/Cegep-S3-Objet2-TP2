package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import outfitting.dto.CottageDTOForList;
import outfitting.model.CottageMemoryRepositoryMockWithAdd;
import outfitting.model.CottageRepositoryMock;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.CottageMock;
import outfitting.view.ViewMock;

public class CottageListControllerTest {
	
	@Test
	public void when_requestCottageList_then_shouldAskCottageListViewToDisplay() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		CottageRepositoryMock repo = new CottageRepositoryMock();
		CottageListController controller = new CottageListController(orchestrator, view, repo);
		
		controller.requestCottageList();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
	
//	@Test
//	public void when_requestCottage_then_shouldAskCottageListToRepo() {
//		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
//		ViewMock view = new ViewMock();
//		CottageRepositoryMock repo = new CottageRepositoryMock();
//		CottageListController controller = new CottageListController(orchestrator, view, repo);
//		CottageDTOForList cottageDTO = new CottageDTOForList(1, "Bob", 3, 4, 5); //need this lign or else test will fail. cannot call .stream() in controller on a empty collection
//		
//		
//		Collection<CottageDTOForList> cottages = repo;
//		cottages.add(cottageDTO);
//		
//		controller.getCottageList();
//		
//		//assertNull(cottages);
//		assertTrue(repo.getListBeenCalled);
//	}
	
	@Test
	public void WHEN_getListIsCalled_THEN_assuredThatGetListHasBeenCalled() 
	{
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		CottageMemoryRepositoryMockWithAdd repo = new CottageMemoryRepositoryMockWithAdd();
		CottageListController controller = new CottageListController(orchestrator, view, repo);
		CottageMock cottage = new CottageMock("bob", 1, 2, 3);
		
		repo.add(cottage);
		Collection<CottageDTOForList> cottageCollection = controller.getCottageList();
		
		assertTrue(repo.getListBeenCalled);
	}
}