package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import outfitting.dto.OutfittingDtoForGet;
import outfitting.model.OutfittingRepositoryMock;
import outfitting.model.entity.Contact;
import outfitting.sort.SortOutfittingType;
import outfitting.view.ViewMock;

public class OutfittingListControllerTest {
	
	@Test
	public void when_requestOutfittingList_then_shouldAskOutfittingListViewToDisplay() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingListController controller = new OutfittingListController(orchestrator, view, repo);
		
		controller.requestOutfittingList();
		
		assertTrue(view.displayMethodHasBeenCalled);
	}
	
	@Test
	public void when_getOutfittingById_then_shouldAskRepoToSearchById() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingListController controller = new OutfittingListController(orchestrator, view, repo);
		int anyId = 0;
		
		controller.getOutfittingById(anyId);
		
		assertTrue(repo.searchByIdBeenCalled);
	}
	
	@Test
	public void when_getOutfittingByIdWithInvalidId_then_shouldAskViewToShowError() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingListController controller = new OutfittingListController(orchestrator, view, repo);
		int errorId = 10;
		
		controller.getOutfittingById(errorId);
		
		assertTrue(view.displayErrorMethodHasBeenCalled);
	}
	
	@Test
	public void when_getOutfittingList_then_shouldReturnDtoOutfittingList() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingListController controller = new OutfittingListController(orchestrator, view, repo);
		
		List<OutfittingDtoForGet> list = controller.getSortedList(SortOutfittingType.NON_SORTED);
		
		assertEquals(list.get(0).getClass(), new OutfittingDtoForGet(0, null, null, null, null, new Contact(null, null, null)).getClass());
	}
	
	@Test
	public void when_getOutfittingListByName_then_shouldReturnDtoOutfittingList() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingListController controller = new OutfittingListController(orchestrator, view, repo);
		
		List<OutfittingDtoForGet> list = controller.getSortedList(SortOutfittingType.BY_NAME);
		
		assertEquals(list.get(0).getClass(), new OutfittingDtoForGet(0, null, null, null, null, new Contact(null, null, null)).getClass());
	}
	
	@Test
	public void when_getOutfittingListByRegion_then_shouldReturnDtoOutfittingList() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingListController controller = new OutfittingListController(orchestrator, view, repo);
		
		List<OutfittingDtoForGet> list = controller.getSortedList(SortOutfittingType.BY_NAME);
		
		assertEquals(list.get(0).getClass(), new OutfittingDtoForGet(0, null, null, null, null, new Contact(null, null, null)).getClass());
	}
	
	@Test
	public void when_searchOutfittingWithValidTermOfOutfittingName_then_getListWithWithExpectedOutfittingInIt() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingListController controller = new OutfittingListController(orchestrator, view, repo);
		
		Collection<OutfittingDtoForGet> list = controller.searchInList(OutfittingRepositoryMock.EXPECTED_NAME_FOR_SEARCH);
		
		OutfittingDtoForGet o = list.iterator().next();
		
		assertEquals(o.getName(), OutfittingRepositoryMock.EXPECTED_NAME_FOR_SEARCH);
	}
	
	@Test
	public void when_searchOutfittingWithInvalidTermOfOutfittingName_then_getEmptyList() {
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		OutfittingRepositoryMock repo = new OutfittingRepositoryMock();
		OutfittingListController controller = new OutfittingListController(orchestrator, view, repo);
		
		Collection<OutfittingDtoForGet> list = controller.searchInList(OutfittingRepositoryMock.UNEXPECTED_NAME_FOR_SEARCH);
		
		assertTrue(list.isEmpty());
	}
}