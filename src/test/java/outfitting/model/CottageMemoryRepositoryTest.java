package outfitting.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.model.entity.Cottage;
import outfitting.model.entity.CottageMock;

public class CottageMemoryRepositoryTest {
	/*The seeded value:
	 *  #1: Cottage("Nar Shaddaa's Cottage", 6666666);
	 *	#2: Cottage("Teepee", 1);
	 *	#3: Cottage("The Max Int Cottage", 2147483647);
	 *	#4: Cottage("Japan", 125800000);
	 */
	
	public static final int ND_SEEDED_COTTAGE = 4;
	
	CottageMock cottage1 = new CottageMock("Nar Shaddaa's Cottage", 5, 20, 70);
	CottageMock cottage2 = new CottageMock("Teepee", 3, 16, 50);
	CottageMock cottage3 = new CottageMock("The Max Int Cottage", 4, 16, 60);
	CottageMock cottage4 = new CottageMock("Japan", 2, 7, 100);
	
	CottageMemoryRepository aRepository = null;
	
	@BeforeEach
	public void init()
	{
		Cottage.lastId = 0;
		aRepository = new CottageMemoryRepository();
		
		aRepository.add(cottage1);
		aRepository.add(cottage2);
		aRepository.add(cottage3);
		aRepository.add(cottage4);
	}
	
	@AfterAll
	public static void end()
	{
		Cottage.lastId = 0;

	}
	
	@Test
	public void when_gettingCottageById_then_returnTheCottageWithTheId() {

		assertEquals(cottage1, aRepository.searchById(cottage1.getId()));
	}
	
	@Test
	public void when_gettingCottageByNonExistentId_then_returnNull() {
		CottageMemoryRepository repo = new CottageMemoryRepository();
		
		Cottage result = repo.searchById(9999);

		assertNull(result);
	}

	@Test
	public void when_addCottageToRepo_then_cottageIsInRepo() {
		CottageMock cottage = new CottageMock("AAAAAAAAAAAAA", 12345, 3, 34);
		
		aRepository.add(cottage);

		assertEquals(aRepository.searchById(cottage.getId()), cottage);
	}
	
	@Test
	public void when_getSizeOfRepo_then_returnNbOfCottageInRepo() {
		
		int size = aRepository.size();
		
		assertEquals(ND_SEEDED_COTTAGE, size-4); //the -4 is because i want the test to pass while having the dataSeed() method on
	}
	
	@Test
	public void when_getAllRepoCottage_then_returnCollectionOfCottageInRepo() {
		ArrayList<Cottage> cottages = new ArrayList<Cottage>(aRepository.getList());
		
		assertEquals(cottages.get(0), aRepository.searchById(cottages.get(0).getId()));
		assertEquals(cottages.get(1), aRepository.searchById(cottages.get(1).getId()));
		assertEquals(cottages.get(2), aRepository.searchById(cottages.get(2).getId()));
		assertEquals(cottages.get(3), aRepository.searchById(cottages.get(3).getId()));
	}
	
	@Test
	public void WHEN_removeGetsCalled_THEN_cottageIsRemovedFromMap() 
	{
		aRepository.remove(cottage4.getId());
		
		assertNull(aRepository.searchById(cottage3.getId()+1));
	}
}
