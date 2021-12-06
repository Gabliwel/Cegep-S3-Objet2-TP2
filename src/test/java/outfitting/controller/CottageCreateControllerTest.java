package outfitting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.dto.CottageDtoForCreateMock;
import outfitting.model.CottageRepositoryMock;
import outfitting.model.OutfittingRepositoryMock;
import outfitting.model.OutfittingRepositoryMockWithAdd;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.Outfitting;
import outfitting.model.entity.OutfittingMock;
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
		
		assertTrue(view.displayErrorMethodHasBeenCalled);
	}
	
	@Test
	public void WHEN_getOutfittingCollectionIsCalled_THEN_aListIsReturnedAndGetListIsTrue() 
	{
		ControllerOrchestratorMock orchestrator = new ControllerOrchestratorMock();
		ViewMock view = new ViewMock();
		CottageRepositoryMock repo = new CottageRepositoryMock();
		OutfittingRepositoryMockWithAdd repo2 = new OutfittingRepositoryMockWithAdd();
		CottageCreateController controller = new CottageCreateController(orchestrator, view, repo, repo2);
		OutfittingMock outfittingMock = new OutfittingMock(1,"name", "name");
		OutfittingMock outfittingMock2 = new OutfittingMock(2,"name", "name");

		repo2.add(outfittingMock);
		repo2.add(outfittingMock2);
		ArrayList<Outfitting> outfittings = new ArrayList<Outfitting>(controller.getOutfittingCollection());
		
		assertEquals(outfittingMock, outfittings.get(0));
		assertEquals(outfittingMock2, outfittings.get(1));
		assertTrue(repo2.getListBeenCalled);
	}
}

