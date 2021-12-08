package outfitting.view;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import outfitting.controller.iController.ICottageListController;
import outfitting.controller.search.CottageSearchType;
import outfitting.dto.CottageDTOForList;
import outfitting.dto.OutfittingDtoForGet;
import outfitting.model.entity.RegionName;

public class CottageListView extends JDialog implements View, ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String VIEW_TITLE = "Liste des chalets";
	private static final String OK_BTN = "OK";
	private static final String ID_TXT = "ID";
	private static final String NAME_TXT = "NOM";
	private static final String NB_PERSON_TXT = "NB. PERSONNES";
	private static final String NB_OF_CHAMBER_TXT = "NB. CHAMBRES";
	private static final String PRICE_PER_NIGHT_TXT = "Prix/Nuit";
	private static final String CONSULT_BUTTON = "Consulter le chalet";
	private static final String OUTFITTING_NAME = "Nom de la pourvoirie";
	private static final String SEARCH_BTN = "CHERCHER UNE POURVOIRIE";
	
	private JPanel inputDataPanel = new JPanel();
	private ICottageListController controller;
	private JTextField searchInput = new JTextField(30);
	private JComboBox<String> searchOption = new JComboBox<String>(CottageSearchType.getAllTypeInString());
	
	public CottageListView() {
		super();
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle(VIEW_TITLE);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(10,10));
		this.setModalityType(DEFAULT_MODALITY_TYPE);
	}
	
	public void setController(ICottageListController cottageListController) {
		this.controller = cottageListController;
	}

	@Override
	public void display() {
		this.setUpComponents();
		this.pack();
		this.setVisible(true);
	}
	
	private void setUpComponents() {
		this.setUpCottageListInfo();
		this.setUpButton();
		this.setUpOtherPanels();
	}
	
	private void setUpOtherPanels() {
		this.add(new JPanel(), BorderLayout.NORTH);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new JPanel(), BorderLayout.WEST);
	}

	private void setUpCottageListInfo() 
	{
		inputDataPanel.removeAll();
		inputDataPanel.revalidate();
		inputDataPanel.repaint();
		this.add(inputDataPanel);
		
		inputDataPanel.setLayout(new GridLayout(this.controller.getCottageList().size()+1, 7));
		
		inputDataPanel.add(new JLabel(ID_TXT));
		inputDataPanel.add(new JLabel(NAME_TXT));
		inputDataPanel.add(new JLabel(NB_PERSON_TXT));
		inputDataPanel.add(new JLabel(NB_OF_CHAMBER_TXT));
		inputDataPanel.add(new JLabel(PRICE_PER_NIGHT_TXT));
		inputDataPanel.add(new JLabel(OUTFITTING_NAME));
		inputDataPanel.add(new JLabel(""));
		
		for(CottageDTOForList cottage : this.controller.getCottageList()) {
			JLabel id = new JLabel(String.valueOf(cottage.getID()));
			inputDataPanel.add(id);
			
			JLabel name = new JLabel(cottage.getName());
			inputDataPanel.add(name);
			
			JLabel nbGuest = new JLabel(String.valueOf(cottage.getNbOfGuests()));
			inputDataPanel.add(nbGuest);
			
			JLabel nbChamber = new JLabel(Integer.toString(cottage.getNbOfChamber()));
			inputDataPanel.add(nbChamber);
			
			JLabel pricePerNight = new JLabel(Integer.toString(cottage.getPricePerNight()));
			inputDataPanel.add(pricePerNight);
			
			JLabel outfittingName = new JLabel(controller.getOutfittingObject(cottage.getIdOfOutfitting()).getName());
			inputDataPanel.add(outfittingName);
			

			IdButton idButton = new IdButton(CONSULT_BUTTON, cottage.getID());
			idButton.setActionCommand(CONSULT_BUTTON);
			idButton.addActionListener(this);
			inputDataPanel.add(idButton);
		}
	}
	
	private void setUpButton() {
		JPanel actionPanel = new JPanel(); 
		this.add(actionPanel, BorderLayout.SOUTH);
		
		JButton okBtn = new JButton(OK_BTN);
		okBtn.setActionCommand(OK_BTN);
		okBtn.addActionListener(this);
		actionPanel.add(okBtn);
		
		actionPanel.add(searchInput);
		
		actionPanel.add(searchOption);
		
		JButton searchBtn = new JButton(SEARCH_BTN);
		searchBtn.setActionCommand(SEARCH_BTN);
		searchBtn.addActionListener(this);
		actionPanel.add(searchBtn);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch(action) 
		{
			case OK_BTN : dispose();
							break;
			case CONSULT_BUTTON : 
				IdButton cottageButton = (IdButton) e.getSource();
				int idCottage = cottageButton.getIdEntity();
				this.controller.requestSpecificCottageView(idCottage);
				break;
			case SEARCH_BTN : 
				searchAction();
				break;
		}
	}
	
	private void searchAction() {
		//pourrait être mieux fait, mais simplifié comme bonus
		if(searchInput != null && !searchInput.getText().isBlank()) {
			CottageSearchType type = null;
			if(searchOption.getSelectedItem() == CottageSearchType.BY_NB_OF_ROOM.string) {
				type = CottageSearchType.BY_NB_OF_ROOM;
			}
			else if(searchOption.getSelectedItem() == CottageSearchType.BY_REGION_NAME.string)
			{
				type = CottageSearchType.BY_REGION_NAME;
			}
			Collection<CottageDTOForList> cottages = controller.searchInList(searchInput.getText(), type);
			String globalMessage = "";
			if(!cottages.isEmpty()) {
				for(CottageDTOForList c : cottages) {
					OutfittingDtoForGet o = controller.getOutfittingObject(c.getIdOfOutfitting());
					String message = "\nId: " + c.getID() + "\nNom: " + c.getName() + "\nNombre d'invités maximun: "+ c.getNbOfGuests() +"\nNom de la pourvoirie: "+ o.getName() + "\nRégion de la pourvoirie: " + o.getRegion() + "\n";
					globalMessage = globalMessage + message;
				}
			}
			else {
				globalMessage = "Auncun résultat de recherche trouvé";
			}
			JOptionPane.showInternalMessageDialog(null, globalMessage, "Resultat de recherche pour: "+searchInput.getText(), JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			displayError("Peut pas executer la recheche, car le champ est vide");
		}
	}
		

	@Override
	public void displayError(String message) 
	{
		JOptionPane.showInternalMessageDialog(null, message);
	}


	@Override
	public void displaySuccess(String message) { }
	
	@Override
	public void refresh() 
	{
		setUpCottageListInfo();
	}
}