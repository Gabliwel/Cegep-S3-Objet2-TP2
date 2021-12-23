package outfitting.controller;

import java.util.Collection;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import outfitting.controller.iController.IControllerOrchestrator;
import outfitting.controller.iController.ICottageListController;
import outfitting.controller.search.CottageSearchFactory;
import outfitting.controller.search.CottageSearchType;
import outfitting.sort.CompareByAmountOfGuest;
import outfitting.convertor.CottageListDTOToCottageConvertor;
import outfitting.convertor.OutfittingConverter;
import outfitting.dto.CottageDTOForList;
import outfitting.dto.OutfittingDtoForGet;
import outfitting.model.GenericRepository;
import outfitting.model.entity.Cottage;
import outfitting.model.entity.Outfitting;
import outfitting.observer.Observer;
import outfitting.observer.Subject;
import outfitting.view.View;

public class CottageListController implements ICottageListController, Observer{

	private GenericRepository<Cottage> repository;
	private GenericRepository<Outfitting> repositoryOutfitting;
	private IControllerOrchestrator orchestrator;
	private View view;
	private CottageListDTOToCottageConvertor cottageConvertor;
	private OutfittingConverter outftittingConverter;
	private CottageSearchFactory searchFactory;
	private Subject subject;
	

	public CottageListController(IControllerOrchestrator controllerOrchestrator, View view, GenericRepository<Cottage> repository, GenericRepository<Outfitting> repositoryOutfitting) {
		this.orchestrator = controllerOrchestrator;
		this.subject = (Subject) repository;
		this.repository = repository;
		this.repositoryOutfitting = repositoryOutfitting;
		this.view = view;
		this.cottageConvertor = new CottageListDTOToCottageConvertor();
		this.outftittingConverter = new OutfittingConverter();
		this.searchFactory = new CottageSearchFactory();
		//FIXME: (Observateur) La meilleure place pour faire ce lien est dans le 'contexte', c'est à dire là où les composants sont initialisés (aka dans l'orchestrateur).
		subject.addObserver(this);
	}

	@Override
	public void requestCottageList() {
		this.view.display();
	} 
	
	@Override
	public List<CottageDTOForList> getCottageList() {
		List<Cottage> list = listAscendingByNbGuest(repository.getList());
		
		return cottageConvertor.listOfCottageToDTO(list);
	}
	
	public List<Cottage> listAscendingByNbGuest(Collection<Cottage> cottageCollection)
	{
		Comparator<Cottage> comparatorType;
		comparatorType = new CompareByAmountOfGuest();
		
		return cottageCollection.stream()
				.sorted(comparatorType)
				.collect(Collectors.toList());
	}
	
	@Override
	public OutfittingDtoForGet getOutfittingObject(int id) 
	{
		return outftittingConverter.getConvertTo(this.repositoryOutfitting.searchById(id));
	}
	
	public void requestSpecificCottageView(int id) 
	{
		this.orchestrator.goToCottageSpecificView(id);
	}
	
	@Override
	public void react() {
		this.view.refresh();
	}

	@Override
	public Collection<CottageDTOForList> searchInList(String researchTerm, CottageSearchType type) {
		//fait très rapidement comme bonus, mais pourrait facilement être mieux fait
		return searchFactory.giveMeStrategyForSortType(researchTerm, type, repository, repositoryOutfitting);
	}
}
