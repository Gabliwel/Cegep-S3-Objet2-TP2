package outfitting.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.controller.search.CottageSearchFactory;
import outfitting.controller.search.CottageSearchType;
import outfitting.dto.CottageDTOForList;
import outfitting.model.CottageMemoryRepositoryMockWithAdd;
import outfitting.model.OutfittingRepositoryMock;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.CottageMock;

public class CottageSearchFactoryTest {
	private static final int NB_ROOM =2;
	private CottageSearchFactory factory = new CottageSearchFactory();
	private CottageMemoryRepositoryMockWithAdd repo;
	private OutfittingRepositoryMock repo2;
	private CottageMock COTTAGE1 =  new CottageMock("1", 1, NB_ROOM, 3, 4);
	private CottageMock COTTAGE2 =  new CottageMock("2", 1, NB_ROOM+1, 3, 4);
	
	@BeforeEach
	public void setUp() 
	{
		Cottage.lastId = 0;
		repo = new CottageMemoryRepositoryMockWithAdd();
		repo2 = new OutfittingRepositoryMock();
		repo.add(COTTAGE1);
		repo.add(COTTAGE2);
	}
	
	@Test
	public void when_searchWithNoType_then_throwError() 
	{
		assertThrows(IllegalArgumentException.class, () ->
		{
			factory.giveMeStrategyForSortType(String.valueOf(NB_ROOM), null, repo, repo2);
		});
	}
	
	@Test
	public void when_searchByNbOfRoom_then_returnListWithGivenSearchValueOfNbOfRoom() 
	{
		List<CottageDTOForList> list = factory.giveMeStrategyForSortType(String.valueOf(NB_ROOM), CottageSearchType.BY_NB_OF_ROOM, repo, repo2);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getID(), COTTAGE1.getId());
	}
	
	@Test
	public void when_searchByRegion_then_returnListWithGivenSearchRegion() 
	{
		String anyRegion = "JSP";
		repo2.region = anyRegion;
		List<CottageDTOForList> list = factory.giveMeStrategyForSortType(anyRegion, CottageSearchType.BY_REGION_NAME, repo, repo2);
		assertEquals(list.size(), 2);
		assertEquals(list.get(0).getID(), COTTAGE1.getId());
		assertEquals(list.get(1).getID(), COTTAGE2.getId());
	}
	
	@Test
	public void when_searchByNbOfRoomWithInvalidSearchTerm_then_returnEmptyListWith() 
	{
		List<CottageDTOForList> list = factory.giveMeStrategyForSortType(String.valueOf(NB_ROOM)+"99999999999", CottageSearchType.BY_NB_OF_ROOM, repo, repo2);
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void when_searchByRegionWithInvalidSearchTerm_then_returnEmptyList() 
	{
		String anyRegion = "JSP";
		repo2.region = anyRegion;
		List<CottageDTOForList> list = factory.giveMeStrategyForSortType(anyRegion + "oh no", CottageSearchType.BY_REGION_NAME, repo, repo2);
		assertEquals(list.size(), 0);
	}
}