package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import outfitting.dto.CottageDTOForList;
import outfitting.model.CottageRepositoryMock;
import outfitting.model.entity.Cottage;
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
	
	@Test
	public void when_requestCottage_then_shouldAskCottageListToRepo() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		CottageRepositoryMock repo = new CottageRepositoryMock();
		CottageListController controller = new CottageListController(orchestrator, view, repo);
		//CottageDTOForList cottageDTO = new CottageDTOForList(1, "Bob", 3, 4, 5); //need this lign or else test will fail. cannot call .stream() in controller on a empty collection
		
		
		
		Collection<CottageDTOForList> cottages = controller.getCottageList();; 
//		cottages.add(cottageDTO);
		
		
		
		//assertNull(cottages);
		assertTrue(repo.getListBeenCalled);
	}
}