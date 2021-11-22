package outfitting.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import outfitting.controller.ICottageListController;
import outfitting.model.entity.Cottage;

public class CottageListView extends JDialog implements View, ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String VIEW_TITLE = "Liste des chalets";
	private static final String OK_BTN = "OK";
	private static final String ID_TXT = "ID";
	private static final String NAME_TXT = "NOM";
	private static final String NB_PERSON_TXT = "NB. PERSONNES";
	private static final String NB_OF_CHAMBER_TXT = "NB. CHAMBRES";
	private static final String PRICE_PER_NIGHT_TXT = "Prix/Nuit";
	
	private ICottageListController controller;
	
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
		JPanel inputDataPanel = new JPanel();
		this.add(inputDataPanel);
		inputDataPanel.setLayout(new GridLayout(this.controller.getCottageList().size()+1, 5));
		
		inputDataPanel.add(new JLabel(ID_TXT));
		inputDataPanel.add(new JLabel(NAME_TXT));
		inputDataPanel.add(new JLabel(NB_PERSON_TXT));
		inputDataPanel.add(new JLabel(NB_OF_CHAMBER_TXT));
		inputDataPanel.add(new JLabel(PRICE_PER_NIGHT_TXT));
		
		for(Cottage cottage : this.controller.getCottageList()) {
			JLabel id = new JLabel(String.valueOf(cottage.getId()));
			inputDataPanel.add(id);
			
			JLabel name = new JLabel(cottage.getName());
			inputDataPanel.add(name);
			
			JLabel nbGuest = new JLabel(String.valueOf(cottage.getNbOfGuests()));
			inputDataPanel.add(nbGuest);
			
			JLabel nbChamber = new JLabel(Integer.toString(cottage.getNbOfChamber()));
			inputDataPanel.add(nbChamber);
			
			JLabel pricePerNight = new JLabel(Integer.toString(cottage.getPricePerNight()));
			inputDataPanel.add(pricePerNight);
		}
	}
	
	private void setUpButton() {
		JPanel actionPanel = new JPanel(); 
		this.add(actionPanel, BorderLayout.SOUTH);
		
		JButton okBtn = new JButton(OK_BTN);
		okBtn.setActionCommand(OK_BTN);
		okBtn.addActionListener(this);
		actionPanel.add(okBtn);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch(action) {
			case OK_BTN -> dispose();
		}
	}
}