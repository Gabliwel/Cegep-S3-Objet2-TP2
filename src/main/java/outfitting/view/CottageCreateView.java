package outfitting.view;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import outfitting.controller.ICottageCreateController;
import outfitting.dto.CottageDtoForCreate;

public class CottageCreateView extends JDialog implements View, ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String VIEW_TITLE = "Ajout d'un chalet";
	private static final String COTTAGE_NAME = "Nom du chalet:";
	private static final String COTTAGE_NB_PEOPLE = "Nombre de personnes:";
	private static final String ADD_COTTAGE = "Ajouter";
	private static final String NB_OF_CHAMBER = "Nombre de chambre";
	private static final String PRICE_PER_NIGHT = "prix par nuit";

	ICottageCreateController controller;

	private JTextField name = new JTextField(30);
	private JTextField guests = new JTextField(3);
	private JTextField nbOfChamber = new JTextField(3);
	private JTextField pricePerNight = new JTextField(3);

	public CottageCreateView() {
		super();
		this.initialize();
		this.setUpComponents();
		this.pack(); // Pour forcer le calcul de la taille de la fenêtre
	}

	private void initialize() {
		this.setTitle(VIEW_TITLE);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(10,10));
		this.setModalityType(DEFAULT_MODALITY_TYPE);
	}

	public void setController(ICottageCreateController cottageCreateController) {
		// FIXME TODO
		this.controller = cottageCreateController;
	}

	@Override
	public void display() {
		// FIXME TODO
		this.setVisible(true);
	}

	private void setUpComponents() {
		this.setUpInputDataPanel();
		this.setUpActionPanel();
		this.setUpOtherPanels();
	}

	private void setUpOtherPanels() {
		this.add(new JPanel(), BorderLayout.NORTH);
		this.add(new JPanel(), BorderLayout.EAST);
		this.add(new JPanel(), BorderLayout.WEST);
	}

	private void setUpInputDataPanel() {
		// FIXME TODO
		// Conteneur intermédiaire JPanel qui contient les étiquettes (JLabel) et les
		// zones de textes (JTextField)
		// Utiliser un GridLayout comme LayoutManager (2 colonnes)
		JPanel inputDataPanel = new JPanel();
		this.add(inputDataPanel);
		
		inputDataPanel.setLayout(new GridLayout(4, 4));
		
		JLabel cottageName = new JLabel(COTTAGE_NAME);
		inputDataPanel.add(cottageName);
		
		inputDataPanel.add(name);
		
		JLabel nbPeople = new JLabel(COTTAGE_NB_PEOPLE);
		inputDataPanel.add(nbPeople);
		
		inputDataPanel.add(guests);
		
		JLabel nbChamber = new JLabel(NB_OF_CHAMBER);
		inputDataPanel.add(nbChamber);
		
		inputDataPanel.add(nbOfChamber);
		
		JLabel priceByNight = new JLabel(PRICE_PER_NIGHT);
		inputDataPanel.add(priceByNight);
		
		inputDataPanel.add(pricePerNight);
	}

	private void setUpActionPanel() {
		// FIXME TODO
		// Conteneur intermédiaire JPanel qui contient le bouton pour ajouter un chalet
		JPanel actionPanel = new JPanel(); 
		this.add(actionPanel, BorderLayout.SOUTH);
		
		JButton addCottageBtn = new JButton(ADD_COTTAGE);
		addCottageBtn.setActionCommand(ADD_COTTAGE);
		addCottageBtn.addActionListener(this);
		actionPanel.add(addCottageBtn);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch(action) {
			case ADD_COTTAGE -> sendCreateDTOToController();
		}
	}
	
	private void sendCreateDTOToController() {
		boolean isValidNumGuest = true;
		
		if(name.getText() != null && guests.getText() != null) 
		{
			try 
			{
				Integer.parseInt(this.guests.getText());
				Integer.parseInt(this.nbOfChamber.getText());
				Integer.parseInt(this.pricePerNight.getText());
			}
			catch (NumberFormatException e) {
				isValidNumGuest = false;
				JOptionPane.showInternalMessageDialog(null, "Vous devez entrer un nombre dans le nombre d'inviter");
			}

			if(isValidNumGuest) {
				CottageDtoForCreate cottage = new CottageDtoForCreate(name.getText(), Integer.parseInt(guests.getText()), 
						Integer.parseInt(nbOfChamber.getText()), Integer.parseInt(pricePerNight.getText()));	
				controller.add(cottage);
				this.dispose();
				JOptionPane.showInternalMessageDialog(null, name.getText() + " à bien été ajouté", "Confirmation d'un nouveau chalet", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else 
		{
			JOptionPane.showInternalMessageDialog(null,"Vous devez entrer des valeurs");
		}
	}

}
