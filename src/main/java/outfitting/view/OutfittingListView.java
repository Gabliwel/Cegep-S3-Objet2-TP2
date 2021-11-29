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
import outfitting.model.entity.Outfitting;

public class OutfittingListView extends JDialog implements View, ActionListener{
	private static final long serialVersionUID = 1L;
	private static final String VIEW_TITLE = "Liste des pouvoiries";
	private static final String OK_BTN = "OK";
	private static final String SORT_BY_NAME_BTN = "TRIER PAR NOM";
	private static final String SORT_BY_REGION_BTN = "TRIER PAR RÉGION";
	private static final String ID_TXT = "ID";
	private static final String NAME_TXT = "NOM";
	private static final String REGION_TXT = "RÉGION";
	private static final String PHONE_NUMBER_TXT = "NUMÉRO DE TÉLÉPHONE";
	private static final String EMAIL_TXT = "ADRESSE COURRIEL";
	
	private IOutfittingListController controller;
	
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
		this.setUpComponents();
		this.pack();
		this.setVisible(true);
	}
	
	private void setUpComponents() {
		this.setUpCottageListInfo();
		this.setUpButtons();
		this.setUpOtherPanels();
	}
	
	private void setUpOtherPanels() {
		this.add(new JPanel(), BorderLayout.NORTH);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new JPanel(), BorderLayout.WEST);
	}

	private void setUpCottageListInfo() {
		
		Collection<Outfitting> outfittings = controller.getSortedByRegionOutfittingList();
		
		JPanel inputDataPanel = new JPanel();
		this.add(inputDataPanel);
		inputDataPanel.setLayout(new GridLayout(outfittings.size()+1, 5));
		
		inputDataPanel.add(new JLabel(ID_TXT));
		inputDataPanel.add(new JLabel(NAME_TXT));
		inputDataPanel.add(new JLabel(REGION_TXT));
		inputDataPanel.add(new JLabel(PHONE_NUMBER_TXT));
		inputDataPanel.add(new JLabel(EMAIL_TXT));
		
		for(Outfitting outfitting : outfittings) {
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
		}
	}
	
	private void setUpButtons() {
		JPanel actionPanel = new JPanel(); 
		this.add(actionPanel, BorderLayout.SOUTH);
		
		JButton okBtn = new JButton(OK_BTN);
		okBtn.setActionCommand(OK_BTN);
		okBtn.addActionListener(this);
		actionPanel.add(okBtn);
		
		JButton sortByName = new JButton(SORT_BY_NAME_BTN);
		sortByName.setActionCommand(SORT_BY_NAME_BTN);
		//sortByName.addActionListener(this);
		actionPanel.add(sortByName);
		
		JButton sortByRegion = new JButton(SORT_BY_REGION_BTN);
		sortByRegion.setActionCommand(SORT_BY_REGION_BTN);
		//sortByRegion.addActionListener(this);
		actionPanel.add(sortByRegion);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch(action) {
			case OK_BTN -> dispose();
			//case SORT_BY_NAME_BTN -> sortByName();
			//case SORT_BY_REGION_BTN -> sortByRegion();
		}
	}

	@Override
	public void displayError(String message) 
	{
		JOptionPane.showInternalMessageDialog(null, message);
	}

	/*private void sortByRegion() {
		
	}*/
	
	/*private void sortByName() {
		
	}*/
}
