package outfitting.view;

import java.awt.BorderLayout;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import outfitting.controller.IOutfittingListController;
import outfitting.dto.OutfittingDtoForGet;
import outfitting.sort.SortOutfittingType;

public class OutfittingListView extends JDialog implements View, ActionListener{
	private static final long serialVersionUID = 1L;
	private static final String VIEW_TITLE = "Liste des pouvoiries";
	private static final String OK_BTN = "OK";
	private static final String SORT_BY_ID_BTN = "TRIER PAR ID";
	private static final String SORT_BY_NAME_BTN = "TRIER PAR NOM";
	private static final String SORT_BY_REGION_BTN = "TRIER PAR RÉGION";
	private static final String DETAIL_BTN = "Plus d'info";
	private static final String ID_TXT = "ID";
	private static final String NAME_TXT = "NOM";
	private static final String REGION_TXT = "RÉGION";
	private static final String PHONE_NUMBER_TXT = "NUMÉRO DE TÉLÉPHONE";
	private static final String EMAIL_TXT = "ADRESSE COURRIEL";
	
	private IOutfittingListController controller;
	private JPanel inputDataPanel = new JPanel();
	private JPanel actionPanel = new JPanel(); 
	
	public OutfittingListView() {
		super();
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle(VIEW_TITLE);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(10,10));
		this.setModalityType(DEFAULT_MODALITY_TYPE);
	}
	
	public void setController(IOutfittingListController outfittingListController) {
		this.controller = outfittingListController;
	}

	@Override
	public void display() {
		this.setUpComponents(SortOutfittingType.NON_SORTED);
		this.pack();
		this.setVisible(true);
	}
	
	private void setUpComponents(SortOutfittingType type) {
		this.setUpListInfo(type);
		this.setUpButtons();
		this.setUpOtherPanels();
	}
	
	private void setUpOtherPanels() {
		this.add(new JPanel(), BorderLayout.NORTH);
		this.add(new JPanel(), BorderLayout.WEST);
	}

	private void setUpListInfo(SortOutfittingType type) {
		
		Collection<OutfittingDtoForGet> outfittings = controller.getSortedList(type);

		inputDataPanel.removeAll();
		this.add(inputDataPanel);
		inputDataPanel.setLayout(new GridLayout(outfittings.size()+1, 6));
		
		inputDataPanel.add(new JLabel(ID_TXT));
		inputDataPanel.add(new JLabel(NAME_TXT));
		inputDataPanel.add(new JLabel(REGION_TXT));
		inputDataPanel.add(new JLabel(PHONE_NUMBER_TXT));
		inputDataPanel.add(new JLabel(EMAIL_TXT));
		inputDataPanel.add(new JLabel());
		
		for(OutfittingDtoForGet outfitting : outfittings) {
			JLabel id = new JLabel(String.valueOf(outfitting.getId()));
			inputDataPanel.add(id);
			
			JLabel name = new JLabel(outfitting.getName());
			inputDataPanel.add(name);
			
			JLabel region = new JLabel(String.valueOf(outfitting.getRegion()));
			inputDataPanel.add(region);
			
			JLabel phoneNumber = new JLabel(String.valueOf(outfitting.getPhoneNumber()));
			inputDataPanel.add(phoneNumber);
			
			JLabel email = new JLabel(String.valueOf(outfitting.getEmail()));
			inputDataPanel.add(email);
			
			IdButton btn = new IdButton(DETAIL_BTN, outfitting.getId());
			btn.setActionCommand(DETAIL_BTN);
			btn.addActionListener(this);
			inputDataPanel.add(btn);
		}
	}
	
	private void setUpButtons() {
		actionPanel.removeAll();
		this.add(actionPanel, BorderLayout.SOUTH);
		
		JButton okBtn = new JButton(OK_BTN);
		okBtn.setActionCommand(OK_BTN);
		okBtn.addActionListener(this);
		actionPanel.add(okBtn);
		
		JButton sortById = new JButton(SORT_BY_ID_BTN);
		sortById.setActionCommand(SORT_BY_ID_BTN);
		sortById.addActionListener(this);
		actionPanel.add(sortById);
		
		JButton sortByName = new JButton(SORT_BY_NAME_BTN);
		sortByName.setActionCommand(SORT_BY_NAME_BTN);
		sortByName.addActionListener(this);
		actionPanel.add(sortByName);
		
		JButton sortByRegion = new JButton(SORT_BY_REGION_BTN);
		sortByRegion.setActionCommand(SORT_BY_REGION_BTN);
		sortByRegion.addActionListener(this);
		actionPanel.add(sortByRegion);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch(action) {
			case OK_BTN -> dispose();
			case SORT_BY_ID_BTN -> displayOnType(SortOutfittingType.NON_SORTED);
			case SORT_BY_NAME_BTN -> displayOnType(SortOutfittingType.BY_NAME);
			case SORT_BY_REGION_BTN -> displayOnType(SortOutfittingType.BY_REGION);
			case DETAIL_BTN -> detailBtnAction((IdButton) e.getSource());
		}
	}

	/*private void sortByRegion() {
		
	}*/
	
	/*private void sortByName() {
		
	}*/

	private void displayOnType(SortOutfittingType type) {
		this.setUpComponents(type);
		this.pack();
		this.setVisible(true);
	}

	private void detailBtnAction(IdButton srcBtn) {
		int id = srcBtn.getIdEntity();
		OutfittingDtoForGet o = controller.getOutfittingById(id);
		if(o!=null) {
			String message = "Id: " + o.getId() + "\nNom: " + o.getName() + "\nRégion: "+ o.getRegion() +"\nTéléphone: " + o.getPhoneNumber() + "\nEmail: " + o.getEmail()
					+"\nNom du contact: "+o.getContactName() + "\nTéléphone du contact: "+o.getContactPhoneNumber() + "\nEmail du contact: "+o.getContactEmail();
			JOptionPane.showInternalMessageDialog(null, message, "Information du contact de la pourvoirie #"+String.valueOf(o.getId()), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void displayError(String message) {
		JOptionPane.showInternalMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void displaySuccess(String message) { }
}
