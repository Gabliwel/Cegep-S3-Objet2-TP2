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

import outfitting.controller.ICottageSpecificController;

public class CottageSpecificView extends JDialog implements View, ActionListener
{

	private static final long serialVersionUID = 1L;
	private static final String VIEW_TITLE = "Chalets";
	private static final String EXIT = "Ok";
	private static final String DELETE = "Supprimer le chalet";
	
	private ICottageSpecificController controller;
	
	public CottageSpecificView() 
	{
		super();
		this.initialize();
	}
	
	private void initialize()  
	{
		this.setTitle(VIEW_TITLE);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(10,10));
		this.setModalityType(DEFAULT_MODALITY_TYPE);
	}
	
	@Override
	public void display() 
	{
		this.setUpComponents();
		this.pack();
		
		this.setVisible(true);
	}
	
	public void setController(ICottageSpecificController cottageSpecificController)
	{
		this.controller = cottageSpecificController;
	}

	private void setUpComponents() 
	{
		this.cottageListPanel();
		this.outfittingListPanel();
	}

	private void cottageListPanel() 
	{
		JPanel cottagePanel = new JPanel();
		this.add(cottagePanel, BorderLayout.WEST);
		cottagePanel.setLayout(new GridLayout(6,2));
		
		JLabel idLabel = new JLabel("Identifiant du Chalet : ");
		cottagePanel.add(idLabel);
		JLabel id = new JLabel(Integer.toString(this.controller.getCottageDTOForList().getID()));
		cottagePanel.add(id);
		
		JLabel nameLabel = new JLabel("Nom du Chalet : ");
		cottagePanel.add(nameLabel);
		JLabel name = new JLabel(this.controller.getCottageDTOForList().getName());
		cottagePanel.add(name);
		
		JLabel nbOfGuestsLabel = new JLabel("Nombre d'inviter possible du Chalet : ");
		cottagePanel.add(nbOfGuestsLabel);
		JLabel nbOfGuests = new JLabel(Integer.toString(this.controller.getCottageDTOForList().getNbOfGuests()));
		cottagePanel.add(nbOfGuests);
		
		JLabel nbOfChamberLabel = new JLabel("Nombre de chambre disponible du Chalet : ");
		cottagePanel.add(nbOfChamberLabel);
		JLabel nbOfChamber = new JLabel(Integer.toString(this.controller.getCottageDTOForList().getNbOfChamber()));
		cottagePanel.add(nbOfChamber);
		
		JLabel pricePerNightLabel = new JLabel("Prix par nuit du Chalet : ");
		cottagePanel.add(pricePerNightLabel);
		JLabel pricePerNight = new JLabel(Integer.toString(this.controller.getCottageDTOForList().getPricePerNight()));
		cottagePanel.add(pricePerNight);
		
		addExitButton(cottagePanel);
	}
	
	private void outfittingListPanel() 
	{
		JPanel outfittingPanel = new JPanel();
		this.add(outfittingPanel,BorderLayout.EAST);
		outfittingPanel.setLayout(new GridLayout(6,2));
		
		JLabel idLabel = new JLabel("Identifiant de la pourvoirie : ");
		outfittingPanel.add(idLabel);
		JLabel id = new JLabel(Integer.toString(this.controller.getOutfittingObject(this.controller.getCottageDTOForList().getIdOfOutfitting()).getId()));
		outfittingPanel.add(id);
		
		JLabel nameLabel = new JLabel("Nom de la pourvoirie : ");
		outfittingPanel.add(nameLabel);
		JLabel name = new JLabel(this.controller.getOutfittingObject(this.controller.getCottageDTOForList().getIdOfOutfitting()).getName());
		outfittingPanel.add(name);
		
		JLabel regionLabel = new JLabel("Region de la pourvoirie : ");
		outfittingPanel.add(regionLabel);
		JLabel region = new JLabel(this.controller.getOutfittingObject(this.controller.getCottageDTOForList().getIdOfOutfitting()).getRegion());
		outfittingPanel.add(region);
		
		JLabel phoneLabel = new JLabel("Numero de telephone de la pourvoirie : ");
		outfittingPanel.add(phoneLabel);
		JLabel phone = new JLabel(this.controller.getOutfittingObject(this.controller.getCottageDTOForList().getIdOfOutfitting()).getPhoneNumber());
		outfittingPanel.add(phone);
		
		JLabel emailLabel = new JLabel("Courriel de la pourvoirie : ");
		outfittingPanel.add(emailLabel);
		JLabel email = new JLabel(this.controller.getOutfittingObject(this.controller.getCottageDTOForList().getIdOfOutfitting()).getEmail());
		outfittingPanel.add(email);
		
		deleteButton(outfittingPanel);
	}
	
	private void addExitButton(JPanel cottagePanel) 
	{
		JButton exitButton = new JButton(EXIT);
		exitButton.setActionCommand(EXIT);
		exitButton.addActionListener(this);
		
		cottagePanel.add(exitButton);
	}
	
	private void deleteButton(JPanel outfittingPanel) 
	{
		JButton deleteButton = new JButton(DELETE);
		deleteButton.setActionCommand(DELETE);
		deleteButton.addActionListener(this);
		
		outfittingPanel.add(deleteButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
			String action = e.getActionCommand();
			switch(action) 
			{
				case EXIT : dispose();
								break;
				case DELETE : confirmMessage();
								dispose();
								break;
				
			}
	}

	private void confirmMessage() 
	{		
		 int result = JOptionPane.showConfirmDialog(null, "Etre vous sure de vouloir oter ce Chalet ?", "Confirmation", 0);
	      switch (result) 
	      {
	         case JOptionPane.YES_OPTION : this.controller.deleteCottage(this.controller.getCottageDTOForList().getID());
	         								break;
	         case JOptionPane.NO_OPTION : dispose();
	         								break;
	      }
	}

	@Override
	public void displayError(String message) 
	{
		JOptionPane.showInternalMessageDialog(null, message);
	}
}
