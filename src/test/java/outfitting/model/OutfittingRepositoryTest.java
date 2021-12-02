package outfitting.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import outfitting.exception.IdAlreadyExistException;
import outfitting.exception.IdDoesNotExistException;
import outfitting.model.entity.Contact;
import outfitting.model.entity.Outfitting;
import outfitting.model.entity.OutfittingMock;
import outfitting.model.entity.RegionName;

public class OutfittingRepositoryTest 
{
	//The seeded value:
	public static final int ND_SEEDED_OUTFITTING = 3;
	public static final OutfittingMock SEEDED_OUTFITTING_1 = new OutfittingMock(1, "La Terre de Roger", RegionName.QUEBEC.name, "911", "terrederoger@chibougamau.qc.ca", new Contact("Bob1", "444-444-4444", "a@b.com"));
	public static final OutfittingMock SEEDED_OUTFITTING_2 = new OutfittingMock(2, "The Universe", RegionName.ONTARIO.name, "000-000-0000", "42@universe.com", new Contact("Bob2", "444-444-4444", "a@b.com"));
	public static final OutfittingMock SEEDED_OUTFITTING_3 = new OutfittingMock(3, "La Terre des Perdues", RegionName.NUNAVUT.name, "123-456-7890", "jesuisou@help.ca", new Contact("Robert3", "123-456-7890", "z@y.com"));
		
	@BeforeEach
	public void init()
	{
		Outfitting.lastId = 0;
	}
		
	@AfterAll
	public static void end()
	{
		Outfitting.lastId = 0;
	}
		
	@Test
	public void when_gettingOutfittingById_then_returnTheOutfittingWithTheId() {
		OutfittingMemoryRepository repo = new OutfittingMemoryRepository();
		
		Outfitting result = repo.searchById(1);

		compareOutfitting(SEEDED_OUTFITTING_1, result);
	}
		
	@Test
	public void when_gettingOutfittingByNonExistentId_then_throwIdDoesNotExistException() {
		OutfittingMemoryRepository repo = new OutfittingMemoryRepository();

		assertThrows(IdDoesNotExistException.class, () -> repo.searchById(-1));
	}

	@Test
	public void when_addOutfittingToRepo_then_cottageIsInRepo() {
		OutfittingMemoryRepository repo = new OutfittingMemoryRepository();
		Outfitting outfittings = new Outfitting("A", "B", "C", "D", new Contact("E", "F", "G"));
			
		repo.add(outfittings);
		Outfitting result = repo.searchById(ND_SEEDED_OUTFITTING+1);

		assertEquals(outfittings.getId(), result.getId());
	}
	
	@Test
	public void when_addOutfittingThatAlradyExistToRepo_then_exceptionIsThrown() {
		OutfittingMemoryRepository repo = new OutfittingMemoryRepository();
		OutfittingMock outfitting = new OutfittingMock(1, "a", "b");
		
		assertThrows(IdAlreadyExistException.class, () -> repo.add(outfitting));
	}
		
	@Test
	public void when_creatingNewMemoryRepo_then_repoHasSeedCottage() {
		OutfittingMemoryRepository repo = new OutfittingMemoryRepository();
			
		Outfitting result1 = repo.searchById(1);
		Outfitting result2 = repo.searchById(2);
		Outfitting result3 = repo.searchById(3);;
			
		compareOutfitting(SEEDED_OUTFITTING_1, result1);
		compareOutfitting(SEEDED_OUTFITTING_2, result2);
		compareOutfitting(SEEDED_OUTFITTING_3, result3);
	}
		
	@Test
	public void when_getSizeOfRepo_then_returnNbOfOutfittingInRepo() {
		OutfittingMemoryRepository repo = new OutfittingMemoryRepository();
			
		int size = repo.size();
			
		assertEquals(ND_SEEDED_OUTFITTING, size);
	}
		
	@Test
	public void when_getAllRepoOutfitting_then_returnCollectionOfOutfittingInRepo() {
		OutfittingMemoryRepository repo = new OutfittingMemoryRepository();
			
		ArrayList<Outfitting> outfittings = new ArrayList<Outfitting>(repo.getList());
			
		compareOutfitting(SEEDED_OUTFITTING_1, outfittings.get(0));
		compareOutfitting(SEEDED_OUTFITTING_2, outfittings.get(1));
		compareOutfitting(SEEDED_OUTFITTING_3, outfittings.get(2));
	}
		
	private void compareOutfitting(OutfittingMock expectedOutfitting, Outfitting resultOutfitting) {
		assertEquals(expectedOutfitting.getId(), resultOutfitting.getId());
		assertEquals(expectedOutfitting.getName(), resultOutfitting.getName());
		assertEquals(expectedOutfitting.getRegion(), resultOutfitting.getRegion());
		assertEquals(expectedOutfitting.getPhoneNumber(), resultOutfitting.getPhoneNumber());
		assertEquals(expectedOutfitting.getEmail(), resultOutfitting.getEmail());
		assertEquals(expectedOutfitting.getContact().getName(), resultOutfitting.getContact().getName());
		assertEquals(expectedOutfitting.getContact().getPhoneNumber(), resultOutfitting.getContact().getPhoneNumber());
		assertEquals(expectedOutfitting.getContact().getEmail(), resultOutfitting.getContact().getEmail());
	}
}