package outfitting.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.model.entity.Cottage;

public class CottageMemoryRepositoryTest {
	/*The seeded value:
	 *  #1: Cottage("Nar Shaddaa's Cottage", 6666666);
	 *	#2: Cottage("Teepee", 1);
	 *	#3: Cottage("The Max Int Cottage", 2147483647);
	 *	#4: Cottage("Japan", 125800000);
	 */
	
	public static final int ND_SEEDED_COTTAGE = 4;
	public static final Cottage SEEDED_COTTAGE_1 = new Cottage("Nar Shaddaa's Cottage", 6666666);
	public static final Cottage SEEDED_COTTAGE_2 = new Cottage("Teepee", 1);
	public static final Cottage SEEDED_COTTAGE_3 = new Cottage("The Max Int Cottage", 2147483647);
	public static final Cottage SEEDED_COTTAGE_4 = new Cottage("Japan", 125800000);
	
	@BeforeEach
	public void init()
	{
		Cottage.lastId = 0;

	}
	
	@AfterAll
	public static void end()
	{
		Cottage.lastId = 0;

	}
	
	@Test
	public void when_gettingCottageById_then_returnTheCottageWithTheId() {
		CottageMemoryRepository repo = new CottageMemoryRepository();
		
		Cottage result = repo.searchById(1);

		compareCottage(SEEDED_COTTAGE_1, result);
	}
	
	@Test
	public void when_gettingCottageByNonExistentId_then_returnNull() {
		CottageMemoryRepository repo = new CottageMemoryRepository();
		
		Cottage result = repo.searchById(9999);

		assertNull(result);
	}

	@Test
	public void when_addCottageToRepo_then_cottageIsInRepo() {
		CottageMemoryRepository repo = new CottageMemoryRepository();
		Cottage cottage = new Cottage("AAAAAAAAAAAAA", 12345);
		
		repo.add(cottage);
		Cottage result = repo.searchById(5);

		compareCottage(cottage, result);
	}
	
	@Test
	public void when_creatingNewMemoryRepo_then_repoHasSeedCottage() {
		CottageMemoryRepository repo = new CottageMemoryRepository();
		
		Cottage result1 = repo.searchById(1);
		Cottage result2 = repo.searchById(2);
		Cottage result3 = repo.searchById(3);
		Cottage result4 = repo.searchById(4);
		
		compareCottage(SEEDED_COTTAGE_1, result1);
		compareCottage(SEEDED_COTTAGE_2, result2);
		compareCottage(SEEDED_COTTAGE_3, result3);
		compareCottage(SEEDED_COTTAGE_4, result4);
	}
	
	@Test
	public void when_getSizeOfRepo_then_returnNbOfCottageInRepo() {
		CottageMemoryRepository repo = new CottageMemoryRepository();
		
		int size = repo.size();
		
		assertEquals(ND_SEEDED_COTTAGE, size);
	}
	
	@Test
	public void when_getAllRepoCottage_then_returnCollectionOfCottageInRepo() {
		CottageMemoryRepository repo = new CottageMemoryRepository();
		
		ArrayList<Cottage> cottages = new ArrayList<Cottage>(repo.getList());
		
		compareCottage(SEEDED_COTTAGE_1, cottages.get(0));
		compareCottage(SEEDED_COTTAGE_2, cottages.get(1));
		compareCottage(SEEDED_COTTAGE_3, cottages.get(2));
		compareCottage(SEEDED_COTTAGE_4, cottages.get(3));
	}
	
	private void compareCottage(Cottage expectedCottage, Cottage resultCottage) {
		assertEquals(expectedCottage.getId(), resultCottage.getId());
		assertEquals(expectedCottage.getName(), resultCottage.getName());
		assertEquals(expectedCottage.getNbOfGuests(), resultCottage.getNbOfGuests());
	}
}
